<%-- 
    Document   : Historico_Firmas_Inventario
    Created on : 18/11/2021, 09:54:28 AM
    Author     : kcordon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    if (session.getAttribute("usuario") == null) {
        System.out.println(session.getAttribute("usuario") == null);
        response.sendRedirect("Login.jsp");
    }
%>

<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified JavaScript -->

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>


        <title>INFORMACION MANIFIESTOS</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>

            <style>
                h3{
                    text-align: center;
                }
                .highlight{
                    color: lightgreen;
                    background: black !important;
                }
                td.details-control {
                    background: url('http://www.datatables.net/examples/resources/details_open.png') no-repeat center center;
                    cursor: pointer;
                }
                tr.shown td.details-control {
                    background: url('http://www.datatables.net/examples/resources/details_close.png') no-repeat center center;

                }
            </style>
        </head>


        </br>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header text-center">
                    <h1><center>Consulta Manifiestos</center></h1>
                </div>
                <div class="card-body">
                    <div id="calendars">
                        <label for="Inicio">Inicio:</label>
                        <input type="date" id="Inicio" name="Inicio"> 

                        <label for="Final">Final:</label>
                        <input type="date" id="Final" name="Final">  
                        <button id="buscar" type="button" class="btn btn-primary btn-sm">Buscar</button>
                    </div>
                    <div id="result">

                    </div>
                </div>
            </div> 
        </div>


        <!-- The Modal -->
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Estado Manifiesto</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        No Operado
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script><!--

        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        -->        
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
        <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
        <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
        <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script><!--

        -->        <script>


            $("#buscar").click(function () {
                if ($('#Inicio').val().length == 0 || $('#Final').val().length == 0) {
                    alert("Inicio Vacio");
                } else {
                    var var1 = $('#Inicio').val();
                    var var2 = $('#Final').val();
                    var Inicio = var1.split("-").reverse().join("-");
                    var Final = var2.split("-").reverse().join("-");
                    //                console.log(Inicio + " " + Final);

                    $.ajax({
                        url: "ServletManifiestos",

                        data: {
                            Inicio: Inicio,
                            Final: Final,
                            param: 1
                        },

                        success: function (data) {

                            $("#result").html(data);

                            //                            console.log(data);
                            $(document).ready(function () {


                                var table = $('#example').DataTable({
                                    "order": [[2, "desc"]],
                                    dom: 'Bfrtip',
                                    buttons: [

                                        {
                                            extend: 'copyHtml5',
                                            title: 'INVENTARIO DE CONTENEDORES'
                                        },
                                        {
                                            extend: 'excelHtml5',
                                            title: 'INVENTARIO DE CONTENEDORES'
                                        }, {
                                            extend: 'csvHtml5',
                                            title: 'INVENTARIO DE CONTENEDORES'
                                        },
                                        {
                                            extend: 'pdfHtml5',
                                            title: 'INVENTARIO DE CONTENEDORES',

                                            pageSize: 'LEGAL'

                                        }
                                    ]

                                });

                                $('#example').on('click', 'td.details-control', function () {
                                    var tr = $(this).closest('tr');
                                    var row = table.row(tr);

                                    if (row.child.isShown()) {
                                        // This row is already open - close it
                                        row.child.hide();
                                        tr.removeClass('shown');
                                    } else {
                                        // Open this row
                                        $.ajax({
                                            url: "ServletManifiestos",

                                            data: {

                                                value: tr.data('child-value'),
                                                param: 2
                                            },

                                            success: function (data) {
                                                row.child(data).show();
                                                tr.addClass('shown');
                                            }
                                        });

                                    }
                                });
                            });
                        }
                    });
                }
            });

            function ir(variable, variable2) {
                if (variable2 == "null") {
//                    alert("No Operado");
                    var myModal = new bootstrap.Modal(document.getElementById('myModal'), {
                        keyboard: false
                    });
                    
                    myModal.show();

                } else {
                    location.href = "Manifiestos.jsp?id=" + variable + "";
                }


            }



        </script>

    <jsp:include page="foot.jsp" flush="true"></jsp:include>

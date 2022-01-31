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
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>


        <title>INFORMACION RX</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>

            <style>
                h3{
                    text-align: center;
                }
            </style>
        </head>


        </br>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header text-center">
                    <h1><center>Consulta Informacion Rayos X</center></h1>
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

        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script><!--

        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        -->        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
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
                        url: "ServletSat",

                        data: {
                            Inicio: Inicio,
                            Final: Final,
                            param: 2
                        },

                        success: function (data) {

                            $("#result").html(data);
                            console.log(data);
                            $(document).ready(function () {
                                
                                

                                $('#example tfoot th').each(function () {
                                    var title = $(this).text();
                                    $(this).html('<input type="text" placeholder="Search ' + title + '" />');
                                });
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
                                    ],
                                    initComplete: function () {
                                        // Apply the search
                                        this.api().columns().every(function () {
                                            var that = this;

                                            $('input', this.footer()).on('keyup change clear', function () {
                                                if (that.search() !== this.value) {
                                                    that
                                                            .search(this.value)
                                                            .draw();
                                                }
                                            });
                                        });
                                    }
                                });
                            });

                        },
                        error: function (jqXHR, textStatus, errorThrown) {

                            //                        document.getElementById("spinner").style.display = "none";
                        }

                    });

                }
            });



        </script>

    <jsp:include page="foot.jsp" flush="true"></jsp:include>

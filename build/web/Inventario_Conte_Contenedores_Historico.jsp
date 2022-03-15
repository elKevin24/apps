<%-- 
    Document   : newjsp
    Created on : 21/07/2021, 10:46:18 AM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <title>Inventario de Contenedores </title>
        <style>
            #spinner{
                display: none;
            }

        </style>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
        </head>
        <body>
        <%

            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);
            String codigo = user.getUSUARIO_DE_SERVICIO();

            System.err.println("CODIGO:  " + codigo);


        %>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header text-center">
                    <h1><center>Historico Inventario de Contenedor</center></h1>
                </div>
                <div class="card-body">

                    <!--<form class="row g-3" >-->
                    <div class="col-md-12">
                        <label for="validationDefault01" class="form-label">Firma Electrónica</label>
                        <input type="text" class="form-control" id="Firma_Electrónica"  required>
                    </div>
                    <div class="col-md-12">
                        <label for="validationDefault02" class="form-label">Ingrese el Contenedor</label>
                        <input type="text" class="form-control" id="Ingrese_Contenedor"  required>
                        <input id="usuario" type="hidden" value="<%= codigo%>">
                    </div>
                    <div class="col-md-3">
                        <button id="Generar_Firma" type="submit" class="btn btn-primary btn-sm">Generar Firma</button>
                        <button id="Consultar" type="submit" class="btn btn-primary btn-sm">Consultar</button>
                    </div>
                    <br>
                    <div id="datos">

                    </div>
                    <!--</form>-->
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
        <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
        <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
        <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script>

        <script>

            $("#Generar_Firma").click(function () {


                if ($("#Ingrese_Contenedor").val() == '')
                {
                    alert("Ingrese Contenedor");
                } else {
                    console.log($("#Ingrese_Contenedor").val());
                    var contenedor = $("#Ingrese_Contenedor").val();
                    $.ajax({
                        url: "Invetario",

                        data: {
                            conte: contenedor,
                            usuario: $('#usuario').val(),
                            param: 4
                        },

                        success: function (data) {

                            $("#Firma_Electrónica").val(data);

//                            document.getElementById("spinner").style.display = "none";

                        },
                        error: function (jqXHR, textStatus, errorThrown) {

//                            document.getElementById("spinner").style.display = "none";
                        }

                    });
                }


//                document.getElementById("spinner").style.display = "block";


            });

            $("#Consultar").click(function () {

                $("#datos").html(' ');

                $.ajax({
                    url: "Invetario",

                    data: {
                        firma: $("#Firma_Electrónica").val(),
                        usuario: $('#usuario').val(),
                        param: 5
                    },

                    success: function (data) {
                        $("#datos").html(data);
                        $(document).ready(function () {
                            $('#example').DataTable({
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
                                        orientation: 'landscape',
                                        pageSize: 'LEGAL'
                                    }
                                ]
                            });
                        });

                    }
                });
            });

        </script>
        <jsp:include page="foot.jsp" flush="true"></jsp:include>

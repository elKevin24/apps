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
                    <h1><center>Inventario de Contenedores </center></h1>
                </div>
                <div class="card-body">
                    <!--<form method="post" action="Inventario_Conte">-->
                    <div class="input-group">
                        <input id="firma" type="text" class="form-control" placeholder="Firma " aria-label="Recipient's username with two button addons">
                        <input id="usuario" type="hidden" value="<%= codigo%>">
                        <button id="consultar" type="submit" class="btn btn-outline-secondary" type="button">Consultar</button>
                        <button id="generar_firma"  type="submit" class="btn btn-outline-secondary" type="button">Generar Firma</button>
                    </div>
                    <div id="spinner" class="text-center">
                        <div class="spinner-border" role="status">
                            <span class="visually-hidden">Loading...</span>
                        </div>
                    </div>
                    <div id="datos">

                    </div>
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

            $("#generar_firma").click(function () {

                document.getElementById("spinner").style.display = "block";
                $.ajax({
                    url: "Invetario",

                    data: {
                        firma: $("#firma").val(),
                        usuario: $('#usuario').val(),
                        param: 2
                    },

                    success: function (data) {

                        $("#firma").val(data);

                        document.getElementById("spinner").style.display = "none";

                    },
                    error: function (jqXHR, textStatus, errorThrown) {

                        document.getElementById("spinner").style.display = "none";
                    }

                });

            });

            $("#consultar").click(function () {

                $.ajax({
                    url: "Invetario",

                    data: {
                        firma: $("#firma").val(),
                        usuario: $('#usuario').val(),
                        param: 1
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

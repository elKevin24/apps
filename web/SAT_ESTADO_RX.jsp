<%-- 
    Document   : Historico_Firmas_Inventario
    Created on : 18/11/2021, 09:54:28 AM
    Author     : kcordon
--%>

<%@page import="modelo.SAT"%>
<%@page import="controlador.BeanRX"%>
<%@page import="java.util.LinkedList"%>


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
        <!--<link href="css/newcss.css" rel="stylesheet" type="text/css"/>-->
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
        
    <%
        
        String id = request.getParameter("id");
            System.err.println("ID: "+id);

        %>


        <div id="ceiba">
            
        </div>


        <!--<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>-->
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
        <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
        <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
        <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script>

        <script>


            function ceiba() {

                $.ajax({
                    url: "ServletSat",
                    data: {

                        param: 1
                    },
                    success: function (data) {

                        $("#ceiba").html(data);
                        console.log("hola");
                        var table = $('table.display').DataTable({
                            "ordering": false,
                            "aLengthMenu": [[20, 50, 75, -1], [20, 50, 75, "All"]],
                            "iDisplayLength": 20,
                            dom: 'Bfrtip',
                            buttons: [

                                {
                                    extend: 'excelHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES'
                                },
                                {
                                    extend: 'pdfHtml5',
                                    title: 'INVENTARIO DE CONTENEDORES',
                                    pageSize: 'LEGAL'

                                }
                            ]
                        });
                        
                    }
                });

            }

//            function Sala_de_Control() {
//
//                $.ajax({
//                    url: "ServletSat",
//                    data: {
//
//                        param: 0
//                    },
//                    success: function (data) {
//
//                        $("#SALA").html(data);
//
//
//                    }
//                });
//
//            }

//            function Rayos_X() {
//
//                $.ajax({
//                    url: "ServletSat",
//                    data: {
//
//                        param: 2
//                    },
//                    success: function (data) {
//
//                        $("#Rayos_X").html(data);
//
//
//                        var table = $('table.display').DataTable({
//                            "order": [[0, "asc"]],
//                            "aLengthMenu": [[20, 50, 75, -1], [20, 50, 75, "All"]],
//                            "iDisplayLength": 20,
//                            dom: 'Bfrtip',
//                            buttons: [
//
//                                {
//                                    extend: 'excelHtml5',
//                                    title: 'INVENTARIO DE CONTENEDORES'
//                                },
//                                {
//                                    extend: 'pdfHtml5',
//                                    title: 'INVENTARIO DE CONTENEDORES',
//                                    pageSize: 'LEGAL'
//
//                                }
//                            ]
//                        });
//
//
//
//
//
//                    }
//                });
//
//            }
            ceiba();
//            Sala_de_Control();
//            Rayos_X();


            $(document).ready(function () {

//                setInterval(ceiba, 10000);
//                setInterval(Sala_de_Control, 32000);
//                setInterval(Rayos_X, 33000);

            });





        </script>

    <jsp:include page="foot.jsp" flush="true"></jsp:include>

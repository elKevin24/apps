<%-- 
    Document   : Manifiestos
    Created on : 10/03/2022, 16:49:54
    Author     : kcordon
--%>

<%@page import="modelo.Manifiestos"%>
<%@page import="controlador.CONTENEDORES_OPERADOS"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%
            String id = request.getParameter("id");

        %>
        <title>INFORMACION MANIFIESTOS</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
            <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
            <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
            <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        </head>
        <body>
            
        <table id="example" class="display" style="width:100%">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                LinkedList<CONTENEDORES_OPERADOS> lista = Manifiestos.CONTENEDORES_OPERADOS(id);
//          
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    
                    out.println("<td>" + lista.get(i).getMANIFIESTO() + "</td>");
                    out.println("<td>" + lista.get(i).getBUQUE() + "</td>");
                    out.println("<td>" + lista.get(i).getVIAJE() + "</td>");
                    out.println("<td>" + lista.get(i).getNAVIERA() + "</td>");
                    out.println("<td>" + lista.get(i).getMEDIDA() + "</td>");
                    out.println("</tr>");
                }
                        %>    
            </tbody>
            
        </table>
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
        <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
        <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
        <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script>
        <script>

            $(document).ready(function () {

                var table = $('#example').DataTable({
                    "order": false,
                    dom: 'Bfrtip',
                    pageLength : 20,
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
            });
        </script>
    </body>
    <jsp:include page="foot.jsp" flush="true"></jsp:include>

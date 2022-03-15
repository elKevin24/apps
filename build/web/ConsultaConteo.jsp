<%-- 
    Document   : ConsultaConteo
    Created on : 22/02/2021, 03:24:14 PM
    Author     : kcordon
--%>

<%@page import="modelo.Factura"%>
<%@page import="controlador.Conteo"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

        </head>
    <body>
        <table id="table_id" border="1"   class="table table-striped table-hover">
                        <thead>
                            <tr >

                                <th colspan="3" class="bg-info text-center" >CONSULTAS REALIZADAS A ESTE DOCUMENTO</th>
                                
                                



                            </tr>
                            <tr>

                                <th>CORL</th>
                                <th>GRABADOR</th>
                                <th>FECHA</th>
                                



                            </tr>
                        </thead>
                        <tbody>
                        <%
                            
                            String fac = String.valueOf(session.getAttribute("factura"));
                            int a = Integer.parseInt(fac);
                            LinkedList<Conteo> lista = Factura.ConsultaConteo(a);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                out.println("<td>" + lista.get(i).getPLPC_CORRELATIVO()+ "</td>");
                                out.println("<td>" + lista.get(i).getGRABADOR()+ "</td>");
                                out.println("<td>" + lista.get(i).getGRABADOR_FECHA()+ "</td>");

                                out.println("</tr>");
                            }
                            fac = null;
                        %>  
                    </tbody>
                </table>
    </body>
</html>

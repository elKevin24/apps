<%-- 
    Document   : Consulta
    Created on : 26/05/2021, 11:11:01 AM
    Author     : kcordon
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Carta"%>
<%@page import="controlador.BeanCarta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>

        <!--Import Google Icon Font-->
        <!--<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">-->
        <!--Import materialize.css-->
        <!--<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">-->

        <!-- Compiled and minified JavaScript -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <jsp:include page="head.jsp" flush="true"></jsp:include>

        </head>
        <body>


            <div class="container-fluid w-100">


                <div class="table-responsive">
                    <table id="example" border="1"   class="table mb-0 table-striped table-sm" >
                        <thead>
                            <tr>

                                <th>NUMERO</th>
                                <th>PREFIJO</th>
                                <th>IDENTIFICACION</th>
                                <th>MEDIDA</th>
                                <th>FECHA</th>
                                <th>ESTADO</th>
                                <th>VER</th>
                                <th>TRAZABILIDAD</th>

                            </tr>
                        </thead>
                        <tbody>
                        <%
                            //String usuario = String.valueOf(session.getAttribute("usuario"));

                            LinkedList<BeanCarta> lista = Carta.ConsultarPendientes();

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                out.println("<td>" + lista.get(i).getRW_ID_RECEPCION() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_PREFIJO_CONT() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_IDENTIFICACION_CONT() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_MEDIDA() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_FECHA_RECEPCION_WEB() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_ESTADO() + "</td>");

                                out.println("<td>" + "<a class='waves-effect waves-light btn-small ' onclick='return myFunction()'href=Detalle.jsp?consulta=" + lista.get(i).getRW_ID_RECEPCION() + ">" + "Ver" + "</a>" + "</td>");
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small ' onclick='return myFunction()'href=Detalle_1.jsp?consulta=" + lista.get(i).getRW_ID_RECEPCION() + ">" + "Trazabilidad" + "</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>
            </div>
        </div>



        <!--JavaScript at end of body for optimized loading-->



        <script type="text/javascript">

            $(document).ready(function () {
                // Setup - add a text input to each footer cell

                // DataTable
                var table = $('#example').DataTable({
                    "order": [[0, "desc"]]
                });

            });

            function validar() {
                if (confirm("Desea Borrar los datos?")) {
                    alert("Datos borrados exitosamente");
                } else {
                    alert("No se borrara");
                    return false;
                }
            }

        </script>
        <jsp:include page="foot.jsp" flush="true"></jsp:include>
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
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <!--<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">-->

        <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <jsp:include page="head.jsp" flush="true"></jsp:include>

        </head>
        <body>

            <div class="container-fluid w-100">
                <br>
                <div class="table-responsive">
                    <table id="example" border="1"   class="table mb-0 table-striped table-sm" >
                        <thead>
                            <tr>

                                <th>NUMERO</th>
                                <th>PREFIJO</th>
                                <th>IDENTIFICACION</th>
                                <th>MEDIDA</th>
                                <th>FECHA</th>
                                <th>VER</th>                               
                                <th>ELIMINAR</th>
                                <th>ENVIAR</th>




                            </tr>
                        </thead>
                        <tbody>
                        <%
                            //String usuario = String.valueOf(session.getAttribute("usuario"));

                            LinkedList<BeanCarta> lista = Carta.ConsultarLista();

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                out.println("<td>" + lista.get(i).getRW_ID_RECEPCION() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_PREFIJO_CONT() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_IDENTIFICACION_CONT() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_MEDIDA() + "</td>");
                                out.println("<td>" + lista.get(i).getRW_FECHA_RECEPCION_WEB() + "</td>");

                                out.println("<td>" + "<a class='waves-effect waves-light btn-small ' onclick='return myFunction()'href=Detalle.jsp?consulta=" + lista.get(i).getRW_ID_RECEPCION() + ">" + "Ver" + "</a>" + "</td>");
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small red accent-4' onclick='return validar()' href=Eliminar.jsp?consulta=" + lista.get(i).getRW_ID_RECEPCION() + ">" + "<i class='material-icons'>delete_forever</i></a>" + "</td>");
                                out.println("<td>" + "<a class='waves-effect waves-light btn-small light-blue darken-4' href=CambiarEstado.jsp?RW_ID_RECEPCION=" + lista.get(i).getRW_ID_RECEPCION() + ">" + "Enviar" + "</a>" + "</td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>


    <script type="text/javascript">

        $(document).ready(function () {
            // Setup - add a text input to each footer cell

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

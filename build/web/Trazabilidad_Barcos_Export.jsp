<%@page import="modelo.TrazabilidadBarcos"%>
<%@page import="controlador.Trazabilidad_Barcos"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="java.util.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Listado de Barcos</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>

<style>
                h3{
                    text-align: center;
                }
            </style>
        </head>
        <body>


            <div class="container">
                <div class="col s12">
                    <h3> Listado de Buques Carga </h3>
                    <table id="example" border="1"   class="display table table-hover table-bordered table-striped" >
                        <thead>
                            <tr>
                                <!--                                <th>LR</th>
                                                                <th>SEÑAL DISTINTIVA</th>-->
                                <th>NOMBRE BUQUE</th>
                                <th>VIAJE</th>
                                <th>FECHA</th>
                                <th>VER</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%

                            String usuario = String.valueOf(session.getAttribute("usuario"));
                            BeanUsuarios user = new BeanUsuarios();
                            user = Usuario.ObtenerUsuario(usuario);
                            String codigo = user.getUSUARIO_DE_SERVICIO();

                            System.err.println("" + codigo);

                            LinkedList<Trazabilidad_Barcos> lista = TrazabilidadBarcos.consultarBarco_Export(codigo);

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr>");
                                //out.println("<td class='text-center'>" + lista.get(i).getVIAJE_EMPORNAC() + "</td>");
                                // out.println("<td class='text-center'>" + lista.get(i).getSITUACION() + "</td>");
                                out.println("<td class='text-center'>" + lista.get(i).getNOMBRE_DEL_BUQUE() + "</td>");
                                out.println("<td class='text-center'>" + lista.get(i).getVIAJE_NAVIERA() + "</td>");
                                out.println("<td class='text-center'>" + lista.get(i).getFECHA().substring(0, 10) + "</td>");

                                out.println("<td class='text-center'>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()' href=Trazabilidad_Contenedores_Export.jsp?id=" + lista.get(i).getUSUARIO() + ">" + "VER" + "</a>" + "</td>");
                                out.println("</tr>");
                            }
                        %>  
                    </tbody>
                    <tfoot>
                        <tr>
                            <!--                            <th>LR</th>
                                                        <th>SEÑAL DISTINTIVA</th>-->
                            <th>NOMBRE BUQUE</th>
                            <th>VIAJE</th>
                            <th>FECHA</th>
                            <th>VER</th>
                        </tr>
                    </tfoot>
                </table>

            </div>
        </div>


        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/jszip-2.5.0/dt-1.10.24/af-2.3.6/b-1.7.0/b-colvis-1.7.0/b-html5-1.7.0/b-print-1.7.0/cr-1.5.3/date-1.0.3/fc-3.3.2/fh-3.1.8/kt-2.6.1/r-2.2.7/rg-1.1.2/rr-1.2.7/sc-2.0.3/sb-1.0.1/sp-1.2.2/sl-1.3.3/datatables.min.js"></script>

        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <!--<script src="js/jquery-3.5.1.js" type="text/javascript"></script>-->
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').DataTable({
                    "order": [[2, "desc"]]
                });
            });

        </script>

        <jsp:include page="foot.jsp" flush="true"></jsp:include>

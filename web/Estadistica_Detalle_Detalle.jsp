
<%@page import="controlador.BeanEstadistica_Detalle"%>
<%@page import="controlador.BeanEstadistico"%>
<%@page import="modelo.Estadistica"%>
<%@page import="controlador.BeanEOPV_VIAJES"%>
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

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        

        <link href="datatables_export/buttons.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link href="datatables_export/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

        <style>
            #chartdiv {
                width: 100%;
                height: 250px;
            }
            h3{
                text-align: center;
            }

        </style>
        <title>
            Detalles
        </title>


        <!-- Chart code -->
        <%
            String descarga_id = request.getParameter("id");
            String tipo = request.getParameter("tipo");
            System.err.println("id: " + descarga_id + "tipo: " + tipo);

        %>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
        </head>
        <body>
            <br>
            <h3>ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%></h3>
        <div class="container">
            <BR>
            <div class="table-responsive-sm">
                <table id="example" border="1"   class="display table table-hover table-bordered table-striped">
                    <thead>
                        <tr>
                            <th colspan="7">OPERADOS</th>
                        </tr>
                        <tr>
                            <th>No.</th>
                            <th>CONTENEDOR</th>
                            <th>CONDICION</th>
                            <th>PESO</th>
                            <th>MEDIDA</th>
                            <th>TIPO</th>
                            <th>ESTADO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%

                            String usuario = String.valueOf(session.getAttribute("usuario"));
                            BeanUsuarios user = new BeanUsuarios();
                            user = Usuario.ObtenerUsuario(usuario);
                            String codigo = user.getUSUARIO_DE_SERVICIO();

                            //System.err.println("CODIGO:  " + codigo);
                            LinkedList<BeanEstadistica_Detalle> lista = Estadistica.Consultar_Detalle_Descarga(descarga_id, tipo);

                            String peso = " ";
                            for (int i = 0; i < lista.size(); i++) {

                                if (lista.get(i).getPESO() == null) {
                                    peso = " ";

                                } else {
                                    peso = lista.get(i).getPESO();
                                }

                                out.println("<td>" + (i + 1) + "</td>");
                                out.println("<td>" + lista.get(i).getCONTENEDOR() + "</td>");
                                out.println("<td>" + lista.get(i).getCONDICION() + "</td>");
                                out.println("<td>" + peso + "</td>");
                                out.println("<td>" + lista.get(i).getMEDIDA() + "</td>");
                                out.println("<td>" + lista.get(i).getC_O_F() + "</td>");
                                out.println("<td>" + lista.get(i).getESTADO() + "</td>");
                                out.println("</tr>");
                            }
                        %> 

                    </tbody>
                    <tfoot>
                        <tr>
                            <th>No.</th>
                            <th>CONTENEDOR</th>
                            <th>CONDICION</th>
                            <th>PESO</th>
                            <th>MEDIDA</th>
                            <th>TIPO</th>
                            <th>ESTADO</th>
                        </tr>
                    </tfo<ot>
                </table>
            </div>



        </div>
        <script src="datatables_export/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="datatables_export/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="datatables_export/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="datatables_export/jszip.min.js" type="text/javascript"></script>
        <script src="datatables_export/pdfmake.min.js" type="text/javascript"></script>
        <script src="datatables_export/vfs_fonts.js" type="text/javascript"></script>
        <script src="datatables_export/buttons.html5.min.js" type="text/javascript"></script>

        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    dom: 'Bfrtip',
                    buttons: [

                        {
                            extend: 'copyHtml5',
                            title: 'ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%>'
                        },
                        {
                            extend: 'excelHtml5',
                            title: 'ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%>'
                        }, {
                            extend: 'csvHtml5',
                            title: 'ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%>'
                        },
                        {
                            extend: 'pdfHtml5',
                            title: 'ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%>'
                        }
                    ], "order": [6, 'desc']
                });
            });
        </script>

            <jsp:include page="foot.jsp" flush="true"></jsp:include>
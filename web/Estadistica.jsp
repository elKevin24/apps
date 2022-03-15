
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
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
        <jsp:include page="head.jsp" flush="true"></jsp:include>
            <title>Estadistica Buque</title>

            <style>
                h3{
                    text-align: center;
                }
            </style>
            <title>
                Litado de Buques
            </title>
        </head>
        <body>

            <div class="container-fluid">
                <div class="row">


                    <h3>Listado de Viajes</h3>
                    <div class="table-responsive-sm">
                        <table id="example" border="1"   class="display table table-hover table-bordered table-striped" >

                            <thead>

                                <tr>
                                    <th></th>
                                    <th>SITUACION</th>
                                    <th>BARCO</th>                                
                                    <th>GRAFICA</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%

                                String usuario = String.valueOf(session.getAttribute("usuario"));
                                BeanUsuarios user1 = new BeanUsuarios();
                                user1 = Usuario.Usuario_Menu(usuario);

                                BeanUsuarios user = new BeanUsuarios();
                                user = Usuario.ObtenerUsuario(user1.getCORREO());
                                String codigo = user.getUSUARIO_DE_SERVICIO();

                                System.err.println("CODIGO:  " + codigo);

                                LinkedList<BeanEOPV_VIAJES> lista = Estadistica.Consulta(codigo);

                                for (int i = 0; i < lista.size(); i++) {

                                    out.println("<tr onclick='myFunction(" + lista.get(i).getVIAJE_EMPORNAC() + ")'>");
                                    out.println("<td class='text-center'><img src='img/32.png'/></td>");
                                    out.println("<td><strong> SITUACION: </strong>" + lista.get(i).getSITUACION() + "<br><strong> VIAJE NAVIERA: </strong>"
                                            + lista.get(i).getVIAJE_NAVIERA() + "<br><strong> VIAJE EMPORNAC: </strong>" + lista.get(i).getVIAJE_EMPORNAC() + ""
                                            + "<br><strong> ATRAQUE: </strong>" + lista.get(i).getATRAQUE() + ""
                                            + "<br><strong> ZARPE: </strong>" + lista.get(i).getZARPE() + "</td>");

                                    out.println("<td> <strong> BARCO:  </strong>" + lista.get(i).getBARCO() + "<br><strong> TIPO BUQUE:  </strong>" + lista.get(i).getTIPO_BUQUE() + "<br><strong> LR: </strong>" + lista.get(i).getLR() + "</td>");
                                    out.println("<td class='text-center'><div id='" + lista.get(i).getVIAJE_EMPORNAC() + "' style='width: 400px; height: 150px;'></div></td>");
                                    out.println("</tr>");
                                }
                            %>  
                        </tbody>                            
                    </table>
                </div>
            </div>
        </div>




        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <!--<script src="js/jquery-3.5.1.js" type="text/javascript"></script>-->
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


        <script type="text/javascript">


            var lista = new Array();

            <%
                for (int i = 0; i < lista.size(); i++) {
            %>
            lista.push(["<%= lista.get(i).getVIAJE_EMPORNAC()%>", "<%= lista.get(i).getMINUENDO()%>", "<%= lista.get(i).getSUSTRAENDO()%>", "<%= lista.get(i).getDIFERENCIA()%>"]);
            <%
                }
            %>

            //            lista.forEach(element => console.log(element));

            $(document).ready(function () {
                $('#example').DataTable();
            });

        </script>

        <script type="text/javascript">

            for (var i = 0; i < lista.length; i++) {
                graf(lista[i][0], lista[i][1], lista[i][2], lista[i][3]);

            }
            function graf(viaje, total, porcentaje, resultado) {
                console.log(total, porcentaje, resultado);
                var num = parseInt(porcentaje);
                var num2 = parseInt(resultado);

                google.charts.load('current', {'packages': ['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                function drawChart() {

                    var data = google.visualization.arrayToDataTable([
                        ['Task', 'Hours per Day'],
                        ['Operados', num],
                        ['Pendientes', num2]
                    ]);

                    var options = {
                        title: 'Contenedores: ' + total + '',
                        legend: 'none'
                    };

                    var chart = new google.visualization.PieChart(document.getElementById(viaje));
                    chart.draw(data, options);
                }
            }




            function myFunction(variable) {
                location.href = "Estadistica_Detalle.jsp?id=" + variable + "";


            }
        </script>

        <!--JavaScript at end of body for optimized loading-->
        <jsp:include page="foot.jsp" flush="true"></jsp:include>

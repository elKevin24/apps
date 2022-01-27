
<%@page import="controlador.BeanDemoras"%>
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
        <title>
            Detalle Buque
        </title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
            <!--<script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>-->
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">

                var lista = new Array();
                var lista_carga = new Array();


            </script>

            <style>

                h3{
                    text-align: center;
                }

            </style>



        <%
            String descarga_id = request.getParameter("id");
            System.err.println("Estadistica Detalle: " + descarga_id);

        %>

    </head>
    <body onload="cargar_graficas()">

        <br>
        <h3>ESTADÍSTICA OPERACIÓN DEL BUQUE VIAJE EMPORNAC <%= descarga_id%></h3>

        <div class="container-fluid">

            <div class="card">
                <div class="card-body">

                    <div class="row justify-content-md-center">
                        <h3>OPERACION DESCARGA</h3>



                        <div class="col-md-auto">
                            <BR>
                            <div class="table-responsive">
                                <table id="example"  class="table table-sm table-hover table-bordered" >
                                    <thead>
                                        <tr>
                                            <th colspan="6">OPERACION DESCARGA</th> 
                                        </tr>
                                        <tr>
                                            <th>MEDIDA</th>
                                            <th>LISTADOS</th>
                                            <th colspan="2">OPERADOS</th>                                
                                            <th colspan="2">PENDIENTES</th>
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

                                            int listados = 0;
                                            int operados = 0;
                                            int pendientes = 0;

                                            System.err.println("CODIGO:  " + codigo);

                                            LinkedList<BeanEstadistico> lista = Estadistica.ConsultarID(descarga_id);

                                            for (int i = 0; i < lista.size(); i++) {
                                        %>
                                    <script>


                                        lista.push([<%= lista.get(i).getMEDIDA()%>, <%=lista.get(i).getOPERADOS()%>, <%= lista.get(i).getPENDIENTES()%>]);

                                    </script>                                    
                                    <%
                                            listados += Integer.parseInt(lista.get(i).getLISTADOS());
                                            operados += Integer.parseInt(lista.get(i).getOPERADOS());
                                            pendientes += Integer.parseInt(lista.get(i).getPENDIENTES());
                                            out.println("<td>" + lista.get(i).getMEDIDA() + "</td>");
                                            out.println("<td>" + lista.get(i).getLISTADOS() + "</td>");
                                            out.println("<td>" + lista.get(i).getOPERADOS() + "</td>");
                                            out.println("<td>" + lista.get(i).getPORCENTAJE_OPERADOS() + "%</td>");
                                            out.println("<td>" + lista.get(i).getPENDIENTES() + "</td>");
                                            out.println("<td>" + lista.get(i).getPORCENTAJE_PENDIENTES() + "%</td>");
                                            out.println("</tr>");
                                        }
                                    %>  


                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>TOTAL</th>
                                            <th><%= listados%></th>
                                            <th colspan="2" id="operados"><%= operados%></th>                                
                                            <th colspan="2" id="pendientes"><%= pendientes%></th>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>

                        <div class="col-md-auto" id="DESCARGA" onclick="DETALLE_DETALLE(<%= descarga_id%>, 1)">
                            <BR>

                            <!-- HTML -->
                            <div id="piechart" style="width: 100%; height: 250px; "></div>
                        </div>
                    </div>

                    <div class="row justify-content-md-center" id="pies"></div>

                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <div class="row justify-content-md-center">
                        <h3>OPERACION CARGA</h3>

                        <div class="col-md-auto">
                            <BR>
                            <div class="table-responsive-sm">
                                <table id="example"  class="table table-sm  table-hover table-bordered" >
                                    <thead>
                                        <tr>
                                            <th colspan="6">OPERACION CARGA</th> 
                                        </tr>
                                        <tr>
                                            <th>MEDIDA</th>
                                            <th>LISTADOS</th>
                                            <th colspan="2">OPERADOS</th>                                
                                            <th colspan="2">PENDIENTES</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%

                                            int listados_carga = 0;
                                            int operados_carga = 0;
                                            int pendientes_carga = 0;

                                            System.err.println("CODIGO:  " + codigo);

                                            LinkedList<BeanEstadistico> lista1 = Estadistica.Consultar_Carga(descarga_id);

                                            for (int i = 0; i < lista.size(); i++) {
                                        %>
                                    <script>


                                        lista_carga.push([<%= lista1.get(i).getMEDIDA()%> + '_carga', <%=lista1.get(i).getOPERADOS()%>, <%= lista1.get(i).getPENDIENTES()%>]);

                                    </script>                                    
                                    <%
                                            listados_carga += Integer.parseInt(lista1.get(i).getLISTADOS());
                                            operados_carga += Integer.parseInt(lista1.get(i).getOPERADOS());
                                            pendientes_carga += Integer.parseInt(lista1.get(i).getPENDIENTES());
                                            out.println("<td>" + lista1.get(i).getMEDIDA() + "</td>");
                                            out.println("<td>" + lista1.get(i).getLISTADOS() + "</td>");
                                            out.println("<td>" + lista1.get(i).getOPERADOS() + "</td>");
                                            out.println("<td>" + lista1.get(i).getPORCENTAJE_OPERADOS() + "%</td>");
                                            out.println("<td>" + lista1.get(i).getPENDIENTES() + "</td>");
                                            out.println("<td>" + lista1.get(i).getPORCENTAJE_PENDIENTES() + "%</td>");
                                            out.println("</tr>");
                                        }
                                    %>  


                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th>TOTAL</th>
                                            <th><%= listados_carga%></th>
                                            <th colspan="2" id="operados_carga"><%= operados_carga%></th>                                
                                            <th colspan="2" id="pendientes_carga"><%= pendientes_carga%></th>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>

                        </div>

                        <div class="col-md-auto" id="DESCARGA" onclick="DETALLE_DETALLE(<%= descarga_id%>, 2)">
                            <BR>

                            <!-- HTML -->
                            <div id="piechart_carga" style="width: 100%; height: 350px;"></div>
                        </div>
                    </div>

                    <div class="row justify-content-md-center"  id="pies_carga">
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-body">
                    <h3 class="text-decoration-underline">DEMORAS</h3>

                    <div class="table-responsive">
                        <table id="example"  class="table table-sm  table-hover table-bordered" >
                            <thead>

                                <tr>
                                    <th>No.</th>                                                               
                                    <th>NOMBRE</th>
                                    <th>DEMORA</th>
                                    <th>HORAS</th>                                
                                    <th>MINUTOS</th> 
                                    <th>CARGA</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%

                                    LinkedList<BeanDemoras> demoras = Estadistica.Consultar_Demoras(descarga_id);

                                    for (int i = 0; i < demoras.size(); i++) {

                                        out.println("<td>" + (i + 1) + "</td>");
                                        out.println("<td>" + demoras.get(i).getNOMBRE() + "</td>");
                                        out.println("<td>" + demoras.get(i).getDEMORA() + "</td>");
                                        out.println("<td>" + demoras.get(i).getHORAS() + "</td>");
                                        out.println("<td>" + demoras.get(i).getMINUTOS() + "</td>");
                                        out.println("<td>" + demoras.get(i).getCARGA() + "</td>");
                                        out.println("</tr>");
                                    }
                                %>  


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>

        <script>
                            function descarga() {
                                var operados = document.getElementById("operados").innerText;
                                var pendientes = document.getElementById("pendientes").innerText;
                                var num = parseInt(operados);
                                var num2 = parseInt(pendientes);

                                google.charts.load('current', {'packages': ['corechart']});
                                google.charts.setOnLoadCallback(drawChart);

                                function drawChart() {

                                    var data = google.visualization.arrayToDataTable([
                                        ['Task', 'Hours per Day'],
                                        ['Operados', num],
                                        ['Pendientes', num2]
                                    ]);

                                    var options = {
                                        title: 'Descarga'
                                    };

                                    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                                    chart.draw(data, options);
                                }
                            }

                            function carga() {
                                var operados = document.getElementById("operados_carga").innerText;
                                var pendientes = document.getElementById("pendientes_carga").innerText;
                                var num = parseInt(operados);
                                var num2 = parseInt(pendientes);

                                google.charts.load('current', {'packages': ['corechart']});
                                google.charts.setOnLoadCallback(drawChart);

                                function drawChart() {

                                    var data = google.visualization.arrayToDataTable([
                                        ['Task', 'Hours per Day'],
                                        ['Operados', num],
                                        ['Pendientes', num2]
                                    ]);

                                    var options = {
                                        title: 'Carga'
                                    };

                                    var chart = new google.visualization.PieChart(document.getElementById('piechart_carga'));

                                    chart.draw(data, options);
                                }
                            }

                            function cargar_graficas() {
                                carga();
                                descarga();

                            }



                            function DETALLE_DETALLE(variable, tipo) {
                                location.href = "Estadistica_Detalle_Detalle.jsp?id=" + variable + "&tipo=" + tipo + "";

                            }


                            function pintar(id, operados, pendientes) {
                                //console.log(id, operados, pendientes);

                                var num = parseInt(operados);
                                var num2 = parseInt(pendientes);
                                google.charts.load('current', {'packages': ['corechart']});
                                google.charts.setOnLoadCallback(drawChart);

                                function drawChart() {

                                    var data = google.visualization.arrayToDataTable([
                                        ['Operacion', 'Contenedores'],
                                        ['Operados', num],
                                        ['Pendientes', num2]
                                    ]);

                                    var options = {
                                        title: 'Contenedores de ' + id + ' '
                                    };

                                    var chart = new google.visualization.PieChart(document.getElementById(id));

                                    chart.draw(data, options);
                                }
                            }

                            $(document).ready(function () {
                                console.log(lista);
                                console.log(lista_carga);
                                //                document.getElementById("pies").innerHTML = '<div id="piechart" style="width: 900px; height: 500px;">a</div>';
                                for (var i = 0; i < lista.length; i++) {
                                    document.getElementById("pies").innerHTML += `<div class="col-md-auto border" style='width: 400px; height: 300px;' id="` + lista[i][0] + `" ></div>`;
                                    document.getElementById("pies_carga").innerHTML += `<div class="col-md-auto border" style='width: 400px; height: 300px;' id="` + lista_carga[i][0] + `" ></div>`;
                                    //console.log(lista[i][0]);

                                    pintar(lista[i][0], lista[i][1], lista[i][2]);
                                    pintar(lista_carga[i][0], lista_carga[i][1], lista_carga[i][2]);
                                }

                            });

        </script>
        <jsp:include page="foot.jsp" flush="true"></jsp:include>

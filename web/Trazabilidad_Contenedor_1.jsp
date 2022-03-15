<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="modelo.servicios_web"%>
<%@page import="modelo.TrazabilidadContenedores"%>
<%@page import="controlador.Trazabilidad_Contenedores"%>
<%@page import="modelo.TrazabilidadBarcos"%>
<%@page import="controlador.Trazabilidad_Barcos"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.Barcos"%>
<%@page import="controlador.BeanBarcos"%>
<%@page import="java.util.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp" flush="true"></jsp:include>
    <!DOCTYPE html>
    <html>

        <head>

            <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
            <script src="js/node_consultaDictamenManifiesto.js" type="text/javascript"></script>
            <script src="js/node_retencion_1.js" type="text/javascript"></script>
            <title>Trazabilidad Contenedor</title>
            <!--        <script src="js/node_retencion_1.js" type="text/javascript"></script>-->

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Compiled and minified JavaScript -->
            <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
            <!-- Compiled and minified JavaScript -->
            <!--Let browser know website is optimized for mobile-->
            <meta name="viewport" content="width=device-width, initial-scale=1.0"/>



        <%
            String usuario = String.valueOf(session.getAttribute("usuario"));
            if (usuario == "null") {
                System.out.println("entro al if del head");
        %>

        <META HTTP-EQUIV="REFRESH" CONTENT="0;URL=Login.jsp"> 

        <%
        } else {

            String id = request.getParameter("id");

            
            Trazabilidad_Contenedores cont = new Trazabilidad_Contenedores();
            cont = TrazabilidadContenedores.ManifiestoImport(id);

            
        %>

    </head>
    <body>
        <div class="container fluid">
            <div class="card">
                <div class="card-header text-center"><h3>Trazabilidad Contenedor  "<%= id%>"</h3></div>

            <!--<h3 class="text-center"> Trazabilidad Contenedor  "<%= id%>"</h3>-->
                <div class="card-body">
                    <div class="table-responsive-sm">
                        <table id="my-table" class="text-center  table table-bordered">
                            <tr class="p-3 mb-2 bg-primary text-white">
                                <th colspan="6" >Retenciones y Liberaciones por Instituciones</th>
                            </tr>
                            <tr class="celeste">
                                <th>Mensaje</th>
                                <th>MAGA</th>
                                <th>DIPA</th>
                                <th>SEPA</th>
                                <th>SGAIA</th>
                            </tr>
                            <tr>
                                <td id="mensaje"> </td>
                                <td id="MAGA"><img src="img/Bullet-grey.png"></td>
                                <td id="DIPA"><img src="img/Bullet-grey.png"></td>
                                <td id="SEPA"><img src="img/Bullet-grey.png"></td>
                                <td id="SGAIA"><img src="img/Bullet-grey.png"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="table-responsive">
                        <table id="my-table" class=" text-center table table-bordered">
                            <tr class="p-3 mb-2 bg-primary text-white">
                                <th colspan="6" >ATC</th>
                            </tr>
                            <tr class="celeste">
                                <th>Mensaje</th>
                                <th>No. Atc</th>
                                <th>Estado</th>
                                <th>Descripcion Estado</th>
                                <th>Fecha Estado Registrado</th>
                                <th>Fecha Estado Actual</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                    <div class="table-responsive-sm">
                        <table id="my-table" class="text-center table table-bordered">
                            <tr class="p-3 mb-2 bg-primary text-white">
                                <th colspan="5" >Informacion Manifiesto</th>
                            </tr>
                            <tr class="celeste">
                                <th>Fecha Recibido</th>
                                <th>No. Manifiesto</th>
                                <th>Nombre Buque</th>
                                <th>Viaje</th>
                                <th>ETA</th>
                            </tr>
                            <tr>
                                <td><%= cont.getC1()%></td>
                                <td><%= cont.getC2()%></td>
                                <td><%= cont.getC3()%></td>
                                <td><%= cont.getC4()%></td>
                                <td><%= cont.getC5()%></td>
                            </tr>
                        </table>
                    </div>

                    <div class="table-responsive-sm">
                        <table id="my-table" class="text-center table table-bordered">
                            <tr class="p-3 mb-2 bg-primary text-white">
                                <th colspan="5" >Dictamen Manifiesto</th>
                            </tr>
                            <tr class="celeste">
                                <th>Mensaje</th>
                                <th>Estatus Dictamen</th>
                                <th>Fecha Estado</th>
                                <th>Estatus</th>

                            </tr>
                            <tr>
                                <td id="MENSAJE">Esperando Respuesta de Sat</td>
                                <td id="estatus_dictamen"></td>
                                <td id="fecha_estado"> </td>
                                <td id="estatus"></td>

                            </tr>
                        </table>
                    </div>

                    <div id="resultado" class="z-index-n1 bg-white"></div>
                </div>
            </div>

        </div>

        <script>

            consultaDictamenManifiesto("<%=cont.getC2()%>");

            retencionode1("<%=id%>");

            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });

        </script>
        <script>


            function cambiar(id, fecha) {
                console.log(id);
                try {
                    // console.log(listaconte[i]);
                    document.getElementById(id).innerHTML = '<img src="img/bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion:' + fecha + ' ">';
                    // declaraciones para try  '<img src="img/new/Bullet-red.png" data-toggle="tooltip" data-placement="bottom" title="Fecha Retencion: ' + response.retencionLiberacion[i].fechaRetencion + '">';
                } catch (e) {
                    // pasar el objeto exception al controlador de errores (es decir, su propia función)
                }
            }

            $.ajax({
                url: "ServletWS",
                data: {

                    id: '<%=id %>'

                },
                success: function (result) {
                    $("#resultado").html(result);
                }
            });





        </script>

        <jsp:include page="foot.jsp" flush="true"></jsp:include>

        <%

            }
        %>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
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
<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="js/node_retencion.js" type="text/javascript"></script>
<script src="js/node_retencion_2.js" type="text/javascript"></script>
<script src="js/node_atc.js" type="text/javascript"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">


<!--Let browser know website is optimized for mobile-->

<title>Listado de Contenedores</title>

<jsp:include page="head.jsp" flush="true"></jsp:include>


    <style>
        h3{
            text-align: center;
        }
    </style>

    <title>Listado de Barcos</title>
<%
    String id = request.getParameter("id");

%>
<body>


    <div class="container-fluid">
        <h3 class="center">Listado de Contenedores Descarga</h3>
        <div class="table-responsive-sm">
            <table id="example" border="1"  class="display table table-hover table-bordered table-striped" >
                <thead>
                    <tr>
                        <th>NUMERO CONTENEDOR</th>
                        <th>FECHA DESCARGA</th>
                        <th>REVISION NO INTRUSIVA</th>
                        <th>UBICACION PATIO DAT</th>
                        <th>PESAJE BASCULA</th>
                        <th>SALIDA DAT</th>
                        <th>SALIDA DAT</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                System.err.println("Viaje Barco" + id);

                        String usuario = String.valueOf(session.getAttribute("usuario"));
                        BeanUsuarios user1 = new BeanUsuarios();
                        user1 = Usuario.Usuario_Menu(usuario);

                        BeanUsuarios user = new BeanUsuarios();
                        user = Usuario.ObtenerUsuario(user1.getCORREO());
                        String codigo = user.getUSUARIO_DE_SERVICIO();

                        LinkedList<Trazabilidad_Contenedores> lista = TrazabilidadContenedores.consultarCont(id, codigo);

                        String json = new Gson().toJson(lista);
                    %>  

                </tbody>                
            </table>
        </div>
    </div>


    <!--<script src="js/jquery-3.5.1.js" type="text/javascript"></script>-->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>


    <script type="text/javascript">



        $(document).ready(function () {

            $('[data-toggle="tooltip"]').tooltip();

            var table = $('#example').DataTable({
                columns: [
                    {name: "C1", data: "C1"},
                    {name: "C2", data: "C2"},
                    {name: "C3", data: "C3"},
                    {name: "C4", data: "C4"},
                    {name: "C5", data: "C5"},
                    {name: "C5", data: "C5"},
                    {name: "C6", data: "C6"}


                ],

                data: <%= json%>,
                "drawCallback": function (settings) {
                    var api = this.api();

                    table_filtered = api.rows({page: 'current'});

//            console.log({data: table_filtered.data()});

                    var data = table_filtered.data().toArray();

                    data.forEach(function (dat, index) {
                        console.log("No " + index + "Dato" + dat.C5);
                        if (dat.C5 == "0") {
                            console.log("soy cero");
                        }
                    });

                }

                //}
            });



        });


    </script>

    <!--JavaScript at end of body for optimized loading-->

    <jsp:include page="foot.jsp" flush="true"></jsp:include>
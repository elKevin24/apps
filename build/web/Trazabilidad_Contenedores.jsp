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
        <h3 class="center"> Listado de Contenedores Descarga</h3>
        <div class="table-responsive-sm">
            <table id="example" border="1"   class="display table table-hover table-bordered table-striped" >
                <thead>
                    <tr>

                        <th>NUMERO CONTENEDOR</th>
                        <th>FECHA DESCARGA</th>
                        <th>REVISION NO INTRUSIVA</th>
                        <th>RETENCION</th>
                        <th>ATC</th>
                        <th>UBICACION PATIO DAT</th>
                        <th>PESAJE BASCULA</th>
                        <th>SALIDA DAT</th>
                        <th>DETALLE</th>

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

                        for (int i = 0; i < lista.size(); i++) {

                    %>
                <script>

                    retencionode("<%= lista.get(i).getC1()%>");
                    atc("<%= lista.get(i).getC1()%>");


                </script>

                <%

                        out.println("<tr>");
                        //1
                        out.println("<td>" + lista.get(i).getC1() + "</td>");
                        //2
                        out.println("<td id='prueba'>" + lista.get(i).getC2() + "</td>");
                        //3
                        if (lista.get(i).getC3() != null) {
                            out.println("<td class='text-center'> <label style='display: none;'>1</label> <img src='img/bullet-green.png' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getC3() + "'></></td>");

                        } else {
                            out.println("<td class='text-center'> <img src='img/bullet-red.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Sin Escaneo'></></td>");
                        }

                        //5
                        out.println("<td id='" + lista.get(i).getC1() + "' class='text-center'><label style='display: none;'>1</label><img src='img/bullet-green.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Sin Retenciones'></td>");

                        //6
                        out.println("<td id='" + lista.get(i).getC1() + "atc' class='text-center'> <img src='img/bullet-red.png' data-bs-toggle='tooltip' data-bs-placement='top' title='No Registrado'></></td>");

                        //7
                        if (lista.get(i).getC6() == null || (lista.get(i).getC6().equals("NO"))) {
                            out.println("<td class='text-center'> <img src='img/bullet-red.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Sin Ubicacion'></></td>");
                        } else {
                            out.println("<td class='text-center'> <label style='display: none;'>1</label><img src='img/bullet-green.png' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getC6() + "'></></td>");
                        }
                        //4
                        if (lista.get(i).getC4().substring(0, 1).equals("R")) {
                            out.println("<td class='text-center'> <img src='img/bullet-red.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Sin Peso'></></td>");
                        } else if (lista.get(i).getC4().substring(0, 1).equals("V")) {
                            out.println("<td class='text-center'> <label style='display: none;'>1</label><img src='img/bullet-green.png' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getC4().substring(1) + "'></a></td>");
                        } else {
                            out.println("<td class='text-center'> <label style='display: none;'>2</label><img src='img/bullet-yellow.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Solo Primer Peso: " + lista.get(i).getC4().substring(1, 12) + "'></a></td>");
                        }
                        //8
                        if (lista.get(i).getC5() != null) {
                            out.println("<td class='text-center'><label style='display: none;'>1</label> <img src='img/bullet-green.png' data-bs-toggle='tooltip' data-bs-placement='top' title='" + lista.get(i).getC5() + "'></></td>");

                        } else {
                            out.println("<td class='text-center'> <img src='img/bullet-red.png' data-bs-toggle='tooltip' data-bs-placement='top' title='Sin Salida'></></td>");
                        }

                        out.println("<td class='text-center'>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()' href=Trazabilidad_Contenedor.jsp?id=" + lista.get(i).getC1() + ">" + "Detalle" + "</a>" + "</td>");

                        out.println("</tr>");
                    }


                %>  
                </tbody>

                <tfoot>
                    <tr>
                        <th>NUMERO CONTENEDOR</th>
                        <th>FECHA DESCARGA</th>
                        <th>REVISION NO INTRUSIVA</th>
                        <th>PESAJE BASCULA</th>
                        <th>RETENCION </th>
                        <th>ATC</th>
                        <th>UBICACION PATIO DAT</th>
                        <th>SALIDA DAT</th>
                        <th>DETALLE</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>


    <!--<script src="js/jquery-3.5.1.js" type="text/javascript"></script>-->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>


    <script type="text/javascript">



                    $(document).ready(function () {
                        $('[data-toggle="tooltip"]').tooltip();
                        $('#example').dataTable({
                            "drawCallback": function (settings) {

                                array();
                                array_atc();

                                $('[data-toggle="tooltip"]').tooltip();


                            }, "order": [[0, "asc"]]
                                    //}
                        });
                    });


    </script>

    <!--JavaScript at end of body for optimized loading-->

    <jsp:include page="foot.jsp" flush="true"></jsp:include>
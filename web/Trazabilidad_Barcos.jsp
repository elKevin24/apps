
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
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
       
        <title>Trazabilidad Empornac</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>

            <style>
                h3{
                    text-align: center;
                }
            </style>
        </head>
        <body>


            <div class="container-fluid">
                <br>
                <h3> Listado de Buques Descarga </h3>
                <table id="example" border="1"   class="display table table-hover table-bordered table-striped" >
                    <thead>
                        <tr>                            
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

                        System.err.println("CODIGO:  " + codigo);

                        LinkedList<Trazabilidad_Barcos> lista = TrazabilidadBarcos.consultarBarco(codigo);

                        for (int i = 0; i < lista.size(); i++) {

                            out.println("<tr>");
                            //out.println("<td class='text-center'>" + lista.get(i).getVIAJE_EMPORNAC() + "</td>");
                            out.println("<td class='text-center'>" + lista.get(i).getNOMBRE_DEL_BUQUE() + "</td>");
                            out.println("<td class='text-center'>" + lista.get(i).getVIAJE_NAVIERA() + "</td>");
                            out.println("<td class='text-center'>" + lista.get(i).getFECHA() + "</td>");
                            out.println("<td class='text-center'>" + "<a class='waves-effect waves-light btn-small' onclick='return myFunction()' href=Trazabilidad_Contenedores.jsp?id=" + lista.get(i).getVIAJE_EMPORNAC() + ">" + "VER" + "</a>" + "</td>");
                            out.println("</tr>");
                        }
                    %>  
                </tbody>                
            </table>

        </div>


    <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <!--<script src="js/jquery-3.5.1.js" type="text/javascript"></script>-->
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#example').DataTable( {
        "order": [[ 2, "desc" ]]
    });
        });

    </script>

            <!--JavaScript at end of body for optimized loading-->
            <jsp:include page="foot.jsp" flush="true"></jsp:include>

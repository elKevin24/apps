<%-- 
    Document   : Usuarios
    Created on : 17/12/2021, 11:06:11 AM
    Author     : kcordon
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
<!DOCTYPE html>
<%

    String usuario = String.valueOf(session.getAttribute("usuario"));
    if (usuario == "null") {
        System.out.println("entro al if");
        response.sendRedirect("Login.jsp");

    } else {
        BeanUsuarios user1 = new BeanUsuarios();
        user1 = Usuario.Usuario_Menu(usuario);

        BeanUsuarios user = new BeanUsuarios();
        user = Usuario.ObtenerUsuario(user1.getCORREO());

        


%>

<jsp:include page="head.jsp" flush="true"></jsp:include>


<div class="container-fluid">
    <br>
    <div class="card">
        <h5 class="card-header">Solicitudes de Usuarios</h5>
        <div class="card-body">
            <div class="table-responsive">
                <table id="example" border="1"   class="display table table-hover table-bordered table-striped" style="width:100%">

                    <thead>

                        <tr>
                            <th>SOLICITUD</th>
                            <th>USUARIO SERVICIO</th>
                            <th>USUARIO CREA</th>
                            <th>NOMBRES </th>
                            <th>APELLIDOS</th>
                            <!--<th>PUESTO EMPRESA</th>-->
                            <th>CORREO</th>
                            <th>DPI</th>
<!--                            <th>FECHA NACIMIENTO</th>
                            <th>FECHA CREACION</th>
                            <th>TIPO USUARIO</th>

                            <th>CATEGORIA SERVICIO</th>
                            <th>DPI</th>
                            <th>CARNET</th>
                            <th>REPRESENTANTE</th>-->

                        </tr>
                    </thead>
                    <tbody>
                        <%                                LinkedList<controlador.Usuario> lista = modelo.Usuario.Solicitudes_Usuario();

                            for (int i = 0; i < lista.size(); i++) {

                                out.println("<tr onclick='myFunction(" + lista.get(i).getUPIS_SOLICITUD() + ")'>");
                                //1
                                out.println("<td>" + lista.get(i).getUPIS_SOLICITUD() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_ID_USUARIO_SERVICIO() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_ID_USUARIO_CREA() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_NOMBRES() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_APELLIDOS() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_DPI() + "</td>");
                                out.println("<td>" + lista.get(i).getUPIS_FECHA_CREACION() + "</td>");
//                                out.println("<td>" + lista.get(i).getUPIS_ESTADO()+ "</td>");
//                                out.println("<td>" + lista.get(i).getUPIS_TIPO_USUARIO() + "</td>");
//                                out.println("<td>" + lista.get(i).getUPIS_CATEGORIA() + "</td>");
//                                out.println("<td><a href='download?usuario_servicio=" + lista.get(i).getUPIS_ID_USUARIO_SERVICIO() + "&DPI=" + lista.get(i).getUPIS_DPI() + "&TIPO=FILE_DPI'>Click Here To Download</a></td>");
//                                out.println("<td><a href='download?usuario_servicio=" + lista.get(i).getUPIS_ID_USUARIO_SERVICIO() + "&DPI=" + lista.get(i).getUPIS_DPI() + "&TIPO=FILE_CARNET'>Click Here To Download</a></td>");
//                                out.println("<td><a href='download?usuario_servicio=" + lista.get(i).getUPIS_ID_USUARIO_SERVICIO() + "&DPI=" + lista.get(i).getUPIS_DPI() + "&TIPO=FILE_LEGAL'>Click Here To Download</a></td>");

                                out.println("</tr>");
                            }
                        %>  
                    </tbody>                            
                </table>
            </div>


        </div>
    </div>
</div>
<%
    }
%>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
<script type="text/javascript">



    $(document).ready(function () {

        $('#example').dataTable({
            "order": [[0, "desc"]]
                    //}
        });
    });
    
    function myFunction(variable) {
                location.href = "Usuarios_Solicitud_Detalle.jsp?id=" + variable + "";


            }


</script>
<jsp:include page="foot.jsp" flush="true"></jsp:include>

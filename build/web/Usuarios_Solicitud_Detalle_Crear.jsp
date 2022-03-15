<%-- 
    Document   : Usuarios
    Created on : 17/12/2021, 11:06:11 AM
    Author     : kcordon
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
        String id = request.getParameter("id");
        controlador.Usuario sol = new controlador.Usuario();
        sol = Usuario.Solicitud_Usuario(id);




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

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th><%= sol.getUPIS_SOLICITUD()%></th>
                            <th><%= sol.getUPIS_ID_USUARIO_SERVICIO()%></th>
                            <th><%= sol.getUPIS_ID_USUARIO_CREA()%></th>
                            <th><%= sol.getUPIS_NOMBRES()%></th>
                            <th><%= sol.getUPIS_APELLIDOS()%></th>
                        </tr>
                    </tbody>
                    <thead>

                        <tr>

                            <th>PUESTO EMPRESA</th>
                            <th>CORREO</th>
                            <th>DPI</th>
                            <th>FECHA NACIMIENTO</th>
                            <th>FECHA CREACION</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th><%= sol.getUPIS_PUESTO_EMPRESA()%></th>
                            <th><%= sol.getUPIS_CORREO()%></th>
                            <th><%= sol.getUPIS_DPI()%></th>
                            <th><%= sol.getUPIS_FECHA_NAC()%></th>
                            <th><%= sol.getUPIS_FECHA_CREACION()%></th>
                        </tr>
                    </tbody>
                    <thead>

                        <tr>

                            <th>TIPO USUARIO</th>
                            <th>CATEGORIA SERVICIO</th>
                            <th>DPI</th>
                            <th>CARNET</th>
                            <th>REPRESENTANTE LEGAL</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th><%= sol.getUPIS_TIPO_USUARIO()%></th>
                            <th><%= sol.getUPIS_CATEGORIA()%></th>
                            <th><a href="download?usuario_servicio=<%= sol.getUPIS_ID_USUARIO_SERVICIO()%>&DPI=<%= sol.getUPIS_DPI()%>&TIPO=FILE_DPI">Ver Archivo</a></th>
                            <th><a href="download?usuario_servicio=<%= sol.getUPIS_ID_USUARIO_SERVICIO()%>&DPI=<%= sol.getUPIS_DPI()%>&TIPO=FILE_CARNET">Ver Archivo</a></th>
                            <th><a href="download?usuario_servicio=<%= sol.getUPIS_ID_USUARIO_SERVICIO()%>&DPI=<%= sol.getUPIS_DPI()%>&TIPO=FILE_LEGAL">Ver Archivo</a></th>
                            
                        </tr>
                    </tbody>

                </table>
                            <button type="submit" class="btn btn-primary">Crear Usuario</button>
            </div>


        </div>
    </div>
</div>
<%
    }
%>

<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script type="text/javascript">



    $(document).ready(function () {

        $('#example').dataTable({
            "order": [[0, "desc"]]
                    //}
        });
    });


</script>
<jsp:include page="foot.jsp" flush="true"></jsp:include>

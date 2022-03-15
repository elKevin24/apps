<%-- 
    Document   : Usuarios
    Created on : 17/12/2021, 11:06:11 AM
    Author     : kcordon
--%>

<%@page import="modelo.CartaBarcos"%>
<%@page import="controlador.BeanCartaBarcos"%>
<%@page import="controlador.BeanCartaBarcos"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="css/custom.css" rel="stylesheet" type="text/css"/>
<%

    String usuario = String.valueOf(session.getAttribute("usuario"));
    if (usuario == "null") {
        System.out.println("entro al if");
        response.sendRedirect("Login.jsp");

    } else {
        BeanUsuarios user = new BeanUsuarios();
        user = Usuario.ObtenerUsuario(usuario);
        System.err.println("Usuario " + usuario);
        System.err.println("USUARIO_DE_SERVICIO " + user.getUSUARIO_DE_SERVICIO());
        System.err.println("USER ID " + user.getUSERID());
        System.err.println("getUSUARIO_INOW " + user.getUSUARIO_INOW());
        System.err.println("getNOMBRE " + user.getNOMBRE());


%>

<jsp:include page="head.jsp" flush="true"></jsp:include>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    


    <div class="container-fluid">
        <br>
        <div class="card">
            <h5 class="card-header">Recepcion Web Excel</h5>
            <div class="card-body">
                <form class="row g-3" action="Usuario" method="post" enctype="multipart/form-data" autocomplete="off">
                    <input type="hidden" id="USER_ID" name="USER_ID" value="<%= user.getUSERID()%>">
                <input type="hidden" id="NAVIERA_ID" name="NAVIERA_ID" value="<%= user.getUSUARIO_DE_SERVICIO()%>">

                <div class="col-md-4">
                    <label for="BUQUE" class="form-label ">NOMBRE BUQUE</label>
                    <select class="form-control js-example-basic-single" style="width:100%" id="BUQUE" name="BUQUE" required>
                        <option value="" disabled selected>NOMBRE BUQUE</option>
                        <%                                            LinkedList<BeanCartaBarcos> lista = CartaBarcos.ConsultarLista();

                            for (int i = 0; i < lista.size(); i++) {


                        %>

                        <option value="<%= lista.get(i).getSENAL()%>_<%= lista.get(i).getLR()%>"><%= lista.get(i).getNOMBRE()%></option>
                        <%
                            }

                        %>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="formFile" class="form-label">Archivo Excel</label>
                    <input class="form-control" type="file" id="FILE_EXCEL" name="FILE_EXCEL">
                </div>




                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Crear Usuario</button>
                </div>
            </form>

        </div>
    </div>
</div>
<%    }


%>
<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

<script>

    $(document).ready(function () {
        $('.js-example-basic-single').select2();
    });
</script>
<jsp:include page="foot.jsp" flush="true"></jsp:include>

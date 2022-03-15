<%-- 
    Document   : Usuarios
    Created on : 17/12/2021, 11:06:11 AM
    Author     : kcordon
--%>

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
        BeanUsuarios user1 = new BeanUsuarios();
        user1 = Usuario.Usuario_Menu(usuario);

        BeanUsuarios user = new BeanUsuarios();
        user = Usuario.ObtenerUsuario(user1.getCORREO());
        System.err.println("getCATEGORIA " + user1.getCATEGORIA());

    


%>

<jsp:include page="head.jsp" flush="true"></jsp:include>



<div class="container">
    <br>
    <div class="card">
        <h5 class="card-header">Registro de Usuarios</h5>
        <div class="card-body">
            <form class="row g-3" action="Usuario" method="post" enctype="multipart/form-data" autocomplete="off">
                <input type="hidden" id="USER_ID" name="USER_ID" value="<%= usuario %>">
                <input type="hidden" id="NAVIERA_ID" name="NAVIERA_ID" value="<%= user.getUSUARIO_DE_SERVICIO()%>">
                <input type="hidden" id="CATEGORIA" name="CATEGORIA" value="<%= user1.getCATEGORIA()%>">
                <div class="col-md-5">
                    <label for="NOMBRES" class="form-label">NOMBRES</label>
                    <input type="text" class="form-control rounded" id="NOMBRES" name="NOMBRES" required>
                </div>
                <div class="col-md-5">
                    <label for="APELLIDOS" class="form-label">APELLIDOS</label>
                    <input type="text" class="form-control rounded" id="APELLIDOS" name="APELLIDOS" required>
                </div>
                <div class="col-md-2">
                    <label for="RW_FECHA_VIAJE_BARCO" class="form-label ">FECHA NACIMIENTO</label>
                    <br>
                    <input type="date"  id="RW_FECHA_VIAJE_BARCO" name="FECHA_NACIMIENTO" class="form-control rounded validate" required>
                </div>

                <div class="col-md-4">
                    <label for="inputEmail4" class="form-label">Email Institucional</label>
                    <input type="email" class="form-control rounded" id="inputEmail4" name="inputEmail4" required="">
                </div>
                <div class="col-md-4">
                    <label for="CARGO" class="form-label">CARGO QUE DESEMPEÑA EN LA EMPRESA</label>
                    <input type="text" class="form-control rounded" id="CARGO"  name="CARGO" required>
                </div>
                <div class="col-md-4">
                    <label for="DPI" class="form-label">DPI</label>
                    <input type="number" class="form-control rounded" id="DPI" name="DPI" minlength="12" required>
                </div>

                
                <div class="mb-3">
                    <label for="formFile" class="form-label">Adjuntar copia del DPI</label>
                    <input class="form-control" type="file" id="FILE_DPI" name="FILE_DPI">
                </div>
                <div class="mb-3">
                    <label for="formFile" class="form-label">Adjuntar copia del carnet de la empresa</label>
                    <input class="form-control" type="file" id="FILE_CARNET" name="FILE_CARNET">
                </div>
                <div class="mb-3">
                    <label for="formFile" class="form-label">Adjuntar copia de representante legal</label>
                    <input class="form-control" type="file" id="FILE_LEGAL" name="FILE_LEGAL">
                </div>


                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Crear Usuario</button>
                </div>
            </form>

        </div>
    </div>
</div>
<%
                 }


%>
                
<jsp:include page="foot.jsp" flush="true"></jsp:include>

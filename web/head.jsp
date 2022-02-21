<%-- 
    Document   : head
    Created on : 18/01/2022, 11:06:27 AM
    Author     : kcordon
--%>


<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String usuario = String.valueOf(session.getAttribute("usuario"));

//    
    if (usuario == "null") {
        System.out.println("entro al if de Trazabilidad");
        response.sendRedirect("Login.jsp");

    } else {

        BeanUsuarios user = new BeanUsuarios();
        user = Usuario.Usuario_Menu(usuario);
        System.err.println("tipo: " + user.getTIPO());
        System.err.println("categoria: " + user.getCATEGORIA());
        if (user.getCATEGORIA().equalsIgnoreCase("1")) {
%>

<jsp:include page="head_1.jsp" flush="true"></jsp:include>

<%    } else if (user.getCATEGORIA().equalsIgnoreCase("2")) {

%>

<jsp:include page="head_2.jsp" flush="true"></jsp:include>
<%    
    } else if (user.getCATEGORIA().equalsIgnoreCase("3")){
%>
<jsp:include page="head_3.jsp" flush="true"></jsp:include>
<%
        }else{

%>
<jsp:include page="head_4.jsp" flush="true"></jsp:include>
<%

}
    }
%>



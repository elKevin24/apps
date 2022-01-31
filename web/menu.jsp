<%-- 
    Document   : menu
    Created on : 15/10/2021, 01:11:34 PM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Santo Tomas Port</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>


<%

    String usuario = String.valueOf(session.getAttribute("usuario"));

    if (usuario == "null") {
        System.out.println("entro al if");
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



<!--    <div>
        <img src="img/menu.JPG" width="100%" height="100%" alt=""/>
    </div>-->

<body>



    <style>
        #back {
            background-image: url('img/menu.JPG');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
            width: 100%;
            height: auto;
        }
    </style>

</body>
<jsp:include page="foot.jsp" flush="true"></jsp:include>


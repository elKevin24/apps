<%-- 
    Document   : head
    Created on : 18/01/2022, 11:06:27 AM
    Author     : kcordon
--%>

<%@page import="java.util.Timer"%>
<%@page import="java.util.TimerTask"%>
<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String usuario = String.valueOf(session.getAttribute("usuario"));

//    
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
<%} else {
%>
<jsp:include page="head_3.jsp" flush="true"></jsp:include>
<%
        }
    }
%>

<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script>

//    $(document).ready(function () {
//        var a = 0;
//        function Session() {
//
//
//            $.ajax({
//                url: "ServletSession",
//
//                data: {
//                    firma: $("#firma").val(),
//                    usuario: $('#usuario').val(),
//                    param: 2
//                },
//
//                success: function (data) {
//
////                        $("#firma").val(data);
//
////                        document.getElementById("spinner").style.display = "none";
//                    console.log(data);
//
//                },
//                error: function (jqXHR, textStatus, errorThrown) {
//
////                        document.getElementById("spinner").style.display = "none";
//                }
//
//            });
////            console.log("hola" + a++);
//        }
//        setInterval(Session, 1000);
//    });

</script>
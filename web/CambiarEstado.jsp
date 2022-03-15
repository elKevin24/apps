<%-- 
    Document   : Eliminar
    Created on : 24/11/2020, 04:25:46 PM
    Author     : kcordon
--%>


<%@page import="controlador.BeanCarta"%>
<%@page import="modelo.Carta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <title>Eliminar Cotizacion</title>
    </head>
    <body>


        <%

            String id = request.getParameter("RW_ID_RECEPCION");

            
            
            
            
            boolean res = false;
            if (id.length() > 0) {
                res = Carta.CambiarEstado(id);
                
            }
            
            boolean ins = Carta.agregarTrazabilidad(id);
            if(ins == true){
                System.err.println("se hizo el insert");
            }else{
                System.out.println("No se hizo el insert");
            }

            if (res == true) {

                response.sendRedirect("EstadoCarta.jsp");

            } else {
                out.println("<script> alert('Registro no eliminado')</script>");

            }

        %>





    </body>



</html>

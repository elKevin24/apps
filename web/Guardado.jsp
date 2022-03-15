<%-- 
    Document   : Guardado
    Created on : 3/06/2018, 03:32:42 PM
    Author     : busqu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head> 
    <link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
<style>
    body {
        font-family: 'Playball', cursive;

    }
  </style>
  <title>Refrescar la URL</title> 
  <%
      
  String id = request.getParameter("id");
  
    
  
  %>

  <META HTTP-EQUIV="REFRESH" CONTENT="2;URL=Detalle.jsp?consulta=<%= id %>"> 
</head> 
<body> 
    
    
<center> <h1> Registrado  </h1></center>
    <center> <img src="IMG/descarga.png" width="400" alt=""/> </center>
Hora: 
<script> 
miFecha = new Date() 
document.write(miFecha.getHours() + ":" + miFecha.getMinutes() + ":" + miFecha.getSeconds()) 
</script> 
</body> 
</html>
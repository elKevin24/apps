<%-- 
    Document   : pilotos
    Created on : 16/06/2021, 05:45:38 PM
    Author     : kcordon
--%>

<%@page import="modelo.Pilotos"%>
<%@page import="controlador.BeanPilotos"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>

        <title>Mantenimiento Pilotos</title>
        
        <%

            BeanPilotos a = new BeanPilotos();
            a = Pilotos.Consultar();

        %>
    </head>
    <body>
        <div class="container-fluid">

            <div class="card">
                <div class="card-header text-center">
                    Mantenimiento de Pilotos
                </div>
                <div class="card-body">



                    <form class="row g-3" action="ServletPiloto" method="post" >
                        <div class="col-md-3">
                            <label for="Nombre" class="inputGroup-sizing-default">Primer Nombre</label>
                            <input type="text" class="form-control" id="Nombre" name="Nombre">
                        </div>
                        <div class="col-md-3">
                            <label for="SegundoNombre" class="inputGroup-sizing-default">Segundo Nombre</label>
                            <input type="text" class="form-control" id="SegundoNombre"  name="SegundoNombre">
                        </div>
                        <div class="col-md-3">
                            <label for="Apellido" class="inputGroup-sizing-default">Primer Apellido</label>
                            <input type="text" class="form-control" id="Apellido" name="Apellido">
                        </div>
                        <div class="col-md-3">
                            <label for="SegundoApellido" class="inputGroup-sizing-default">Segundo Apellido</label>
                            <input type="text" class="form-control" id="SegundoApellido" name="SegundoApellido">
                        </div>
                        <div class="col-md-6">
                            <label for="Licencia" class="inputGroup-sizing-default">Licencia</label>
                            <input type="text" class="form-control" id="Licencia" name="Licencia">
                        </div>
                        <div class="col-md-3">
                            <label for="TipoLicencia" class="inputGroup-sizing-default">Tipo Licencia</label>
                            <input type="text" class="form-control" id="TipoLicencia" name="TipoLicencia">
                        </div>
                        <div class="col-md-3">
                            <label for="pais" class="inputGroup-sizing-default">Pais Licencia</label>

                            <select class="form-select" name="Pais_licencia" required id="pais">
                                <option selected>PAIS ORIGEN</option>
                                <%                                            try {
                                        Conexion c = new Conexion();
                                        Connection con = c.getConexion();
                                        Statement st;
                                        st = con.createStatement();
                                        ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                        while (rs.next()) {
                                %>

                                <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        out.println("Error " + e.getMessage());
                                    }
                                %>
                            </select>

                        </div>
                        <div class="col-md-6">
                            <label for="Pasaporte" class="inputGroup-sizing-default">Pasaporte</label>
                            <input type="text" class="form-control" id="Pasaporte" name="Pasaporte">
                        </div>
                        <div class="col-md-3">
                            <label for="date" class="inputGroup-sizing-default">Fecha Vencimiento</label>
                            <input id="date" type="date" class="form-control" name="expiracion" >
                        </div>
                        <div class="col-md-3">
                            <label for="pais" class="inputGroup-sizing-default">Pais Pasaporte</label>

                            <select class="form-select" name="Pais_pasaporte" required id="pais">
                                <option selected>PAIS ORIGEN</option>
                                <%                                            try {
                                        Conexion c = new Conexion();
                                        Connection con = c.getConexion();
                                        Statement st;
                                        st = con.createStatement();
                                        ResultSet rs = st.executeQuery("select pais, nombre from PUERTO.eopt_paises");
                                        while (rs.next()) {
                                %>

                                <option value="<%=rs.getString("pais")%>"><%=rs.getString("nombre")%></option>
                                <%
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        out.println("Error " + e.getMessage());
                                    }
                                %>
                            </select>
                        </div>
                            
                            <input type="hidden"  name="ID" value="<%=a.getID()%>" >
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Registrar</button>
                        </div>
                    </form>
                </div>
            </div>
                            
                            
                         
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        -->
        
        <script>
            $(document).ready(function() {
    $('#example').DataTable();
} );
        </script>
    </body>
</html>
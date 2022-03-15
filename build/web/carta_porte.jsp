<%-- 
    Document   : carta_porte
    Created on : 11/05/2021, 11:18:28 AM
    Author     : kcordon
--%>

<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="modelo.CartaBarcos"%>
<%@page import="controlador.BeanCartaBarcos"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Conexion"%>
<%@page import="modelo.Carta"%>
<%@page import="controlador.BeanCarta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">-->
        <title> Carta de Porte</title>

        <jsp:include page="head.jsp" flush="true"></jsp:include>
            <link href="css/custom.css" rel="stylesheet" type="text/css"/>
            <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
            <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
            <style>
                body {
                    background-color: #eceff1;
                }
                .ocultar {
                    display: none;
                }

                .mostrar {
                    display: block;
                }

            </style>

        <%

            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);
            System.err.println("Usuario " + usuario);
            System.err.println("Usuario2 " + user.getUSUARIO_DE_SERVICIO());
            System.err.println("USER ID " + user.getUSERID());

        %>
    </head>
    <body>
        <section class="forms"> 
            <div class="container-fluid">

                <!-- Basic Form-->
                <form action="ServletCarta" onsubmit="return verificarPiloto();" method ="post">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="h4 mb-0">Ingrese Datos Recepcion Web
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">

                                <div class="col-md-4">
                                    <label for="Viaje" class="form-label">VIAJE</label>
                                    <input type="text" class="form-control rounded" id="Viaje" name="RW_VIAJE_BARCO" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="RW_FECHA_VIAJE_BARCO" class="form-label ">FECHA VIAJE BARCO</label>
                                    <!--<input type="text" class="form-control" id="inputPassword4" required>-->
                                    <br>
                                    <input type="datetime-local"  id="RW_FECHA_VIAJE_BARCO" name="RW_FECHA_VIAJE_BARCO" class="form-control rounded validate" required>
                                </div>
                                <div class="col-md-4">
                                    <label for="BUQUE" class="form-label ">NOMBRE BUQUE</label>
                                    <select class="form-control js-example-basic-single" style="width:100%" id="BUQUE" name="BUQUE" required>
                                        <option value="" disabled selected>NOMBRE BUQUE</option>
                                        <%                                            LinkedList<BeanCartaBarcos> lista = CartaBarcos.ConsultarLista();

                                            for (int i = 0; i < lista.size(); i++) {

                                                lista.get(i).getLR();
                                                lista.get(i).getSENAL();
                                                lista.get(i).getNOMBRE();


                                        %>

                                        <option value="<%= lista.get(i).getSENAL()%>_<%= lista.get(i).getLR()%>"><%= lista.get(i).getNOMBRE()%></option>
                                        <%
                                            }

                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h3 class="h4 mb-0">Datos Contenedor
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-2">
                                    <label for="Prefijo" class="form-label">Prefijo</label>
                                    <input id="Prefijo" type="text" placeholder="TMOU" class="form-control rounded"  name="RW_PREFIJO_CONT" required maxlength="4" required>                                  
                                </div>
                                <div class="col-md-2">
                                    <label for="Numero_Contenedor" class="form-label">Numero Contenedor</label>
                                    <input id="Numero_Contenedor" type="number" class="form-control rounded"  name="RW_IDENTIFICACION_CONT" required min="0" maxlength="12" required>                                  
                                </div>
                                <div class="col-md-2">
                                    <label for="RW_ESTADO_CONT" class="form-label">ESTADO CONTE</label>
                                    <select class="browser-default form-select rounded" name="RW_ESTADO_CONT" id="RW_ESTADO_CONT">                                        
                                        <option value="" disabled selected>Lleno/Vacio</option>
                                        <option value="1">Lleno</option>
                                        <option value="2">Vacio</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label for="RW_PAIS_ORIGEN" class="form-label">PAIS ORIGEN</label>
                                    <select class="form-select js-example-basic-single " name="RW_PAIS_ORIGEN" required>
                                        <option value="" disabled selected>PAIS ORIGEN</option>
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
                                <div class="col-md-3">
                                    <label for="RW_PAIS_ORIGEN" class="form-label">PAIS DESTINO</label>
                                    <select class="js-example-basic-single form-select " name="RW_PAIS_DESTINO" required>
                                        <option value="" disabled selected>PAIS DESTINO</option>
                                        <%
                                            try {
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

                                <div class="col-md-4">
                                    <label for="RW_ATC" class="form-label" id="RW_ATC_LABEL">ATC</label>
                                    <input type="text" class="form-control rounded" id="RW_ATC" name="RW_ATC"  maxlength="20" > 
                                </div>
                                <div class="col-md-4">
                                    <label for="RW_MARCHAMO" class="form-label" id="RW_MARCHAMO_LABEL">MARCHAMO</label>
                                    <input type="text" class="form-control rounded" id="RW_MARCHAMO" name="RW_MARCHAMO"  maxlength="20" > 
                                </div>
                                <div class="col-md-4">
                                    <label id="Peso_label" for="Peso" class="form-label">Peso</label>
                                    <input id="Peso" type="number" class="form-control rounded"  name="RW_PESO_CONTENEDOR" min="0"  maxlength="10" >                                  
                                </div>
                                <div class="col-md-3">
                                    <label for="RW_C_O_F" class="form-label">Contenedor Furgon</label>
                                    <select class="browser-default form-select rounded" name="RW_C_O_F" id="RW_C_O_F">
                                        <option value="" disabled selected>Contenedor/Furgon</option>
                                        <option value="1">Contenedor</option>
                                        <option value="2">Furgon</option>

                                    </select>

                                </div>

                                <div class="col-md-3">
                                    <label for="RW_MEDIDA" class="form-label">MEDIDA</label>
                                    <select class="browser-default form-select rounded" name="RW_MEDIDA" id="RW_MEDIDA">                                        
                                        <option value="" disabled selected>Medida</option>
                                        <option value="20">20</option>
                                        <option value="40">40</option>
                                        <option value="45">45</option>
                                        <option value="48">48</option>
                                    </select>

                                </div>

                                <div class="col-md-3">
                                    <label for="RW_REFER_SECO_OPERANDO" class="form-label">Tipo Contenedor</label>
                                    <select class="browser-default form-select rounded" name="RW_REFER_SECO_OPERANDO" id="RW_REFER_SECO_OPERANDO">                                        
                                        <option value="" disabled selected>Tipo Contenedor</option>
                                        <option value="S">Seco</option>
                                        <option value="O">Rifer Encendido</option>
                                        <option value="A">Rifer Apagado</option>
                                    </select>
                                </div>
                            </div>


                            </br>
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="RW_DICE_CONTENER"></textarea>
                                <label for="floatingTextarea" id="floatingTextareal">DICE CONTENER</label>
                            </div>

                            </br>
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name="RW_DICE_OBSERVACIONES" ></textarea>
                                <label for="floatingTextarea">OBSERVACIONES</label>
                            </div>



                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h3 class="h4 mb-0">Datos de Transportista
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-3">
                                    <label for="TRANSPORTISTA" class="form-label">TRANSPORTISTA</label>
                                    <select class="js-example-basic-single form-select rounded" name="TRANSPORTISTA" required>
                                        <option value="" disabled selected>NOMBRE TRANSPORTISTA</option>
                                        <%                                                try {
                                                Conexion c = new Conexion();
                                                Connection con = c.getConexion();
                                                Statement st;
                                                st = con.createStatement();
                                                ResultSet rs = st.executeQuery("select TRANSPORTE, NOMBRE from PUERTO.EOPT_TRANSPORTES");
                                                while (rs.next()) {
                                        %>

                                        <option value="<%=rs.getString("TRANSPORTE")%>"><%=rs.getString("NOMBRE")%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                out.println("Error " + e.getMessage());
                                            }
                                        %>

                                    </select>

                                </div>
                                <div class="col-md-2">
                                    <label for="Placa" class="form-label">Placa Cabezal</label>
                                    <input id="Placa" type="text" placeholder="C0123ABC" class="form-control rounded" name="RW_PLACA_CABEZAL" required maxlength="12">
                                </div>
                                <div class="col-md-2">
                                    <label for="Prefijo_Chasis" class="form-label">Prefijo Chasis</label>
                                    <input id="Prefijo_Chasis" type="text" class="form-control rounded" name="RW_PREFIJO_CHASIS" required maxlength="6">
                                </div>
                                <div class="col-md-3">
                                    <label for="Numero_Chasis" class="form-label">Numero Chasis</label>
                                    <input id="Numero_Chasis" type="text" class="form-control rounded" name="RW_IDENTIFICACION_CHASIS" required maxlength="6">
                                </div>

                                <div class="col-md-2">

                                    <label class="form-label" for="RW_PAIS_PLACA">Pais Placa</label>
                                    <select class="js-example-basic-single form-select" name="RW_PAIS_PLACA" id="RW_PAIS_PLACA" required>
                                        <option value="" disabled selected>Pais Placa</option>
                                        <%                                                try {
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
                            </div>                                     
                        </div>
                    </div>


                    <div class="card">
                        <div class="card-header">
                            <h3 class="h4 mb-0">Datos Piloto
                            </h3>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-12">
                                    <label for="txtBuscar" class="form-label">PILOTO</label>
                                    <input type="text" class="form-control" placeholder="PILOTO" aria-label="Username"  id="txtBuscar" onkeyup="buscar()" aria-describedby="addon-wrapping">
                                    <input type="hidden" value ="" id="PILOTO" name="PILOTO">
                                    <div id="resultado" class="z-index-n1 bg-white"></div>

                                </div>

                            </div>

                        </div>
                    </div>

                    <div class="card" id="declaraciones">
                        <div class="card-header">
                            <h3 class="h4 mb-0">Declaracion Aduanera
                            </h3>
                        </div>
                        <div class="card-body">

                            <div class="table-responsive-sm">

                                <table border="1" class="table" id="tablaprueba">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th colspan="6" class="center">Declaracion Aduanera</th>

                                        </tr>
                                    </thead>
                                    <thead class="thead-dark ">
                                        <tr class="center">
                                            <th class="center">Modalidad</th>
                                            <th class="center">Numero de Orden</th>
                                            <th class="center">Observaciones</th>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-primary" onclick="agregarFila()">Agregar Fila</button>
                                <button type="button" class="btn btn-warning" onclick="eliminarFila()">Eliminar Fila</button>
                            </div>





                        </div>
                    </div>
                    <input type="hidden" value ="" id="cont" name="cont">
                    <input type="hidden"  name="RW_ID_GRABADOR" value="<%= user.getUSERID()%>" >
                    <input type="hidden"  name="USUARIO_DE_SERVICIO" value="<%= user.getUSUARIO_DE_SERVICIO()%>" required>
                    <div id="error" class="alert alert-danger ocultar" role="alert">
                        Datos de Piloto correctos
                    </div>
                    <div id="ok" class="alert alert-success ocultar" role="alert">
                        Ingreso un Piloto valido
                    </div>
                    <div class="modal-footer">

                        <button class="btn btn-primary" type="submit" value="Ingresar" name="enviar">Guardar</button>
                    </div>
                </form>
            </div>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>

            <script>
                                    function buscar() {
                                        //lo que el usuario escribio

                                        var txtFiltro = $("#txtBuscar").val();
//                                            var PILOTO = $("#PILOTO").val();
//                                            if($("#PILOTO").val().length == 0){
//                                                console.log("PILO: "+PILOTO);
//                                            }

                                        $.ajax({
                                            url: "busca.do",
                                            data: {
                                                filtro: txtFiltro,
                                                param: 2

                                            },
                                            success: function (result) {
                                                $("#resultado").html(result);
                                            }
                                        });
                                    }


                                    function myFunction(valor, nombre) {



                                        document.getElementById("txtBuscar").value = nombre;
                                        document.getElementById("PILOTO").value = valor;
                                        document.getElementById("resultado").innerHTML = " ";
                                        console.log(valor);
                                    }

            </script>


            <script>
                var a = 0;
                function agregarFila() {
                    a++;
                    document.getElementById("tablaprueba").insertRow(-1).innerHTML = "<td>\n\
                    <select class='js-example-basic-single' name='DA[" + a + "]'>\n"
                            + "<option value='' disabled selected>DECLARACION</option>\n"
                <%                                            try {
                        Conexion c = new Conexion();
                        Connection con = c.getConexion();
                        Statement st;
                        st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT ECR_MODALIDAD, ECR_DESCRIPCION, ECR_CODIGO_REGIMEN_MODALIDAD FROM PUERTO.eopt_cat_regimen where ecr_estado = 'A'");
                        while (rs.next()) {
                %>
                    + "<option value='<%=rs.getString("ECR_MODALIDAD")%>'><%=rs.getString("ECR_DESCRIPCION")%></option>\n"<%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            out.println("Error " + e.getMessage());
                        }
                %>
                    + "</select></td><td><input  type='text' name='Numero_Orden[" + a + "]'/></td>\n\
                    <td><input type='text' name='Observaciones[" + a + "]'/></td>";
                    document.getElementById("cont").value = a;
                    $('.js-example-basic-single').select2();
                }

                function eliminarFila() {
                    var table = document.getElementById("tablaprueba");
                    var rowCount = table.rows.length;
                    //console.log(rowCount);

                    if (rowCount <= 2)
                        alert('No se puede eliminar el encabezado');
                    else
                        table.deleteRow(rowCount - 1);
                }

            </script>

            <script>
                $(document).ready(function () {
                    $('.js-example-basic-single').select2();

                    $("select[name=RW_ESTADO_CONT]").change(function () {
                        console.log($('select[name=RW_ESTADO_CONT]').val());
                        if ($('select[name=RW_ESTADO_CONT]').val() == 2) {
                            console.log('hola');
                            $("#RW_ATC").hide();
                            $("#RW_ATC_LABEL").hide();
                            $("#RW_MARCHAMO_LABEL").hide();
                            $("#RW_MARCHAMO").hide();
                            $("#Peso").hide();
                            $("#Peso_label").hide();
                            $("#floatingTextareal").hide();
                            $("#floatingTextarea").hide();
                            $("#declaraciones").hide();

                        }
                        if ($('select[name=RW_ESTADO_CONT]').val() == 1) {
                            $("#RW_ATC").show();
                            $("#RW_ATC_LABEL").show();
                            $("#RW_MARCHAMO_LABEL").show();
                            $("#RW_MARCHAMO").show();
                            $("#Peso").show();
                            $("#Peso_label").show();
                            $("#floatingTextareal").show();
                            $("#floatingTextarea").show();
                            $("#declaraciones").show();
                        }
//            $('input[name=RW_ESTADO_CONT]').val($(this).val());
                    });
                });

            </script>

            <script>

                function verificarPiloto() {

                    // Ontenemos los valores de los campos de contraseñas 
                    PILOTO = document.getElementById('PILOTO');
                    // Verificamos si las constraseñas no coinciden


                    if ($("#PILOTO").val().length == 0) {

                        // Si las constraseñas no coinciden mostramos un mensaje 
                        document.getElementById("error").classList.add("mostrar");
                        return false;
                    } else {

                        // Si las contraseñas coinciden ocultamos el mensaje de error
                        document.getElementById("error").classList.remove("mostrar");
                        // Mostramos un mensaje mencionando que las Contraseñas coinciden 
                        document.getElementById("ok").classList.remove("ocultar");
                        // Desabilitamos el botón de login 
//                    document.getElementById("login").disabled = true;

                        // Refrescamos la página (Simulación de envío del formulario) 


                        return true;
                    }

                }


            </script>
            <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>-->

            <jsp:include page="foot.jsp" flush="true"></jsp:include>
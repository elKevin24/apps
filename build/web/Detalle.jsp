<%-- 
    Document   : Detalle
    Created on : 17/11/2020, 10:06:01 AM
    Author     : kcordon
--%>


<%@page import="modelo.Usuario"%>
<%@page import="controlador.BeanUsuarios"%>
<%@page import="controlador.BeanCarta_Detalle"%>
<%@page import="modelo.detalle_carta"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modelo.Carta"%>
<%@page import="controlador.BeanCarta"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>



        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">-->


        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <%
            String consulta = request.getParameter("consulta");
            System.err.println("consulta"+consulta);
            BeanCarta enc = new BeanCarta();
            enc = Carta.ConsultarVer(consulta);
            
            String usuario = String.valueOf(session.getAttribute("usuario"));
            BeanUsuarios user = new BeanUsuarios();
            user = Usuario.ObtenerUsuario(usuario);
            System.err.println("Usuario " + usuario);
            System.err.println("USUARIO_DE_SERVICIO " + user.getUSUARIO_DE_SERVICIO());
            System.err.println("USER ID " + user.getUSERID());
            System.err.println("getUSUARIO_INOW " + user.getUSUARIO_INOW());
            System.err.println("getNOMBRE " + user.getNOMBRE());
            

            System.err.println("ATC" + enc.getRW_ATC());


        %>
        <script>

            function exportTableToExcel(tableID, filename = '') {
                var downloadLink;
                var dataType = 'application/vnd.ms-excel';
                var tableSelect = document.getElementById(tableID);
                var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');

                // Specify file name
                filename = filename ? filename + '.xls' : 'excel_data.xls';

                // Create download link element
                downloadLink = document.createElement("a");

                document.body.appendChild(downloadLink);

                if (navigator.msSaveOrOpenBlob) {
                    var blob = new Blob(['ufeff', tableHTML], {
                        type: dataType
                    });
                    navigator.msSaveOrOpenBlob(blob, filename);
                } else {
                    // Create a link to the file
                    downloadLink.href = 'data:' + dataType + ', ' + tableHTML;

                    // Setting the file name
                    downloadLink.download = filename;

                    //triggering the function
                    downloadLink.click();
            }
            }
        </script>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
        <title>Detalle Recepcion</title>
        </head>
        <body>



            <div class="container-fluid text-center">
                <br>
                <div class="align-items-center">
                    <input type="image" onclick="exportTableToExcel('customers', 'empornac')" src="img/excel.png">
                    <input type="image" onclick="tablepdf()" src="img/pdf.png">

                </div>
                <div class="table-responsive-lg">
                    <div id="render_me">
                        <table id="customers" class="table table-bordered table-striped table-hover" class="text-center">
                            <thead class="text-center">
                                <tr>
                                    <th>

                                        <p><img id="logo" src="img/EMPORNAC_logo.png"></p>
                                    </th>
                                    <th colspan="7"  class="text-center">
                                        <p>EMPRESA PORTUARIA NACIONAL "SANTO TOMAS DE CASTILLA"</p> 
                                        <p>IZABAL, GUATEMALA </p> 
                                        <p>RECEPCION WEB</p> 
                                    </th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td colspan="2" class="text-center">
                                        Numero Carta Porte: <%= enc.getRW_ID_RECEPCION()%>
                                </td>
                                <td colspan="2" class="text-center">
                                    NAVIERA: <%= enc.getRW_USUARIO_SERVICIO()%>
                                </td>
                                <td colspan="2" class="text-center">
                                    USUARIO: <%= user.getUSUARIO_INOW() %>
                                </td>
                                <td colspan="2" class="text-center">
                                    Fecha Creacion: <%= enc.getRW_FECHA_RECEPCION_WEB().substring(0, 16)%>
                                </td>

                            </tr>
                            <tr class="blue lighten-2">
                                <th colspan="8" class="text-center">
                                    Datos de Contenedor
                                </th>

                            </tr>
                            <tr>
                                <th>
                                    Contenedor/Furgon
                                </th>
                                <th>
                                    Contenedor
                                </th>
                                <th>
                                    Medida

                                </th>
                                <th>
                                    Peso
                                </th>
                                <th>
                                    Condiciones
                                </th>
                                <th>
                                    Condiciones
                                </th>
                                <th>
                                    Pais Origen
                                </th>
                                <th>
                                    Pais Destino 
                                </th>
                            </tr>

                            <tr>
                                <td>
                                    <%= enc.getRW_C_O_F().toUpperCase()%>
                                </td>
                                <td>
                                    <%= enc.getRW_PREFIJO_CONT()%> <%= enc.getRW_IDENTIFICACION_CONT()%>
                                </td>
                                <td>

                                    <%= enc.getRW_MEDIDA()%>
                                </td>
                                <td>
                                    <%= enc.getRW_PESO_CONTENEDOR()%>
                                </td>
                                <td>
                                    <%= enc.getRW_ESTADO_CONT()%>
                                </td>
                                <td>
                                    <%= enc.getRW_REFER_SECO_OPERANDO()%>
                                </td>
                                <td>
                                    <%= enc.getRW_PAIS_ORIGEN()%>
                                </td>
                                <td>
                                    <%= enc.getRW_PAIS_DESTINO()%>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="8">
                                    Dice Contener:  <%= enc.getRW_DICE_CONTENER()%>
                                </td>

                            </tr>
                            </tr>
                            <tr class="text-center">                             

                                <th colspan="8">
                                    Observaciones:  <%= enc.getRW_DICE_OBSERVACIONES()%> 
                                </th>


                            </tr>
                        </tbody>

                        <tbody>
                            <tr class="text-center blue lighten-2" >
                                <th colspan="2" class="cuerpo"> 
                                    Numero ATC
                                </th>
                                <th colspan="6" class="text-center blue lighten-2">
                                    Datos Buque 
                                </th>
                            </tr>

                            <tr class="text-center">                               

                                <th colspan="2"> 
                                    <%= enc.getRW_ATC()%> 
                                </th>
                                <th colspan="2">
                                    Nombre Buque:  
                                </th>
                                <th colspan="2">
                                    Viaje: <%= enc.getRW_VIAJE_BARCO()%> 
                                </th>
                                <th colspan="2">
                                    Fecha: <%= enc.getRW_FECHA_VIAJE_BARCO()%> 
                                </th>
                            </tr>

                            <tr class="text-center">

                                <th colspan="8" class="text-center blue lighten-2">
                                    Datos Transportista 
                                </th>

                            </tr>  

                            <tr class="text-center">                             

                                <th colspan="2">
                                    Nombre:  <%= enc.getRW_ID_TRANSPORTISTA()%> 
                                </th>
                                <th olspan="1">
                                    Placa Cabezal: <%= enc.getRW_PLACA_CABEZAL()%> 
                                </th>
                                <th colspan="2">
                                    Prefijo Chasis: <%= enc.getRW_PREFIJO_CHASIS()%> 
                                </th>
                                <th colspan="2">
                                    Chasis: <%= enc.getRW_IDENTIFICACION_CHASIS()%> 
                                </th>
                                <th colspan="1">
                                    Pais Placa: <%= enc.getRW_PAIS_PLACA()%> 
                                </th>
                            </tr>
                            <tr class="text-center">

                                <th colspan="8" class="text-center blue lighten-2">
                                    Datos Piloto: 
                                </th>

                            </tr>

                            <tr class="text-center">                             

                                <th colspan="6">
                                    Nombres:   <%= enc.getNOMBRE_PILOTO()%> 
                                </th>

                                <th colspan="2">
                                    Licencia:  <%= enc.getLICENCIA_PILOTO()%> 
                                </th>



                        </tbody> 
                        <tbody>
                            <tr>
                                <th colspan="8" class="center blue lighten-2">Declaracion Aduanera</th>
                            </tr>
                        </tbody>
                        <tbody>
                            <tr>
                                <th>Numero</th> 
                                <th colspan="3">Modalidad</th>                             
                                <th colspan="2">No Orden</th>
                                <th colspan="2">Observaciones</th>
                            </tr>
                        </tbody>
                        <tbody>
                            <%

                                LinkedList<BeanCarta_Detalle> lista = detalle_carta.ConsultarLista(consulta);

                                for (int i = 0; i < lista.size(); i++) {
                                    int a = 1;
                                    a = i + a;
                                    out.println("<td>" + a + "</td>");
                                    out.println("<td colspan='3'>" + lista.get(i).getDA_MODALIDAD() + "</td>");
                                    out.println("<td colspan='2'>" + lista.get(i).getDA_NUMERO_ORDEN() + "</td>");
                                    out.println("<td  colspan='2' class='text-right'>" + lista.get(i).getDA_OBSERVACIONES() + "</td>");

                                    out.println("</tr>");

                                }

                            %>  



                        </tbody>
                    </table>              
                </div>
            </div>
        </div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<script src="js/jspdf.plugin.autotable.min.js" type="text/javascript"></script>


<script type="text/javascript">
                        function tablepdf() {

                            var logo = document.getElementById("logo");
                            var doc = new jsPDF('p', 'mm', 'letter');
                            margins = {
                                top: 150,
                                bottom: 60,
                                left: 40,
                                right: 40,
                                width: 600
                            };
                            var y = 20;
                            doc.setLineWidth(2);

                            doc.setLineWidth(2);
                            doc.addImage(logo, 'PNG', 3, 2);
                            doc.autoTable({
                                html: '#customers',
                                theme: 'grid',

                            })
                            doc.save('CartaPorte.pdf');
                        }
</script>

<jsp:include page="foot.jsp" flush="true"></jsp:include>



<%@page import="java.text.DecimalFormat"%>
<%@page import="controlador.Conteo"%>
<%@page import="modelo.Factura"%>
<%@page import="controlador.BeanFactura"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>Consulta Facturas</title>
        <jsp:include page="head.jsp" flush="true"></jsp:include>
    

        <%

            String user = String.valueOf(session.getAttribute("usuario"));
        %>
        
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            Usuario  <%= user%>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Consulta de Facturas Serie 64-D2</h5>
                            <form action="FACTURA.jsp" method="post">
                                <div class="input-group mb-3">
                                    <input name="numero" type="number" class="form-control" placeholder="Ingrese numero de Factura" aria-label="Ingrese numero de Factura" aria-describedby="button-addon2"  max="2147483647" required>
                                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2" style="background-color:#6ab7ff;">Consultar</button>
                                    <div class="invalid-feedback">
                                        Ingrese Numero de Factura.
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <%

                        if (user == "null") {
                            System.err.println("if");

                            response.sendRedirect("login.jsp");
                        } else {

                            System.err.println("else");

                        }

                        String variable = request.getParameter("numero");

                        int a = 0;
                        String Null = null;

                        String ast = null;
                        String numero = null;

                        if (variable == null) {
                            variable = "vacio";
                            session.setAttribute("factura", a);
                        } else if (variable.substring(0, 1).equals("*")) {
                            System.err.println("" + "hola");
                            numero = variable.substring(1, variable.length());
                            a = Integer.parseInt(numero);
                            System.err.println("" + a);
                            session.setAttribute("factura", a);
                        } else {

                            a = Integer.parseInt(variable);
                            Conteo cont = new Conteo(a, user);
                            session.setAttribute("factura", a);
                            if (a != 0) {
                                boolean sw = Factura.agregar(cont);
                            }

                        }

                        BeanFactura ship = new BeanFactura();
                        ship = Factura.ConsultaCreado(a);

                        //CONSULTAR CONTEO FACTURA
                        BeanFactura detalle = new BeanFactura();
                        System.err.println("id" + ship.getP_ID_NOTA());
                        detalle = Factura.Detalle(ship.getP_ID_NOTA());
                        if (ship.getP_ID_NOTA() == " ") {
                            System.err.println("vacio" + ship.getP_ID_NOTA());
                        }

                        //PARA QUITAR NULL
                        String mail;

                        if (ship.getP_EMAIL() == null) {
                            mail = " ";

                        } else {
                            mail = ship.getP_EMAIL();
                        }

                        DecimalFormat formato = new DecimalFormat("¤#,###.00");


                    %>

                    <br>
                    <table border="1" class="table table-bordered table-striped table-hover">
                        <thead>

                            <tr>
                                <th  colspan="6" class="text-center bg-info"> FACTURADO A</th>
                            </tr>
                            <tr>
                                <th>NIT</th>
                                <th colspan="2">NOMBRE</th>
                                <th colspan="2">DIRECCION</th>
                                <th>CORREO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                out.println("<tr>");
                                out.println("<td>" + ship.getP_NIT() + "</td>");
                                out.println("<td colspan='2'>" + ship.getP_NOMBRE() + "</td>");
                                out.println("<td colspan='2'>" + ship.getP_DIRECCION() + "</td>");
                                out.println("<td>" + mail + "</td>");
                                out.println("</tr>");
                            %>
                            <tr>
                                <th colspan="6" class="text-center">CAMBIO DOLAR</th>                                                          
                            </tr>
                            <tr>
                                <th colspan="3">TIPO CAMBIO</th>                                                             
                                <th colspan="3">FECHA TIPO CAMBIO</th>                                                             
                            </tr>
                            <%
                                out.println("<tr>");
                                out.println("<td colspan='3'>" + ship.getP_TIPO_CAMBIO() + "</td>");
                                out.println("<td colspan='3'>" + ship.getP_TIPO_CAMBIO_FECHA() + "</td>");
                                out.println("</tr>");
                            %> 
                            <tr>
                                <th colspan="6" class="text-center">DETALLE</th>                                                          
                            </tr>
                            <tr>

                                <th colspan="2">TARIFA</th>
                                <th colspan="2">SERVICIO</th>
                                <th colspan="2" class="text-end">SUB TOTAL</th>

                            </tr>
                            <%
                                String val2 = " ";
                                if (detalle.getSUB_TOTAL() == " ") {

                                } else {
                                    Double val1 = Double.valueOf(detalle.getSUB_TOTAL());
                                    val2 = formato.format(val1);
                                }
                                System.err.println("espacio" + detalle.getSUB_TOTAL());
                                out.println("<tr>");
                                out.println("<td colspan='2'>" + detalle.getTARIFA() + "</td>");
                                out.println("<td colspan='2'>" + detalle.getSERVICIO() + "</td>");
                                out.println("<td colspan='2' class='text-end'>" + val2 + "</td>");
                                out.println("</tr>");

                            %>  
                            <tr>
                                <th colspan="6" class="text-center">INFORMACION ADICIONAL</th>                                                             
                            </tr>
                            <tr>
                                <th colspan="3">TRAMITADOR</th>                                                             
                                <th colspan="3">REFERENCIA</th>                                                           
                            </tr>
                            <%                                out.println("<tr>");
                                out.println("<td colspan='3'>" + ship.getP_TRAMITADOR() + "</td>");
                                out.println("<td colspan='3'>" + ship.getP_REFERENCIA_PIE() + "</td>");
                                out.println("</tr>");

                            %> 
                            <tr>
                                <th colspan="6"> </th>
                            </tr>
                            <tr>
                                <th colspan="6" class="text-center bg-info">INFORMACION SAT</th>                                                             

                            </tr>
                            <tr>
                                <th>AUTORIZACION</th>
                                <th>SERIE</th>
                                <th>FECHA FACTURA</th>
                                <th>FECHA CERTIFICA</th>
                                <th>NUMERO</th>
                                <th>TOTAL</th>


                            </tr>


                            <%                                String val3 = " ";
                                if (detalle.getSUB_TOTAL() == " ") {

                                } else {
                                    Double val4 = Double.valueOf(detalle.getSUB_TOTAL());
                                    val3 = formato.format(val4);
                                }
                                out.println("<tr>");
                                out.println("<td>" + ship.getAUTORIZACION() + "</td>");
                                out.println("<td>" + ship.getSERIE() + "</td>");
                                out.println("<td>" + ship.getFECHA() + "</td>");
                                out.println("<td>" + ship.getFECHA_CERTIFICA() + "</td>");
                                out.println("<td>" + ship.getPS_NUMERO() + "</td>");
                                out.println("<td class='text-end'>" + val3 + "</td>");
                                out.println("</tr>");

                            %>  



                        </tbody>
                    </table>

                    <div class="ratio ratio-16x9">
                        <iframe src="ConsultaConteo.jsp" title="" allowfullscreen>                                 


                        </iframe>
                    </div>
                </div>


                <!-- Ingresar Proceso-->         

                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            Ingrese descripcion del uso que se le dara a  Factura
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">Ingrese Proceso</h5>
                            <form action="Comentario" method="post">
                                <div class="input-group mb-3">
                                    <input name="Comentario" type="text" class="form-control"  aria-describedby="button-addon2"   required>
                                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2" style="background-color:#6ab7ff;">Ingresar</button>
                                    <div class="invalid-feedback">
                                        Ingrese Numero de Factura.
                                    </div>
                                </div>

                                <input  type="hidden" value="<%= a%>" name="factura">
                                <input  type="hidden" value="<%= user%>" name="usuario">
                            </form>
                        </div>
                    </div>
                    <br>
                    <div class="ratio ratio-16x9">
                        <iframe src="ConsultaProceso.jsp" title="YouTube video" allowfullscreen>                                 


                        </iframe>
                    </div>

                </div>
            </div>
        </div>
<jsp:include page="foot.jsp" flush="true"></jsp:include>


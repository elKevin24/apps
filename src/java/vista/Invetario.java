/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vista;

import controlador.BeanInventario_Consulta_Historico_Firmas_Conte;
import controlador.BeanInventario_Conte;
import controlador.BeanInventario_Conte1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Invetario_Conte;

/**
 *
 * @author kcordon
 */
public class Invetario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            if (request.getParameter("param").equalsIgnoreCase("1")) {
                String firma = request.getParameter("firma");

                BeanInventario_Conte cont = new BeanInventario_Conte();
                cont = Invetario_Conte.Consulta_Correlativo(firma);

                //INVENTARIO DETALLE
                BeanInventario_Conte1 cont2 = new BeanInventario_Conte1();

//                
                if (cont.getCORRELATIVO() == null) {
                    out.println("<center>firma no existente</center>");
                } else {

                    LinkedList<BeanInventario_Conte1> lista = Invetario_Conte.Consultar_Inventario(cont.getCORRELATIVO());

                    out.println("<div class=\"table-responsive\">");
                    out.println("<table id=\"example\" border=\"1\"   class=\"display table table-hover table-bordered table-striped\">");

                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th colspan='13'><center>EMPRESA PORTUARIA NACIONAL SANTO TOMAS DE CASTILLA\n"
                            + "INVENTARIO DE CONTENEDORES</center></th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<th>ORDEN</th>");
                    out.println("<th>CONTENEDOR</th>");
                    out.println("<th>TIPO</th>");
                    out.println("<th>OPERACION</th>");
                    out.println("<th>FECHA INGRESO</th>");
                    out.println("<th>MODALIDAD</th>");
                    out.println("<th>PATIO</th>");
                    out.println("<th>FILA</th>");
                    out.println("<th>MODULO</th>");
                    out.println("<th>NIVEL</th>");
                    out.println("<th>OBSERVACION</th>");
                    out.println("<th>MANIFIESTO</th>");
                    out.println("<th>DICE CONTENER</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (int i = 0; i < lista.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + lista.get(i).getC1() + "</td>");
                        out.println("<td>" + lista.get(i).getC2() + "</td>");
                        out.println("<td>" + lista.get(i).getC3() + "</td>");
                        out.println("<td>" + lista.get(i).getC4() + "</td>");
                        out.println("<td>" + lista.get(i).getC5() + "</td>");
                        out.println("<td>" + lista.get(i).getC6() + "</td>");
                        out.println("<td>" + lista.get(i).getC7() + "</td>");
                        out.println("<td>" + lista.get(i).getC8() + "</td>");
                        out.println("<td>" + lista.get(i).getC9() + "</td>");
                        out.println("<td>" + lista.get(i).getC10() + "</td>");
                        out.println("<td>" + lista.get(i).getC11() + "</td>");
                        out.println("<td>" + lista.get(i).getC12() + "</td>");
                        out.println("<td>" + lista.get(i).getC13() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("<tfood>");
                    out.println("<tr>");
                    out.println("<th>ORDEN</th>");
                    out.println("<th>CONTENEDOR</th>");
                    out.println("<th>TIPO</th>");
                    out.println("<th>OPERACION</th>");
                    out.println("<th>FECHA INGRESO</th>");
                    out.println("<th>MODALIDAD</th>");
                    out.println("<th>PATIO</th>");
                    out.println("<th>FILA</th>");
                    out.println("<th>MODULO</th>");
                    out.println("<th>NIVEL</th>");
                    out.println("<th>OBSERVACION</th>");
                    out.println("<th>MANIFIESTO</th>");
                    out.println("<th>DICE CONTENER</th>");
                    out.println("</tr>");
                    out.println("</food>");
                    out.println("</table>");
                    out.println("</div>");

                }

            }

            if (request.getParameter("param").equalsIgnoreCase("2")) {
                String usuario = request.getParameter("usuario");
                String retorno = Invetario_Conte.CREAR_FIRMA(usuario);

                out.println(retorno);

            }

            if (request.getParameter("param").equalsIgnoreCase("3")) {

                String Inicio = request.getParameter("Inicio");
                String Final = request.getParameter("Final");

                LinkedList<BeanInventario_Conte> lista = Invetario_Conte.Consultar_Historico_Firmas(Inicio, Final);

                out.println("<div class=\"table-responsive\">");
                out.println("<table id=\"example\" border=\"1\"   class=\"display table table-hover table-bordered table-striped\">");

                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan='13'><center>EMPRESA PORTUARIA NACIONAL SANTO TOMAS DE CASTILLA\n"
                        + "HISTORICO FIRMAS</center></th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>CORRELATIVO</th>");
                out.println("<th>FIRMA ELECTRONICA</th>");
                out.println("<th>USUARIO</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + lista.get(i).getCORRELATIVO() + "</td>");
                    out.println("<td>" + lista.get(i).getFIRMA() + "</td>");
                    out.println("<td>" + lista.get(i).getUSUARIO() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("<tfood>");
                out.println("<tr>");
                out.println("<th>CORRELATIVO</th>");
                out.println("<th>FIRMA ELECTRONICA</th>");
                out.println("<th>USUARIO</th>");
                out.println("</tr>");
                out.println("</food>");
                out.println("</table>");
                out.println("</div>");

            }

            if (request.getParameter("param").equalsIgnoreCase("4")) {

                String usuario = request.getParameter("usuario");
                String contenedor = request.getParameter("conte");
                String retorno = Invetario_Conte.CREAR_FIRMA_HISTORICO_CONTE(contenedor, usuario);

                out.println(retorno);

            }
            if (request.getParameter("param").equalsIgnoreCase("5")) {
                //Detalle contenedor
                //System.err.println("Detalle contenedor");
                String firma = request.getParameter("firma");
                System.err.println("firma" + firma);

                BeanInventario_Conte cont = new BeanInventario_Conte();
                cont = Invetario_Conte.Consulta_Correlativo_Conte(firma);
                System.out.println("getCORRELATIVO: " + cont.getCORRELATIVO());

                if (cont.getCORRELATIVO() == null) {
                    out.println("<center>firma no existente</center>");
                } else {

                    LinkedList<BeanInventario_Conte1> lista = Invetario_Conte.Consultar_Inventario_Conte(cont.getCORRELATIVO());

                    out.println("<div class=\"table-responsive\">");
                    out.println("<table id=\"example\" border=\"1\"   class=\"display table table-hover table-bordered table-striped\">");

                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th colspan='13'><center>EMPRESA PORTUARIA NACIONAL SANTO TOMAS DE CASTILLA\n"
                            + "HISTORICO CONTENEDOR</center></th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<th>ORDEN</th>");
                    out.println("<th>TIPO</th>");
                    out.println("<th>CONDICION</th>");
                    out.println("<th>OPERACION</th>");
                    out.println("<th>FECHA OPERACION</th>");
                    out.println("<th>DOCUMENTO ADUANA</th>");
                    out.println("<th>DICE CONTENER</th>");
                    out.println("<th>MEDIDA</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (int i = 0; i < lista.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + lista.get(i).getORDEN() + "</td>");
                        out.println("<td>" + lista.get(i).getC1() + "</td>");
                        out.println("<td>" + lista.get(i).getC2() + "</td>");
                        out.println("<td>" + lista.get(i).getC3() + "</td>");
                        out.println("<td>" + lista.get(i).getC4() + "</td>");
                        out.println("<td>" + lista.get(i).getC5() + "</td>");
                        out.println("<td>" + lista.get(i).getC6() + "</td>");
                        out.println("<td>" + lista.get(i).getC7() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("<tfood>");
                    out.println("<tr>");
                    out.println("<th>ORDEN</th>");
                    out.println("<th>TIPO</th>");
                    out.println("<th>CONDICION</th>");
                    out.println("<th>OPERACION</th>");
                    out.println("<th>FECHA OPERACION</th>");
                    out.println("<th>DOCUMENTO ADUANA</th>");
                    out.println("<th>DICE CONTENER</th>");
                    out.println("<th>MEDIDA</th>");
                    out.println("</tr>");
                    out.println("</food>");
                    out.println("</table>");
                    out.println("</div>");

                }

            }if (request.getParameter("param").equalsIgnoreCase("6")) {

                String Inicio = request.getParameter("Inicio");
                String Final = request.getParameter("Final");

                LinkedList<BeanInventario_Consulta_Historico_Firmas_Conte> lista = Invetario_Conte.Consultar_Historico_Firmas_Conte(Inicio, Final);

                out.println("<div class=\"table-responsive\">");
                out.println("<table id=\"example\" border=\"1\"   class=\"display table table-hover table-bordered table-striped\">");

                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan='13'><center>EMPRESA PORTUARIA NACIONAL SANTO TOMAS DE CASTILLA\n"
                        + "HISTORICO FIRMAS</center></th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>CORRELATIVO</th>");
                out.println("<th>FIRMA ELECTRONICA</th>");
                out.println("<th>FECHA</th>");
                out.println("<th>USUARIO</th>");
                out.println("<th>CONTENEDOR</th>");
                out.println("<th>MEDIDA</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + lista.get(i).getCORRELATIVO() + "</td>");
                    out.println("<td>" + lista.get(i).getFIRMA() + "</td>");
                    out.println("<td>" + lista.get(i).getFECHA()+ "</td>");
                    out.println("<td>" + lista.get(i).getUSUARIO() + "</td>");
                    out.println("<td>" + lista.get(i).getCONTENEDOR() + "</td>");
                    out.println("<td>" + lista.get(i).getMEDIDA() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("<tfood>");
                out.println("<tr>");
                out.println("<th>CORRELATIVO</th>");
                out.println("<th>FIRMA ELECTRONICA</th>");
                out.println("<th>FECHA</th>");
                out.println("<th>USUARIO</th>");
                out.println("<th>CONTENEDOR</th>");
                out.println("<th>MEDIDA</th>");
                out.println("</tr>");
                out.println("</food>");
                out.println("</table>");
                out.println("</div>");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Invetario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

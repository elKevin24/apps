/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vista;

import controlador.BeanRX;
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
import modelo.SAT;

/**
 *
 * @author kcordon
 */
public class ServletSat extends HttpServlet {

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

            if (request.getParameter("param").equalsIgnoreCase("1")) {

                out.println("<div class=\"container-fluid\">\n"
                        + "            <div class=\"row gy-4\">\n"
                        + "                <div class=\"col-lg-3\">\n"
                        + "                    <div class=\"card mb-0\">\n"
                        + "                        <div class=\"card-header\">\n"
                        + "                            <div class=\"card-close\">\n"
                        + "                                <div class=\"dropdown\">\n"
                        + "                                    <button class=\"dropdown-toggle text-sm\" type=\"button\" id=\"closeCard1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"fas fa-ellipsis-v\"></i></button>\n"
                        + "                                    <div class=\"dropdown-menu dropdown-menu-end shadow-sm\" aria-labelledby=\"closeCard1\"><a class=\"dropdown-item py-1 px-3 remove\" href=\"#\"> <i class=\"fas fa-times\"></i>Close</a><a class=\"dropdown-item py-1 px-3 edit\" href=\"#\"> <i class=\"fas fa-cog\"></i>Edit</a></div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <h3 class=\"h4 mb-0\">SALA DE CONTROL</h3>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"card-body\" >");

                LinkedList<BeanRX> lista = SAT.Sala_de_Control();

                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");
                out.println("<tr>");

                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Recepcion</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");

                    out.println("<td>" + lista.get(i).getPREFIJO() + "</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ESCANEO() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");

                out.println("</div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "\n"
                        + "                <div class=\"col-lg-5\">\n"
                        + "                    <div class=\"card mb-0\">\n"
                        + "                        <div class=\"card-header\">\n"
                        + "                            <div class=\"card-close\">\n"
                        + "                                <div class=\"dropdown\">\n"
                        + "                                    <button class=\"dropdown-toggle text-sm\" type=\"button\" id=\"closeCard1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"fas fa-ellipsis-v\"></i></button>\n"
                        + "                                    <div class=\"dropdown-menu dropdown-menu-end shadow-sm\" aria-labelledby=\"closeCard1\"><a class=\"dropdown-item py-1 px-3 remove\" href=\"#\"> <i class=\"fas fa-times\"></i>Close</a><a class=\"dropdown-item py-1 px-3 edit\" href=\"#\"> <i class=\"fas fa-cog\"></i>Edit</a></div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <h3 class=\"h4 mb-0\">YA PASARON POR CEIBA</h3>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"card-body\">");

                LinkedList<BeanRX> lista1 = SAT.Ceiba();

                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Recepcion</th>");
                out.println("<th>Fecha Hora Entrada</th>");
                out.println("<th>Fecha Hora Ubicacion</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista1.size(); i++) {
                    out.println("<tr>");
                    
                    out.println("<td>" + lista1.get(i).getPREFIJO() + "</td>");
                    out.println("<td>" + lista1.get(i).getFECHA_ESCANEO() + "</td>");
                    out.println("<td>" + lista1.get(i).getIMPORTEXPORT() + "</td>");
                    out.println("<td>" + lista1.get(i).getIDENTIFICACION() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");

                out.println("</div>\n"
                        + "                    </div>\n"
                        + "                    <br>\n"
                        + "                    <div class=\"card mb-0\">\n"
                        + "                        <div class=\"card-header\">\n"
                        + "                            <div class=\"card-close\">\n"
                        + "                                <div class=\"dropdown\">\n"
                        + "                                    <button class=\"dropdown-toggle text-sm\" type=\"button\" id=\"closeCard1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"fas fa-ellipsis-v\"></i></button>\n"
                        + "                                    <div class=\"dropdown-menu dropdown-menu-end shadow-sm\" aria-labelledby=\"closeCard1\"><a class=\"dropdown-item py-1 px-3 remove\" href=\"#\"> <i class=\"fas fa-times\"></i>Close</a><a class=\"dropdown-item py-1 px-3 edit\" href=\"#\"> <i class=\"fas fa-cog\"></i>Edit</a></div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <h3 class=\"h4 mb-0\">YA PASARON POR BASCULA</h3>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"card-body\">");

                LinkedList<BeanRX> lista2 = SAT.Bascula();

                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");
                out.println("<tr>");
                
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Entrada</th>");
                out.println("<th>Fecha Hora Bascula</th>");
                out.println("<th>Fecha Ubicacion</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista2.size(); i++) {
                    out.println("<tr>");
                    
                    out.println("<td>" + lista2.get(i).getPREFIJO() + "</td>");
                    out.println("<td>" + lista2.get(i).getIMPORTEXPORT() + "</td>");
                    out.println("<td>" + lista2.get(i).getFECHA_BASCULA() + "</td>");
                    out.println("<td>" + lista2.get(i).getIDENTIFICACION() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");

                out.println("</div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                \n"
                        + "\n"
                        + "                <div class=\"col-lg-4\">\n"
                        + "                    <div class=\"card mb-0\">\n"
                        + "                        <div class=\"card-header\">\n"
                        + "                            <div class=\"card-close\">\n"
                        + "                                <div class=\"dropdown\">\n"
                        + "                                    <button class=\"dropdown-toggle text-sm\" type=\"button\" id=\"closeCard1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\"><i class=\"fas fa-ellipsis-v\"></i></button>\n"
                        + "                                    <div class=\"dropdown-menu dropdown-menu-end shadow-sm\" aria-labelledby=\"closeCard1\"><a class=\"dropdown-item py-1 px-3 remove\" href=\"#\"> <i class=\"fas fa-times\"></i>Close</a><a class=\"dropdown-item py-1 px-3 edit\" href=\"#\"> <i class=\"fas fa-cog\"></i>Edit</a></div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                            <h3 class=\"h4 mb-0\">CONTROL RAYOS X</h3>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"card-body\">");

                LinkedList<BeanRX> lista3 = SAT.Rayos_X();

                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");
                out.println("<tr>");
               
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Consulta Manifiesto</th>");
                out.println("<th>Fecha Resultado</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista3.size(); i++) {
                    out.println("<tr>");
                    
                    out.println("<td>" + lista3.get(i).getPREFIJO() + "</td>");
                    out.println("<td>" + lista3.get(i).getFECHA_ESCANEO() + "</td>");
                    out.println("<td>" + lista3.get(i).getIMPORTEXPORT() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");

                out.println("</div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "\n"
                        + "\n"
                        + "            </div>\n"
                        + "        </div>");

            } else {

                /* TODO output your page here. You may use following sample code. */
                String Inicio = request.getParameter("Inicio");
                String Final = request.getParameter("Final");

                LinkedList<BeanRX> lista = SAT.RX_RESULTADO_ESCANEO_CONTE(Inicio, Final);
                String lista1 = SAT.RX_RESULTADO_ESCANEO_CONTE1(Inicio, Final);

                if (lista1 == null) {
                    System.err.println("null");
                }

                out.println("<div class=\"table-responsive\">");
                out.println("<table id=\"example\" border=\"1\"   class=\"display style=\"width:100%\" table table-hover table-bordered table-striped\">");

                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan='13'><center>EMPRESA PORTUARIA NACIONAL SANTO TOMAS DE CASTILLA\n"
                        + "INFORMACION RAYOS X</center></th>");
                out.println("</tr>");
//            out.println("<th colspan='13'><center>"+lista1+"</center></th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>PREFIJO</th>");
                out.println("<th>IDENTIFICACION</th>");
                out.println("<th>FECHA ESCANEO</th>");
                out.println("<th>ARCO OPERACION</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + lista.get(i).getPREFIJO() + "</td>");
                    out.println("<td>" + lista.get(i).getIDENTIFICACION() + "</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ESCANEO() + "</td>");
                    out.println("<td>" + lista.get(i).getIMPORTEXPORT() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("<tfoot>");
                out.println("<tr>");
                out.println("<th>PREFIJO</th>");
                out.println("<th>IDENTIFICACION</th>");
                out.println("<th>FECHA ESCANEO</th>");
                out.println("<th>ARCO OPERACION</th>");
                out.println("</tr>");
                out.println("</tfoot>");
                out.println("</table>");
                out.println("</div>");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletSat.class.getName()).log(Level.SEVERE, null, ex);
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

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

            if (request.getParameter("param").equalsIgnoreCase("0")) {
                
                LinkedList<BeanRX> lista = SAT.Sala_de_Control();
                
                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");                
                out.println("<tr>");
                out.println("<th>#</th>");
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Recepcion</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + (i + 1) + "</td>");
                    out.println("<td>" + lista.get(i).getPREFIJO() +"</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ESCANEO() +  "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                
                
            } else if (request.getParameter("param").equalsIgnoreCase("1")) {
                
                LinkedList<BeanRX> lista = SAT.Ceiba();
                
                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");                
                out.println("<tr>");
                out.println("<th>#</th>");
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Recepcion</th>");
                out.println("<th>Fecha Hora Entrada</th>");
                out.println("<th>Fecha Ubicacion</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + (i + 1) + "</td>");
                    out.println("<td>" + lista.get(i).getPREFIJO() +"</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ESCANEO() +  "</td>");
                    out.println("<td>" + lista.get(i).getIMPORTEXPORT() +  "</td>");
                    out.println("<td>" + lista.get(i).getIDENTIFICACION()+  "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                
                
            } else if (request.getParameter("param").equalsIgnoreCase("2")) {
                
                LinkedList<BeanRX> lista = SAT.Rayos_X();
                
                out.println("<div class=\"table-responsive\">");
                out.println("<table border=\"1\"   class=\"table mb-0 table-striped table-sm display\">");
                out.println("<thead>");                
                out.println("<tr>");
                out.println("<th>#</th>");
                out.println("<th>Contenedor</th>");
                out.println("<th>Fecha Hora Consulta Manifiesto</th>");
                out.println("<th>Fecha Hora Resultado</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + (i + 1) + "</td>");
                    out.println("<td>" + lista.get(i).getPREFIJO() +"</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ESCANEO() +  "</td>");
                    out.println("<td>" + lista.get(i).getIMPORTEXPORT()+  "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
                
                
            } else{

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

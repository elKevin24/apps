/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vista;

import com.google.gson.Gson;
import controlador.BeanLISTADO_BUQUES;
import controlador.BeanMANIFIESTOSXBUQUE;
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
import modelo.Manifiestos;

/**
 *
 * @author kcordon
 */
public class ServletManifiestos extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("param").equalsIgnoreCase("1")) {
            String Inicio = request.getParameter("Inicio");
            String Final = request.getParameter("Final");

            LinkedList<BeanLISTADO_BUQUES> lista = Manifiestos.RX_RESULTADO_ESCANEO_CONTE(Inicio, Final);
//            String json = new Gson().toJson(lista);
//            out.println(json);

                out.println("<div class=\"table-responsive\">");
                out.println("<table id=\"example\" border=\"1\"   class=\"display style=\"width:100%\" table table-hover table-bordered table-striped\">");

                out.println("<thead>");
                
                out.println("<tr>");
                out.println("<th></th>");
                out.println("<th>VIAJE SISTEMA</th>");
                out.println("<th>BARCO</th>");
                out.println("<th>VIAJE BARCO</th>");
                out.println("<th>SITUACION</th>");
                out.println("<th>FECHA ETA</th>");
                out.println("<th>NAVIERA</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr data-child-value='" + lista.get(i).getVIAJE_SISTEMA() + "'>");
                    out.println("<td class='details-control'></td>");
                    out.println("<td>" + lista.get(i).getVIAJE_SISTEMA() + "</td>");
                    out.println("<td>" + lista.get(i).getBARCO() + "</td>");
                    out.println("<td>" + lista.get(i).getVIAJE_BARCO() + "</td>");
                    out.println("<td>" + lista.get(i).getSITUACION() + "</td>");
                    out.println("<td>" + lista.get(i).getFECHA_ETA() + "</td>");
                    out.println("<td>" + lista.get(i).getNAVIERA() + "</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                out.println("</div>");
            }
            if (request.getParameter("param").equalsIgnoreCase("2")) {
//                String Inicio = request.getParameter("Inicio");
//            String Final = request.getParameter("Final");
//
//            LinkedList<BeanLISTADO_BUQUES> lista = Manifiestos.RX_RESULTADO_ESCANEO_CONTE(Inicio, Final);
//            String json = new Gson().toJson(lista);
//            out.println(json);

//                out.println("<div class=\"table-responsive\">");
//                out.println("<table id=\"example\" border=\"1\"   class=\"display style=\"width:100%\" table table-hover table-bordered table-striped\">");
//
//                out.println("<thead>");
//                
//                out.println("<tr>");
//                out.println("<th></th>");
//                out.println("<th>VIAJE SISTEMA</th>");
//                out.println("<th>BARCO</th>");
//                out.println("<th>VIAJE BARCO</th>");
//                out.println("<th>SITUACION</th>");
//                out.println("<th>FECHA ETA</th>");
//                out.println("<th>NAVIERA</th>");
//                out.println("</tr>");
//                out.println("</thead>");
//                out.println("<tbody>");
//                for (int i = 0; i < lista.size(); i++) {
//                    out.println("<tr data-child-value='" + lista.get(i).getVIAJE_SISTEMA() + "'>");
//                    out.println("<td class='details-control'></td>");
//                    out.println("<td>" + lista.get(i).getVIAJE_SISTEMA() + "</td>");
//                    out.println("<td>" + lista.get(i).getBARCO() + "</td>");
//                    out.println("<td>" + lista.get(i).getVIAJE_BARCO() + "</td>");
//                    out.println("<td>" + lista.get(i).getSITUACION() + "</td>");
//                    out.println("<td>" + lista.get(i).getFECHA_ETA() + "</td>");
//                    out.println("<td>" + lista.get(i).getNAVIERA() + "</td>");
//                    out.println("</tr>");
//                }
//                out.println("</tbody>");
//                out.println("</table>");
//                out.println("</div>");
                String value = request.getParameter("value");
                
                LinkedList<BeanMANIFIESTOSXBUQUE> lista = Manifiestos.MANIFIESTOSXBUQUE(value);
                out.println("<table cellpadding=\"5\" cellspacing=\"0\" border=\"0\" style=\"padding-left:50px;\">");

                
                out.println("<tr>");
                out.println("<th>MODALIDAD</th>");
                out.println("<th>MANIFIESTO</th>");
                out.println("<th>NAVIERA</th>");
                out.println("<th>OPERADO</th>");
                out.println("</tr>");
                for (int i = 0; i < lista.size(); i++) {
                    out.println("<tr onclick=\"ir('" + lista.get(i).getMANIFIESTO() + "','" + lista.get(i).getOPERADO() + "')\">");
                    out.println("<td>" + lista.get(i).getMODALIDAD() + "</td>");
                    out.println("<td>" + lista.get(i).getMANIFIESTO() + "</td>");
                    out.println("<td>" + lista.get(i).getNAVIERA() + "</td>");
                    out.println("<td>" + lista.get(i).getOPERADO() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletManifiestos.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanPilotos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pilotos;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "BuscarServlet", urlPatterns = {"/busca.do"})
public class BuscarServlet extends HttpServlet {

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
        
        String param = request.getParameter("param");
        
        System.err.println(""+param);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String filtro = request.getParameter("filtro");
            
            Pilotos d = new Pilotos();
            
            try {
                for( BeanPilotos p : d.getPiloto(filtro)){
                    
                    
                    
                   // MessageFormat.format("{0} is a government of the {1}, for the {1} and by the {1}",Nombre);
                    
                  
                    out.println("<li id='piloto' value='"+p.getNombre()+"' onclick='myFunction(\""+p.getNombre()+"\")'>"+p.getNombre()+"</li>");
                    out.println("<li id='piloto' value='"+p.getNombre()+"'>"+param+"</li>");
                    
                    
                    //out.println(`<li id='piloto'><a onclick="myFunction(${p.getNombre()})">${p.getNombre()}</a></li>`);
                    //out.println("<li>"+p.getNombre()+"</li>");
                    
                    
                }
            } catch (SQLException ex) {
                System.err.println(""+ex);
            }
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

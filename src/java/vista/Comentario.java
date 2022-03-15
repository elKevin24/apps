/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanComentario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Factura;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "Comentario", urlPatterns = {"/Comentario"})
public class Comentario extends HttpServlet {

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
        
        
        String factura = request.getParameter("factura");
        String comentario = request.getParameter("Comentario");
        String usuario = request.getParameter("usuario");
        
        PrintWriter out = response.getWriter();
        out.println("factura: "+factura  + " comentario: "+comentario );
        
        BeanComentario busuario;
        busuario = new BeanComentario(factura, comentario, usuario);
        
        //String nombre, String num_convenio, String descripcion, 
           //BigDecimal monto_total, String direccion, String id_municipio, String fecha, String id_tipo_proyecto
        boolean sw = Factura.agregarProceso(busuario);
        factura = "*"+factura;

       
       
        if (sw) {
            response.sendRedirect("FACTURA.jsp?numero="+factura+"");

        } else {

            out.println(sw);
        }

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

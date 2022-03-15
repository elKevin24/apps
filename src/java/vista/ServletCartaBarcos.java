/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanCartaBarcos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CartaBarcos;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "ServletBarco", urlPatterns = {"/ServletBarco"})
public class ServletCartaBarcos extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        String LR = request.getParameter("LR");
        String SENAL_DISTINTIVA = request.getParameter("SENAL_DISTINTIVA");
        String NOMBRE_BUQUE = request.getParameter("NOMBRE_BUQUE");
        String TIPO_DE_BARCO_POR_ESTRUCTURA = request.getParameter("TIPO_DE_BARCO_POR_ESTRUCTURA");
        String USUARIO_DE_SERVICIO = request.getParameter("USUARIO_DE_SERVICIO");

        BeanCartaBarcos carta = new BeanCartaBarcos(LR, SENAL_DISTINTIVA, NOMBRE_BUQUE, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO);

        boolean recepcion = CartaBarcos.agregar(carta);

        if (recepcion) {

            try {
                //Ponemos a "Dormir" el programa durante los ms que queremos
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            response.sendRedirect("GuardadoP.jsp");

        } else {
            out.println(recepcion);

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

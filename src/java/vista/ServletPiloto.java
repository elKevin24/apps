/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanPilotos;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletPiloto", urlPatterns = {"/ServletPiloto"})
public class ServletPiloto extends HttpServlet {

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

        String ID = request.getParameter("ID");
        String Nombre = request.getParameter("Nombre");
        String SegundoNombre = request.getParameter("SegundoNombre");
        String Apellido = request.getParameter("Apellido");
        String SegundoApellido = request.getParameter("SegundoApellido");
        String Licencia = request.getParameter("Licencia");
        String TipoLicencia = request.getParameter("TipoLicencia");
        String Pais_licencia = request.getParameter("Pais_licencia");
        String Pasaporte = request.getParameter("Pasaporte");
        String expiracion = request.getParameter("expiracion");
        String Pais_pasaporte = request.getParameter("Pais_pasaporte");

        BeanPilotos carta;

        System.err.println("" + Nombre);

        carta = new BeanPilotos(ID, Nombre, SegundoNombre, Apellido,
                SegundoApellido, Licencia, TipoLicencia,
                Pais_licencia, Pasaporte, expiracion,
                Pais_pasaporte);

        boolean recepcion = Pilotos.agregar(carta);

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

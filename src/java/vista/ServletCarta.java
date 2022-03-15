/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BeanCarta;
import controlador.BeanCarta_Detalle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carta;
import modelo.detalle_carta;

/**
 *
 * @author kcordon
 */
@WebServlet(name = "ServletCarta", urlPatterns = {"/ServletCarta"})
public class ServletCarta extends HttpServlet {

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

        String BUQUE = request.getParameter("BUQUE");
        int salida = BUQUE.indexOf("S");
        String SENAL = BUQUE.substring(0, salida);
        String LR = BUQUE.substring(salida + 1);
        String Id_piloto = request.getParameter("PILOTO");
        String TRANSPORTISTA = request.getParameter("TRANSPORTISTA");

        String CWBC_ETA = request.getParameter("RW_FECHA_VIAJE_BARCO");

        String RW_FECHA_VIAJE_BARCO = null;

        CWBC_ETA = CWBC_ETA.replace('T', ' ');
        RW_FECHA_VIAJE_BARCO = CWBC_ETA + ":00";
        String RW_ID_RECEPCION = request.getParameter("RW_ID_RECEPCION").toUpperCase();

        String RW_ATC = request.getParameter("RW_ATC").toUpperCase();

        String RW_VIAJE_BARCO = request.getParameter("RW_VIAJE_BARCO").toUpperCase();

        String RW_PREFIJO_CONT = request.getParameter("RW_PREFIJO_CONT").toUpperCase();
        String RW_IDENTIFICACION_CONT = request.getParameter("RW_IDENTIFICACION_CONT").toUpperCase();
        String RW_C_O_F = request.getParameter("RW_C_O_F");
        String RW_MEDIDA = request.getParameter("RW_MEDIDA");
        String RW_ESTADO_CONT = request.getParameter("RW_ESTADO_CONT");
        String RW_REFER_SECO_OPERANDO = request.getParameter("RW_REFER_SECO_OPERANDO").toUpperCase();
        String RW_PESO_CONTENEDOR = request.getParameter("RW_PESO_CONTENEDOR").toUpperCase();
        String RW_PAIS_ORIGEN = request.getParameter("RW_PAIS_ORIGEN").toUpperCase();
        String RW_PAIS_DESTINO = request.getParameter("RW_PAIS_DESTINO").toUpperCase();
        String RW_DICE_CONTENER = request.getParameter("RW_DICE_CONTENER").toUpperCase();
        String RW_DICE_OBSERVACIONES = request.getParameter("RW_DICE_OBSERVACIONES").toUpperCase();

        String RW_PLACA_CABEZAL = request.getParameter("RW_PLACA_CABEZAL").toUpperCase();
        String RW_PAIS_PLACA = request.getParameter("RW_PAIS_PLACA").toUpperCase();
        String RW_PREFIJO_CHASIS = request.getParameter("RW_PREFIJO_CHASIS").toUpperCase();
        String RW_IDENTIFICACION_CHASIS = request.getParameter("RW_IDENTIFICACION_CHASIS").toUpperCase();

        String RW_USUARIO_SERVICIO = request.getParameter("USUARIO_DE_SERVICIO");

        out.println("BUQUE: " + BUQUE + " salida: " + salida + " LR: " + LR + " SENAL: " + SENAL);
        System.out.println("BUQUE: " + BUQUE + " salida: " + salida + " LR: " + LR + " SENAL: " + SENAL);

        BeanCarta carta = null;

        System.err.println(" " + RW_FECHA_VIAJE_BARCO);

        carta = new BeanCarta(RW_ID_RECEPCION, RW_PREFIJO_CONT, RW_IDENTIFICACION_CONT,
                RW_C_O_F, RW_MEDIDA, RW_ESTADO_CONT, RW_VIAJE_BARCO, RW_FECHA_VIAJE_BARCO,
                RW_REFER_SECO_OPERANDO, RW_ATC, RW_PREFIJO_CHASIS, RW_IDENTIFICACION_CHASIS,
                RW_PLACA_CABEZAL, RW_PAIS_PLACA, RW_PESO_CONTENEDOR, RW_PAIS_ORIGEN,
                RW_PAIS_DESTINO, RW_DICE_CONTENER, RW_DICE_OBSERVACIONES, RW_USUARIO_SERVICIO, Id_piloto, TRANSPORTISTA, LR, SENAL
        );
        boolean recepsion = Carta.agregar(carta);
        

        if (recepsion) {

            System.err.println("se guardo carta falta DA");

        } else {
            out.println(recepsion);

        }

        if (request.getParameter("cont").isEmpty()) {
            System.err.println("is empty");
            response.sendRedirect("Solicitud_Servicios.jsp");
        } else {
            //Empieza parte de Detalle
            int cont = Integer.valueOf(request.getParameter("cont"));

            //String Nombre = request.getParameter("Nombre[1]");
            BeanCarta_Detalle CD = null;
            BeanCarta_Detalle consulta = new BeanCarta_Detalle();
            consulta = detalle_carta.Consultar();

            boolean k = false;

            // lo envio pero no afecta en el insert
            int numero = 4; //numero de inputs
            String[][] detalle = new String[cont][numero];

            for (int i = 0; i < detalle.length; i++) {
                int a = i + 1;
                for (int j = 1; j < detalle[i].length; j++) {

                }
                detalle[i][1] = request.getParameter("DA[" + a + "]").toUpperCase();
                detalle[i][2] = request.getParameter("Numero_Orden[" + a + "]").toUpperCase();
                detalle[i][3] = request.getParameter("Observaciones[" + a + "]").toUpperCase();
                //Aqui vas obteniendo el id del curso
            }

            for (String[] detalle1 : detalle) {
                for (int j = 1; j < detalle1.length; j++) {

                    System.err.println("valor guardado" + detalle1[j]);
                }
                //Aqui vas obteniendo el id del curso
            }

            for (int i = 0; i < detalle.length; i++) {
                int a = i + 1;
                for (int j = 1; j < detalle[i].length; j++) {

                }

                CD = new BeanCarta_Detalle(detalle[i][1], RW_ID_RECEPCION, detalle[i][2], detalle[i][3]);
                k = detalle_carta.agregar(CD);
            }

            if (k) {
                //response.sendRedirect("carta_porte.jsp");

                System.out.println("exito detalle");
                response.sendRedirect("Guardado.jsp?id="+ RW_ID_RECEPCION+"");

            } else {

                out.println(k);
            }

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vista;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author kcordon
 */
public class Usuario extends HttpServlet {

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

//        String USER_ID = request.getParameter("USER_ID");
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Usuario</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Usuario at " + request.getContextPath() + USER_ID+"</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        ArrayList<String> inputs = new ArrayList<String>();
        String[][] input = null;
        String fieldName;
        String fileName;
        String contentType;
        boolean isInMemory;
        long sizeInBytes;

        try {

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

// Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

// Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

// Parse the request
            List<FileItem> items = upload.parseRequest(request);
            input = new String[items.size()][2];
//            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
//                System.err.println("items.size()" + items.size());
                for (int i = 0; i < items.size(); i++) {
                    /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
                    FileItem item = (FileItem) items.get(i);
                    /*item.isFormField() false=input file; true=text field*/
                    if (item.isFormField()) {
                        inputs.add(item.getString());
                        inputs.add(item.getFieldName());
                        input[i][0] = item.getFieldName();
                        input[i][1] = item.getString();

                        /*cual sera la ruta al archivo en el servidor*/
//            File archivo_server = new File("C:/Users/Kcordon/Documents/NetBeansProjects/gobernacionizabal/web/img/imgnoticia/" + nombre);

                        /*y lo escribimos en el servido*/
//            item.write(archivo_server);
                        /*response.setHeader("Refresh", "2;url=formulario.jsp?nombre=" + nombre + "");*/
                    } else {
                        try {

                            fieldName = item.getFieldName();
                            fileName = item.getName();
                            contentType = item.getContentType();
                            isInMemory = item.isInMemory();
                            sizeInBytes = item.getSize();
//                            String uploadPath = getServletContext().getRealPath("") + input[1][1] ;
//                            String uploadPath = getServletContext().getRealPath("") + input[1][1] + File.separator + input[8][1];
                            String uploadPath = getServletContext().getRealPath("") + input[2][1]+ File.separator + input[8][1];

//                        String uploadPath = "/home/oracle/Users/" + input[1][1];
                            File uploadDir = new File(uploadPath);
                            //mkdir solo para crear una carpeta
                            //mkdirs para crear varias
                            
                            if (!uploadDir.exists()) {
                                uploadDir.mkdirs();
                                

                            }
                            String filePath = uploadPath + File.separator + fieldName + ".pdf";

                            File storeFile = new File(filePath);

//                            out.println("<h1>uploadPath: " + uploadDir + "</h1>");
//                            out.println("storeFile: " + storeFile);
//                            out.println("<h1>fieldName: " + fieldName + ", fileName: " + fileName + ", contentType: " + contentType + ", isInMemory: " + isInMemory + ", sizeInBytes: " + sizeInBytes + "</h1>");
                            item.write(storeFile);
                            request.setAttribute("message", "Upload has been done successfully!");
                        } catch (Exception e) {
                            System.err.println("Creacion de Archivos" + e);

                        }
                    }
                }
                
                controlador.Usuario agregar;

//        if (input.length == 9) {
//            System.out.println(input[0][1] + input[1][1] + input[2][1] + input[3][1] + input[4][1] + input[5][1] + input[6][1] + input[7][1]);
        agregar = new controlador.Usuario(input[0][1], input[1][1], input[3][1], input[4][1], input[5][1], input[6][1], input[7][1], input[8][1], "2", input[2][1]);

        
        boolean sw = modelo.Usuario.agregar_Usuario(agregar);
        if (sw) {
//            System.err.println("sw");
            response.sendRedirect("Usuarios_Listado_Solicitud.jsp");
            
        }
                /* TODO output your page here. You may use following sample code. */

//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet Usuario</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Servlet Usuario at " + request.getContextPath() + items + "</h1>");

//                out.println("<h1>Nombre: " + inputs + "</h1>");
//                for (int i = 0; i < input.length; i++) {
//
//                    out.println("<h1>Nombre: " + i + input[i][0] + "Valor: " + input[i][1] + "</h1>");
//
//                }
//                out.println("<h1>"+input[0][1] + input[1][1] + input[2][1] + input[3][1] + input[4][1] + input[5][1] + input[6][1] + input[7][1] + input[8][1]+ "</h1>");
//                out.println("<h1>input.length" + input.length + "</h1>");
//                out.println("<h1>lista: " + input[0][1] + input[1][1] + input[2][1] + input[3][1] + input[4][1] + input[5][1] + input[6][1] + input[7][1] + input[8][1] + "</h1>");
//
//                out.println("</body>");
//                out.println("</html>");
            }

        } catch (FileUploadException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);

        }
        
//        }else{
//            System.out.println(input[0][1] + input[1][1] + input[2][1] + input[3][1] + input[4][1] + input[5][1] + input[6][1] + input[7][1] + 0);
//            agregar = new controlador.Usuario(input[0][1], input[1][1], input[2][1], input[3][1], input[4][1],  input[5][1],  input[6][1], input[7][1], "2", "2");
//        }
//        controlador.Usuario agregar = new controlador.Usuario(input[0][1], input[1][1], input[2][1], input[3][1], input[4][1],  input[5][1],  input[6][1], input[7][1], input[7][1], input[7][1]);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}

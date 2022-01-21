/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileLocation = null;
        String DPI = null;
        //tipo documento
        String TIPO = null;
        String CAT = null;
        String usuario_servicio = null;
        if (req.getParameter("usuario_servicio").equalsIgnoreCase("null")) {
            CAT = req.getParameter("CAT");
            DPI = req.getParameter("DPI");
            TIPO = req.getParameter("TIPO");
            fileLocation = "C:\\Users\\Kcordon\\Documents\\NetBeansProjects\\apps\\build\\web\\" + CAT + "\\" + DPI + "\\" + TIPO + ".pdf"; //change the path according to you

        } else {

            usuario_servicio = req.getParameter("usuario_servicio");
            DPI = req.getParameter("DPI");
            TIPO = req.getParameter("TIPO");

            System.out.println("usuario_servicio: " + usuario_servicio + "DPI: " + DPI);
            fileLocation = "C:\\Users\\Kcordon\\Documents\\NetBeansProjects\\apps\\build\\web\\" + usuario_servicio + "\\" + DPI + "\\" + TIPO + ".pdf"; //change the path according to you

        }
        File file = new File(fileLocation);
        FileInputStream fis = new FileInputStream(file);
        ServletOutputStream sos = resp.getOutputStream();
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment;filename=" + TIPO + ".pdf");
        byte[] buffer = new byte[4096];

        while ((fis.read(buffer, 0, 4096)) != -1) {
            sos.write(buffer, 0, 4096);
        }
        fis.close();
    }
}

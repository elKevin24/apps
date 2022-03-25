package vista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.persona;
import controlador.personaDAO;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    personaDAO dao = new personaDAO();
    persona p = new persona();
    int r;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {
            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");
            HttpSession session = request.getSession(true);
//            session.setMaxInactiveInterval(30 * 60);

            p.setUsuario(usuario);
            p.setClave(clave);
            r = dao.Validar(p);
            if (r == 1) {

                session.setAttribute("usuario", usuario);
//                session.setAttribute("clave", clave);
//                System.err.println("user"+p.getId_login());


                boolean A = modelo.Usuario.agregar_Bitacora(p.getId_login());

                request.getSession().setAttribute("usuario", p.getId_login());
//                

                if (clave.equals("12345678")) {
                    System.err.println("pass: " + clave);
                    response.sendRedirect("cambia_pass.jsp");
//                response.sendRedirect("menu.jsp");
                } else {
                    response.sendRedirect("menu.jsp");
                    System.out.println("Ingreso Apps");
                    
                }

            } else {
                request.setAttribute("mensaje", "false");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensaje", "false");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }

    }

}

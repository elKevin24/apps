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
    personaDAO dao= new personaDAO();
    persona p=new persona();
    int r;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion= request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String usuario=request.getParameter("usuario");
            String clave=request.getParameter("clave");
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(30*60);
            
            p.setUsuario(usuario);
            p.setClave(clave);
            r=dao.Validar(p);
            if(r==1){
                
                session.setAttribute("usuario", usuario);
                session.setAttribute("clave", clave);
                
                request.getSession().setAttribute("usuario", usuario);
                request.getSession().setAttribute("clave", clave);
                
                
                response.sendRedirect("menu.jsp");
                
            }else{
                request.setAttribute("mensaje", "false");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("mensaje", "false");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    
    }

}

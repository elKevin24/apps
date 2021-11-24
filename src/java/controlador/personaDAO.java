
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.Validar;

public class personaDAO implements Validar {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;   
  

    
    @Override
    public int Validar(persona per) {
        int r=0;
        

        String sql="select * from USUARIOS_WEB.USUARIOS_PORTAL_INOW where Correo=? and Clave=?";
        try{
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getUsuario());
            ps.setString(2, per.getClave());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUsuario(rs.getString("Correo"));
                per.setClave(rs.getString("Clave"));
            }
            
            ps.close();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
        }catch (SQLException e){  
            System.err.println("error login"+e);
            return 0;
        }
    }
    
}

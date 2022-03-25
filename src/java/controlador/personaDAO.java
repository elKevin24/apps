package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;
import modelo.Validar;

public class personaDAO implements Validar {
//    Connection con;
//    Conexion cn=new Conexion();
//    PreparedStatement ps;

    @Override
    public int Validar(persona per) {
        int r = 0;

        String sql = "select * from USUARIOS_WEB.USUARIOS_PORTAL where Correo=? and Clave=? and Estatus = 'A'";
        try {
            Conexion c = new Conexion();
            try ( Connection con = c.getConexion()) {
                try ( PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, per.getUsuario());
                    ps.setString(2, per.getClave());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        r = r + 1;
                        per.setUsuario(rs.getString("Correo"));
                        per.setId_login(rs.getString("USER_ID"));
                    }
                    rs.close();
                    ps.close();
                }
                con.close();
            }

            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.err.println("error login" + e);
            return 0;
        }
    }

}

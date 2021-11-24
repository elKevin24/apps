package modelo;

import controlador.BeanUsuarios;
import controlador.BeanTipoBuque;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Usuario {

    public static BeanUsuarios ObtenerUsuario(String id) {
        BeanUsuarios user = new BeanUsuarios();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select \n"
                        + "USERID, UPPER(USUARIO_INOW) USUARIO_INOW, USUARIO_DE_SERVICIO, NOMBRE, NVL(TO_CHAR(TELEFONO),' ') TELEFONO, NIT, DIRECCION, REPRESENTANTE, EMAIL_US, \n"
                        + "usuarios_web.usuarios_portal_inow.correo CORREO \n"
                        + "from \n"
                        + "FINANCIERO.usuarios_web_inow, FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS,USUARIOS_WEB.USUARIOS_PORTAL_INOW \n"
                        + "WHERE usuarios_web_inow.USUARIO_DE_SERVICIO = asft_usuarios_de_servicios.codigo\n"
                        + "AND UPPER(USUARIO_INOW) = UPPER(USUARIOS_PORTAL_INOW.USUARIO(+))\n"
                        + "AND usuarios_web.usuarios_portal_inow.correo =  '" + id + "'")) {
                    while (rs.next()) {

                        user.setUSERID(rs.getString("USERID"));
                        user.setUSUARIO_INOW(rs.getString("USUARIO_INOW"));
                        user.setUSUARIO_DE_SERVICIO(rs.getString("USUARIO_DE_SERVICIO"));
                        user.setNOMBRE(rs.getString("NOMBRE"));
                        user.setTELEFONO(rs.getString("TELEFONO"));
                        user.setNIT(rs.getString("NIT"));
                        user.setDIRECCION(rs.getString("DIRECCION"));
                        user.setREPRESENTANTE(rs.getString("REPRESENTANTE"));
                        user.setEMAIL_US(rs.getString("EMAIL_US"));
                        user.setCORREO(rs.getString("CORREO"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public static BeanUsuarios ObtenerCambioDolar() {
        BeanUsuarios user = new BeanUsuarios();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("Select  fecha, valor_quetzal\n"
                        + "from \n"
                        + "FINANCIERO.asft_tipos_de_cambio\n"
                        + "WHERE fecha = (select Max(fecha) from FINANCIERO.asft_tipos_de_cambio)")) {
                    while (rs.next()) {
                        user.setFECHA_CAMBIO(rs.getString("fecha"));
                        user.setCAMBIO(rs.getDouble("valor_quetzal"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public static LinkedList<BeanTipoBuque> consultarTipoBuque() throws SQLException {
        LinkedList<BeanTipoBuque> tipo = new LinkedList<>();
        String sql;

        sql = "select * from COTIZADOR_WEB.CW_TIPO_OPERACION Order by 1";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanTipoBuque user = new BeanTipoBuque();
                        user.setCWTO_TIPO_OPERACION(rs.getString("CWTO_TIPO_OPERACION"));
                        user.setCWTO_OPERACION(rs.getString("CWTO_OPERACION"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return tipo;
    }

    public static boolean agregar (BeanTipoBuque Tipo) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO COTIZADOR_WEB.cw_tipo_operacion (CWTO_TIPO_OPERACION, CWTO_OPERACION) VALUES ('" + Tipo.getCWTO_TIPO_OPERACION() + "','" + Tipo.getCWTO_OPERACION() + "')";

                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

}

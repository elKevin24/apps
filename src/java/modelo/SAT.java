package modelo;

import controlador.BeanRX;
import controlador.BeanUsuarios;
import controlador.BeanTipoBuque;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class SAT {

    public static BeanUsuarios ObtenerUsuario(String id) {
        BeanUsuarios user = new BeanUsuarios();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    \"A1\".\"USER_ID\"                \"USER_ID\",\n"
                        + "    upper(\"A3\".\"USUARIO_INOW\") \"USUARIO_INOW\",\n"
                        + "    \"A3\".\"USUARIO_DE_SERVICIO\"   \"USUARIO_DE_SERVICIO\",\n"
                        + "    \"A2\".\"NOMBRE\"                \"NOMBRE\",\n"
                        + "    nvl(to_char(\"A2\".\"TELEFONO\"), ' ') \"TELEFONO\",\n"
                        + "    \"A2\".\"NIT\"                   \"NIT\",\n"
                        + "    \"A2\".\"DIRECCION\"             \"DIRECCION\",\n"
                        + "    \"A2\".\"REPRESENTANTE\"         \"REPRESENTANTE\",\n"
                        + "    \"A2\".\"EMAIL_US\"              \"EMAIL_US\",\n"
                        + "    \"A1\".\"CORREO\"                \"CORREO\"\n"
                        + "FROM\n"
                        + "    \"FINANCIERO\".\"USUARIOS_WEB_INOW\"            \"A3\",\n"
                        + "    \"FINANCIERO\".\"ASFT_USUARIOS_DE_SERVICIOS\"   \"A2\",\n"
                        + "    \"USUARIOS_WEB\".\"USUARIOS_PORTAL\"       \"A1\"\n"
                        + "WHERE\n"
                        + "    \"A3\".\"USUARIO_DE_SERVICIO\" = \"A2\".\"CODIGO\"\n"
                        + "    AND upper(\"A3\".\"USUARIO_INOW\") = upper(\"A1\".\"USUARIO\"(+))\n"
                        + "    AND \"A1\".\"CORREO\" =  '" + id + "'")) {
                    while (rs.next()) {

                        user.setUSERID(rs.getString("USER_ID"));
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

            System.out.println("modelo.Usuario.ObtenerUsuario(): " + e);
        }
        return user;
    }

    public static LinkedList<BeanRX> RX_RESULTADO_ESCANEO_CONTE(String Inicio, String Final) throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "SELECT\n"
                + "    \"A1\".\"PREFIJO\"          \"PREFIJO\",\n"
                + "    \"A1\".\"IDENTIFICACION\"   \"IDENTIFICACION\",\n"
                + "    \"A1\".\"FECHA_ESCANEO\"    \"FECHA_ESCANEO\",\n"
                + "    decode(\"A1\".\"IMPORTEXPORT\", 'I', 'IMPORT', 'E', 'EXPORT') \"ARCO_OPERACION\"\n"
                + "FROM\n"
                + "    \"PUERTO\".\"RX_RESULTADO_ESCANEO_CONTE\" \"A1\"\n"
                + "WHERE\n"
                + "    \"A1\".\"FECHA_ESCANEO\" >= '" + Inicio + "'\n"
                + "    AND \"A1\".\"FECHA_ESCANEO\" <= to_date('" + Final + "')+1";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanRX user = new BeanRX();
                        user.setPREFIJO(rs.getString("PREFIJO"));
                        user.setIDENTIFICACION(rs.getString("IDENTIFICACION"));
                        user.setFECHA_ESCANEO(rs.getString("FECHA_ESCANEO"));
                        user.setIMPORTEXPORT(rs.getString("ARCO_OPERACION"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.RX_RESULTADO_ESCANEO_CONTE()" + e);

        }

        return tipo;
    }

    public static LinkedList<BeanRX> Sala_de_Control () throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "SELECT A.PREFIJO||' '||A.NUMERO_DE_IDENTIFICACION contenedor, A.FECHA_HORA_RECEPCION\n"
                + "FROM PUERTO.EOPT_RECEPCION_DE_CONTENEDORES A\n"
                + "where A.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "AND A.FECHA_HORA_ENTRADA is null\n"
                + "and not exists\n"
                + "    (select  *  -- pasaron por bascula \n"
                + "    from PUERTO.BASC_RECEPCION d, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES e\n"
                + "    where d.recepcion = e.AUTORIZACION_RECEPCION\n"
                + "    and e.AUTORIZACION_RECEPCION = a.AUTORIZACION_RECEPCION\n"
                + "    and e.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "    )\n"
                + "order by A.FECHA_HORA_RECEPCION asc";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanRX user = new BeanRX();
                        user.setPREFIJO(rs.getString("contenedor"));
                        user.setFECHA_ESCANEO(rs.getString("FECHA_HORA_RECEPCION"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.Sala_de_Control()"+e);

        }

        return tipo;
    }

}

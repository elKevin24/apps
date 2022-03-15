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
        String error = null;

        sql = "SELECT\n"
                + "                PREFIJO,\n"
                + "                IDENTIFICACION,\n"
                + "                FECHA_ESCANEO,\n"
                + "                decode(IMPORTEXPORT, 'I', 'IMPORT', 'E', 'EXPORT') ARCO_OPERACION\n"
                + "                FROM\n"
                + "                PUERTO.RX_RESULTADO_ESCANEO_CONTE\n"
                + "                WHERE\n"
                + "                FECHA_ESCANEO >=   to_date('" + Inicio + "','DD-MM-YYYY')\n"
                + "                AND FECHA_ESCANEO <= to_date('" + Final + "','DD-MM-YYYY')+1";

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
            error = "RX_RESULTADO_ESCANEO_CONTE: _" + e;
            System.out.println("modelo.SAT.RX_RESULTADO_ESCANEO_CONTE()" + e);

        }

        return tipo;
    }

    public static String RX_RESULTADO_ESCANEO_CONTE1(String Inicio, String Final) throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;
        String error = null;

        sql = "SELECT\n"
                + "                PREFIJO,\n"
                + "                IDENTIFICACION,\n"
                + "                FECHA_ESCANEO,\n"
                + "                decode(IMPORTEXPORT, 'I', 'IMPORT', 'E', 'EXPORT') ARCO_OPERACION\n"
                + "                FROM\n"
                + "                PUERTO.RX_RESULTADO_ESCANEO_CONTE\n"
                + "                WHERE\n"
                + "                FECHA_ESCANEO >=   to_date('" + Inicio + "','DD-MM-YYYY')\n"
                + "                AND FECHA_ESCANEO <= to_date('" + Final + "','DD-MM-YYYY')+1";

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
            error = "RX_RESULTADO_ESCANEO_CONTE: _" + e + " Inicio: " + Inicio + " Final: " + Final;
            System.out.println("modelo.SAT.RX_RESULTADO_ESCANEO_CONTE()" + e);

        }

        return error;
    }

    public static LinkedList<BeanRX> Sala_de_Control() throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "SELECT A.PREFIJO||' '||A.NUMERO_DE_IDENTIFICACION contenedor, to_char( A.FECHA_HORA_RECEPCION, 'DD-MM-YY HH24:MI') FECHA_HORA_RECEPCION\n"
                + "FROM PUERTO.EOPT_RECEPCION_DE_CONTENEDORES A\n"
                + "where A.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "AND A.FECHA_HORA_ENTRADA is null\n"
                + "and not exists\n"
                + "    (select  *  -- pasaron por bascula\n"
                + "    from PUERTO.BASC_RECEPCION d, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES e\n"
                + "    where d.recepcion = e.AUTORIZACION_RECEPCION\n"
                + "    and e.AUTORIZACION_RECEPCION = a.AUTORIZACION_RECEPCION\n"
                + "    and e.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "    ) order by FECHA_HORA_RECEPCION desc";

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

            System.out.println("modelo.SAT.Sala_de_Control()" + e);

        }

        return tipo;
    }

    public static LinkedList<BeanRX> Ceiba() throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "SELECT c.PREFIJO||' '||c.NUMERO_DE_IDENTIFICACION contenedor, to_char(c.FECHA_HORA_RECEPCION, 'DD-MM-YY HH24:MI') FECHA_HORA_RECEPCION, to_char(c.FECHA_HORA_ENTRADA, 'DD-MM-YY HH24:MI') FECHA_HORA_ENTRADA,\n"
                + "\n"
                + "NVL((select TO_CHAR(TU.FECHA_GRABADOR, 'DD-MM-YY HH24:MI') \n"
                + "from PUERTO.TARJETA_COF tc, PUERTO.tarjeta_cof_ubicacion tu \n"
                + "WHERE TC.TCF_CORRELATIVO_TARJETA = TU.TCF_CORRELATIVO_TARJETA\n"
                + "AND TC.TCF_ESTADO_TARJETA = 'A'\n"
                + "AND TC.TCF_MODO_CREACION_TARJETA = 'R'\n"
                + "AND TC.TCF_PREFIJO = C.PREFIJO\n"
                + "AND TC.TCF_IDENTIFICACION = C.NUMERO_DE_IDENTIFICACION), ' ') FECHA_UBICACION\n"
                + "\n"
                + "FROM PUERTO.EOPT_RECEPCION_DE_CONTENEDORES c\n"
                + "where c.FECHA_HORA_ENTRADA is not null\n"
                + "and c.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "and not exists  \n"
                + "    (select  *  --pasaron por bascula\n"
                + "    from PUERTO.BASC_RECEPCION d, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES e\n"
                + "    where d.recepcion = e.AUTORIZACION_RECEPCION\n"
                + "    and e.AUTORIZACION_RECEPCION = c.AUTORIZACION_RECEPCION\n"
                + "    and e.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate)\n"
                + "and not exists (\n"
                + "    select *   --pasaron resultado RX\n"
                + "    from PUERTO.RX_RESULTADO_ESCANEO_CONTE f\n"
                + "    where f.FECHA_INSERT between (sysdate-3) and sysdate\n"
                + "    and F.PREFIJO = c.PREFIJO\n"
                + "    and F.IDENTIFICACION = c.NUMERO_DE_IDENTIFICACION\n"
                + "    ) ";

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
                        user.setIMPORTEXPORT(rs.getString("FECHA_HORA_ENTRADA"));
                        user.setIDENTIFICACION(rs.getString("FECHA_UBICACION"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.Ceiba()" + e);

        }

        return tipo;
    }

    public static LinkedList<BeanRX> Rayos_X() throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "select c.contenedor,  NVL(TO_CHAR(c.FECHA_ARCO,'DD-MM-YY HH24:MI'), ' ') fecha_consulta_manif, NVL(TO_CHAR(c.FECHA_RESULTADO,'DD-MM-YY HH24:MI'), ' ') fecha_resultado\n"
                + "from (\n"
                + "select a.PREFIJO||' '||a.IDENTIFICACION CONTENEDOR,  FECHA_ARCO,  B.FECHA_INSERT FECHA_RESULTADO\n"
                + "from PUERTO.RX_INFO_CONTE_ESCANEO a, PUERTO.RX_RESULTADO_ESCANEO_CONTE b\n"
                + "where (A.PREFIJO = B.PREFIJO(+)\n"
                + "and A.IDENTIFICACION = B.IDENTIFICACION(+)\n"
                + "and A.FECHA_RESULT_ESCANEO = B.FECHA_INSERT(+))\n"
                + "and nvl(a.fecha_arco, B.FECHA_INSERT) between (sysdate-3) and sysdate\n"
                + "and a.IMPORTEXPORT = 'E'\n"
                + "union\n"
                + "select B.PREFIJO||' '||B.IDENTIFICACION CONTENEDOR, FECHA_ARCO, B.FECHA_INSERT FECHA_RESULTADO\n"
                + "from PUERTO.RX_INFO_CONTE_ESCANEO a, PUERTO.RX_RESULTADO_ESCANEO_CONTE b\n"
                + "where (A.PREFIJO(+) = B.PREFIJO\n"
                + "and A.IDENTIFICACION(+) = B.IDENTIFICACION\n"
                + "and A.FECHA_RESULT_ESCANEO(+) = B.FECHA_INSERT)\n"
                + "and nvl(a.fecha_arco, B.FECHA_INSERT) between (sysdate-3) and sysdate\n"
                + "and b.IMPORTEXPORT = 'E'\n"
                + ") c ORDER BY nvl(c.fecha_arco, c.fecha_resultado) desc";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanRX user = new BeanRX();
                        user.setPREFIJO(rs.getString("contenedor"));
                        user.setFECHA_ESCANEO(rs.getString("fecha_consulta_manif"));
                        user.setIMPORTEXPORT(rs.getString("fecha_resultado"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.Rayos_X()" + e);

        }

        return tipo;
    }

    public static LinkedList<BeanRX> Bascula() throws SQLException {
        LinkedList<BeanRX> tipo = new LinkedList<>();
        String sql;

        sql = "select  e.PREFIJO||' '||e.NUMERO_DE_IDENTIFICACION contenedor, TO_CHAR(e.FECHA_HORA_RECEPCION,'DD-MM-YY HH24:MI') FECHA_HORA_RECEPCION, NVL(TO_CHAR(e.FECHA_HORA_ENTRADA,'DD-MM-YY HH24:MI'), ' ') FECHA_HORA_ENTRADA, \n"
                + "NVL(TO_CHAR(D.FECHA_PRIMERA_TRANSACCION,'DD-MM-YY HH24:MI'), ' ') FECHA_BASCULA,\n"
                + "NVL((select TO_CHAR(TU.FECHA_GRABADOR, 'DD-MM-YY HH24:MI') \n"
                + "from PUERTO.TARJETA_COF tc, PUERTO.tarjeta_cof_ubicacion tu \n"
                + "WHERE TC.TCF_CORRELATIVO_TARJETA = TU.TCF_CORRELATIVO_TARJETA\n"
                + "AND TC.TCF_ESTADO_TARJETA = 'A'\n"
                + "AND TC.TCF_MODO_CREACION_TARJETA = 'R'\n"
                + "AND TC.TCF_PREFIJO = E.PREFIJO\n"
                + "AND TC.TCF_IDENTIFICACION = E.NUMERO_DE_IDENTIFICACION), ' ') FECHA_UBICACION\n"
                + "from PUERTO.BASC_RECEPCION d, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES e\n"
                + "where d.recepcion = e.AUTORIZACION_RECEPCION\n"
                + "and e.FECHA_HORA_RECEPCION between (sysdate-3) and sysdate\n"
                + "and not exists (\n"
                + "    select *\n"
                + "    from PUERTO.RX_RESULTADO_ESCANEO_CONTE f\n"
                + "    where f.FECHA_INSERT between (sysdate-3) and sysdate\n"
                + "    and F.PREFIJO = E.PREFIJO\n"
                + "    and F.IDENTIFICACION = E.NUMERO_DE_IDENTIFICACION\n"
                + "    )order by FECHA_HORA_RECEPCION desc";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanRX user = new BeanRX();
                        user.setPREFIJO(rs.getString("contenedor"));
                        user.setIMPORTEXPORT(rs.getString("FECHA_HORA_ENTRADA"));
                        user.setFECHA_BASCULA(rs.getString("FECHA_BASCULA"));
                        user.setIDENTIFICACION(rs.getString("FECHA_UBICACION"));

                        tipo.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.Rayos_X()" + e);

        }

        return tipo;
    }

}

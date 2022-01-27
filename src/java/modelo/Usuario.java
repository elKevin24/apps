package modelo;

import controlador.BeanUsuarios;
import controlador.BeanTipoBuque;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;

public class Usuario {

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

    public static BeanUsuarios Usuario_Menu(String id) {
        BeanUsuarios user = new BeanUsuarios();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    usuario,\n"
                        + "    clave,\n"
                        + "    correo,\n"
                        + "    user_id,\n"
                        + "    tipo,\n"
                        + "    categoria,\n"
                        + "    estatus\n"
                        + "FROM\n"
                        + "    usuarios_web.usuarios_portal\n"
                        + "    where user_id = '" + id + "'")) {
                    while (rs.next()) {

                        user.setUSERID(rs.getString("user_id"));
                        user.setUSUARIO_INOW(rs.getString("usuario"));
                        user.setCATEGORIA(rs.getString("categoria"));
                        user.setTIPO(rs.getString("tipo"));
                        user.setCORREO(rs.getString("correo"));

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

    public static boolean agregar(BeanTipoBuque Tipo) {
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

    public static boolean agregar_Usuario(controlador.Usuario User) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO USUARIOS_WEB.USUARIOS_PORTAL_SOLICITUD (UPS_ID_USUARIO_SERVICIO, UPS_ID_USUARIO_CREA, UPS_NOMBRES, UPS_APELLIDOS, UPS_PUESTO_EMPRESA, UPS_CORREO, UPS_DPI, UPS_FECHA_NAC, UPS_TIPO, UPS_CATEGORIA)"
                        + " VALUES (" + User.getUPIS_ID_USUARIO_SERVICIO() + ",'" + User.getUPIS_ID_USUARIO_CREA() + "','" + User.getUPIS_NOMBRES() + "','" + User.getUPIS_APELLIDOS() + "','" + User.getUPIS_PUESTO_EMPRESA() + "','" + User.getUPIS_CORREO() + "'"
                        + ",'" + User.getUPIS_DPI() + "',TO_DATE('" + User.getUPIS_FECHA_NAC() + "', 'YYYY-MM-DD')," + User.getUPIS_TIPO_USUARIO() + "," + User.getUPIS_CATEGORIA() + ")";

                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            System.err.println("agregar_Usuario" + e);
            agregado = false;
        }
        return agregado;
    }

    public static LinkedList<controlador.Usuario> Solicitudes_Usuario() throws SQLException {
        LinkedList<controlador.Usuario> soli = new LinkedList<>();
        String sql;

        sql = "SELECT A.UPS_SOLICITUD,  b.nombre,  c.usuario , a.ups_nombres, a.ups_apellidos, a.ups_puesto_empresa, a.ups_correo,\n"
                + "a.ups_dpi, a.ups_fecha_nac, a.ups_fecha_creacion, a.ups_estado, d.upst_nombre , e.upsc_nombre\n"
                + "FROM USUARIOS_WEB.USUARIOS_PORTAL_SOLICITUD A,  FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS B, USUARIOS_WEB.USUARIOS_PORTAL C, USUARIOS_WEB.ups_tipo D, USUARIOS_WEB.ups_categoria E\n"
                + "WHERE a.ups_id_usuario_servicio = b.codigo  \n"
                + "AND a.ups_id_usuario_crea = c.user_id \n"
                + "AND a.ups_tipo = d.upst_id\n"
                + "AND a.ups_categoria = e.upsc_id";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        controlador.Usuario user = new controlador.Usuario();
                        user.setUPIS_SOLICITUD(rs.getString("ups_solicitud"));
                        user.setUPIS_ID_USUARIO_SERVICIO(rs.getString("NOMBRE"));
                        user.setUPIS_ID_USUARIO_CREA(rs.getString("USUARIO"));
                        user.setUPIS_NOMBRES(rs.getString("ups_nombres"));
                        user.setUPIS_APELLIDOS(rs.getString("ups_apellidos"));
                        user.setUPIS_PUESTO_EMPRESA(rs.getString("ups_puesto_empresa"));
                        user.setUPIS_CORREO(rs.getString("ups_correo"));
                        user.setUPIS_DPI(rs.getString("ups_dpi"));
                        user.setUPIS_FECHA_NAC(rs.getString("ups_fecha_nac"));
                        user.setUPIS_FECHA_CREACION(rs.getString("ups_fecha_creacion"));
                        user.setUPIS_ESTADO(rs.getString("ups_estado"));
                        user.setUPIS_TIPO_USUARIO(rs.getString("upst_nombre"));
                        user.setUPIS_CATEGORIA(rs.getString("upsc_nombre"));

                        soli.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("Solicitudes_Usuario" + e);
        }

        return soli;
    }

    public static LinkedList<controlador.Usuario> Solicitudes_Usuario(String filtro) throws SQLException {
        LinkedList<controlador.Usuario> soli = new LinkedList<>();
        String sql;

        sql = "SELECT A.UPS_SOLICITUD,  b.nombre ups_id_usuario_servicio,  c.usuario ups_id_usuario_crea, a.ups_nombres, a.ups_apellidos, a.ups_puesto_empresa, a.ups_correo,\n"
                + "a.ups_dpi, a.ups_fecha_nac, a.ups_fecha_creacion, a.ups_estado, d.upst_nombre ups_tipo, e.upsc_nombre ups_categoria\n"
                + "FROM USUARIOS_WEB.USUARIOS_PORTAL_SOLICITUD A,   FINANCIERO.ASFT_USUARIOS_DE_SERVICIOS B, USUARIOS_WEB.USUARIOS_PORTAL C, USUARIOS_WEB.ups_tipo D, USUARIOS_WEB.ups_categoria E\n"
                + "WHERE  a.ups_id_usuario_crea = c.user_id\n"
                + "AND a.ups_tipo = d.upst_id\n"
                + "AND a.ups_categoria = e.upsc_id\n"
                + "AND a.ups_id_usuario_crea = "+filtro+"\n"
                + "\n"
                + "AND a.ups_id_usuario_servicio = b.codigo(+)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        controlador.Usuario user = new controlador.Usuario();
                        user.setUPIS_SOLICITUD(rs.getString("ups_solicitud"));
                        user.setUPIS_ID_USUARIO_SERVICIO(rs.getString("ups_id_usuario_servicio"));
                        user.setUPIS_ID_USUARIO_CREA(rs.getString("ups_id_usuario_crea"));
                        user.setUPIS_NOMBRES(rs.getString("ups_nombres"));
                        user.setUPIS_APELLIDOS(rs.getString("ups_apellidos"));
                        user.setUPIS_PUESTO_EMPRESA(rs.getString("ups_puesto_empresa"));
                        user.setUPIS_CORREO(rs.getString("ups_correo"));
                        user.setUPIS_DPI(rs.getString("ups_dpi"));
                        user.setUPIS_FECHA_NAC(rs.getString("ups_fecha_nac"));
                        user.setUPIS_FECHA_CREACION(rs.getString("ups_fecha_creacion"));
                        user.setUPIS_ESTADO(rs.getString("ups_estado"));
                        user.setUPIS_TIPO_USUARIO(rs.getString("ups_tipo"));
                        user.setUPIS_CATEGORIA(rs.getString("ups_categoria"));

                        soli.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("Solicitudes_Usuario"+e);
        }

        return soli;
    }

    public static controlador.Usuario Solicitud_Usuario(String id) {
        controlador.Usuario user = new controlador.Usuario();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    \"A1\".\"UPS_SOLICITUD\"             \"UPS_SOLICITUD\",\n"
                        + "    \"A1\".\"UPS_ID_USUARIO_SERVICIO\"   \"UPS_ID_USUARIO_SERVICIO\",\n"
                        + "    \"A1\".\"UPS_ID_USUARIO_CREA\"       \"UPS_ID_USUARIO_CREA\",\n"
                        + "    \"A1\".\"UPS_NOMBRES\"               \"UPS_NOMBRES\",\n"
                        + "    \"A1\".\"UPS_APELLIDOS\"             \"UPS_APELLIDOS\",\n"
                        + "    \"A1\".\"UPS_PUESTO_EMPRESA\"        \"UPS_PUESTO_EMPRESA\",\n"
                        + "    \"A1\".\"UPS_CORREO\"                \"UPS_CORREO\",\n"
                        + "    \"A1\".\"UPS_DPI\"                   \"UPS_DPI\",\n"
                        + "    \"A1\".\"UPS_FECHA_NAC\"             \"UPS_FECHA_NAC\",\n"
                        + "    \"A1\".\"UPS_FECHA_CREACION\"        \"UPS_FECHA_CREACION\",\n"
                        + "    \"A1\".\"UPS_ESTADO\"                \"UPS_ESTADO\",\n"
                        + "    \"A1\".\"UPS_FECHA_ACTUALIZACION\"   \"UPS_FECHA_ACTUALIZACION\",\n"
                        + "    \"A1\".\"UPS_TIPO\"                  \"UPS_TIPO\",\n"
                        + "    \"A1\".\"UPS_CATEGORIA\"             \"UPS_CATEGORIA\"\n"
                        + "FROM\n"
                        + "    \"USUARIOS_WEB\".\"USUARIOS_PORTAL_SOLICITUD\" \"A1\"\n"
                        + "WHERE\n"
                        + "    \"A1\".\"UPS_SOLICITUD\" =  '" + id + "'")) {
                    while (rs.next()) {

                        user.setUPIS_SOLICITUD(rs.getString("UPS_SOLICITUD"));
                        user.setUPIS_ID_USUARIO_SERVICIO(rs.getString("UPS_ID_USUARIO_SERVICIO"));
                        user.setUPIS_ID_USUARIO_CREA(rs.getString("UPS_ID_USUARIO_CREA"));
                        user.setUPIS_NOMBRES(rs.getString("UPS_NOMBRES"));
                        user.setUPIS_APELLIDOS(rs.getString("UPS_APELLIDOS"));
                        user.setUPIS_PUESTO_EMPRESA(rs.getString("UPS_PUESTO_EMPRESA"));
                        user.setUPIS_CORREO(rs.getString("UPS_CORREO"));
                        user.setUPIS_DPI(rs.getString("UPS_DPI"));
                        user.setUPIS_FECHA_NAC(rs.getString("UPS_FECHA_NAC"));
                        user.setUPIS_FECHA_CREACION(rs.getString("UPS_FECHA_CREACION"));
                        user.setUPIS_ESTADO(rs.getString("UPS_ESTADO"));
                        user.setUPIS_FECHA_ACTUALIZACION(rs.getString("UPS_FECHA_ACTUALIZACION"));
                        user.setUPIS_TIPO_USUARIO(rs.getString("UPS_TIPO"));
                        user.setUPIS_CATEGORIA(rs.getString("UPS_CATEGORIA"));

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }
        return user;
    }
    
    
    public static String Actualizar_Contrasena_1(String id, String contrasena) {
        String retorno = null;
        System.out.println("id: "+ id +"contrasena: " + contrasena);
//        USUARIOS_WEB.P_ACT_CLAVE_USUARIO(P_USERID in NUMBER, P_CLAVE in VARCHAR2, resultado in out varchar2)

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion(); CallableStatement cs = con.prepareCall("{call USUARIOS_WEB.P_ACT_CLAVE_USUARIO(?, ?, ?)}")) {

                
                cs.setString(1, id);
                cs.setString(2, contrasena);
                cs.registerOutParameter(3, Types.VARCHAR);
                cs.execute();
                //se recupera el resultado de la funcion pl/sql
                retorno = cs.getString(3);
                System.err.println("retorno: "+retorno);

            }
        } catch (SQLException e) {

            System.err.println("Actualizar_Contrasena_1: " + e);
        }
        return retorno;
    }

}

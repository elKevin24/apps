package modelo;

import controlador.Trazabilidad_Contenedores;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class TrazabilidadContenedores {

    public static LinkedList<Trazabilidad_Contenedores> consultarCont(String entrada, String usuario) throws SQLException {
        LinkedList<Trazabilidad_Contenedores> usuarios = new LinkedList<>();
        String sql = "select  tc.tcf_prefijo||tc.tcf_identificacion as cont, \n"
                + "NVL(TO_CHAR(tc.tcf_descarga_fecha, 'DD-MM-YYYY'), '0') fecha_descarga,\n"
                + "NVL(TO_CHAR(puerto.f_busca_escaneo_rx(tc.tcf_prefijo||tc.tcf_identificacion,TRUNC(TC.TCF_DESCARGA_FECHA)-2,'I'), 'DD-MM-YYYY'), '0') escaneo,\n"
                + "puerto.F_BUSCA_PESO_BASCULA(tc.tcf_correlativo_tarjeta, NULL, TC.TCF_DESPACHO ) bascula,\n"
                + "NVL(TO_CHAR(TC.TCF_DESPACHO_FECHA, 'DD-MM-YYYY'), '0') salida_recinto,\n"
                + "DECODE(TC.TCF_DESPACHO_FECHA,NULL,puerto.F_UBICACION_ACTUAL_CONTE(tc.tcf_correlativo_tarjeta),'NO') ubicacion_contenedor\n"
                + "from PUERTO.tarjeta_cof tc, PUERTO.CCOP_DETALLE_CARDESC_CO DD\n"
                + "where (DD.VIAJE_NO = TC.TCF_VIAJE_SISTEMA\n"
                + "       AND DD.TIPO_DE_MOVIMIENTO = 1\n"
                + "       AND DD.PREFIJO = TC.TCF_PREFIJO\n"
                + "       AND DD.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n"
                + "       AND DD.OPERADOR = '"+usuario+"'  )\n"
                + "AND tc.tcf_viaje_sistema = '"+entrada+"'\n"
                + "AND TC.TCF_RECEPCION IS NULL order by tc.tcf_prefijo||tc.tcf_identificacion";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
                        user.setC1(rs.getString("cont"));
                        user.setC2(rs.getString("fecha_descarga"));
                        user.setC3(rs.getString("escaneo"));
                        user.setC4(rs.getString("bascula"));
                        user.setC5(rs.getString("salida_recinto"));
                        user.setC6(rs.getString("ubicacion_contenedor"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);

        }

        return usuarios;
    }

    public static LinkedList<Trazabilidad_Contenedores> consultarContExport(String codigo, String entrada) throws SQLException {
        LinkedList<Trazabilidad_Contenedores> usuarios = new LinkedList<>();

        //System.err.println("hola");
        String sql = "select RR.LR||RR.SENAL_DISTINTIVA||RR.VIAJE_BARCO codigo,\n"
                + "tc.tcf_prefijo||tc.tcf_identificacion as cont, tc.tcf_recepcion_fecha fecha_recepcion,\n"
                + "puerto.f_busca_escaneo_rx(tc.tcf_prefijo||tc.tcf_identificacion,TRUNC(TC.TCF_RECEPCION_FECHA)-.5,'E') escaneo,\n"
                + "puerto.F_BUSCA_PESO_BASCULA(tc.tcf_correlativo_tarjeta, TC.TCF_RECEPCION, NULL ) bascula,\n"
                + "TC.TCF_CARGA_FECHA salida_recinto,\n"
                + "DECODE(TC.TCF_CARGA_FECHA,NULL,puerto.F_UBICACION_ACTUAL_CONTE(tc.tcf_correlativo_tarjeta),'NO') ubicacion_contenedor\n"
                + "from PUERTO.tarjeta_cof tc, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES RR\n"
                + "where ( RR.AUTORIZACION_RECEPCION = TC.TCF_RECEPCION\n"
                + "       AND RR.PREFIJO = TC.TCF_PREFIJO\n"
                + "       AND RR.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n"
                + "       AND RR.OPERADOR = " + entrada + " )\n"
                + "AND TC.TCF_RECEPCION IS NOT NULL\n"
                + "AND TC.TCF_ADENTRO_AFUERA IS NULL\n"
                + "and RR.LR||RR.SENAL_DISTINTIVA||RR.VIAJE_BARCO = '" + codigo + "'\n"
                + "ORDER BY tc.tcf_recepcion_fecha DESC";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                //System.err.println(""+sql);

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
                        user.setC1(rs.getString("cont"));
                        user.setC2(rs.getString("fecha_recepcion"));
                        user.setC3(rs.getString("escaneo"));
                        user.setC4(rs.getString("bascula"));
                        user.setC5(rs.getString("salida_recinto"));
                        user.setC6(rs.getString("ubicacion_contenedor"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }

        return usuarios;
    }

    public static LinkedList<Trazabilidad_Contenedores> consultarContPuerto(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Contenedores> usuarios = new LinkedList<>();
        String sql = "SELECT  tar.tcf_correlativo_tarjeta tarjeta_kardex, tar.tcf_prefijo || tar.tcf_identificacion CONTENEDOR,DECODE (tar.tcf_refrigerado_seco,'S', 'SECO','R', 'REFRIGERADO') TIPO,\n"
                + "DECODE (MAX (TARU.TCU_MODALIDAD),'V', 'VACIO','L', 'LLENO') MODALIDAD,\n"
                + "TARU.TCU_PATIO PATIO, TARU.TCU_FILA FILA, TARU.TCU_MODULO MODULO, TARU.TCU_NIVEL NIVEL, tar.tcf_viaje_sistema viaje_sistema,\n"
                + "(SELECT BARCO FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = tcf_viaje_sistema and tcf_viaje_sistema is not null) BUQUE,\n"
                + "(SELECT VIAJE_NAVIERA FROM PUERTO.EOPV_VIAJES WHERE VIAJE_EMPORNAC = tcf_viaje_sistema and tcf_viaje_sistema is not null) VIAJE_BUQUE,\n"
                + "puerto.busca_escaneo(tar.tcf_prefijo || tar.tcf_identificacion, tcf_viaje_sistema) escaneo,puerto.busca_peso_salida(tcf_viaje_sistema) bascula,\n"
                + "(SELECT USUARIO FROM puerto.EOPT_REGISTRO_CONTENEDORES WHERE PREFIJO||NUMERO_DE_IDENTIFICACION LIKE tar.tcf_prefijo || tar.tcf_identificacion ) OPERADOR\n"
                + "FROM PUERTO.tarjeta_cof tar, PUERTO.TARJETA_COF_UBICACION taru\n"
                + "WHERE TAR.TCF_CORRELATIVO_TARJETA =  TARU.TCF_CORRELATIVO_TARJETA\n"
                + "AND tar.tcf_estado_tarjeta = 'A'\n"
                + "and tar.tcf_adentro_afuera is null\n"
                + "GROUP BY tar.tcf_correlativo_tarjeta, tar.tcf_prefijo || tar.tcf_identificacion,tar.tcf_refrigerado_seco, TARU.TCU_PATIO,TARU.TCU_FILA,TARU.TCU_MODULO,TARU.TCU_NIVEL,tar.tcf_viaje_sistema";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
                        user.setC1(rs.getString("CONT"));
                        user.setC2(rs.getString("fecha_recepcion"));
                        user.setC3(rs.getString("escaneo"));
                        user.setC4(rs.getString("bascula"));
                        user.setC5(rs.getString("salida_recinto"));
                        user.setC6(rs.getString("ubicacion_contenedor"));
//                        user.setC7(rs.getString("nivel"));
//                        user.setC8(rs.getString("tarjeta"));
//                        user.setC9(rs.getString("viaje_sistema"));
//                        user.setC10(rs.getString("buque"));
//                        user.setC11(rs.getString("viaje_buque"));
//                        user.setC12(rs.getString("naviera"));
//                        user.setC13(rs.getString("escaneo"));
//                        user.setC14(rs.getString("bascula"));

                        System.err.println("" + rs.getString("CONTENEDOR"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);

        }

        return usuarios;
    }

    public static Trazabilidad_Contenedores ManifiestoImport(String contenedor) {
        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT RECIBIDO, MANIFIESTO, BUQUE, VIAJE, ETA\n"
                        + "FROM(  \n"
                        + "SELECT TO_CHAR(M.FECHA_DECODIFICACION,'DD/MM/YYYY HH24:MI') RECIBIDO, M.N_UNICO_MANIF MANIFIESTO, M.NOM_BUQUE BUQUE, M.NUM_VIAJE VIAJE, TO_CHAR(M.FECHA_ETA,'DD/MM/YYYY HH24:MI') ETA\n"
                        + "FROM EDI.MANIFIESTO M, EDI.EQUIPO_MANIFESTADO A\n"
                        + "WHERE M.N_UNICO_MANIF = A.N_UNICO_MANIF\n"
                        + "AND M.MODALIDAD = DECODE('I','I','179','E','178')\n"
                        + "AND A.NUM_CONTENEDOR = '" + contenedor + "'\n"
                        + "ORDER BY A.FECHA_DECODIFICACION DESC)\n"
                        + "WHERE ROWNUM = 1")) {

                    while (rs.next()) {

                        user.setC1(rs.getString("RECIBIDO"));
                        user.setC2(rs.getString("MANIFIESTO"));
                        user.setC3(rs.getString("BUQUE"));
                        user.setC4(rs.getString("VIAJE"));
                        user.setC5(rs.getString("ETA"));

                    }
                    if (user.getC1() == null) {
                        user.setC1(" ");
                        user.setC2(" ");
                        user.setC3(" ");
                        user.setC4(" ");
                        user.setC5(" ");

                    }

                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("ManifiestoImport: " + e);
        }

        return user;

    }

    public static Trazabilidad_Contenedores ManifiestoExport(String contenedor) {
        Trazabilidad_Contenedores user = new Trazabilidad_Contenedores();
        System.err.println("" + contenedor);
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT RECIBIDO, MANIFIESTO, BUQUE, VIAJE, ETA\n"
                        + "FROM(  \n"
                        + "SELECT TO_CHAR(M.FECHA_DECODIFICACION,'DD/MM/YYYY HH24:MI') RECIBIDO, M.N_UNICO_MANIF MANIFIESTO, M.NOM_BUQUE BUQUE, M.NUM_VIAJE VIAJE, TO_CHAR(M.FECHA_ETA,'DD/MM/YYYY HH24:MI') ETA\n"
                        + "FROM EDI.MANIFIESTO M, EDI.EQUIPO_MANIFESTADO A\n"
                        + "WHERE M.N_UNICO_MANIF = A.N_UNICO_MANIF\n"
                        + "AND M.MODALIDAD = DECODE('E','I','179','E','178')\n"
                        + "AND A.NUM_CONTENEDOR = '" + contenedor + "'\n"
                        + "ORDER BY A.FECHA_DECODIFICACION DESC)\n"
                        + "WHERE ROWNUM = 1")) {
                    while (rs.next()) {

                        user.setC1(rs.getString("RECIBIDO"));
                        user.setC2(rs.getString("MANIFIESTO"));
                        user.setC3(rs.getString("BUQUE"));
                        user.setC4(rs.getString("VIAJE"));
                        user.setC5(rs.getString("ETA"));

                    }
                    if (user.getC1() == null) {
                        user.setC1(" ");
                        user.setC2(" ");
                        user.setC3(" ");
                        user.setC4(" ");
                        user.setC5(" ");

                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("ManifiestoExport: " + e);

        }

        return user;

    }

}

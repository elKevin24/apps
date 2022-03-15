package modelo;

import controlador.BeanLISTADO_BUQUES;
import controlador.BeanMANIFIESTOSXBUQUE;
import controlador.CONTENEDORES_OPERADOS;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Manifiestos {

    public static LinkedList<CONTENEDORES_OPERADOS> CONTENEDORES_OPERADOS(String ID) throws SQLException {
        LinkedList<CONTENEDORES_OPERADOS> cont = new LinkedList<>();
        String sql = "select 'MANIFIESTO' C1, 'BUQUE' C2, 'VIAJE' C3, 'NAVIERA' C4, ' ' C5, 1 C6\n"
                + "FROM DUAL\n"
                + "UNION\n"
                + "select '----------', '----------', '----------', '----------' , ' ', 2 ORDEN\n"
                + "FROM DUAL\n"
                + "UNION\n"
                + "select A.N_UNICO_MANIF manifiesto, B.BARCO, B.VIAJE_NAVIERA,  B.USUARIO naviera, ' ', 3\n"
                + "from EDI.MANIFIESTO a, PUERTO.EOPV_VIAJES b\n"
                + "where A.VIAJE_SISTEMA = B.VIAJE_EMPORNAC\n"
                + "and a.N_UNICO_MANIF = '" + ID + "'\n"
                + "UNION\n"
                + "select ' ', ' ', ' ', ' ',' ', 4 ORDEN\n"
                + "FROM DUAL\n"
                + "UNION\n"
                + "SELECT 'CLASE EQUPO','NUMERO EQUIPO', 'CONDICION',  'OPERACION', 'MEDIDA', 5\n"
                + "FROM DUAL\n"
                + "UNION\n"
                + "select  '----------', '----------', '----------' , '----------' , '----------' ,6 ORDEN\n"
                + "FROM DUAL\n"
                + "UNION\n"
                + "SELECT CQ.DESCRIPCION TIPO,\n"
                + "EM.NUM_CONTENEDOR    ,\n"
                + "DECODE(EM.CONDICION_EQUIPO, '4' , 'Vacio', '5', 'Lleno') CONDICION_EQUIPO,\n"
                + "decode(EM.CONFIRMADO, 'C', 'CONFIRMADOS', 'S', 'SOBRANTES', NULL, 'FALTANTES') CONFIRMADO,\n"
                + "TO_CHAR(TE.MEDIDA)MEDIDA,\n"
                + "decode(EM.CONFIRMADO, 'C', 10, 'S', 11, NULL, 12) ord_CONFIRMADO\n"
                + "FROM edi.EQUIPO_MANIFESTADO EM, EDI.CO_CLASE_EQUIPO CQ, EDI.CO_TIPO_EQUIPO TE\n"
                + "WHERE CQ.codigo(+) = EM.CLASE_EQUIPO\n"
                + "AND TE.CODIGO(+) = EM.TIPO_EQUIPO\n"
                + "and EM.N_UNICO_MANIF = '" + ID + "'\n"
                + "UNION\n"
                + "SELECT CQ.DESCRIPCION TIPO,\n"
                + "B.NUM_CONTENEDOR,\n"
                + "DECODE(B.CONDICION_EQUIPO, '4' , 'Vacio', '5', 'Lleno') CONDICION_EQUIPO,\n"
                + "decode(B.CONFIRMADO, 'C', 'CONFIRMADOS', 'S', 'SOBRANTES', NULL, 'FALTANTES') CONFIRMADO,\n"
                + "TO_CHAR(TE.MEDIDA)MEDIDA,\n"
                + "to_number(decode(B.CONFIRMADO, 'C', 10, 'S', 11, NULL, 12)) ord_CONFIRMADO\n"
                + "FROM edi.EQUIPO_MANIFESTADO_SOBRANTE  B , EDI.CO_CLASE_EQUIPO CQ, EDI.CO_TIPO_EQUIPO TE\n"
                + "WHERE CQ.codigo(+) = B.CLASE_EQUIPO\n"
                + "AND TE.CODIGO(+) = B.TIPO_EQUIPO\n"
                + "and B.N_UNICO_MANIF = '" + ID + "'\n"
                + "order by 6, 3";

        try {
            Conexion c = new Conexion();
            try ( Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try ( ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        CONTENEDORES_OPERADOS conte = new CONTENEDORES_OPERADOS();
                        conte.setMANIFIESTO(rs.getString("C1"));
                        conte.setBUQUE(rs.getString("C2"));
                        conte.setVIAJE(rs.getString("C3"));
                        conte.setNAVIERA(rs.getString("C4"));
                        conte.setMEDIDA(rs.getString("C5"));

                        cont.add(conte);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.CONTENEDORES_OPERADOS()" + e);

        }

        return cont;
    }

    public static LinkedList<BeanLISTADO_BUQUES> RX_RESULTADO_ESCANEO_CONTE(String Inicio, String Final) throws SQLException {
        LinkedList<BeanLISTADO_BUQUES> tipo = new LinkedList<>();
        String sql = "SELECT    DISTINCT\n"
                + "          V.NUMERO_DE_VIAJE VIAJE_SISTEMA,\n"
                + "          B.NOMBRE_DEL_BUQUE BARCO,\n"
                + "          V.VIAJE_BARCO VIAJE_BARCO,\n"
                + "          S.DESCRIPCION SITUACION,\n"
                + "          V.FECHA_ESTATUS FECHA_ETA,\n"
                + "          U.NOMBRE_USUARIO_DE_SERVICIO NAVIERA\n"
                + "   FROM   PUERTO.EOPT_VIAJES V,\n"
                + "          PUERTO.EOPT_BARCOS B,\n"
                + "          PUERTO.EOPT_USUARIO_SERVICIO U,\n"
                + "          PUERTO.EOPT_SITUACIONES S,\n"
                + "          EDI.MANIFIESTO M\n"
                + "    WHERE (V.LR = B.LR\n"
                + "      AND V.SENAL_DISTINTIVA = B.SENAL_DISTINTIVA)\n"
                + "      AND (U.USUARIO_DE_SERVICIO = V.USUARIO_DE_SERVICIO)\n"
                + "      AND (V.ESTATUS = S.CODIGO)\n"
                + "      AND (M.VIAJE_SISTEMA = V.NUMERO_DE_VIAJE)\n"
                + "      AND V.FECHA_ESTATUS between NVL(to_date('" + Inicio + "','DD-MM-YYYY'),SYSDATE-10) AND NVL(to_date('" + Final + "','DD-MM-YYYY'),SYSDATE)+1\n"
                + "ORDER BY  V.FECHA_ESTATUS DESC";

        try {
            Conexion c = new Conexion();
            try ( Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try ( ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanLISTADO_BUQUES user = new BeanLISTADO_BUQUES();
                        user.setVIAJE_SISTEMA(rs.getString("VIAJE_SISTEMA"));
                        user.setBARCO(rs.getString("BARCO"));
                        user.setVIAJE_BARCO(rs.getString("VIAJE_BARCO"));
                        user.setSITUACION(rs.getString("SITUACION"));
                        user.setFECHA_ETA(rs.getString("FECHA_ETA"));
                        user.setNAVIERA(rs.getString("NAVIERA"));

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

    public static LinkedList<BeanMANIFIESTOSXBUQUE> MANIFIESTOSXBUQUE(String param) throws SQLException {
        LinkedList<BeanMANIFIESTOSXBUQUE> manifiesto = new LinkedList<>();
        String sql = "SELECT DECODE(A.MODALIDAD,'179','IMPORTACION','178','EXPORTACION') MODALIDAD,\n"
                + "UPPER(A.N_UNICO_MANIF) MANIFIESTO,\n"
                + "UPPER(GLN.DESCRIPCION) NAVIERA,\n"
                + "to_char(A.FECHA_CONFIRMACION,'dd-Mon-yyyy hh24:mi')  OPERADO\n"
                + "FROM EDI.MANIFIESTO A, EDI.CO_GLN GLN\n"
                + "WHERE A.NAVIERA_BUQUE = GLN.CODIGO\n"
                + "AND A.VIAJE_SISTEMA = " + param + "\n"
                + "ORDER BY 1";

        try {
            Conexion c = new Conexion();
            try ( Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try ( ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanMANIFIESTOSXBUQUE user = new BeanMANIFIESTOSXBUQUE();
                        user.setMODALIDAD(rs.getString("MODALIDAD"));
                        user.setMANIFIESTO(rs.getString("MANIFIESTO"));
                        user.setNAVIERA(rs.getString("NAVIERA"));
                        user.setOPERADO(rs.getString("OPERADO"));

                        manifiesto.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.out.println("modelo.SAT.RX_RESULTADO_ESCANEO_CONTE()" + e);

        }

        return manifiesto;
    }

}

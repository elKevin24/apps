package modelo;

import controlador.BeanConsulta;
import controlador.Trazabilidad_Barcos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class TrazabilidadBarcos {

    public static LinkedList<Trazabilidad_Barcos> consultarBarco(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Barcos> usuarios = new LinkedList<>();
        String sql = "select viaje_empornac, barco, viaje_naviera,  fecha_situacion\n"
                + "from puerto.eopv_viajes A\n"
                + "where viaje_empornac in\n"
                + "(select distinct tc.tcf_viaje_sistema\n"
                + "from PUERTO.tarjeta_cof tc, PUERTO.CCOP_DETALLE_CARDESC_CO DD\n"
                + "where (DD.VIAJE_NO = TC.TCF_VIAJE_SISTEMA\n"
                + "       AND DD.TIPO_DE_MOVIMIENTO = 1\n"
                + "       AND DD.PREFIJO = TC.TCF_PREFIJO\n"
                + "       AND DD.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n"
                + "       AND DD.OPERADOR = " + entrada + " ) \n"
                + "AND TC.TCF_ESTADO_TARJETA = 'A'\n"
                + "and TC.TCF_ADENTRO_AFUERA IS  NULL\n"
                + "AND TC.TCF_DESPACHO IS NULL\n"
                + "and nvl(tc.tcf_viaje_sistema,0) > 0)";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Barcos user = new Trazabilidad_Barcos();
                        user.setVIAJE_EMPORNAC(rs.getString("viaje_empornac"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("barco"));
                        user.setVIAJE_NAVIERA(rs.getString("viaje_naviera"));
                        user.setFECHA(rs.getString("fecha_situacion"));

                        usuarios.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);

        }

        return usuarios;
    }

    public static LinkedList<Trazabilidad_Barcos> consultarBarco_Export(String entrada) throws SQLException {
        LinkedList<Trazabilidad_Barcos> usuarios = new LinkedList<>();
        String sql = "select RR.LR||RR.SENAL_DISTINTIVA||RR.VIAJE_BARCO codigo, RR.LR, RR.SENAL_DISTINTIVA, PUERTO.F_BUQUE(RR.LR,RR.SENAL_DISTINTIVA) BARCO, RR.VIAJE_BARCO, MAX(RR.FECHA_VIAJE_BARCO) FECHA_VIAJE_BARCO\n" +
"from PUERTO.tarjeta_cof tc, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES RR\n" +
"where ( RR.AUTORIZACION_RECEPCION = TC.TCF_RECEPCION\n" +
"AND RR.PREFIJO = TC.TCF_PREFIJO\n" +
"AND RR.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n" +
"AND nvl(RR.OPERADOR, RR.USUARIO_DE_SERVICIO) = "+entrada+")\n" +
"AND TC.TCF_RECEPCION IS NOT NULL\n" +
"AND TC.TCF_ADENTRO_AFUERA IS NULL\n" +
"AND RR.FECHA_VIAJE_BARCO IS NOT NULL\n" +
"GROUP BY RR.LR, RR.SENAL_DISTINTIVA, PUERTO.F_BUQUE(RR.LR,RR.SENAL_DISTINTIVA), RR.VIAJE_BARCO\n" +
"ORDER BY FECHA_VIAJE_BARCO DESC";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Barcos user = new Trazabilidad_Barcos();
                        user.setUSUARIO(rs.getString("CODIGO"));
                        user.setVIAJE_EMPORNAC(rs.getString("lr"));
                        user.setSITUACION(rs.getString("senal_distintiva"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("barco"));
                        user.setVIAJE_NAVIERA(rs.getString("viaje_barco"));
                        user.setFECHA(rs.getString("fecha_viaje_barco"));

                        usuarios.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("Export " + e);

        }

        return usuarios;
    }

    public static LinkedList<Trazabilidad_Barcos> consultarBarco_Export_One(String id, String viaje_barco, String fecha_viaje_barco, String Operador) throws SQLException {
        LinkedList<Trazabilidad_Barcos> usuarios = new LinkedList<>();
        String sql = "select DISTINCT  RR.LR, RR.SENAL_DISTINTIVA, PUERTO.F_BUQUE(RR.LR,RR.SENAL_DISTINTIVA) BARCO, RR.VIAJE_BARCO, TO_CHAR( RR.FECHA_VIAJE_BARCO, 'DD/MM/YYYY' ) FECHA_VIAJE_BARCO\n"
                + "from PUERTO.tarjeta_cof tc, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES RR\n"
                + "where ( RR.AUTORIZACION_RECEPCION = TC.TCF_RECEPCION\n"
                + "       AND RR.PREFIJO = TC.TCF_PREFIJO\n"
                + "       AND RR.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n"
                + "       AND RR.OPERADOR = "+Operador+" )\n"
                + "AND TC.TCF_RECEPCION IS NOT NULL\n"
                + "AND TC.TCF_ADENTRO_AFUERA IS NULL\n"
                + "AND RR.LR || rr.senal_distintiva = '"+id+"'\n"
                + "AND RR.viaje_barco = '"+viaje_barco+"'\n"
                + "and  rr.fecha_viaje_barco = '"+fecha_viaje_barco+"'\n"
                + "ORDER BY FECHA_VIAJE_BARCO DESC";
        
        //System.err.println(""+sql);

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Trazabilidad_Barcos user = new Trazabilidad_Barcos();
                        user.setVIAJE_EMPORNAC(rs.getString("lr"));
                        user.setSITUACION(rs.getString("senal_distintiva"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("barco"));
                        user.setVIAJE_NAVIERA(rs.getString("viaje_barco"));
                        user.setFECHA(rs.getString("fecha_viaje_barco"));

                        usuarios.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("Export" + e);

        }

        return usuarios;
    }
    
    public static Trazabilidad_Barcos ConsultaBarcoExport(String id, String viaje_barco, String fecha_viaje_barco, String Operador) {
        Trazabilidad_Barcos user = new Trazabilidad_Barcos();

        
        String sql = "select DISTINCT  RR.LR, RR.SENAL_DISTINTIVA, PUERTO.F_BUQUE(RR.LR,RR.SENAL_DISTINTIVA) BARCO, RR.VIAJE_BARCO, TO_CHAR( RR.FECHA_VIAJE_BARCO, 'DD/MM/YYYY' ) FECHA_VIAJE_BARCO\n"
                + "from PUERTO.tarjeta_cof tc, PUERTO.EOPT_RECEPCION_DE_CONTENEDORES RR\n"
                + "where ( RR.AUTORIZACION_RECEPCION = TC.TCF_RECEPCION\n"
                + "       AND RR.PREFIJO = TC.TCF_PREFIJO\n"
                + "       AND RR.NUMERO_DE_IDENTIFICACION = TC.TCF_IDENTIFICACION\n"
                + "       AND RR.OPERADOR = "+Operador+" )\n"
                + "AND TC.TCF_RECEPCION IS NOT NULL\n"
                + "AND TC.TCF_ADENTRO_AFUERA IS NULL\n"
                + "AND RR.LR || rr.senal_distintiva = '"+id+"'\n"
                + "AND RR.viaje_barco = '"+viaje_barco+"'\n"
                + "and  rr.fecha_viaje_barco = '"+fecha_viaje_barco+"'\n"
                + "ORDER BY FECHA_VIAJE_BARCO DESC";
        
        System.err.println(""+sql);
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        
                        

                        user.setVIAJE_EMPORNAC(rs.getString("lr"));
                        user.setSITUACION(rs.getString("senal_distintiva"));
                        user.setNOMBRE_DEL_BUQUE(rs.getString("barco"));
                        user.setVIAJE_NAVIERA(rs.getString("viaje_barco"));
                        user.setFECHA(rs.getString("fecha_viaje_barco"));
                        System.err.println(""+rs.getString("lr"));

                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {
            
            System.err.println(""+e);
        }
        return user;

    }

//    public static LinkedList<BeanBarcos> consultarBarco() throws SQLException {
//        LinkedList<BeanBarcos> usuarios = new LinkedList<>();
//
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//
//                try (ResultSet rs = st.executeQuery("select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos where tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)")) {
//                    while (rs.next()) {
//                        BeanBarcos user = new BeanBarcos();
//                        user.setLR(rs.getString("LR"));
//                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
//                        user.setBANDERA(rs.getString("senal_distintiva"));
//                        user.setTRB(rs.getString("TRB"));
//                        user.setESLORA(rs.getString("ESLORA"));
//
//                        usuarios.add(user);
//                    }
//                }
//                st.close();
//             con.close();
//            }
//        } catch (SQLException e) {
//        }
//
//        return usuarios;
//    }
//
//    public static BeanBarcos ObtenerBarcos(String id) {
//        BeanBarcos user = new BeanBarcos();
//
//        try {
//            Conexion c = new Conexion();
//            try (Connection con = c.getConexion()) {
//                Statement st;
//                st = con.createStatement();
//                try (ResultSet rs = st.executeQuery("SELECT DISTINCT LR, NOMBRE_DEL_BUQUE, SENAL_DISTINTIVA, TRB, ESLORA\n"
//                        + "FROM(\n"
//                        + "SELECT A.LR, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, A.SENAL_DISTINTIVA, A.TRB, A.ESLORA\n"
//                        + "FROM PUERTO.EOPT_BARCOS A\n"
//                        + "WHERE LR = " + id + "\n"
//                        + "UNION\n"
//                        + "SELECT B.LR, B.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, B.SENAL_DISTINTIVA, B.TRB, B.ESLORA\n"
//                        + "FROM CW_EOPT_BARCOS B\n"
//                        + "WHERE LR = " + id + ")")) {
//                    while (rs.next()) {
//
//                        user.setLR(rs.getString("LR"));
//                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
//                        user.setBANDERA(rs.getString("senal_distintiva"));
//                        user.setTRB(rs.getString("TRB"));
//                        user.setESLORA(rs.getString("ESLORA"));
//
//                    }
//                }
//                st.close();
//             con.close();
//            }
//        } catch (SQLException e) {
//        }
//        return user;
//
//    }
}

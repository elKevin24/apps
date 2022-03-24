package modelo;

import controlador.BeanDemoras;
import controlador.BeanEOPV_VIAJES;
import controlador.BeanEstadistica_Detalle;
import controlador.BeanEstadistico;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.LinkedList;

public class Estadistica {

    public static LinkedList<BeanEOPV_VIAJES> Consulta(String usuario) throws SQLException {
        LinkedList<BeanEOPV_VIAJES> servicios = new LinkedList<>();
        //System.out.println("Consulta: "+fecha);
        String sql;

        sql = "SELECT\n"
                + "B.MOV_MOVIMIENTO SITUACION,\n"
                + "A.FECHA_HORA FECHA_HORA,\n"
                + "A.VIAJE_EMPORNAC VIAJE_EMPORNAC,\n"
                + "A.BARCO BARCO,\n"
                + "A.VIAJE_NAVIERA VIAJE_NAVIERA,\n"
                + "A.COD_NAV COD_NAV,\n"
                + "A.USUARIO USUARIO,\n"
                + "A.TIPO_BUQUE TIPO_BUQUE,\n"
                + "A.ESLORA ESLORA,\n"
                + "A.MANGA MANGA,\n"
                + "A.TRB TRB,\n"
                + "A.OBSERVACION OBSERVACION,\n"
                + "A.FECHA_SITUACION FECHA_SITUACION,\n"
                + "A.BANDERA BANDERA,\n"
                + "A.IMO IMO,\n"
                + "A.ORIGEN ORIGEN,\n"
                + "A.DESTINO DESTINO,\n"
                + "A.C_CODIGO C_CODIGO,\n"
                + "A.LR LR,\n"
                + "A.TIPO_DE_BARCO_POR_ESTRUCTURA TIPO_DE_BARCO_POR_ESTRUCTURA,\n"
                + "A.C_FECHA_REPORTE C_FECHA_REPORTE,\n"
                + "A.CALADO CALADO,\n"
                + "(\n"
                + "select COUNT(*) FROM\n"
                + "PUERTO.ccop_detalle_cardesc_co a\n"
                + "where viaje_no = A.VIAJE_EMPORNAC) as   ccop_detalle_cardesc_co,\n"
                + "(\n"
                + "select COUNT(DISTINCT(A.PREFIJO||A.NUMERO_DE_IDENTIFICACION))\n"
                + "FROM PUERTO.ccop_detalle_movimiento a\n"
                + "where viaje_no = A.VIAJE_EMPORNAC) as ccop_detalle_movimiento,\n"
                + "(\n"
                + "select COUNT(*) FROM\n"
                + "PUERTO.ccop_detalle_cardesc_co a\n"
                + "where viaje_no = A.VIAJE_EMPORNAC)-\n"
                + "(\n"
                + "select COUNT(DISTINCT(A.PREFIJO||A.NUMERO_DE_IDENTIFICACION))\n"
                + "FROM PUERTO.ccop_detalle_movimiento a\n"
                + "where viaje_no = A.VIAJE_EMPORNAC) AS RESULT ,\n"
                + "(\n"
                + "select \n"
                + "z.fecha_hora_final\n"
                + "\n"
                + "from\n"
                + "PUERTO.EOPT_DETALLE_DE_VIAJES z, PUERTO.eopt_cat_movimientos_buque x\n"
                + "where numero_de_viajes  =  A.VIAJE_EMPORNAC\n"
                + " and z.movimiento = x.mov_id\n"
                + " AND z.MOVIMIENTO = 4) as   ATRAQUE,\n"
                + "(\n"
                + "select \n"
                + "z.fecha_hora_final\n"
                + "\n"
                + "from\n"
                + "PUERTO.EOPT_DETALLE_DE_VIAJES z, PUERTO.eopt_cat_movimientos_buque x\n"
                + "where numero_de_viajes  =  A.VIAJE_EMPORNAC\n"
                + " and z.movimiento = x.mov_id\n"
                + " AND z.MOVIMIENTO = 9) as   ZARPE\n"
                + "FROM PUERTO.EOPV_VIAJES A, PUERTO.eopt_cat_movimientos_buque B\n"
                + "WHERE A.situacion = B.mov_id\n"
                + "AND A.COD_NAV = " + usuario + "\n"
                + "and a.fecha_hora > sysdate -7\n"
                + "group by B.MOV_MOVIMIENTO, A.FECHA_HORA, A.VIAJE_EMPORNAC, A.BARCO, A.VIAJE_NAVIERA,\n"
                + "A.COD_NAV, A.USUARIO, A.TIPO_BUQUE, A.ESLORA, A.MANGA,\n"
                + "A.TRB, A.OBSERVACION, A.FECHA_SITUACION, A.BANDERA, A.IMO,\n"
                + "A.ORIGEN, A.DESTINO, A.C_CODIGO, A.LR, A.TIPO_DE_BARCO_POR_ESTRUCTURA,\n"
                + "A.C_FECHA_REPORTE, A.CALADO\n"
                + "ORDER BY a.fecha_hora DESC";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanEOPV_VIAJES user = new BeanEOPV_VIAJES();
                        user.setSITUACION(rs.getString("SITUACION"));
                        user.setVIAJE_EMPORNAC(rs.getString("VIAJE_EMPORNAC"));
                        user.setBARCO(rs.getString("BARCO"));
                        user.setESLORA(rs.getString("ESLORA"));
                        user.setVIAJE_NAVIERA(rs.getString("VIAJE_NAVIERA"));
                        user.setUSUARIO(rs.getString("USUARIO"));
                        user.setTIPO_BUQUE(rs.getString("TIPO_BUQUE"));
                        user.setLR(rs.getString("LR"));
                        user.setFECHA_HORA(rs.getString("FECHA_HORA"));
                        user.setMINUENDO(rs.getString("ccop_detalle_cardesc_co"));
                        user.setSUSTRAENDO(rs.getString("ccop_detalle_movimiento"));
                        user.setDIFERENCIA(rs.getString("RESULT"));
                        user.setATRAQUE(rs.getString("ATRAQUE"));
                        user.setZARPE(rs.getString("ZARPE"));

                        //System.err.println("Consulta"+rs.getString("VIAJE_EMPORNAC"));
                        servicios.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("error" + e);
        }

        return servicios;
    }

    public static LinkedList<BeanEstadistico> ConsultarID(String codigo) throws SQLException {
        LinkedList<BeanEstadistico> servicios = new LinkedList<>();
        //System.out.println("Consulta: "+fecha);
        String sql;

        sql = "SELECT MEDIDA, SUM(LISTADOS) LISTADOS, SUM(OPERADOS) OPERADOS, round((SUM(OPERADOS)*100/SUM(LISTADOS)), 0) AS PORCENTAJE_OPERADOS, SUM(LISTADOS) - SUM(OPERADOS) PENDIENTES,  round(((SUM(OPERADOS)*100/SUM(LISTADOS)-100)*-1),0) AS PORCENTAJE_PENDIENTES\n"
                + "FROM\n"
                + "(select MEDIDA, COUNT(MEDIDA) LISTADOS,0 OPERADOS\n"
                + "from PUERTO.ccop_detalle_cardesc_co\n"
                + "where viaje_no = '" + codigo + "'\n"
                + "AND tipo_de_movimiento = 1\n"
                + "GROUP BY MEDIDA, 0\n"
                + "UNION\n"
                + "select d.MEDIDA, 0 LISTADOS, COUNT(MEDIDA) OPERADOS\n"
                + "from PUERTO.ccop_detalle_cardesc_co d, PUERTO.ccop_detalle_movimiento m\n"
                + "where (D.VIAJE_NO = M.VIAJE_NO\n"
                + "and D.TIPO_DE_MOVIMIENTO = M.TIPO_MOVIMIENTO\n"
                + "and D.PREFIJO = M.PREFIJO\n"
                + "and D.NUMERO_DE_IDENTIFICACION = M.NUMERO_DE_IDENTIFICACION \n"
                + ")\n"
                + "and d.viaje_no = '" + codigo + "'\n"
                + "AND d.tipo_de_movimiento = 1\n"
                + "GROUP BY MEDIDA, d.MEDIDA, 0)\n"
                + "GROUP BY MEDIDA";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanEstadistico user = new BeanEstadistico();
                        user.setMEDIDA(rs.getString("MEDIDA"));
                        user.setLISTADOS(rs.getString("LISTADOS"));
                        user.setOPERADOS(rs.getString("OPERADOS"));
                        user.setPORCENTAJE_OPERADOS(rs.getString("PORCENTAJE_OPERADOS"));
                        user.setPENDIENTES(rs.getString("PENDIENTES"));
                        user.setPORCENTAJE_PENDIENTES(rs.getString("PORCENTAJE_PENDIENTES"));

                        //System.err.println("Consulta" + rs.getString("MEDIDA"));
                        servicios.add(user);
                    }
                }

                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("error ConsultarID" + e);
        }

        return servicios;
    }

    public static LinkedList<BeanEstadistico> Consultar_Carga(String codigo) throws SQLException {
        LinkedList<BeanEstadistico> servicios = new LinkedList<>();
        //System.out.println("Consulta: "+fecha);
        String sql;

        sql = "SELECT MEDIDA, SUM(LISTADOS) LISTADOS, SUM(OPERADOS) OPERADOS, round((SUM(OPERADOS)*100/SUM(LISTADOS)), 0) AS PORCENTAJE_OPERADOS, SUM(LISTADOS) - SUM(OPERADOS) PENDIENTES,  round(((SUM(OPERADOS)*100/SUM(LISTADOS)-100)*-1),0) AS PORCENTAJE_PENDIENTES\n"
                + "FROM\n"
                + "(select MEDIDA, COUNT(MEDIDA) LISTADOS,0 OPERADOS\n"
                + "from PUERTO.ccop_detalle_cardesc_co\n"
                + "where viaje_no = '" + codigo + "'\n"
                + "AND tipo_de_movimiento = 2\n"
                + "GROUP BY MEDIDA, 0\n"
                + "UNION\n"
                + "select d.MEDIDA, 0 LISTADOS, COUNT(MEDIDA) OPERADOS\n"
                + "from PUERTO.ccop_detalle_cardesc_co d, PUERTO.ccop_detalle_movimiento m\n"
                + "where (D.VIAJE_NO = M.VIAJE_NO\n"
                + "and D.TIPO_DE_MOVIMIENTO = M.TIPO_MOVIMIENTO\n"
                + "and D.PREFIJO = M.PREFIJO\n"
                + "and D.NUMERO_DE_IDENTIFICACION = M.NUMERO_DE_IDENTIFICACION \n"
                + ")\n"
                + "and d.viaje_no = '" + codigo + "'\n"
                + "AND d.tipo_de_movimiento = 2\n"
                + "GROUP BY MEDIDA, d.MEDIDA, 0)\n"
                + "GROUP BY MEDIDA";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanEstadistico user = new BeanEstadistico();
                        user.setMEDIDA(rs.getString("MEDIDA"));
                        user.setLISTADOS(rs.getString("LISTADOS"));
                        user.setOPERADOS(rs.getString("OPERADOS"));
                        user.setPORCENTAJE_OPERADOS(rs.getString("PORCENTAJE_OPERADOS"));
                        user.setPENDIENTES(rs.getString("PENDIENTES"));
                        user.setPORCENTAJE_PENDIENTES(rs.getString("PORCENTAJE_PENDIENTES"));

                        //System.err.println("Consulta" + rs.getString("MEDIDA"));
                        servicios.add(user);
                    }
                }

                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("error Consultar_Carga" + e);
        }

        return servicios;
    }

    public static LinkedList<BeanEstadistica_Detalle> Consultar_Detalle_Descarga(String codigo, String tipo_mov) throws SQLException {
        LinkedList<BeanEstadistica_Detalle> servicios = new LinkedList<>();
        //System.out.println("Consulta: "+fecha);
        String sql;

        sql = "SELECT\n"
                + "A.PREFIJO || A.NUMERO_DE_IDENTIFICACION contenedor,\n"
                + "DECODE(A.CONDICION, 'E','LLENO','V',  'VACIO')  CONDICION, \n"
                + "A.PESO_MANIFESTADO ,\n"
                + "A.MEDIDA ,\n"
                + "DECODE(A.C_O_F, 'C','CONTENEDOR','F',  'FURGON')  C_O_F, 'OPERADO' ESTADO\n"
                + "from\n"
                + "PUERTO.ccop_detalle_cardesc_co A, PUERTO.ccop_detalle_movimiento B\n"
                + "WHERE A.viaje_no = B.viaje_no\n"
                + "AND A.viaje_no = " + codigo + "\n"
                + "and A.tipo_de_movimiento = " + tipo_mov + "\n"
                + "AND A.PREFIJO || A.NUMERO_DE_IDENTIFICACION = B.PREFIJO || B.NUMERO_DE_IDENTIFICACION\n"
                + "GROUP BY a.viaje_no, A.PREFIJO || A.NUMERO_DE_IDENTIFICACION, A.NUMERO_DE_IDENTIFICACION, DECODE(A.CONDICION, 'E','LLENO','V', 'VACIO'), A.CONDICION, \n"
                + "'E', 'LLENO', 'V', 'VACIO', A.PESO_MANIFESTADO, \n"
                + "A.MEDIDA, DECODE(A.C_O_F, 'C','CONTENEDOR','F', 'FURGON'), A.C_O_F, 'C', 'CONTENEDOR', \n"
                + "'F', 'FURGON', 'OPERADO'\n"
                + "UNION\n"
                + "SELECT\n"
                + "A.PREFIJO || A.NUMERO_DE_IDENTIFICACION  contenedor,\n"
                + "DECODE(A.CONDICION, 'E','LLENO','V',  'VACIO')  CONDICION,\n"
                + "A.PESO_MANIFESTADO ,\n"
                + "A.MEDIDA ,\n"
                + "DECODE(A.C_O_F, 'C','CONTENEDOR','F',  'FURGON')  C_O_F, 'PENDIENTE' ESTADO\n"
                + "from\n"
                + "PUERTO.ccop_detalle_cardesc_co A\n"
                + "WHERE A.viaje_no = " + codigo + "\n"
                + "and A.tipo_de_movimiento = " + tipo_mov + "\n"
                + "minus\n"
                + "SELECT\n"
                + "A.PREFIJO ||\n"
                + "A.NUMERO_DE_IDENTIFICACION  contenedor,\n"
                + "DECODE(A.CONDICION, 'E','LLENO','V',  'VACIO')  CONDICION,\n"
                + "A.PESO_MANIFESTADO ,\n"
                + "A.MEDIDA ,\n"
                + "DECODE(A.C_O_F, 'C','CONTENEDOR','F',  'FURGON')  C_O_F, 'PENDIENTE' ESTADO\n"
                + "from\n"
                + "PUERTO.ccop_detalle_cardesc_co A, PUERTO.ccop_detalle_movimiento B\n"
                + "WHERE A.viaje_no = B.viaje_no\n"
                + "AND A.viaje_no = " + codigo + "\n"
                + "and A.tipo_de_movimiento = " + tipo_mov + "\n"
                + "AND A.PREFIJO = B.PREFIJO\n"
                + "and A.NUMERO_DE_IDENTIFICACION = B.NUMERO_DE_IDENTIFICACION";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanEstadistica_Detalle user = new BeanEstadistica_Detalle();
                        user.setCONTENEDOR(rs.getString("CONTENEDOR"));
                        user.setCONDICION(rs.getString("CONDICION"));
                        user.setPESO(rs.getString("PESO_MANIFESTADO"));
                        user.setC_O_F(rs.getString("C_O_F"));
                        user.setMEDIDA(rs.getString("MEDIDA"));
                        user.setESTADO(rs.getString("ESTADO"));

                        //System.err.println("Consulta" + rs.getString("MEDIDA"));
                        servicios.add(user);
                    }
                }

                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("error Consultar_Detalle_Descarga" + e);
        }

        return servicios;
    }

    public static LinkedList<BeanDemoras> Consultar_Demoras(String viaje) throws SQLException {
        LinkedList<BeanDemoras> servicios = new LinkedList<>();
        System.out.println("Consulta: " + viaje);
        String sql;

        sql = "select A.VIAJE VIAJE,\n"
                + "A.HORAS_F HORAS_F,\n"
                + "A.MINU_F MINU_F,\n"
                + "B.NOMBRE_DEMORA NOMBRE_DEMORA,\n"
                + "c.descripcion TIPO_DEMORA,\n"
                + "d.descripcion TIPO_CARGA\n"
                + "from\n"
                + "PUERTO.CCOP_V_RF_DEMORAS A, PUERTO.eopt_demoras B,  PUERTO.EOPT_TIPOS_DEMORAS C, PUERTO.eopt_tipo_carga D\n"
                + "where a.demora = b.demora\n"
                + "AND a.tipo_demora = b.tipo_demora\n"
                + "AND a.tipo_carga = d.codigo\n"
                + "and a.viaje = "+viaje+"";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanDemoras user = new BeanDemoras();
                        user.setHORAS(rs.getString("HORAS_F"));
                        user.setMINUTOS(rs.getString("MINU_F"));
                        user.setNOMBRE(rs.getString("NOMBRE_DEMORA"));
                        user.setDEMORA(rs.getString("TIPO_DEMORA"));
                        user.setCARGA(rs.getString("TIPO_CARGA"));
                        servicios.add(user);
                    }
                }

                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("error Consultar_Demoras: " + e);
        }

        return servicios;
    }

    public static boolean Ejecutar() {
        boolean resp = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            Statement st;
            st = con.createStatement();

            String sql = "CALL PUERTO.p_buques_ventanas('17/09/2021')";
            st.execute(sql);
            System.err.println("" + sql);
            resp = true;
        } catch (SQLException e) {
            System.err.println("ERROR Ejecutar" + e);

        }
        return resp;

    }

}

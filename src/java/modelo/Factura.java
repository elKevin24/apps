package modelo;

import controlador.BeanComentario;
import controlador.BeanFactura;
import controlador.Conteo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Factura {

    public static BeanFactura ConsultaCreado(int id) {
        BeanFactura user = new BeanFactura();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                CallableStatement cst = con.prepareCall("{call financiero.p_consulta_factura_64D2 (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setInt(1, id);
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                cst.registerOutParameter(2, java.sql.Types.VARCHAR);
                cst.registerOutParameter(3, java.sql.Types.VARCHAR);
                cst.registerOutParameter(4, java.sql.Types.VARCHAR);
                cst.registerOutParameter(5, java.sql.Types.VARCHAR);
                cst.registerOutParameter(6, java.sql.Types.VARCHAR);
                cst.registerOutParameter(7, java.sql.Types.VARCHAR);
                cst.registerOutParameter(8, java.sql.Types.VARCHAR);
                cst.registerOutParameter(9, java.sql.Types.VARCHAR);
                cst.registerOutParameter(10, java.sql.Types.VARCHAR);
                cst.registerOutParameter(11, java.sql.Types.VARCHAR);
                cst.registerOutParameter(12, java.sql.Types.VARCHAR);
                cst.registerOutParameter(13, java.sql.Types.VARCHAR);
                cst.registerOutParameter(14, java.sql.Types.VARCHAR);
                cst.registerOutParameter(15, java.sql.Types.VARCHAR);
                cst.registerOutParameter(16, java.sql.Types.VARCHAR);

                cst.execute();

                if (cst.getString(2) != null) {
                    System.err.println("" + cst.getString(2));

                    user.setFECHA(cst.getString(2));
                    user.setTOTAL(cst.getString(3));
                    user.setSERIE(cst.getString(4));
                    user.setPS_NUMERO(cst.getString(5));
                    user.setAUTORIZACION(cst.getString(6));
                    user.setFECHA_CERTIFICA(cst.getString(7));
                    user.setP_NIT(cst.getString(8));
                    user.setP_NOMBRE(cst.getString(9));
                    user.setP_DIRECCION(cst.getString(10));
                    user.setP_EMAIL(cst.getString(11));
                    user.setP_TIPO_CAMBIO_FECHA(cst.getString(12));
                    user.setP_TIPO_CAMBIO(cst.getString(13));
                    user.setP_TRAMITADOR(cst.getString(14));
                    user.setP_REFERENCIA_PIE(cst.getString(15));

                    user.setP_ID_NOTA(cst.getString(16));
                } else {
                    user.setFECHA(" ");
                    user.setTOTAL(" ");
                    user.setSERIE(" ");
                    user.setPS_NUMERO(" ");
                    user.setAUTORIZACION(" ");
                    user.setFECHA_CERTIFICA(" ");
                    user.setP_NIT(" ");
                    user.setP_NOMBRE(" ");
                    user.setP_DIRECCION(" ");
                    user.setP_EMAIL(" ");
                    user.setP_TIPO_CAMBIO_FECHA(" ");
                    user.setP_TIPO_CAMBIO(" ");
                    user.setP_TRAMITADOR(" ");
                    user.setP_REFERENCIA_PIE(" ");
                    user.setP_ID_NOTA(" ");
                }
                con.close();
            }

        } catch (SQLException e) {
        }
        return user;

    }

    public static BeanFactura Detalle(String id) {
        BeanFactura user = new BeanFactura();
        if (" ".equals(id)) {

            user.setCANTIDAD(" ");
            user.setTARIFA(" ");
            user.setSERVICIO(" ");
            user.setSUB_TOTAL(" ");

        } else {
            try {
                Conexion c = new Conexion();
                try (Connection con = c.getConexion()) {
                    Statement st;
                    st = con.createStatement();
                    try (ResultSet rs = st.executeQuery("Select 1 orden,\n"
                            + "d.cantidad cantidad,\n"
                            + "d.co_tds_codigo tarifa,\n"
                            + "TAR.DESCRIPCION servicio,\n"
                            + "round(d.sub_total,2)SUB_TOTAL\n"
                            + "from financiero.asft_detalle_de_notas_de_cargo d, financiero.asft_tarifas_de_servicios tar\n"
                            + "where d.co_ndc_codigo = " + id + "\n"
                            + "and D.CO_TDS_CODIGO = TAR.CODIGO\n"
                            + "and (d.co_tds_codigo < 140200 or d.co_tds_codigo >140299)\n"
                            + "union all\n"
                            + "-- detalle cobro a terceros\n"
                            + "Select 2 orden,\n"
                            + "d.cantidad cantidad,\n"
                            + "d.co_tds_codigo tarifa,\n"
                            + "TAR.DESCRIPCION servicio,\n"
                            + "round(d.sub_total,2) SUB_TOTAL\n"
                            + "from financiero.asft_detalle_de_notas_de_cargo d, financiero.asft_tarifas_de_servicios tar\n"
                            + "where d.co_ndc_codigo = " + id + "\n"
                            + "and D.CO_TDS_CODIGO = TAR.CODIGO\n"
                            + "and d.co_tds_codigo BETWEEN 140200 AND 140299\n"
                            + "order by orden")) {
                        while (rs.next()) {

                            user.setCANTIDAD(rs.getString("cantidad"));
                            user.setTARIFA(rs.getString("tarifa"));
                            user.setSERVICIO(rs.getString("servicio"));
                            user.setSUB_TOTAL(rs.getString("SUB_TOTAL"));

                        }
                    }
                    st.close();
             con.close();
                }
            } catch (SQLException e) {

            }
        }

        return user;

    }

    public static String agregarConteo(int a, String usuario) {
        String agregado = null;

        String sql = null;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                sql = "insert into PLAN_PRESTACIONES.PLP_CONSULTA_X_FACTURA(PLPC_SERIE,PLPC_FACTURA,GRABADOR)\n"
                        + "values ('64-D2'," + a + ",'" + usuario + "')";

                st.execute(sql);

                agregado = "bien";
                st.close();
             con.close();
            }

        } catch (SQLException e) {
            agregado = "false";
            System.err.println("" + e + sql);
        }
        return agregado;
    }

    public static boolean agregar(Conteo En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "insert into PLAN_PRESTACIONES.PLP_CONSULTA_X_FACTURA(PLPC_SERIE,PLPC_FACTURA,GRABADOR)\n"
                        + "values ('64-D2'," + En.getPLPC_FACTURA() + ",'" + En.getGRABADOR() + "')";

//                INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                        + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
             con.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static boolean agregarProceso(BeanComentario A) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "insert into PLAN_PRESTACIONES.PLP_PROCESO_X_FACTURA(PLPP_SERIE,PLPP_FACTURA,PLPP_PROCESO,GRABADOR)\n"
                        + "values ('64-D2'," + A.getPLPP_FACTURA() + ",'" + A.getPLPP_PROCESO() + "', '" + A.getGRABADOR() + "')";

//                INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                        + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
             con.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static LinkedList<Conteo> ConsultaConteo(int num) throws SQLException {
        LinkedList<Conteo> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("select *\n"
                        + "from PLAN_PRESTACIONES.PLP_CONSULTA_X_FACTURA a\n"
                        + "where PLPC_SERIE = '64-D2'\n"
                        + "and PLPC_FACTURA = " + num + " "
                        + "Order by PLPC_CORRELATIVO")) {
                    while (rs.next()) {
                        Conteo user = new Conteo();
                        user.setPLPC_CORRELATIVO(rs.getString("PLPC_CORRELATIVO"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));

                        datos.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {
        }

        return datos;
    }

    public static LinkedList<BeanComentario> ConsultaProceso(int num) throws SQLException {
        LinkedList<BeanComentario> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("select a.PLPP_CORRELATIVO, a.PLPP_PROCESO,GRABADOR,GRABADOR_FECHA\n"
                        + "from PLAN_PRESTACIONES.PLP_PROCESO_X_FACTURA a\n"
                        + "where PLPP_SERIE = '64-D2'\n"
                        + "and PLPP_FACTURA = " + num + ""
                        + "Order by PLPP_CORRELATIVO")) {
                    while (rs.next()) {
                        BeanComentario user = new BeanComentario();
                        user.setPLPP_CORRELATIVO(rs.getString("PLPP_CORRELATIVO"));
                        user.setPLPP_PROCESO(rs.getString("PLPP_PROCESO"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));

                        datos.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }

        return datos;
    }

}

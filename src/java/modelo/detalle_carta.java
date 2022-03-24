/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanCarta_Detalle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author kcordon
 */
public class detalle_carta {

    public static boolean agregar(BeanCarta_Detalle Carta) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO puerto.recepcion_web_da (da_modalidad, da_recepcion_web, da_numero_orden, da_observaciones) VALUES"
                        + "( '" + Carta.getDA_MODALIDAD() + "', '" + Carta.getDA_RECEPCION_WEB() + "', '" + Carta.getDA_NUMERO_ORDEN() + "', '" + Carta.getDA_OBSERVACIONES() + "')";
//                        + "('1','tmu','12345678','C','20','GUATE','1','13/05/2020','T','S','TOMAS', 'CORTEZ','1234564', 'GT','1231564' ,'987654','CHA','123456','TRANSPORTES', 'C0954ABC', 'GT', '1000', 'GT', 'SV', 'ALMOHADAS', 'OBSERVACIONES', '123456', sysdate)";

//               INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                      + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
             con.close();
            }

        } catch (SQLException e) {
            agregado = false;
            System.err.println("insert da: " + e);
        }
        return agregado;
    }

    public static LinkedList<BeanCarta_Detalle> ConsultarLista(String id) throws SQLException {
        LinkedList<BeanCarta_Detalle> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    b.ecr_modalidad,\n"
                        + "    b.ecr_descripcion,\n"
                        + "    b.ecr_codigo_regimen_modalidad,   \n"
                        + "    a.da_numero_orden,\n"
                        + "    a.da_observaciones\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web_da a, PUERTO.eopt_cat_regimen b\n"
                        + "    where a.da_modalidad = b.ecr_modalidad\n"
                        + "    and a.da_recepcion_web = " + id + "")) {
                    while (rs.next()) {
                        BeanCarta_Detalle user = new BeanCarta_Detalle();
                        user.setDA_ID(rs.getString("ecr_modalidad"));
                        user.setDA_MODALIDAD(rs.getString("ecr_descripcion"));
                        user.setDA_NUMERO_ORDEN(rs.getString("ecr_codigo_regimen_modalidad"));
                        user.setDA_RECEPCION_WEB(rs.getString("da_numero_orden"));
                        user.setDA_OBSERVACIONES(rs.getString("da_observaciones"));

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

    public static BeanCarta_Detalle Consultar() {
        BeanCarta_Detalle user = new BeanCarta_Detalle();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select nvl(max(rw_dr), 0)  rw_dr\n"
                        + "from\n"
                        + "puerto.recepcion_web_detalle")) {
                    while (rs.next()) {

//                        user.setRW_DR(rs.getString("RW_DR"));
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {
        }
        return user;

    }

}

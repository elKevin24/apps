/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanCartaBarcos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author kcordon
 */
public class CartaBarcos {

    public static boolean agregar(BeanCartaBarcos P) {
        boolean agregado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO puerto.eopt_barcos ( LR, SENAL_DISTINTIVA, NOMBRE_DEL_BUQUE, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO) VALUES ('" + P.getLR()+ "', '" + P.getSENAL()+ "','" + P.getNOMBRE()+ "','" + P.getESTRUCTURA()+ "','" + P.getUSUARIO()+ "' )";

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
            System.err.println("INSERT PILOTOS " + e);
        }
        return agregado;
    }
    
     public static LinkedList<BeanCartaBarcos> ConsultarLista() throws SQLException {
        LinkedList<BeanCartaBarcos> datos = new LinkedList<>();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT LR, senal_distintiva, nombre_del_buque FROM puerto.eopt_barcos")) {
                    while (rs.next()) {
                        BeanCartaBarcos user = new BeanCartaBarcos();
                        user.setLR(rs.getString("LR"));
                        user.setSENAL(rs.getString("senal_distintiva"));
                        user.setNOMBRE(rs.getString("nombre_del_buque"));

                        datos.add(user);
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {
            System.err.println("ConsultarLista" + e);
        }

        return datos;
    }

}

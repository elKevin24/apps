/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanComentario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author kcordon
 */
public class Comentario {

    public static boolean agregarDetalle(BeanComentario En) {
        boolean agregado = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO plan_prestaciones.plp_proceso_x_factura (\n"
                        + "    plpp_correlativo,\n"
                        + "    plpp_serie,\n"
                        + "    plpp_factura,\n"
                        + "    plpp_proceso,\n"
                        + "    grabador,\n"
                        + "    grabador_fecha) VALUES ('" + En.getPLPP_CORRELATIVO() + "','" + En.getPLPP_SERIE() + "','" + En.getPLPP_FACTURA() + "','" + En.getPLPP_PROCESO() + "','" + En.getGRABADOR() + "','sysdate')";

                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
        }
        return agregado;
    }

    public static LinkedList<BeanComentario> Consulta(String entrada) throws SQLException {
        LinkedList<BeanComentario> usuarios = new LinkedList<>();
        String sql;

        sql = "SELECT\n"
                + "    plpp_correlativo,\n"
                + "    plpp_serie,\n"
                + "    plpp_factura,\n"
                + "    plpp_proceso,\n"
                + "    grabador,\n"
                + "    grabador_fecha\n"
                + "FROM\n"
                + "    plan_prestaciones.plp_proceso_x_factura\n"
                + "    where PLPP_FACTURA = " + entrada + "";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanComentario user = new BeanComentario();
                        user.setPLPP_CORRELATIVO(rs.getString("PLPP_CORRELATIVO"));
                        user.setPLPP_SERIE(rs.getString("PLPP_SERIE"));
                        user.setPLPP_FACTURA(rs.getString("PLPP_FACTURA"));
                        user.setPLPP_PROCESO(rs.getString("PLPP_PROCESO"));
                        user.setGRABADOR(rs.getString("GRABADOR"));
                        user.setGRABADOR_FECHA(rs.getString("GRABADOR_FECHA"));

                        usuarios.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return usuarios;
    }

}

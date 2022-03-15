/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.BeanInventario_Consulta_Historico_Firmas_Conte;
import controlador.BeanInventario_Conte;
import controlador.BeanInventario_Conte1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author kcordon
 */
public class Invetario_Conte {

    public static String CREAR_FIRMA(String usuario) {
        String retorno = null;
        System.out.println("entrando a  CREAR_FIRMA");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                CallableStatement cs = con.prepareCall("{? = call PUERTO.F_FIRMA_INVENTARIO_CONTE_SAT(?)}");

                cs.registerOutParameter(1, Types.VARCHAR);
                cs.setString(2, usuario);
                cs.execute();
                //se recupera el resultado de la funcion pl/sql
                retorno = cs.getString(1);

                cs.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return retorno;
    }

    public static String CREAR_FIRMA_HISTORICO_CONTE(String usuario, String contenedor) {
        String retorno = null;
        System.out.println("entrando a  CREAR_FIRMA_HISTORICO_CONTE");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                CallableStatement cs = con.prepareCall("{? = call PUERTO.F_FIRMA_HISTORICO_CONTE_SAT(?, ?)}");

                cs.registerOutParameter(1, Types.VARCHAR);
                cs.setString(2, usuario);
                cs.setString(3, contenedor);
                cs.execute();
                //se recupera el resultado de la funcion pl/sql
                retorno = cs.getString(1);

                cs.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return retorno;
    }

    public static BeanInventario_Conte Consulta_Correlativo(String filtro) {
        System.out.println("Consulta_Correlativo" + filtro);
        BeanInventario_Conte user = new BeanInventario_Conte();
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select *\n"
                        + "from PUERTO.SAT_INVENTARIO_CONTENEDORES1\n"
                        + "where firma_electronica = '" + filtro + "'")) {
                    while (rs.next()) {
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setFIRMA(rs.getString("FIRMA_ELECTRONICA"));
                        user.setFECHA(rs.getString("FECHA"));
                        user.setUSUARIO(rs.getString("USUARIO"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        return user;
    }

    public static BeanInventario_Conte Consulta_Correlativo_Conte(String filtro) {
        System.out.println("Consulta_Correlativo_Conte" + filtro);
        BeanInventario_Conte user = new BeanInventario_Conte();
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select *\n"
                        + "from PUERTO.SAT_HISTORICO_CONTENEDORES1\n"
                        + "where firma_electronica = '" + filtro + "'")) {
                    while (rs.next()) {
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setFIRMA(rs.getString("FIRMA_ELECTRONICA"));
                        user.setFECHA(rs.getString("FECHA"));
                        user.setUSUARIO(rs.getString("USUARIO"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("" + e);
        }
        return user;
    }

    public static LinkedList<BeanInventario_Conte1> Consultar_Inventario(String correlativo) throws SQLException {

        System.err.println("Consultar_Inventario: " + correlativo);
        LinkedList<BeanInventario_Conte1> conte = new LinkedList<>();
        String sql = "SELECT\n"
                + "    \"A1\".\"CORRELATIVO\"   \"CORRELATIVO\",\n"
                + "    \"A1\".\"ORDEN\"         \"ORDEN\",\n"
                + "    \"A1\".\"C1\"            \"C1\",\n"
                + "    \"A1\".\"C2\"            \"C2\",\n"
                + "    \"A1\".\"C3\"            \"C3\",\n"
                + "    \"A1\".\"C4\"            \"C4\",\n"
                + "    \"A1\".\"C5\"            \"C5\",\n"
                + "    \"A1\".\"C6\"            \"C6\",\n"
                + "    \"A1\".\"C7\"            \"C7\",\n"
                + "    \"A1\".\"C8\"            \"C8\",\n"
                + "    \"A1\".\"C9\"            \"C9\",\n"
                + "    nvl(\"A1\".\"C10\", ' ') \"C10\",\n"
                + "    nvl(\"A1\".\"C11\", ' ') \"C11\",\n"
                + "    nvl(\"A1\".\"C12\", ' ') \"C12\",\n"
                + "    nvl(\"A1\".\"C13\", ' ') \"C13\"\n"
                + "FROM\n"
                + "    \"PUERTO\".\"SAT_INVENTARIO_CONTENEDORES2\" \"A1\"\n"
                + "WHERE\n"
                + "    \"A1\".\"CORRELATIVO\" = " + correlativo + "\n"
                + "    AND \"A1\".\"ORDEN\" <> 0";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario_Conte1 user = new BeanInventario_Conte1();
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setORDEN(rs.getString("ORDEN"));
                        user.setC1(rs.getString("C1"));
                        user.setC2(rs.getString("C2"));
                        user.setC3(rs.getString("C3"));
                        user.setC4(rs.getString("C4"));
                        user.setC5(rs.getString("C5"));
                        user.setC6(rs.getString("C6"));
                        user.setC7(rs.getString("C7"));
                        user.setC8(rs.getString("C8"));
                        user.setC9(rs.getString("C9"));
                        user.setC10(rs.getString("C10"));
                        user.setC11(rs.getString("C11"));
                        user.setC12(rs.getString("C12"));
                        user.setC13(rs.getString("C13"));

                        conte.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("consultar barco" + e);
        }

        return conte;
    }

    public static LinkedList<BeanInventario_Conte1> Consultar_Inventario_Conte(String correlativo) throws SQLException {
        LinkedList<BeanInventario_Conte1> conte = new LinkedList<>();
        String sql = "SELECT\n"
                + "    \"A1\".\"CORRELATIVO\"   \"CORRELATIVO\",\n"
                + "    \"A1\".\"ORDEN\"         \"ORDEN\",\n"
                + "    \"A1\".\"C1\"            \"C1\",\n"
                + "    \"A1\".\"C2\"            \"C2\",\n"
                + "    \"A1\".\"C3\"            \"C3\",\n"
                + "    \"A1\".\"C4\"            \"C4\",\n"
                + "    nvl(\"A1\".\"C5\", ' ') \"C5\",\n"
                + "    nvl(\"A1\".\"C6\", ' ') \"C6\",\n"
                + "    nvl(\"A1\".\"MEDIDA\", ' ') \"MEDIDA\"\n"
                + "FROM\n"
                + "    \"PUERTO\".\"SAT_HISTORICO_CONTENEDORES2\" \"A1\"\n"
                + "WHERE\n"
                + "    \"A1\".\"CORRELATIVO\" = " + correlativo + "\n"
                + "    AND \"A1\".\"ORDEN\" <> 0";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario_Conte1 user = new BeanInventario_Conte1();
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setORDEN(rs.getString("ORDEN"));
                        user.setC1(rs.getString("C1"));
                        user.setC2(rs.getString("C2"));
                        user.setC3(rs.getString("C3"));
                        user.setC4(rs.getString("C4"));
                        user.setC5(rs.getString("C5"));
                        user.setC6(rs.getString("C6"));
                        user.setC7(rs.getString("MEDIDA"));

                        conte.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("erro Consultar_Inventario_Conte" + e);
        }

        return conte;
    }

    public static LinkedList<BeanInventario_Conte> Consultar_Historico_Firmas(String Inicio, String Final) throws SQLException {
        LinkedList<BeanInventario_Conte> conte = new LinkedList<>();
        String sql = "SELECT\n"
                + "    \"A1\".\"CORRELATIVO\"         \"CORRELATIVO\",\n"
                + "    \"A1\".\"FIRMA_ELECTRONICA\"   \"FIRMA_ELECTRONICA\",\n"
                + "    \"A1\".\"FECHA\"               \"FECHA\",\n"
                + "    \"A1\".\"USUARIO\"             \"USUARIO\"\n"
                + "FROM\n"
                + "    \"PUERTO\".\"SAT_INVENTARIO_CONTENEDORES1\" \"A1\"\n"
                + "WHERE\n"
                + "    \"A1\".\"FECHA\" >= TO_DATE('" + Inicio + "', 'DD-MM-YYYY')\n"
                + "    AND \"A1\".\"FECHA\" <= TO_DATE('" + Final + "', 'DD-MM-YYYY') + 1\n"
                + "ORDER BY\n"
                + "    \"A1\".\"CORRELATIVO\" DESC";

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario_Conte user = new BeanInventario_Conte();
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setFIRMA(rs.getString("FIRMA_ELECTRONICA"));
                        user.setFECHA(rs.getString("FECHA"));
                        user.setUSUARIO(rs.getString("USUARIO"));

                        conte.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("Consultar_Historico_Firmas" + e);
        }

        return conte;
    }
    
    public static LinkedList<BeanInventario_Consulta_Historico_Firmas_Conte> Consultar_Historico_Firmas_Conte(String Inicio, String Final) throws SQLException {
        LinkedList<BeanInventario_Consulta_Historico_Firmas_Conte> conte = new LinkedList<>();
        String sql = "SELECT\n"
                + "    nvl(\"A1\".\"CORRELATIVO\", ' ')         \"CORRELATIVO\",\n"
                + "    nvl(\"A1\".\"FIRMA_ELECTRONICA\", ' ')   \"FIRMA_ELECTRONICA\",\n"
                + "    nvl(\"A1\".\"FECHA\", ' ')               \"FECHA\",\n"
                + "    nvl(\"A1\".\"USUARIO\", ' ')            \"USUARIO\",\n"
                + "    nvl(\"A1\".\"CONTENEDOR\", ' ')             \"CONTENEDOR\",\n"
                + "    nvl(\"A1\".\"MEDIDA\", ' ')             \"MEDIDA\"\n"
                + "FROM\n"
                + "    \"PUERTO\".\"SAT_HISTORICO_CONTENEDORES1\" \"A1\"\n"
                + "WHERE\n"
                + "    \"A1\".\"FECHA\" >= TO_DATE('" + Inicio + "', 'DD-MM-YYYY')\n"
                + "    AND \"A1\".\"FECHA\" <= TO_DATE('" + Final + "', 'DD-MM-YYYY') + 1\n"
                + "ORDER BY\n"
                + "    \"A1\".\"CORRELATIVO\" DESC";
        
//        + "    nvl(\"A1\".\"C10\", ' ') \"C10\",\n"

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        BeanInventario_Consulta_Historico_Firmas_Conte user = new BeanInventario_Consulta_Historico_Firmas_Conte();
                        user.setCORRELATIVO(rs.getString("CORRELATIVO"));
                        user.setFIRMA(rs.getString("FIRMA_ELECTRONICA"));
                        user.setFECHA(rs.getString("FECHA"));
                        user.setUSUARIO(rs.getString("USUARIO"));

                        conte.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("Consultar_Historico_Firmas" + e);
        }

        return conte;
    }

}

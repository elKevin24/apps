/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanPilotos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kcordon
 */
public class Pilotos {

    public static boolean agregar(BeanPilotos P) {
        boolean agregado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO puerto.eopt_visitantes ( visitante, tipo_visitante, nombre_uno, nombre_dos, apellido_uno, apellido_dos, pasaporte, pais_pasaporte, fecha_vence_pasaporte, numero_licencia,tipo_licencia, pais_licencia, estatus,grabador, fecha_grabacion\n"
                        + ") VALUES ('" + P.getID() + "',1, '" + P.getNombre() + "','" + P.getSegundoNombre() + "','" + P.getApellido() + "' ,'" + P.getSegundoApellido() + "' ,'" + P.getPasaporte() + "','','" + P.getexpiracion() + "','" + P.getLicencia() + "','" + P.getTipoLicencia() + "','" + P.getPais_licencia() + "', 'A', 'KCORDON', sysdate)";

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

    public static LinkedList<BeanPilotos> ConsultarLista() throws SQLException {
        LinkedList<BeanPilotos> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("Select visitante, nvl(nombre_uno, ' ') nombre, nvl(nombre_dos, ' ') nombre_dos, nvl(apellido_uno, ' ') apellido , nvl(apellido_dos, ' ') apellido_dos, numero_licencia from \n"
                        + "PUERTO.EOPT_VISITANTES \n"
                        + "WHERE tipo_visitante = 1\n"
                        + "and estatus = 'A' \n"
                        + "ORDER BY visitante desc FETCH NEXT 10000 ROWS ONLY")) {
                    while (rs.next()) {
                        BeanPilotos user = new BeanPilotos();
                        user.setID(rs.getString("visitante"));
                        user.setNombre(rs.getString("nombre"));
                        user.setSegundoNombre(rs.getString("nombre_dos"));
                        user.setApellido(rs.getString("apellido"));
                        user.setSegundoApellido(rs.getString("apellido_dos"));
                        user.setLicencia(rs.getString("numero_licencia"));

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

    //Metodo para cambiar estado 
    public static boolean CambiarEstado(String id) {
        boolean actualizado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //UNA COMA ME HIZO DESVELARME HASTA LAS DOS DE LA MAÑANA
                String sql = "UPDATE puerto.recepcion_web\n"
                        + "SET\n"
                        + "    RW_ESTADO_RECEPCION = 1\n"
                        + "WHERE\n"
                        + "    rw_id_recepcion = " + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
             con.close();
            }

        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    public static BeanPilotos Consultar() {
        BeanPilotos user = new BeanPilotos();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select nvl(max(visitante), 0)+1  visitante\n"
                        + "from\n"
                        + "puerto.eopt_visitantes")) {
                    while (rs.next()) {

                        user.setID(rs.getString("visitante"));
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return user;

    }

    public static BeanPilotos ConsultarPiloto(String id) {
        BeanPilotos user = new BeanPilotos();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    visitante,\n"
                        + "    nvl(nombre_uno, ' ') nombre,\n"
                        + "    nvl(nombre_dos, ' ') nombre_dos,\n"
                        + "    nvl(apellido_uno, ' ') apellido,\n"
                        + "    nvl(apellido_dos, ' ') apellido_dos,\n"
                        + "    numero_licencia,\n"
                        + "    pais_licencia from\n"
                        + "    puerto.eopt_visitantes\n"
                        + "WHERE\n"
                        + "    tipo_visitante = 1\n"
                        + "    AND estatus = 'A'\n"
                        + "    and visitante = " + id + "")) {
                    while (rs.next()) {
                        user.setID(rs.getString("visitante"));
                        user.setNombre(rs.getString("nombre"));
                        user.setSegundoNombre(rs.getString("nombre_dos"));
                        user.setApellido(rs.getString("apellido"));
                        user.setSegundoApellido(rs.getString("apellido_dos"));
                        user.setLicencia(rs.getString("numero_licencia"));
                        user.setPais_licencia(rs.getString("pais_licencia"));
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("Consultar Piloto" + e);
        }
        return user;

    }

    public List<BeanPilotos> getPiloto(String filtro) throws SQLException {
        List<BeanPilotos> lista = new ArrayList<>();

        String query = "Select a.visitante, nvl(a.nombre_uno, ' ')  ||' ' || nvl(a.nombre_dos, ' ') ||' ' || nvl(a.apellido_uno, ' ')   ||' ' || nvl(a.apellido_dos, ' ') ||' ' || a.numero_licencia AS PILOTO \n" +
"from PUERTO.EOPT_VISITANTES A                                                    \n" +
"WHERE tipo_visitante = 1\n" +
"and a.estatus = 'A'\n" +
"and nvl(a.nombre_uno, ' ')  ||' ' || nvl(a.nombre_dos, ' ') ||' ' || nvl(a.apellido_uno, ' ')   ||' ' || nvl(a.apellido_dos, ' ') ||' ' || a.numero_licencia  LIKE '%"+filtro+"%'\n" +
"ORDER BY a.visitante desc FETCH FIRST  5 ROWS ONLY";
        Conexion c = new Conexion();
        try (Connection con = c.getConexion()) {

            Statement st;
            st = con.createStatement();

            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    BeanPilotos user = new BeanPilotos();

                    user.setID(rs.getString("visitante"));
                    user.setNombre(rs.getString("piloto"));

                    lista.add(user);

                }
            }
            st.close();
             con.close();

            con.close();

        } catch (SQLException e) {
            System.err.println("ConsultarLista" + e);
        }
        return lista;

    }

    
    
    public static BeanPilotos ConsultarPiloto1(String id) {
        BeanPilotos user = new BeanPilotos();

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    visitante,\n"
                        + "    nvl(nombre_uno, ' ') nombre,\n"
                        + "    nvl(nombre_dos, ' ') nombre_dos,\n"
                        + "    nvl(apellido_uno, ' ') apellido,\n"
                        + "    nvl(apellido_dos, ' ') apellido_dos,\n"
                        + "    numero_licencia,\n"
                        + "    pais_licencia from\n"
                        + "    puerto.eopt_visitantes\n"
                        + "WHERE\n"
                        + "    tipo_visitante = 1\n"
                        + "    AND estatus = 'A'\n"
                        + "    and visitante = " + id + "")) {
                    while (rs.next()) {
                        user.setID(rs.getString("visitante"));
                        user.setNombre(rs.getString("nombre"));
                        user.setSegundoNombre(rs.getString("nombre_dos"));
                        user.setApellido(rs.getString("apellido"));
                        user.setSegundoApellido(rs.getString("apellido_dos"));
                        user.setLicencia(rs.getString("numero_licencia"));
                        user.setPais_licencia(rs.getString("pais_licencia"));
                    }
                }
                st.close();
             con.close();
            }
        } catch (SQLException e) {

            System.err.println("Consultar Piloto" + e);
        }
        return user;

    }
}

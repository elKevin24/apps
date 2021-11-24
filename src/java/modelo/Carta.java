/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.BeanCarta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author kcordon
 */
public class Carta {

    public static boolean agregar(BeanCarta Carta) {
        boolean agregado = false;

        int medida = Integer.parseInt(Carta.getRW_MEDIDA());

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO PUERTO.RECEPCION_WEB "
                        + "(RW_ID_RECEPCION,"
                        + "RW_PREFIJO_CONT,"
                        + "RW_IDENTIFICACION_CONT,"
                        + "RW_C_O_F,"
                        + "RW_MEDIDA,"
                        + "RW_VIAJE_BARCO,"
                        + "RW_FECHA_VIAJE_BARCO,"
                        + "RW_VIA,"
                        + "RW_REFER_SECO_OPERANDO,"
                        + "RW_ATC,"
                        + "RW_PREFIJO_CHASIS,"
                        + "RW_IDENTIFICACION_CHASIS,"
                        + "RW_PLACA_CABEZAL,"
                        + "RW_PAIS_PLACA,"
                        + "RW_PESO_CONTENEDOR,"
                        + "RW_PAIS_ORIGEN,"
                        + "RW_PAIS_DESTINO,"
                        + "RW_DICE_CONTENER,"
                        + "RW_DICE_OBSERVACIONES,"
                        + "RW_FECHA_RECEPCION_WEB,"
                        + "RW_ESTADO_CONT,"
                        + "RW_USUARIO_SERVICIO,"
                        + "RW_ID_PILOTO,"
                        + "RW_ID_TRANSPORTISTA,"
                        + "RW_LR,"
                        + "RW_SENAL_DISTINTIVA) VALUES "
                        + "('" + Carta.getRW_ID_RECEPCION() + "','" + Carta.getRW_PREFIJO_CONT() + "','" + Carta.getRW_IDENTIFICACION_CONT() + "','" + Carta.getRW_C_O_F() + "','" + medida + "',"
                        + "'" + Carta.getRW_VIAJE_BARCO() + "',TO_DATE('" + Carta.getRW_FECHA_VIAJE_BARCO() + "', 'YYYY-MM-DD HH24:MI:SS'),'T','" + Carta.getRW_REFER_SECO_OPERANDO() + "',"
                        + "'" + Carta.getRW_ATC() + "','" + Carta.getRW_PREFIJO_CHASIS() + "','" + Carta.getRW_IDENTIFICACION_CHASIS() + "','" + Carta.getRW_PLACA_CABEZAL() + "',"
                        + "'" + Carta.getRW_PAIS_PLACA() + "','" + Carta.getRW_PESO_CONTENEDOR() + "','" + Carta.getRW_PAIS_ORIGEN() + "', '" + Carta.getRW_PAIS_DESTINO() + "', '" + Carta.getRW_DICE_CONTENER() + "', '" + Carta.getRW_DICE_OBSERVACIONES() + "', sysdate, " + Carta.getRW_ESTADO_CONT() + ", "
                        + "'" + Carta.getRW_USUARIO_SERVICIO() + "','" + Carta.getRW_ID_PILOTO() + "','" + Carta.getRW_ID_TRANSPORTISTA() + "','" + Carta.getRW_LR() + "','" + Carta.getRW_SENAL_DISTINTIVA() + "')";
//                        + "('1','tmu','12345678','C','20','GUATE','1','13/05/2020','T','S','TOMAS', 'CORTEZ','1234564', 'GT','1231564' ,'987654','CHA','123456','TRANSPORTES', 'C0954ABC', 'GT', '1000', 'GT', 'SV', 'ALMOHADAS', 'OBSERVACIONES', '123456', sysdate)";

//               INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                      + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
            System.err.println(" " + e);
        }
        return agregado;
    }

    public static boolean agregarTrazabilidad(String recepcion) {
        boolean agregado = false;

        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if (con != null) {
                Statement st;
                st = con.createStatement();
                //campos de la tabla
                String sql = "INSERT INTO puerto.recepcion_web_te (\n"
                        + "    rwte_id,\n"
                        + "    rwte_rwe,\n"
                        + "    rw_id_recepcion,\n"
                        + "    rwte_fecha\n"
                        + ") VALUES (\n"
                        + "    1,\n"
                        + "    2,\n"
                        + "    " + recepcion + ",\n"
                        + "    sysdate)";
//                        + "('1','tmu','12345678','C','20','GUATE','1','13/05/2020','T','S','TOMAS', 'CORTEZ','1234564', 'GT','1231564' ,'987654','CHA','123456','TRANSPORTES', 'C0954ABC', 'GT', '1000', 'GT', 'SV', 'ALMOHADAS', 'OBSERVACIONES', '123456', sysdate)";

//               INSERT INTO COTIZADOR_WEB.CW_EOPT_BARCOS (LR, SENAL_DISTINTICA, TIPO_DE_BARCO_POR_ESTRUCTURA, USUARIO_DE_SERVICIO, NOMBRE_DEL_BUQUE, BANDERA, TRB, TRN, TPM, CALADO, ESLORA, MANGA, BITA_USUARIO_INSERTA) VALUES "
//                      + "('"+ En.getLR()+"','"+En.getSENAL_DISTINTIVA()+"','"+En.getTIPO_DE_BARCO_POR_ESTRUCTURA()+"',"+En.getUSUARIO_DE_SERVICIO()+" ,'"+En.getNOMBRE_DEL_BUQUE()+"' ,'"+En.getBANDERA()+"','"+En.getTRB()+"','"+En.getTRN()+"','"+En.getTPM()+"','"+En.getCALADO()+"','"+En.getESLORA()+"','"+En.getMANGA()+"','"+En.getBITA_USUARIO_INSERTA()+"')";
                System.out.println(sql);
                st.execute(sql);

                agregado = true;
                st.close();
            }

        } catch (SQLException e) {
            agregado = false;
            System.err.println(" " + e);
        }
        return agregado;
    }

    public static LinkedList<BeanCarta> ConsultarLista() throws SQLException {
        LinkedList<BeanCarta> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    rw_id_recepcion,\n"
                        + "    rw_prefijo_cont,\n"
                        + "    rw_identificacion_cont,\n"
                        + "    rw_medida,\n"
                        + "    rw_fecha_recepcion_web\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web WHERE RW_ESTADO = 1")) {
                    while (rs.next()) {
                        BeanCarta user = new BeanCarta();
                        user.setRW_ID_RECEPCION(rs.getString("RW_ID_RECEPCION"));
                        user.setRW_PREFIJO_CONT(rs.getString("rw_prefijo_cont"));
                        user.setRW_IDENTIFICACION_CONT(rs.getString("rw_identificacion_cont"));
                        user.setRW_MEDIDA(rs.getString("rw_medida"));
                        user.setRW_FECHA_RECEPCION_WEB(rs.getString("rw_fecha_recepcion_web"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("consulta creados: " + e);
        }

        return datos;
    }

    public static LinkedList<BeanCarta> ConsultarPendientes() throws SQLException {
        LinkedList<BeanCarta> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    rw_id_recepcion,\n"
                        + "    rw_prefijo_cont,\n"
                        + "    rw_identificacion_cont,   \n"
                        + "    rw_medida,\n"
                        + "    rw_fecha_recepcion_web,\n"
                        + "    RW_ESTADO\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web")) {
                    while (rs.next()) {
                        BeanCarta user = new BeanCarta();
                        user.setRW_ID_RECEPCION(rs.getString("RW_ID_RECEPCION"));
                        user.setRW_PREFIJO_CONT(rs.getString("rw_prefijo_cont"));
                        user.setRW_IDENTIFICACION_CONT(rs.getString("rw_identificacion_cont"));
                        user.setRW_MEDIDA(rs.getString("rw_medida"));
                        user.setRW_FECHA_RECEPCION_WEB(rs.getString("rw_fecha_recepcion_web"));
                        user.setRW_ESTADO(rs.getString("RW_ESTADO"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return datos;
    }

    public static LinkedList<BeanCarta> ConsultarAprobados() throws SQLException {
        LinkedList<BeanCarta> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    rw_id_recepcion,\n"
                        + "    rw_prefijo_cont,\n"
                        + "    rw_identificacion_cont,   \n"
                        + "    rw_medida,\n"
                        + "    rw_fecha_recepcion_web\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web WHERE RW_ESTADO = 3")) {
                    while (rs.next()) {
                        BeanCarta user = new BeanCarta();
                        user.setRW_ID_RECEPCION(rs.getString("RW_ID_RECEPCION"));
                        user.setRW_PREFIJO_CONT(rs.getString("rw_prefijo_cont"));
                        user.setRW_IDENTIFICACION_CONT(rs.getString("rw_identificacion_cont"));
                        user.setRW_MEDIDA(rs.getString("rw_medida"));
                        user.setRW_FECHA_RECEPCION_WEB(rs.getString("rw_fecha_recepcion_web"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
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
                        + "    RW_ESTADO = 2\n"
                        + "WHERE\n"
                        + "    rw_id_recepcion = " + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
            }

        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    public static boolean CambiarEstadoEliminar(String id) {
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
                        + "    RW_ESTADO_RECEPCION = 3\n"
                        + "WHERE\n"
                        + "    rw_id_recepcion = " + id + "";
                //"update tbl_seccion set grado ='"+usuario.getGrado()+"', seccion='"+usuario.getSeccion()+"', Id_nivel='"+usuario.getId_nivel()+"' where Id_seccion="+usuario.getId_seccion()+"";

                st.execute(sql);
                actualizado = true;
                st.close();
            }

        } catch (SQLException e) {
            System.err.println("" + e);
        }

        return actualizado;
    }

    public static BeanCarta Consultar() {
        BeanCarta user = new BeanCarta();
        System.out.println("entrando a consultar");

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("select nvl(max(rw_id_recepcion), 0)+1  rw_id_recepcion\n"
                        + "from\n"
                        + "puerto.recepcion_web")) {
                    while (rs.next()) {

                        user.setRW_ID_RECEPCION(rs.getString("RW_ID_RECEPCION"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {

            System.err.println("" + e);
        }
        return user;

    }

    public static BeanCarta ConsultarVer(String id) {
        BeanCarta user = new BeanCarta();
        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();
                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    rw_id_recepcion,\n"
                        + "    rw_prefijo_cont,\n"
                        + "    rw_identificacion_cont,\n"
                        + "    DECODE(rw_c_o_f, 1,'CONTENEDOR',2,  'FURGON')  rw_c_o_f,\n"
                        + "    rw_medida,\n"
                        + "    rw_viaje_barco,\n"
                        + "    rw_fecha_viaje_barco,\n"
                        + "    DECODE(rw_refer_seco_operando, 'S','Seco','O',  'Encendido', 'A', 'Apagado' ) rw_refer_seco_operando,\n"
                        + "    rw_atc,\n"
                        + "    rw_prefijo_chasis,\n"
                        + "    rw_identificacion_chasis,\n"
                        + "    rw_placa_cabezal,    \n"
                        + "    (select puerto.eopt_paises.NOMBRE from PUERTO.eopt_paises WHERE puerto.eopt_paises.pais = rw_pais_placa ) rw_pais_placa,\n"
                        + "    rw_peso_contenedor,\n"
                        + "    (select puerto.eopt_paises.NOMBRE from PUERTO.eopt_paises WHERE puerto.eopt_paises.pais = rw_pais_origen ) rw_pais_origen,\n"
                        + "    (select puerto.eopt_paises.NOMBRE from PUERTO.eopt_paises WHERE puerto.eopt_paises.pais = rw_pais_destino ) rw_pais_destino,\n"
                        + "    rw_dice_contener,\n"
                        + "    rw_dice_observaciones,\n"
                        + "    rw_fecha_recepcion_web,\n"
                        + "    DECODE(rw_estado_cont, '1','Lleno','2', 'Vacio' ) rw_estado_cont,\n"
                        + "    rw_estado,\n"
                        + "    rw_observaciones_opip,\n"
                        + "    rw_fecha_opip,\n"
                        + "    rw_usuario_opip,\n"
                        + "    rw_usuario_conte,\n"
                        + "    rw_fecha_conte,\n"
                        + "    rw_usuario_servicio,\n"
                        + "    puerto.eopt_visitantes.visitante,\n"
                        + "   (Select nvl(a.nombre_uno, ' ')  ||' ' || nvl(a.nombre_dos, ' ') ||' ' || nvl(a.apellido_uno, ' ')   ||' ' || nvl(a.apellido_dos, ' ') from PUERTO.EOPT_VISITANTES A WHERE visitante = rw_id_piloto) rw_id_piloto,\n"
                        + "    puerto.eopt_visitantes.NUMERO_LICENCIA,    \n"
                        + "    PUERTO.EOPT_TRANSPORTES.NOMBRE rw_id_transportista,  \n"
                        + "    (SELECT  nombre_del_buque FROM puerto.eopt_barcos WHERE LR = rw_lr AND senal_distintiva = rw_senal_distintiva) BUQUE,\n"
                        + "    \n"
                        + "    rw_observaciones_conte\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web, PUERTO.eopt_paises, PUERTO.EOPT_VISITANTES,  PUERTO.EOPT_TRANSPORTES\n"
                        + "    where rw_id_recepcion = " + id + "\n"
                        + "    AND rw_pais_placa = puerto.eopt_paises.pais\n"
                        + "    AND rw_id_piloto = puerto.eopt_visitantes.visitante\n"
                        + "    AND rw_id_transportista = PUERTO.EOPT_TRANSPORTES.TRANSPORTE ")) {
                    while (rs.next()) {

                        user.setRW_ID_RECEPCION(rs.getString("rw_id_recepcion"));
                        user.setRW_PREFIJO_CONT(rs.getString("rw_prefijo_cont"));
                        user.setRW_IDENTIFICACION_CONT(rs.getString("rw_identificacion_cont"));
                        user.setRW_C_O_F(rs.getString("rw_c_o_f"));
                        user.setRW_MEDIDA(rs.getString("rw_medida"));
                        user.setRW_VIAJE_BARCO(rs.getString("rw_viaje_barco"));
                        user.setRW_FECHA_VIAJE_BARCO(rs.getString("rw_fecha_viaje_barco"));
                        user.setRW_REFER_SECO_OPERANDO(rs.getString("rw_refer_seco_operando"));
                        user.setRW_ATC(rs.getString("rw_atc"));
                        user.setRW_PREFIJO_CHASIS(rs.getString("rw_prefijo_chasis"));
                        user.setRW_IDENTIFICACION_CHASIS(rs.getString("rw_identificacion_chasis"));
                        user.setRW_PLACA_CABEZAL(rs.getString("rw_placa_cabezal"));
                        user.setRW_PAIS_PLACA(rs.getString("rw_pais_placa"));
                        user.setRW_PESO_CONTENEDOR(rs.getString("rw_peso_contenedor"));
                        user.setRW_PAIS_ORIGEN(rs.getString("rw_pais_origen"));
                        user.setRW_PAIS_DESTINO(rs.getString("rw_pais_destino"));
                        user.setRW_DICE_CONTENER(rs.getString("rw_dice_contener"));
                        user.setRW_DICE_OBSERVACIONES(rs.getString("rw_dice_observaciones"));
                        user.setRW_FECHA_RECEPCION_WEB(rs.getString("rw_fecha_recepcion_web"));
                        user.setRW_ESTADO(rs.getString("rw_estado"));
                        user.setRW_ESTADO_CONT(rs.getString("rw_estado_cont"));
                        user.setRW_ID_PILOTO(rs.getString("visitante"));
                        user.setNOMBRE_PILOTO(rs.getString("RW_ID_PILOTO"));
                        user.setLICENCIA_PILOTO(rs.getString("NUMERO_LICENCIA"));
                        user.setRW_ID_TRANSPORTISTA(rs.getString("RW_ID_TRANSPORTISTA"));
                        user.setNOMBRE_BUQUE(rs.getString("BUQUE"));
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
            System.err.println("consulta detalle" + e);
        }
        return user;

    }

    public static LinkedList<BeanCarta> ConsultarT(String id) throws SQLException {
        LinkedList<BeanCarta> datos = new LinkedList<>();
        String sql;

        try {
            Conexion c = new Conexion();
            try (Connection con = c.getConexion()) {
                Statement st;
                st = con.createStatement();

                try (ResultSet rs = st.executeQuery("SELECT\n"
                        + "    A.rwte_id,\n"
                        + "    A.rwte_rwe,\n"
                        + "    A.rw_id_recepcion,\n"
                        + "    A.rwte_fecha,\n"
                        + "    B.rw_observaciones_opip\n"
                        + "FROM\n"
                        + "    puerto.recepcion_web_te A, PUERTO.recepcion_web B\n"
                        + "    where A.rw_id_recepcion = "+id+"\n"
                        + "    and A.rw_id_recepcion = B.rw_id_recepcion")) {
                    while (rs.next()) {
                        BeanCarta user = new BeanCarta();
                        user.setRWTE_ID(rs.getString("rwte_id"));
                        user.setRWTE_RWE(rs.getString("rwte_rwe"));
                        user.setRWTE_FECHA(rs.getString("rwte_fecha"));
                        user.setRw_observaciones_opip(rs.getString("rw_observaciones_opip"));

                        datos.add(user);
                    }
                }
                st.close();
            }
        } catch (SQLException e) {
        }

        return datos;
    }

}

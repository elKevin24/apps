package modelo;

import java.sql.*;

public class Conexion {

    Connection con = null;

    public Conexion() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            //jdbc:sqlserver://localhost:1433;databaseName=db_proyecto [sa on dbo]
            con = DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.5:1521:EMPORA", "UA_KCORDON", "Zacapa2022");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.5:1521:EMPORA", "SERVICIOS_WEB", "SERVI#1WEB");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.50:1521:DESAEMP", "UA_KCORDON", "12345678");
            

            //jdbc:oracle:thin:@172.20.10.50:1521:DESAEMP [UA_KCORDON on FINANCIERO]
        } catch (SQLException e) {
            // TODO Auto-generated catch bloc

        }
    }
    //este es elultimo

    public Connection getConexion() {
        return con;
    }

}

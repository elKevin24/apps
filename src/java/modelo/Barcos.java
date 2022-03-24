
package modelo;
import controlador.BeanBarcos;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.ResultSet;
import java.util.LinkedList;



public class Barcos {
 
public static LinkedList<BeanBarcos> consultarBarco(String entrada) throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     String sql  =  "SELECT DISTINCT LR, NOMBRE_DEL_BUQUE, SENAL_DISTINTIVA, TRB, ESLORA\n" +
"FROM(\n" +
"SELECT A.LR, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, A.SENAL_DISTINTIVA, A.TRB, A.ESLORA\n" +
"FROM PUERTO.EOPT_BARCOS A\n" +
"WHERE USUARIO_DE_SERVICIO = "+entrada+"\n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)\n" +
"UNION\n" +
"SELECT B.LR, B.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, B.SENAL_DISTINTIVA, B.TRB, B.ESLORA\n" +
"FROM COTIZADOR_WEB.CW_EOPT_BARCOS B\n" +
"WHERE USUARIO_DE_SERVICIO = "+entrada+" \n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90))";
     
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));   
                        user.setTRB(rs.getString("TRB"));
                        user.setESLORA(rs.getString("ESLORA"));         
                               
                                                                        
                        usuarios.add(user);                                 
                    }  }
             st.close();
             con.close();
             con.close();
         }                    
      }                        
     catch (SQLException e)
      {    
          
          System.err.println("consultar barco"+e);
      }                     
                             
    return usuarios;
}

public static LinkedList<BeanBarcos> consultarBarcoFind(String entrada, String Name) throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     String sql  =  "SELECT DISTINCT LR, NOMBRE_DEL_BUQUE, SENAL_DISTINTIVA\n" +
"FROM(\n" +
"SELECT A.LR,  A.SENAL_DISTINTIVA, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE\n" +
"FROM PUERTO.EOPT_BARCOS A\n" +
"WHERE USUARIO_DE_SERVICIO = "+entrada+"\n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)\n" +
"OR A.NOMBRE_DEL_BUQUE LIKE '%"+Name+"%'\n" +
"UNION\n" +
"SELECT B.LR, B.SENAL_DISTINTIVA, B.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE\n" +
"FROM COTIZADOR_WEB.CW_EOPT_BARCOS B\n" +
"WHERE USUARIO_DE_SERVICIO = "+entrada+"\n" +
"and tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)\n" +
"OR B.NOMBRE_DEL_BUQUE LIKE '%"+Name+"%'\n" +
")";
     
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));   
                        user.setTRB(rs.getString("TRB"));
                        user.setESLORA(rs.getString("ESLORA"));         
                               
                                                                        
                        usuarios.add(user);                                 
                    }  }
             st.close();
             con.close();
         }                    
      }                        
     catch (SQLException e)
      {    
          
          System.err.println("consultar barco"+e);
      }                     
                             
    return usuarios;
}

public static LinkedList<BeanBarcos> consultarBarco() throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     
         
            
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery("select LR, NOMBRE_DEL_BUQUE, senal_distintiva, TRB, ESLORA from PUERTO.eopt_barcos where tipo_de_barco_por_estructura in (12, 13, 21, 22, 31, 32, 51, 52, 61,62, 63, 64, 71, 72, 73,74, 90)")) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));   
                        user.setTRB(rs.getString("TRB"));
                        user.setESLORA(rs.getString("ESLORA"));         
                               
                                                                        
                        usuarios.add(user);                                 
                    }  }
             st.close();
             con.close();
         }                    
      }                        
     catch (SQLException e)
      {                                                            
      }                     
                             
    return usuarios;
}



public static BeanBarcos ObtenerBarcos(String id)
{                  
    BeanBarcos user = new BeanBarcos();
               
     try        
      {        
    Conexion c=new Conexion();
        try (Connection con = c.getConexion()) {
            Statement st;
            st = con.createStatement();
        try (ResultSet rs = st.executeQuery("SELECT DISTINCT LR, NOMBRE_DEL_BUQUE, SENAL_DISTINTIVA, TRB, ESLORA\n" +
"FROM(\n" +
"SELECT A.LR, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, A.SENAL_DISTINTIVA, A.TRB, A.ESLORA\n" +
"FROM PUERTO.EOPT_BARCOS A\n" +
"WHERE LR = "+id+"\n" +
"UNION\n" +
"SELECT B.LR, B.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, B.SENAL_DISTINTIVA, B.TRB, B.ESLORA\n" +
"FROM COTIZADOR_WEB.CW_EOPT_BARCOS B\n" +
"WHERE LR = "+id+")")) {
            while (rs.next())
            {
                
                user.setLR(rs.getString("LR"));
                user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));
                user.setBANDERA(rs.getString("senal_distintiva"));
                user.setTRB(rs.getString("TRB"));
                user.setESLORA(rs.getString("ESLORA"));
                
                 
            }
        }
            st.close();
             con.close();
        }
      }
     catch(SQLException e)
     {
     }
    return user;
    
} 


public static LinkedList<BeanBarcos> consultarBarcoSL(String entrada) throws SQLException
{
     LinkedList<BeanBarcos> usuarios = new LinkedList<>();
     String sql  =  "SELECT A.LR, A.NOMBRE_DEL_BUQUE NOMBRE_DEL_BUQUE, A.SENAL_DISTINTIVA\n" +
"FROM PUERTO.EOPT_BARCOS A\n" +
"WHERE A.LR LIKE  '%"+entrada+"%' \n" +
" OR A.NOMBRE_DEL_BUQUE  LIKE  '%"+entrada+"%'\n" +
" OR A.SENAL_DISTINTIVA LIKE  '%"+entrada+"%'";
     
    try
      {
            Conexion c=new Conexion();
         try (Connection con = c.getConexion()) {
             Statement st;
             st = con.createStatement();
           
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next())
                    {
                        BeanBarcos user = new BeanBarcos();
                        user.setLR(rs.getString("LR"));       
                        user.setNOMBRE_DEL_BUQUE(rs.getString("NOMBRE_DEL_BUQUE"));             
                        user.setBANDERA(rs.getString("senal_distintiva"));                             
                                                                                                       
                        usuarios.add(user);                                 
                    }  }
             st.close();
             con.close();
         }                    
      }                        
     catch (SQLException e)
      {    
          
          System.err.println("consultar barco"+e);
      }                     
                             
    return usuarios;
}


}
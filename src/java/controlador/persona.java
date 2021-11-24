
package controlador;

public class persona {
    int id_login;
    String usuario;
    String clave;
    
    public persona(){
        
    }
        
    public persona(int id_login, String usuario, String clave){
        this.id_login = id_login;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}

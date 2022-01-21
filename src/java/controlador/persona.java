
package controlador;

public class persona {
    String id_login;
    String usuario;
    String clave;
    
    public persona(){
        
    }
        
    public persona(String id_login, String usuario, String clave){
        this.id_login = id_login;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getId_login() {
        return id_login;
    }

    public void setId_login(String id_login) {
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

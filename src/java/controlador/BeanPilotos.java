/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author kcordon
 */
public class BeanPilotos {  

     
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public String getTipoLicencia() {
        return TipoLicencia;
    }

    public void setTipoLicencia(String TipoLicencia) {
        this.TipoLicencia = TipoLicencia;
    }
    

    public String getPais_licencia() {
        return Pais_licencia;
    }

    public void setPais_licencia(String Pais_licencia) {
        this.Pais_licencia = Pais_licencia;
    }

    public String getPasaporte() {
        return Pasaporte;
    }

    public void setPasaporte(String Pasaporte) {
        this.Pasaporte = Pasaporte;
    }

    public String getexpiracion() {
        return expiracion;
    }

    public void setexpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public String getPais_pasaporte() {
        return Pais_pasaporte;
    }

    public void setPais_pasaporte(String Pais_pasaporte) {
        this.Pais_pasaporte = Pais_pasaporte;
    }

    public String getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
    
    
    

    

    

    public BeanPilotos(String ID, String Nombre, String SegundoNombre, String Apellido,
            String SegundoApellido, String Licencia, String TipoLicencia, String Pais_licencia, String Pasaporte , String expiracion, String Pais_pasaporte
  ) {

        this.ID = ID;
        this.Nombre = Nombre;
        this.SegundoNombre = SegundoNombre;
        this.Apellido = Apellido;
        this.SegundoApellido = SegundoApellido;
        this.Licencia = Licencia;
        this.TipoLicencia = TipoLicencia;
        this.Pais_licencia = Pais_licencia;
        this.Pasaporte = Pasaporte;
        this.expiracion = expiracion;
        this.Pais_pasaporte = Pais_pasaporte;
        
        
       

    }

    private String ID;
    private String Nombre;
    private String SegundoNombre;
    private String Apellido;
    private String SegundoApellido;
    private String Licencia;
    private String TipoLicencia;
    private String Pais_licencia;
    private String Pasaporte;
    private String expiracion;
    private String Pais_pasaporte;
    private String usuario;
    private String fecha;
    private String estado;
    

    public BeanPilotos() {
    }
}

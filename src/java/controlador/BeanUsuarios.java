package controlador;

public class BeanUsuarios {

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getUSUARIO_INOW() {
        return USUARIO_INOW;
    }

    public void setUSUARIO_INOW(String USUARIO_INOW) {
        this.USUARIO_INOW = USUARIO_INOW;
    }

    public String getUSUARIO_DE_SERVICIO() {
        return USUARIO_DE_SERVICIO;
    }

    public void setUSUARIO_DE_SERVICIO(String USUARIO_DE_SERVICIO) {
        this.USUARIO_DE_SERVICIO = USUARIO_DE_SERVICIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getREPRESENTANTE() {
        return REPRESENTANTE;
    }

    public void setREPRESENTANTE(String REPRESENTANTE) {
        this.REPRESENTANTE = REPRESENTANTE;
    }

    public String getEMAIL_US() {
        return EMAIL_US;
    }

    public void setEMAIL_US(String EMAIL_US) {
        this.EMAIL_US = EMAIL_US;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public Double getCAMBIO() {
        return CAMBIO;
    }

    public void setCAMBIO(Double CAMBIO) {
        this.CAMBIO = CAMBIO;
    }

    public String getFECHA_CAMBIO() {
        return FECHA_CAMBIO;
    }

    public void setFECHA_CAMBIO(String FECHA_CAMBIO) {
        this.FECHA_CAMBIO = FECHA_CAMBIO;
    }

    

    
    

    
    
    
    

    

    public BeanUsuarios(String USERID, String USUARIO_INOW, String USUARIO_DE_SERVICIO, 
            String NOMBRE,  String TELEFONO, String NIT, String DIRECCION, String REPRESENTANTE, String EMAIL_US, String CORREO) {
        
        
        this.USERID = USERID;
        this.USUARIO_INOW = USUARIO_INOW;
        this.USUARIO_DE_SERVICIO = USUARIO_DE_SERVICIO;
        this.NOMBRE = NOMBRE;
        this.TELEFONO = TELEFONO;
        this.NIT = NIT;
        this.DIRECCION = DIRECCION;
        this.REPRESENTANTE = REPRESENTANTE;
        this.EMAIL_US = EMAIL_US;
        this.CORREO = CORREO;


        
        
    }

    private String USERID;
    private String USUARIO_INOW;
    private String USUARIO_DE_SERVICIO;
    private String NOMBRE;
    private String TELEFONO;
    private String NIT;
    private String DIRECCION;
    private String REPRESENTANTE;
    private String EMAIL_US;
    private String CORREO;
    private Double CAMBIO;
    private String FECHA_CAMBIO;
    
    
    public BeanUsuarios() {
    }

}

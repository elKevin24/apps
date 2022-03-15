package controlador;



public class BeanFactura {

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }

    public String getSERIE() {
        return SERIE;
    }

    public void setSERIE(String SERIE) {
        this.SERIE = SERIE;
    }

    public String getPS_NUMERO() {
        return PS_NUMERO;
    }

    public void setPS_NUMERO(String PS_NUMERO) {
        this.PS_NUMERO = PS_NUMERO;
    }

    public String getAUTORIZACION() {
        return AUTORIZACION;
    }

    public void setAUTORIZACION(String AUTORIZACION) {
        this.AUTORIZACION = AUTORIZACION;
    }

    public String getFECHA_CERTIFICA() {
        return FECHA_CERTIFICA;
    }

    public void setFECHA_CERTIFICA(String FECHA_CERTIFICA) {
        this.FECHA_CERTIFICA = FECHA_CERTIFICA;
    }

    public String getP_NIT() {
        return P_NIT;
    }

    public void setP_NIT(String P_NIT) {
        this.P_NIT = P_NIT;
    }

    public String getP_NOMBRE() {
        return P_NOMBRE;
    }

    public void setP_NOMBRE(String P_NOMBRE) {
        this.P_NOMBRE = P_NOMBRE;
    }

    public String getP_DIRECCION() {
        return P_DIRECCION;
    }

    public void setP_DIRECCION(String P_DIRECCION) {
        this.P_DIRECCION = P_DIRECCION;
    }

    public String getP_EMAIL() {
        return P_EMAIL;
    }

    public void setP_EMAIL(String P_EMAIL) {
        this.P_EMAIL = P_EMAIL;
    }

    public String getP_TIPO_CAMBIO_FECHA() {
        return P_TIPO_CAMBIO_FECHA;
    }

    public void setP_TIPO_CAMBIO_FECHA(String P_TIPO_CAMBIO_FECHA) {
        this.P_TIPO_CAMBIO_FECHA = P_TIPO_CAMBIO_FECHA;
    }

    public String getP_TIPO_CAMBIO() {
        return P_TIPO_CAMBIO;
    }

    public void setP_TIPO_CAMBIO(String P_TIPO_CAMBIO) {
        this.P_TIPO_CAMBIO = P_TIPO_CAMBIO;
    }

    public String getP_TRAMITADOR() {
        return P_TRAMITADOR;
    }

    public void setP_TRAMITADOR(String P_TRAMITADOR) {
        this.P_TRAMITADOR = P_TRAMITADOR;
    }

    public String getP_REFERENCIA_PIE() {
        return P_REFERENCIA_PIE;
    }

    public void setP_REFERENCIA_PIE(String P_REFERENCIA_PIE) {
        this.P_REFERENCIA_PIE = P_REFERENCIA_PIE;
    }

    public String getP_ID_NOTA() {
        return P_ID_NOTA;
    }

    public void setP_ID_NOTA(String P_ID_NOTA) {
        this.P_ID_NOTA = P_ID_NOTA;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public String getTARIFA() {
        return TARIFA;
    }

    public void setTARIFA(String TARIFA) {
        this.TARIFA = TARIFA;
    }

    public String getSERVICIO() {
        return SERVICIO;
    }

    public void setSERVICIO(String SERVICIO) {
        this.SERVICIO = SERVICIO;
    }

    public String getSUB_TOTAL() {
        return SUB_TOTAL;
    }

    public void setSUB_TOTAL(String SUB_TOTAL) {
        this.SUB_TOTAL = SUB_TOTAL;
    }

    public String getREFERENCIA() {
        return REFERENCIA;
    }

    public void setREFERENCIA(String REFERENCIA) {
        this.REFERENCIA = REFERENCIA;
    }
    
    
    
    
    

    
    

    
    private String NUMERO;
    private String FECHA;
    private String TOTAL;
    private String SERIE;
    private String PS_NUMERO;
    private String AUTORIZACION;
    private String FECHA_CERTIFICA;
    
    private String P_NIT; 
    private String P_NOMBRE;
    private String P_DIRECCION; 
    private String P_EMAIL; 
    
    private String P_TIPO_CAMBIO_FECHA; 
    private String P_TIPO_CAMBIO; 
    
    private String P_TRAMITADOR; 
    private String P_REFERENCIA_PIE; 
    private String P_ID_NOTA;  
    
    //detalle
    
    private String CANTIDAD;
    private String TARIFA;
    private String SERVICIO;
    private String SUB_TOTAL;
    private String REFERENCIA;
    
    
    public BeanFactura() {
    }

}

package controlador;

public class BeanRX {

    public String getPREFIJO() {
        return PREFIJO;
    }

    public void setPREFIJO(String PREFIJO) {
        this.PREFIJO = PREFIJO;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public void setIDENTIFICACION(String IDENTIFICACION) {
        this.IDENTIFICACION = IDENTIFICACION;
    }

    public String getFECHA_ESCANEO() {
        return FECHA_ESCANEO;
    }

    public void setFECHA_ESCANEO(String FECHA_ESCANEO) {
        this.FECHA_ESCANEO = FECHA_ESCANEO;
    }

    public String getIMPORTEXPORT() {
        return IMPORTEXPORT;
    }

    public void setIMPORTEXPORT(String IMPORTEXPORT) {
        this.IMPORTEXPORT = IMPORTEXPORT;
    }

    public String getFECHA_BASCULA() {
        return FECHA_BASCULA;
    }

    public void setFECHA_BASCULA(String FECHA_BASCULA) {
        this.FECHA_BASCULA = FECHA_BASCULA;
    }
    
    

    


  

    private String PREFIJO;
    private String IDENTIFICACION;
    private String FECHA_ESCANEO;
    private String IMPORTEXPORT;
    private String FECHA_BASCULA;
    
    
    public BeanRX() {
    }

}

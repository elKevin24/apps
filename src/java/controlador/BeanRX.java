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

    


  

    private String PREFIJO;
    private String IDENTIFICACION;
    private String FECHA_ESCANEO;
    private String IMPORTEXPORT;
    
    
    public BeanRX() {
    }

}

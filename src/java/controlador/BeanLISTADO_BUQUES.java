package controlador;

public class BeanLISTADO_BUQUES {

    public String getVIAJE_SISTEMA() {
        return VIAJE_SISTEMA;
    }

    public void setVIAJE_SISTEMA(String VIAJE_SISTEMA) {
        this.VIAJE_SISTEMA = VIAJE_SISTEMA;
    }

    public String getBARCO() {
        return BARCO;
    }

    public void setBARCO(String BARCO) {
        this.BARCO = BARCO;
    }

    public String getVIAJE_BARCO() {
        return VIAJE_BARCO;
    }

    public void setVIAJE_BARCO(String VIAJE_BARCO) {
        this.VIAJE_BARCO = VIAJE_BARCO;
    }

    public String getSITUACION() {
        return SITUACION;
    }

    public void setSITUACION(String SITUACION) {
        this.SITUACION = SITUACION;
    }

    public String getFECHA_ETA() {
        return FECHA_ETA;
    }

    public void setFECHA_ETA(String FECHA_ETA) {
        this.FECHA_ETA = FECHA_ETA;
    }

    public String getNAVIERA() {
        return NAVIERA;
    }

    public void setNAVIERA(String NAVIERA) {
        this.NAVIERA = NAVIERA;
    }
    
    
    


    public BeanLISTADO_BUQUES(String VIAJE_SISTEMA, String BARCO, String VIAJE_BARCO, 
            String SITUACION,  String FECHA_ETA, String NAVIERA) {
        
        
        this.VIAJE_SISTEMA = VIAJE_SISTEMA;
        this.BARCO = BARCO;
        this.VIAJE_BARCO = VIAJE_BARCO;
        this.SITUACION = SITUACION;
        this.FECHA_ETA = FECHA_ETA;
        this.NAVIERA = NAVIERA;


        
        
    }

    private String VIAJE_SISTEMA;
    private String BARCO;
    private String VIAJE_BARCO;
    private String SITUACION;
    private String FECHA_ETA;
    private String NAVIERA;
    
    
    public BeanLISTADO_BUQUES() {
    }

}

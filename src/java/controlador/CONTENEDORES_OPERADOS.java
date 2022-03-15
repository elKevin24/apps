package controlador;

public class CONTENEDORES_OPERADOS {

    public String getMANIFIESTO() {
        return MANIFIESTO;
    }

    public void setMANIFIESTO(String MANIFIESTO) {
        this.MANIFIESTO = MANIFIESTO;
    }

    public String getBUQUE() {
        return BUQUE;
    }

    public void setBUQUE(String BUQUE) {
        this.BUQUE = BUQUE;
    }

    public String getVIAJE() {
        return VIAJE;
    }

    public void setVIAJE(String VIAJE) {
        this.VIAJE = VIAJE;
    }

    public String getNAVIERA() {
        return NAVIERA;
    }

    public void setNAVIERA(String NAVIERA) {
        this.NAVIERA = NAVIERA;
    }

    public String getMEDIDA() {
        return MEDIDA;
    }

    public void setMEDIDA(String MEDIDA) {
        this.MEDIDA = MEDIDA;
    }

    

    public CONTENEDORES_OPERADOS(String MANIFIESTO, String BUQUE, String VIAJE, 
            String MEDIDA, String NAVIERA) {
        
        
        this.MANIFIESTO = MANIFIESTO;
        this.BUQUE = BUQUE;
        this.VIAJE = VIAJE;
        this.NAVIERA = NAVIERA;
        this.MEDIDA = MEDIDA;


        
        
    }

    private String MANIFIESTO;
    private String BUQUE;
    private String VIAJE;
    private String NAVIERA;
    private String MEDIDA;
    
    
    public CONTENEDORES_OPERADOS() {
    }

}

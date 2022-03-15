package controlador;

public class BeanMANIFIESTOSXBUQUE {

    public String getMODALIDAD() {
        return MODALIDAD;
    }

    public void setMODALIDAD(String MODALIDAD) {
        this.MODALIDAD = MODALIDAD;
    }

    public String getMANIFIESTO() {
        return MANIFIESTO;
    }

    public void setMANIFIESTO(String MANIFIESTO) {
        this.MANIFIESTO = MANIFIESTO;
    }

    public String getNAVIERA() {
        return NAVIERA;
    }

    public void setNAVIERA(String NAVIERA) {
        this.NAVIERA = NAVIERA;
    }

    public String getOPERADO() {
        return OPERADO;
    }

    public void setOPERADO(String OPERADO) {
        this.OPERADO = OPERADO;
    }

    
    
    


    public BeanMANIFIESTOSXBUQUE(String MODALIDAD, String MANIFIESTO, String OPERADO, 
            String NAVIERA) {
        
        
        this.MODALIDAD = MODALIDAD;
        this.MANIFIESTO = MANIFIESTO;
        this.OPERADO = OPERADO;
        this.NAVIERA = NAVIERA;


        
        
    }

    private String MODALIDAD;
    private String MANIFIESTO;
    private String NAVIERA;
    private String OPERADO;
    
    
    public BeanMANIFIESTOSXBUQUE() {
    }

}

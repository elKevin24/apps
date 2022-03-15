package controlador;

public class BeanEstadistico {

    public String getMEDIDA() {
        return MEDIDA;
    }

    public void setMEDIDA(String MEDIDA) {
        this.MEDIDA = MEDIDA;
    }

    public String getLISTADOS() {
        return LISTADOS;
    }

    public void setLISTADOS(String LISTADOS) {
        this.LISTADOS = LISTADOS;
    }

    public String getOPERADOS() {
        return OPERADOS;
    }

    public void setOPERADOS(String OPERADOS) {
        this.OPERADOS = OPERADOS;
    }

    public String getPORCENTAJE_OPERADOS() {
        return PORCENTAJE_OPERADOS;
    }

    public void setPORCENTAJE_OPERADOS(String PORCENTAJE_OPERADOS) {
        this.PORCENTAJE_OPERADOS = PORCENTAJE_OPERADOS;
    }

    public String getPENDIENTES() {
        return PENDIENTES;
    }

    public void setPENDIENTES(String PENDIENTES) {
        this.PENDIENTES = PENDIENTES;
    }

    public String getPORCENTAJE_PENDIENTES() {
        return PORCENTAJE_PENDIENTES;
    }

    public void setPORCENTAJE_PENDIENTES(String PORCENTAJE_PENDIENTES) {
        this.PORCENTAJE_PENDIENTES = PORCENTAJE_PENDIENTES;
    }

    
    

    private String MEDIDA;
    private String LISTADOS;
    private String OPERADOS;
    private String PORCENTAJE_OPERADOS;
    private String PENDIENTES;
    private String PORCENTAJE_PENDIENTES;

   

    public BeanEstadistico() {
    }

}

package controlador;

public class BeanDemoras {

    public String getHORAS() {
        return HORAS;
    }

    public void setHORAS(String HORAS) {
        this.HORAS = HORAS;
    }

    public String getMINUTOS() {
        return MINUTOS;
    }

    public void setMINUTOS(String MINUTOS) {
        this.MINUTOS = MINUTOS;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDEMORA() {
        return DEMORA;
    }

    public void setDEMORA(String DEMORA) {
        this.DEMORA = DEMORA;
    }

    public String getCARGA() {
        return CARGA;
    }

    public void setCARGA(String CARGA) {
        this.CARGA = CARGA;
    }

    

    
    

    

    public BeanDemoras(String HORAS, String MINUTOS, String NOMBRE, String DEMORA, String CARGA
        ) {
        
        
        this.HORAS = HORAS;        
        this.MINUTOS = MINUTOS;
        this.NOMBRE = NOMBRE;
        this.DEMORA = DEMORA;
        this.CARGA = CARGA;     
        
    }

    
    private String HORAS;
    private String MINUTOS; 
    private String NOMBRE;
    private String DEMORA; 
    private String CARGA;
    
    
    public BeanDemoras() {
    }

}

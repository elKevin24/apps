package controlador;

public class BeanTipoBuque {

    public String getCWTO_TIPO_OPERACION() {
        return CWTO_TIPO_OPERACION;
    }

    public void setCWTO_TIPO_OPERACION(String CWTO_TIPO_OPERACION) {
        this.CWTO_TIPO_OPERACION = CWTO_TIPO_OPERACION;
    }

    public String getCWTO_OPERACION() {
        return CWTO_OPERACION;
    }

    public void setCWTO_OPERACION(String CWTO_OPERACION) {
        this.CWTO_OPERACION = CWTO_OPERACION;
    }

    

    public BeanTipoBuque(String CWTO_TIPO_OPERACION, String CWTO_OPERACION) {
        
        
        this.CWTO_TIPO_OPERACION = CWTO_TIPO_OPERACION;
        this.CWTO_OPERACION = CWTO_OPERACION;
              
        }

    private String CWTO_TIPO_OPERACION;
    private String CWTO_OPERACION;
    
    
    public BeanTipoBuque() {
    }

}

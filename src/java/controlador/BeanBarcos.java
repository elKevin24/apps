package controlador;

public class BeanBarcos {

    public String getLR() {
        return LR;
    }

    public void setLR(String LR) {
        this.LR = LR;
    }

    public String getNOMBRE_DEL_BUQUE() {
        return NOMBRE_DEL_BUQUE;
    }

    public void setNOMBRE_DEL_BUQUE(String NOMBRE_DEL_BUQUE) {
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
    }

    public String getBANDERA() {
        return BANDERA;
    }

    public void setBANDERA(String BANDERA) {
        this.BANDERA = BANDERA;
    }

    public String getTRB() {
        return TRB;
    }

    public void setTRB(String TRB) {
        this.TRB = TRB;
    }

    public String getESLORA() {
        return ESLORA;
    }

    public void setESLORA(String ESLORA) {
        this.ESLORA = ESLORA;
    }


    public BeanBarcos(String LR, String NOMBRE_DEL_BUQUE, String BANDERA, 
            String TRB,  String ESLORA) {
        
        
        this.LR = LR;
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
        this.BANDERA = BANDERA;
        this.TRB = TRB;
        this.ESLORA = ESLORA;


        
        
    }

    private String LR;
    private String NOMBRE_DEL_BUQUE;
    private String BANDERA;
    private String TRB;
    private String ESLORA;
    
    
    public BeanBarcos() {
    }

}

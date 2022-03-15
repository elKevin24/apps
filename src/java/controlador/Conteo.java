package controlador;



public class Conteo {

    public String getPLPC_CORRELATIVO() {
        return PLPC_CORRELATIVO;
    }

    public void setPLPC_CORRELATIVO(String PLPC_CORRELATIVO) {
        this.PLPC_CORRELATIVO = PLPC_CORRELATIVO;
    }

    public String getPLPC_SERIE() {
        return PLPC_SERIE;
    }

    public void setPLPC_SERIE(String PLPC_SERIE) {
        this.PLPC_SERIE = PLPC_SERIE;
    }

    public int getPLPC_FACTURA() {
        return PLPC_FACTURA;
    }

    public void setPLPC_FACTURA(int PLPC_FACTURA) {
        this.PLPC_FACTURA = PLPC_FACTURA;
    }

    public String getGRABADOR() {
        return GRABADOR;
    }

    public void setGRABADOR(String GRABADOR) {
        this.GRABADOR = GRABADOR;
    }

    public String getGRABADOR_FECHA() {
        return GRABADOR_FECHA;
    }

    public void setGRABADOR_FECHA(String GRABADOR_FECHA) {
        this.GRABADOR_FECHA = GRABADOR_FECHA;
    }

     
    
    
    
    public Conteo(int PLPC_FACTURA,
             String GRABADOR) {

       
        
        this.PLPC_FACTURA  = PLPC_FACTURA;
        this.GRABADOR = GRABADOR;
        

    }

    private String PLPC_CORRELATIVO;
    private String PLPC_SERIE;
    private int PLPC_FACTURA;
    
    private String GRABADOR;
    private String GRABADOR_FECHA;

    public Conteo() {

    }

}
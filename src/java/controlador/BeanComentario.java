/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author kcordon
 */
public class BeanComentario {

    public String getPLPP_CORRELATIVO() {
        return PLPP_CORRELATIVO;
    }

    public void setPLPP_CORRELATIVO(String PLPP_CORRELATIVO) {
        this.PLPP_CORRELATIVO = PLPP_CORRELATIVO;
    }

    public String getPLPP_SERIE() {
        return PLPP_SERIE;
    }

    public void setPLPP_SERIE(String PLPP_SERIE) {
        this.PLPP_SERIE = PLPP_SERIE;
    }

    public String getPLPP_FACTURA() {
        return PLPP_FACTURA;
    }

    public void setPLPP_FACTURA(String PLPP_FACTURA) {
        this.PLPP_FACTURA = PLPP_FACTURA;
    }

    public String getPLPP_PROCESO() {
        return PLPP_PROCESO;
    }

    public void setPLPP_PROCESO(String PLPP_PROCESO) {
        this.PLPP_PROCESO = PLPP_PROCESO;
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

    public BeanComentario( String PLPP_FACTURA,
            String PLPP_PROCESO, String GRABADOR) {

        
        this.PLPP_FACTURA = PLPP_FACTURA;
        this.PLPP_PROCESO = PLPP_PROCESO;
        this.GRABADOR = GRABADOR;
        
       

    }

    private String PLPP_CORRELATIVO;
    private String PLPP_SERIE;
    private String PLPP_FACTURA;
    private String PLPP_PROCESO;
    private String GRABADOR;
    private String GRABADOR_FECHA;

    public BeanComentario() {

    }

}

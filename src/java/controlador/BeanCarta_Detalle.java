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
public class BeanCarta_Detalle {

    public String getDA_ID() {
        return DA_ID;
    }

    public void setDA_ID(String DA_ID) {
        this.DA_ID = DA_ID;
    }

    public String getDA_MODALIDAD() {
        return DA_MODALIDAD;
    }

    public void setDA_MODALIDAD(String DA_MODALIDAD) {
        this.DA_MODALIDAD = DA_MODALIDAD;
    }

    public String getDA_FECHA() {
        return DA_FECHA;
    }

    public void setDA_FECHA(String DA_FECHA) {
        this.DA_FECHA = DA_FECHA;
    }

    public String getDA_RECEPCION_WEB() {
        return DA_RECEPCION_WEB;
    }

    public void setDA_RECEPCION_WEB(String DA_RECEPCION_WEB) {
        this.DA_RECEPCION_WEB = DA_RECEPCION_WEB;
    }

    public String getDA_NUMERO_ORDEN() {
        return DA_NUMERO_ORDEN;
    }

    public void setDA_NUMERO_ORDEN(String DA_NUMERO_ORDEN) {
        this.DA_NUMERO_ORDEN = DA_NUMERO_ORDEN;
    }

    public String getDA_OBSERVACIONES() {
        return DA_OBSERVACIONES;
    }

    public void setDA_OBSERVACIONES(String DA_OBSERVACIONES) {
        this.DA_OBSERVACIONES = DA_OBSERVACIONES;
    }
    
    
    

    

    public BeanCarta_Detalle(String DA_MODALIDAD, String DA_RECEPCION_WEB, String DA_NUMERO_ORDEN, String DA_OBSERVACIONES) {
        
        this.DA_MODALIDAD = DA_MODALIDAD;
        this.DA_RECEPCION_WEB = DA_RECEPCION_WEB;
        this.DA_NUMERO_ORDEN = DA_NUMERO_ORDEN;
        this.DA_OBSERVACIONES = DA_OBSERVACIONES;
      
       
       

    }

    private String DA_ID;
    private String DA_MODALIDAD;
    private String DA_FECHA;
    private String DA_RECEPCION_WEB;
    private String DA_NUMERO_ORDEN;
    private String DA_OBSERVACIONES;
    
    
    public BeanCarta_Detalle() {
    }
}

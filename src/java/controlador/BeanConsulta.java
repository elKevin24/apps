package controlador;

public class BeanConsulta {

    public String getCWBC_COTIZACION() {
        return CWBC_COTIZACION;
    }

    public void setCWBC_COTIZACION(String CWBC_COTIZACION) {
        this.CWBC_COTIZACION = CWBC_COTIZACION;
    }

    public String getCWBC_LR() {
        return CWBC_LR;
    }

    public void setCWBC_LR(String CWBC_LR) {
        this.CWBC_LR = CWBC_LR;
    }

    public String getCWBC_SENAL_DISTINTIVA() {
        return CWBC_SENAL_DISTINTIVA;
    }

    public void setCWBC_SENAL_DISTINTIVA(String CWBC_SENAL_DISTINTIVA) {
        this.CWBC_SENAL_DISTINTIVA = CWBC_SENAL_DISTINTIVA;
    }

    public String getCWBC_BUQUE_VIAJE() {
        return CWBC_BUQUE_VIAJE;
    }

    public void setCWBC_BUQUE_VIAJE(String CWBC_BUQUE_VIAJE) {
        this.CWBC_BUQUE_VIAJE = CWBC_BUQUE_VIAJE;
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

    public String getCWBC_ETA() {
        return CWBC_ETA;
    }

    public void setCWBC_ETA(String CWBC_ETA) {
        this.CWBC_ETA = CWBC_ETA;
    }

    public String getCWBC_TIPO_CAMBIO() {
        return CWBC_TIPO_CAMBIO;
    }

    public void setCWBC_TIPO_CAMBIO(String CWBC_TIPO_CAMBIO) {
        this.CWBC_TIPO_CAMBIO = CWBC_TIPO_CAMBIO;
    }

    public String getCWBC_TIPO_CAMBIO_FECHA() {
        return CWBC_TIPO_CAMBIO_FECHA;
    }

    public void setCWBC_TIPO_CAMBIO_FECHA(String CWBC_TIPO_CAMBIO_FECHA) {
        this.CWBC_TIPO_CAMBIO_FECHA = CWBC_TIPO_CAMBIO_FECHA;
    }

    public String getCWBC_USUARIO_SERVICIO() {
        return CWBC_USUARIO_SERVICIO;
    }

    public void setCWBC_USUARIO_SERVICIO(String CWBC_USUARIO_SERVICIO) {
        this.CWBC_USUARIO_SERVICIO = CWBC_USUARIO_SERVICIO;
    }

    public String getCWBC_NIT() {
        return CWBC_NIT;
    }

    public void setCWBC_NIT(String CWBC_NIT) {
        this.CWBC_NIT = CWBC_NIT;
    }

    public String getCWBC_TIPO_OPERACION() {
        return CWBC_TIPO_OPERACION;
    }

    public void setCWBC_TIPO_OPERACION(String CWBC_TIPO_OPERACION) {
        this.CWBC_TIPO_OPERACION = CWBC_TIPO_OPERACION;
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

    public String getACTUALIZADOR() {
        return ACTUALIZADOR;
    }

    public void setACTUALIZADOR(String ACTUALIZADOR) {
        this.ACTUALIZADOR = ACTUALIZADOR;
    }

    public String getACTUALIZADOR_FECHA() {
        return ACTUALIZADOR_FECHA;
    }

    public void setACTUALIZADOR_FECHA(String ACTUALIZADOR_FECHA) {
        this.ACTUALIZADOR_FECHA = ACTUALIZADOR_FECHA;
    }

    public String getCWBC_ESTADO() {
        return CWBC_ESTADO;
    }

    public void setCWBC_ESTADO(String CWBC_ESTADO) {
        this.CWBC_ESTADO = CWBC_ESTADO;
    }

    public String getCWBC_HORA() {
        return CWBC_HORA;
    }

    public void setCWBC_HORA(String CWBC_HORA) {
        this.CWBC_HORA = CWBC_HORA;
    }

    


    public BeanConsulta(String CWBC_COTIZACION, String CWBC_LR, String CWBC_SENAL_DISTINTIVA, String CWBC_BUQUE_VIAJE,  String BANDERA,
            String CWBC_ETA, String CWBC_TIPO_CAMBIO, String CWBC_TIPO_CAMBIO_FECHA, String CWBC_USUARIO_SERVICIO,  String CWBC_NIT,
            String CWBC_TIPO_OPERACION, String GRABADOR, String GRABADOR_FECHA, String ACTUALIZADOR,  String ACTUALIZADOR_FECHA,
            String CWBC_ESTADO, String CWBC_HORA
    ) {
        
        
        this.CWBC_COTIZACION = CWBC_COTIZACION;
        this.CWBC_LR = CWBC_LR;
        this.CWBC_SENAL_DISTINTIVA = CWBC_SENAL_DISTINTIVA;
        this.CWBC_BUQUE_VIAJE = CWBC_BUQUE_VIAJE;
        this.BANDERA = BANDERA;
        this.CWBC_ETA = CWBC_ETA;
        this.CWBC_TIPO_CAMBIO = CWBC_TIPO_CAMBIO;
        this.CWBC_TIPO_CAMBIO_FECHA = CWBC_TIPO_CAMBIO_FECHA;
        this.CWBC_USUARIO_SERVICIO = CWBC_USUARIO_SERVICIO;
        this.CWBC_NIT = CWBC_NIT;
        this.CWBC_TIPO_OPERACION = CWBC_TIPO_OPERACION;
        this.GRABADOR = GRABADOR;
        this.GRABADOR_FECHA = GRABADOR_FECHA;
        this.ACTUALIZADOR = ACTUALIZADOR;
        this.ACTUALIZADOR_FECHA = ACTUALIZADOR_FECHA;
        this.CWBC_ESTADO = CWBC_ESTADO;
        this.CWBC_HORA = CWBC_HORA;


        
        
    }

    private String CWBC_COTIZACION;
    private String CWBC_LR;
    private String CWBC_SENAL_DISTINTIVA;
    private String CWBC_BUQUE_VIAJE;
    private String NOMBRE_DEL_BUQUE;
    private String BANDERA;
    private String CWBC_ETA;
    private String CWBC_TIPO_CAMBIO;
    private String CWBC_TIPO_CAMBIO_FECHA;
    private String CWBC_USUARIO_SERVICIO;
    private String CWBC_NIT;
    private String CWBC_TIPO_OPERACION;
    private String GRABADOR;
    private String GRABADOR_FECHA;
    private String ACTUALIZADOR;
    private String ACTUALIZADOR_FECHA;
    private String CWBC_ESTADO;
    private String CWBC_HORA;
    
       
    
    public BeanConsulta() {
    }

}

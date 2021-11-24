package controlador;

public class Trazabilidad_Barcos {

    public String getVIAJE_EMPORNAC() {
        return VIAJE_EMPORNAC;
    }

    public void setVIAJE_EMPORNAC(String VIAJE_EMPORNAC) {
        this.VIAJE_EMPORNAC = VIAJE_EMPORNAC;
    }

    public String getNOMBRE_DEL_BUQUE() {
        return NOMBRE_DEL_BUQUE;
    }

    public void setNOMBRE_DEL_BUQUE(String NOMBRE_DEL_BUQUE) {
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
    }

    public String getVIAJE_NAVIERA() {
        return VIAJE_NAVIERA;
    }

    public void setVIAJE_NAVIERA(String VIAJE_NAVIERA) {
        this.VIAJE_NAVIERA = VIAJE_NAVIERA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getSITUACION() {
        return SITUACION;
    }

    public void setSITUACION(String SITUACION) {
        this.SITUACION = SITUACION;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public Trazabilidad_Barcos(String VIAJE_EMPORNAC, String NOMBRE_DEL_BUQUE, String VIAJE_NAVIERA,
            String USUARIO, String SITUACION, String FECHA) {

        this.VIAJE_EMPORNAC = VIAJE_EMPORNAC;
        this.NOMBRE_DEL_BUQUE = NOMBRE_DEL_BUQUE;
        this.VIAJE_NAVIERA = VIAJE_NAVIERA;
        this.USUARIO = USUARIO;
        this.SITUACION = SITUACION;
        this.FECHA = FECHA;

    }

    private String VIAJE_EMPORNAC;
    private String NOMBRE_DEL_BUQUE;
    private String VIAJE_NAVIERA;
    private String USUARIO;
    private String SITUACION;
    private String FECHA;

    public Trazabilidad_Barcos() {
    }

}

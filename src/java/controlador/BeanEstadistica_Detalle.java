package controlador;

public class BeanEstadistica_Detalle {

    public String getCONTENEDOR() {
        return CONTENEDOR;
    }

    public void setCONTENEDOR(String CONTENEDOR) {
        this.CONTENEDOR = CONTENEDOR;
    }

    public String getCONDICION() {
        return CONDICION;
    }

    public void setCONDICION(String CONDICION) {
        this.CONDICION = CONDICION;
    }

    public String getPESO() {
        return PESO;
    }

    public void setPESO(String PESO) {
        this.PESO = PESO;
    }

    public String getMEDIDA() {
        return MEDIDA;
    }

    public void setMEDIDA(String MEDIDA) {
        this.MEDIDA = MEDIDA;
    }

    public String getC_O_F() {
        return C_O_F;
    }

    public void setC_O_F(String C_O_F) {
        this.C_O_F = C_O_F;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    private String CONTENEDOR;
    private String CONDICION;
    private String PESO;
    private String MEDIDA;
    private String C_O_F;
    private String ESTADO;

   

    public BeanEstadistica_Detalle() {
    }

}

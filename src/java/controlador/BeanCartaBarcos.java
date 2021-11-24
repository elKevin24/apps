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
public class BeanCartaBarcos {

    public String getLR() {
        return LR;
    }

    public void setLR(String LR) {
        this.LR = LR;
    }

    public String getSENAL() {
        return SENAL;
    }

    public void setSENAL(String SENAL) {
        this.SENAL = SENAL;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getTRB() {
        return TRB;
    }

    public void setTRB(String TRB) {
        this.TRB = TRB;
    }

    public String getTRN() {
        return TRN;
    }

    public void setTRN(String TRN) {
        this.TRN = TRN;
    }

    public String getTPM() {
        return TPM;
    }

    public void setTPM(String TPM) {
        this.TPM = TPM;
    }

    public String getESTRUCTURA() {
        return ESTRUCTURA;
    }

    public void setESTRUCTURA(String ESTRUCTURA) {
        this.ESTRUCTURA = ESTRUCTURA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    
    

    public BeanCartaBarcos(String LR, String SENAL, String NOMBRE, String ESTRUCTURA, String USUARIO
    ) {

        this.LR = LR;
        this.SENAL = SENAL;
        this.NOMBRE = NOMBRE;
        this.ESTRUCTURA = ESTRUCTURA;
        this.USUARIO = USUARIO;

    }

    private String LR;
    private String SENAL;
    private String NOMBRE;
    private String TRB;
    private String TRN;
    private String TPM;
    private String ESTRUCTURA;
    private String USUARIO;

    public BeanCartaBarcos() {
    }
}

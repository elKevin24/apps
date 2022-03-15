package controlador;

public class Usuario {

    String UPIS_SOLICITUD;
    String UPIS_ID_USUARIO_SERVICIO;
    String UPIS_ID_USUARIO_CREA;
    String UPIS_NOMBRES;
    String UPIS_APELLIDOS;
    String UPIS_PUESTO_EMPRESA;
    String UPIS_CORREO;
    String UPIS_DPI;
    String UPIS_FECHA_NAC;
    String UPIS_FECHA_CREACION;
    String UPIS_ESTADO;
    String UPIS_FECHA_ACTUALIZACION;
    String UPIS_TIPO_USUARIO;
    String UPIS_CATEGORIA;

    public Usuario() {

    }

    public Usuario(
            String UPIS_ID_USUARIO_CREA, 
            String UPIS_ID_USUARIO_SERVICIO, 
            String UPIS_NOMBRES, 
            String UPIS_APELLIDOS, 
            String UPIS_FECHA_NAC, 
            String UPIS_CORREO, 
            String UPIS_PUESTO_EMPRESA,
            String UPIS_DPI, 
            String UPIS_TIPO_USUARIO, 
            String UPIS_CATEGORIA) {

        this.UPIS_ID_USUARIO_SERVICIO = UPIS_ID_USUARIO_SERVICIO;
        this.UPIS_ID_USUARIO_CREA = UPIS_ID_USUARIO_CREA;
        this.UPIS_NOMBRES = UPIS_NOMBRES;
        this.UPIS_APELLIDOS = UPIS_APELLIDOS;
        this.UPIS_PUESTO_EMPRESA = UPIS_PUESTO_EMPRESA;
        this.UPIS_CORREO = UPIS_CORREO;
        this.UPIS_DPI = UPIS_DPI;
        this.UPIS_FECHA_NAC = UPIS_FECHA_NAC;
        this.UPIS_TIPO_USUARIO = UPIS_TIPO_USUARIO;
        this.UPIS_CATEGORIA = UPIS_CATEGORIA;
    }

    public String getUPIS_TIPO_USUARIO() {
        return UPIS_TIPO_USUARIO;
    }

    public void setUPIS_TIPO_USUARIO(String UPIS_TIPO_USUARIO) {
        this.UPIS_TIPO_USUARIO = UPIS_TIPO_USUARIO;
    }

    public String getUPIS_CATEGORIA() {
        return UPIS_CATEGORIA;
    }

    public void setUPIS_CATEGORIA(String UPIS_CATEGORIA) {
        this.UPIS_CATEGORIA = UPIS_CATEGORIA;
    }

    public String getUPIS_SOLICITUD() {
        return UPIS_SOLICITUD;
    }

    public void setUPIS_SOLICITUD(String UPIS_SOLICITUD) {
        this.UPIS_SOLICITUD = UPIS_SOLICITUD;
    }

    public String getUPIS_ID_USUARIO_SERVICIO() {
        return UPIS_ID_USUARIO_SERVICIO;
    }

    public void setUPIS_ID_USUARIO_SERVICIO(String UPIS_ID_USUARIO_SERVICIO) {
        this.UPIS_ID_USUARIO_SERVICIO = UPIS_ID_USUARIO_SERVICIO;
    }

    public String getUPIS_ID_USUARIO_CREA() {
        return UPIS_ID_USUARIO_CREA;
    }

    public void setUPIS_ID_USUARIO_CREA(String UPIS_ID_USUARIO_CREA) {
        this.UPIS_ID_USUARIO_CREA = UPIS_ID_USUARIO_CREA;
    }

    public String getUPIS_NOMBRES() {
        return UPIS_NOMBRES;
    }

    public void setUPIS_NOMBRES(String UPIS_NOMBRES) {
        this.UPIS_NOMBRES = UPIS_NOMBRES;
    }

    public String getUPIS_APELLIDOS() {
        return UPIS_APELLIDOS;
    }

    public void setUPIS_APELLIDOS(String UPIS_APELLIDOS) {
        this.UPIS_APELLIDOS = UPIS_APELLIDOS;
    }

    public String getUPIS_PUESTO_EMPRESA() {
        return UPIS_PUESTO_EMPRESA;
    }

    public void setUPIS_PUESTO_EMPRESA(String UPIS_PUESTO_EMPRESA) {
        this.UPIS_PUESTO_EMPRESA = UPIS_PUESTO_EMPRESA;
    }

    public String getUPIS_CORREO() {
        return UPIS_CORREO;
    }

    public void setUPIS_CORREO(String UPIS_CORREO) {
        this.UPIS_CORREO = UPIS_CORREO;
    }

    public String getUPIS_DPI() {
        return UPIS_DPI;
    }

    public void setUPIS_DPI(String UPIS_DPI) {
        this.UPIS_DPI = UPIS_DPI;
    }

    public String getUPIS_FECHA_NAC() {
        return UPIS_FECHA_NAC;
    }

    public void setUPIS_FECHA_NAC(String UPIS_FECHA_NAC) {
        this.UPIS_FECHA_NAC = UPIS_FECHA_NAC;
    }

    public String getUPIS_FECHA_CREACION() {
        return UPIS_FECHA_CREACION;
    }

    public void setUPIS_FECHA_CREACION(String UPIS_FECHA_CREACION) {
        this.UPIS_FECHA_CREACION = UPIS_FECHA_CREACION;
    }

    public String getUPIS_ESTADO() {
        return UPIS_ESTADO;
    }

    public void setUPIS_ESTADO(String UPIS_ESTADO) {
        this.UPIS_ESTADO = UPIS_ESTADO;
    }

    public String getUPIS_FECHA_ACTUALIZACION() {
        return UPIS_FECHA_ACTUALIZACION;
    }

    public void setUPIS_FECHA_ACTUALIZACION(String UPIS_FECHA_ACTUALIZACION) {
        this.UPIS_FECHA_ACTUALIZACION = UPIS_FECHA_ACTUALIZACION;
    }

}

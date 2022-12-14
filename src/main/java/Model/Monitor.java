package Model;

public class Monitor extends Persona {
    private String carrera;
    private String telefono;
    private String correo;
    private int añosCompañia;
    private String perfil;
    public Monitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia, String perfil) {
        super(nombre, id);
        this.carrera = carrera;
        this.telefono = telefono;
        this.correo = correo;
        this.añosCompañia = añosCompañia;
        this.perfil=perfil;
    }

    public Monitor() {

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getAñosCompañia() {
        return añosCompañia;
    }

    public void setAñosCompañia(int añosCompañia) {
        this.añosCompañia = añosCompañia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}

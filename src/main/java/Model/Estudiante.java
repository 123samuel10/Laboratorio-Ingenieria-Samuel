package Model;

import javafx.beans.property.SimpleStringProperty;

public class Estudiante extends Persona {


    private String carrera;
    private String telefono;
    private String correoElectronico;

    private String perfil;


    public Estudiante(String nombre, String id, String carrera, String telefono, String correoElectronico, String perfil) {
        super(nombre, id);
        this.carrera = carrera;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.perfil = perfil;
    }

    public Estudiante() {
        super();
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

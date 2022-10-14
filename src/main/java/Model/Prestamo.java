package Model;

import Controler.EstudianteController;

import java.util.ArrayList;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;
    private String codigo;
    private String id;
    private String nombre;
    private String perfil;

    public Prestamo(String fechaInicial,String fechaFinal,String id, String nombre, String perfil) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.id = id;
        this.nombre = nombre;
        this.perfil = perfil;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

}



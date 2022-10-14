package Model;

import Controler.EstudianteController;

import java.util.ArrayList;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;

    private String codigo;
    private Estudiante estudiante;
    private Monitor monitor;





    public Prestamo(String fechaInicial,String fechaFinal,Estudiante estudiante,Monitor monitor) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.estudiante=estudiante;
        this.monitor=monitor;

    }

    public Prestamo(String fecha, String fechaFinal, String codigo, ArrayList<Estudiante> estudiantes) {
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}



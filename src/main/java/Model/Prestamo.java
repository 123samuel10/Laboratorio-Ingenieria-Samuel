package Model;

import Controler.EstudianteController;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;

    private Estudiante estudiante;





    public Prestamo(String fechaInicial,String fechaFinal, Estudiante estudiante) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.estudiante=estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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



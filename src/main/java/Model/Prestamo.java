package Model;

import Controler.EstudianteController;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;

    private EstudianteController estudiante;





    public Prestamo(String fechaInicial,String fechaFinal, EstudianteController estudiante) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.estudiante=estudiante;
    }

    public EstudianteController getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteController estudiante) {
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



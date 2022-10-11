package Model;

import Controler.EstudianteController;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;

    private String codigo;
    private Estudiante estudiante;





    public Prestamo(String fechaInicial,String fechaFinal, String codigo,Estudiante estudiante) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.codigo=codigo;
        this.estudiante=estudiante;
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
}



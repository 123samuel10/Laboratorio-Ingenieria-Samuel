package Model;

import Controler.EstudianteController;

public class Prestamo {

    private String fechaInicial;
    private String fechaFinal;

    private String codigo;
    private EstudianteController estudianteController;





    public Prestamo(String fechaInicial,String fechaFinal, String codigo,EstudianteController estudianteController) {
        this.fechaInicial=fechaInicial;
        this.fechaFinal=fechaFinal;
        this.codigo=codigo;
        this.estudianteController=estudianteController;
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

    public EstudianteController getEstudianteController() {
        return estudianteController;
    }

    public void setEstudianteController(EstudianteController estudianteController) {
        this.estudianteController = estudianteController;
    }
}



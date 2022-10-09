package Model;

public class Prestamo {

    private String fecha;

    private Estudiante estudiante;





    public Prestamo(String fecha,Estudiante estudiante) {
        this.fecha = fecha;
        this.estudiante=estudiante;

    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}



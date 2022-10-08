package service;

public interface EstudianteService {
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo);

    boolean buscar(String nombre,String tabla);

    boolean eliminar(String nombre);

}

package service;

import Model.Estudiante;

import java.util.ArrayList;

public interface EstudianteService {
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo);

    boolean buscar(String nombre);

    boolean eliminar(String codigo);



}

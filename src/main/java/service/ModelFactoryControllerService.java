package service;

import Controler.EstudianteController;
import Model.Estudiante;
import Model.Monitor;

import java.util.ArrayList;

public interface ModelFactoryControllerService {
    //estudiante
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo);
    boolean eliminar(String nombre);


    boolean buscar(String codigo);

    //monitor
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia);
    boolean eliminarMonitor(String nombre);
    boolean buscarMonitor(String codigo);


    //prestamo
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String codigo,Estudiante estudiante);




}

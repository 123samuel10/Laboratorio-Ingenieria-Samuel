package service;

import Controler.EstudianteController;
import Model.Estudiante;
import Model.Monitor;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface ModelFactoryControllerService {
    //estudiante
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo,String perfil);
    boolean eliminar(String nombre);


    boolean buscar(String codigo);

    //monitor
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia,String perfil);
    boolean eliminarMonitor(String nombre);
    boolean buscarMonitor(String codigo);


    //prestamo
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String nombre,String perfil,String id);




}

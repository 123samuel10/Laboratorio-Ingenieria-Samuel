package service;

public interface ModelFactoryControllerService {
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo);
    boolean buscar(String nombre);
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo,int añosCompañia);



}

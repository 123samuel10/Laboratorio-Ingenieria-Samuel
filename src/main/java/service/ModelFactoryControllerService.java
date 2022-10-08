package service;

public interface ModelFactoryControllerService {
    boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo);
    boolean eliminar(String nombre);
    boolean buscar(String nombre,String tabla);
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo,int añosCompañia);
    boolean eliminarMonitor(String nombre);
    boolean buscarMonitor(String nombre,String tabla);




}

package service;

public interface MonitorService {
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo,int añosCompañia);
    boolean eliminarMonitor(String nombre);
    boolean buscarMonitro(String nombre,String tabla);
}

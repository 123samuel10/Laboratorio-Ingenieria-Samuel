package service;

public interface MonitorService {
    boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo,int añosCompañia,String perfil);
    boolean eliminarMonitor(String nombre);
    boolean buscarMonitro(String codigo);
}

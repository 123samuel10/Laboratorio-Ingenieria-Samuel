package service;

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
    boolean cantidadPrestamosRealizadoMonitor(String nombre);




}

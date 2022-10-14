package service;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String nombre,String perfil,String id);

    boolean cantidadPrestamosRealizadoMonitor(String nombre);




}

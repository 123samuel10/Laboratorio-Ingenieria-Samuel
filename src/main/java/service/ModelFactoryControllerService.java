package service;

import Model.Monitor;
import Model.Prestamo;
import javafx.scene.control.TableColumn;

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
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String id,String nombre,String perfil);
    boolean cantidadPrestamosRealizadoMonitor(int size);
    boolean estudianteConMaPrestamos();
    void calcular(String fechaFinal);





}

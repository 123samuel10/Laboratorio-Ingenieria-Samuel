package service;

import Model.Monitor;
import Model.Prestamo;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String id,String nombre,String perfil);
    boolean cantidadPrestamosRealizadoMonitor(int size);
    boolean estudianteConMaPrestamos();
    void calcular(String fechaFinal);






}

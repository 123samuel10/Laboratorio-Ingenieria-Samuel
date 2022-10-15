package service;

import Model.Prestamo;
import javafx.scene.control.TableColumn;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String nombre,String perfil,String id);
    boolean cantidadPrestamosRealizadoMonitor();
    boolean estudianteConMaPrestamos();
    void calcular(String fechaFinal);






}

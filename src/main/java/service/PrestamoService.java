package service;

import Model.Prestamo;
import javafx.scene.control.TableColumn;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,String id,String nombre,String perfil);
    boolean cantidadPrestamosRealizadoMonitor();
    boolean estudianteConMaPrestamos();
    void calcular(String fechaFinal);






}

package Controler;

import Model.Monitor;
import Model.Prestamo;
import javafx.scene.control.TableColumn;
import service.ModelFactoryControllerService;
import service.impl.Laboratorio;

import java.util.ArrayList;

public class ModelFactoryController implements ModelFactoryControllerService {

    Laboratorio laboratorio;


    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        laboratorio = new Laboratorio();
    }

    @Override
    public boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo,String perfil) {
        return laboratorio.getEstudianteService().agregarEstudiante(nombre,id,carrera,telefono,correo,perfil);

    }

    @Override
    public boolean eliminar(String nombre) {
        return laboratorio.getEstudianteService().eliminar(nombre);
    }



    @Override
    public boolean buscar(String codigo) {
        return laboratorio.getEstudianteService().buscar(codigo);
    }

    //parte monitor

    @Override
    public boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia,String perfil) {
        return laboratorio.getMonitorService().agregarMonitor(nombre,id,carrera,telefono,correo,añosCompañia,perfil);
    }

    @Override
    public boolean eliminarMonitor(String nombre) {
        return laboratorio.getMonitorService().eliminarMonitor(nombre);
    }

    @Override
    public boolean buscarMonitor(String codigo) {
        return laboratorio.getMonitorService().buscarMonitro(codigo);
    }

    //prestamo
    @Override
    public boolean enviarCodigoPersona(String fechaInicial, String fechaFinal,String id,String nombre,String perfil) {
        return laboratorio.getPrestamoService().enviarCodigoPersona(fechaInicial,fechaFinal,id,nombre,perfil);
    }





    @Override
    public boolean cantidadPrestamosRealizadoMonitor(int size) {
        return laboratorio.getPrestamoService().cantidadPrestamosRealizadoMonitor(size);

    }



    @Override
    public boolean estudianteConMaPrestamos() {
        return laboratorio.getPrestamoService().estudianteConMaPrestamos();
    }

    @Override
    public void calcular(String fechaFinal) {
        laboratorio.getPrestamoService().calcular(fechaFinal);
    }


}

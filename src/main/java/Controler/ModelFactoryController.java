package Controler;

import service.ModelFactoryControllerService;
import service.impl.Laboratorio;

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
    public boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {
        return laboratorio.getEstudianteService().agregarEstudiante(nombre,id,carrera,telefono,correo);

    }

    @Override
    public boolean buscar(String nombre) {
        return laboratorio.getEstudianteService().buscar(nombre);
    }

    @Override
    public boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia) {
        return laboratorio.getMonitorService().agregarMonitor(nombre,id,carrera,telefono,correo,añosCompañia);
    }


}

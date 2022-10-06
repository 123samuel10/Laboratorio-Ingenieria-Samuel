package Controler;

import service.ModelFactoryControllerService;

public class ModelFactoryController implements ModelFactoryControllerService {


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
    //    laboratorio = new Laboratorio();
    }

    @Override
    public void agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {

    }
}

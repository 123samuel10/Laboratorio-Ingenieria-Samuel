package service.impl;


import Controler.EstudianteController;
import Controler.ModelFactoryController;
import Model.Estudiante;
import Model.Monitor;
import Model.Prestamo;
import service.PrestamoService;

import java.util.ArrayList;

public class PrestamoServiceImpl implements PrestamoService {
    ArrayList<Prestamo>prestamos=new ArrayList<>();

    EstudianteController estudianteController=new EstudianteController();

    @Override
    public boolean enviarCodigoPersona(String fechaInicial,String fechaFinal, String  codigo,EstudianteController estudianteController){
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fechaInicial,fechaFinal,codigo, (EstudianteController) estudianteController.getEstudiantes()));
        for (int i=0;i<prestamos.size();i++){
            if (codigo.equals(estudianteController.getEstudiantes().get(i).getId())) {
                System.out.println(fechaInicial);
                System.out.println(fechaFinal);
                System.out.println("EL NOMBRE ES:"+estudianteController.getEstudiantes().get(i).getNombre());

            }
        }

        return true;
    }
}

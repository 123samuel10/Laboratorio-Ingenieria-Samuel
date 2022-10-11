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
    public boolean enviarCodigoPersona(String fechaInicial,String fechaFinal, String  codigo,Estudiante estudiante,Monitor monitor){
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fechaInicial,fechaFinal,codigo,estudiante,monitor));
        for (int i=0;i<prestamos.size();i++){
            if (prestamos.get(i)!=null) {
                System.out.println(fechaInicial);
                System.out.println(fechaFinal);

            }
        }

        return true;
    }
}

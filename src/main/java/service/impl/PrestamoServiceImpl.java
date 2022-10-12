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

    EstudianteServiceImpl estudianteService=new EstudianteServiceImpl();

    @Override
    public boolean enviarCodigoPersona(String fechaInicial,String fechaFinal, String  codigo){
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fechaInicial,fechaFinal,codigo));
        for (int i=0;i<prestamos.size();i++){
            System.out.println("siu");
            if (prestamos.get(i)!=null) {
                System.out.println(fechaInicial);
                System.out.println(fechaFinal);
            }

        }


        return true;
    }
}

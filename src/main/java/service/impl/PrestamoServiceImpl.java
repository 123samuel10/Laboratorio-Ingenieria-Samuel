package service.impl;


import Controler.EstudianteController;
import Model.Estudiante;
import Model.Monitor;
import Model.Prestamo;
import service.PrestamoService;

import java.util.ArrayList;

public class PrestamoServiceImpl implements PrestamoService {
    ArrayList<Prestamo>prestamos=new ArrayList<>();


    @Override
    public boolean enviarCodigoPersona(String fechaInicial,String fechaFinal, Estudiante  estudiante){
        System.out.println("entro al prestamo"+estudiante);
        prestamos.add(new Prestamo(fechaInicial,fechaFinal,estudiante));
        for (int i=0;i<prestamos.size();i++){
            if (prestamos!=null){
                System.out.println(prestamos.get(i).getFechaInicial());
                System.out.println(prestamos.get(i).getFechaFinal());
                System.out.println(estudiante);
            }

        }

        return true;
    }
}

package service.impl;


import Model.Estudiante;
import Model.Monitor;
import Model.Prestamo;
import service.PrestamoService;

import java.util.ArrayList;

public class PrestamoServiceImpl implements PrestamoService {
    ArrayList<Prestamo>prestamos=new ArrayList<>();


    @Override
    public boolean enviarCodigoPersona(String fecha) {
        System.out.println("entro al prestamo");
        prestamos.add(new Prestamo(fecha));
        System.out.println(prestamos);
        return true;
    }
}

package service.impl;

import Model.Monitor;
import service.MonitorService;

import java.util.ArrayList;

public class MonitorServiceImlp implements MonitorService {
    ArrayList<Monitor>monitors=new ArrayList<>();


    @Override
    public boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia) {
        System.out.println("entro");
        this.monitors.add(new Monitor(nombre,id,carrera,telefono,correo,añosCompañia));
        System.out.println(monitors);
        return true;
    }
}

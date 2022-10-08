package service.impl;

import Model.Monitor;
import javafx.scene.control.Alert;
import service.MonitorService;

import java.util.ArrayList;

public class MonitorServiceImlp implements MonitorService {
    ArrayList<Monitor> monitors = new ArrayList<>();


    @Override
    public boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia) {
        System.out.println("entro");
        this.monitors.add(new Monitor(nombre, id, carrera, telefono, correo, añosCompañia));
        System.out.println(monitors);
        return true;
    }

    @Override
    public boolean eliminarMonitor(String nombre) {
        for (int i = 0; i < monitors.size(); i++) {
            if (monitors.get(i).getNombre().equals(nombre)) {
                monitors.remove(monitors.get(i));
            }
        }
        return true;
    }

    @Override
    public boolean buscarMonitro(String nombre,String tabla) {
        for (int i = 0; i < monitors.size(); i++) {
            if (tabla!=null && nombre.equals(tabla)) {
                System.out.println("alerta");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SE HA ENCONTRADO SUS DATOS SON:");
                alert.setContentText("TELEFONO: "+monitors.get(i).getTelefono()+" "+"EMAIL: "+monitors.get(i).getCorreo()+" "+"CARRERA: "+monitors.get(i).getCarrera());
                alert.showAndWait();
                alert.getAlertType();
                break;
            } else if (tabla==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" NO ENCONTRADO");
                alert.setContentText("NO ENCONTRADO");
                alert.showAndWait();
            }
        }
        return true;
    }
}

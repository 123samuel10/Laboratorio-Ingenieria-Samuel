package service.impl;

import Model.Estudiante;
import Model.Monitor;
import javafx.scene.control.Alert;
import service.MonitorService;

import java.util.ArrayList;

public class MonitorServiceImlp implements MonitorService {
    ArrayList<Monitor> monitors = new ArrayList<>();


    @Override
    public boolean agregarMonitor(String nombre, String id, String carrera, String telefono, String correo, int añosCompañia,String perfil) {
        System.out.println("entro");
        this.monitors.add(new Monitor(nombre, id, carrera, telefono, correo, añosCompañia,perfil));
        System.out.println("***************************");


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
    public boolean buscarMonitro(String codigo) {
        for (int i = 0; i < monitors.size(); i++) {
            if (monitors != null && monitors.get(i).getId().equals(codigo)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SE HA ENCONTRADO SUS DATOS SON:");
                alert.setContentText("NOMBRE:" + " " + monitors.get(i).getNombre() + " " + "TELEFONO: " + monitors.get(i).getTelefono() + " " + "EMAIL: " + monitors.get(i).getCorreo() + " " + "CARRERA: " +monitors.get(i).getCarrera());
                alert.showAndWait();
                alert.getAlertType();
                break;
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("NO HAY NADA");
            }
        }
        return true;
    }

    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }


}

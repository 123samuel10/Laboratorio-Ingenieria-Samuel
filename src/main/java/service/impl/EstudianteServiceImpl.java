package service.impl;

import Controler.EstudianteController;
import Model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import service.EstudianteService;

import java.util.ArrayList;

public class EstudianteServiceImpl implements EstudianteService {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();

    @Override
    public boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {
        System.out.println("entro");
        this.estudiantes.add(new Estudiante(nombre, id, carrera, telefono, correo));
        System.out.println(estudiantes);
        return true;
    }

    @Override
    public boolean eliminar(String nombre) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i) != null && estudiantes.get(i).getNombre().equals(nombre)) {
                estudiantes.remove(estudiantes.get(i));
            }

        }
        return true;
    }



    @Override
    public boolean buscar(String codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {

                if (estudiantes != null && estudiantes.get(i).getId().equals(codigo)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("SE HA ENCONTRADO SUS DATOS SON:");
                    alert.setContentText("NOMBRE:" + " " + estudiantes.get(i).getNombre() + " " + "TELEFONO: " + estudiantes.get(i).getTelefono() + " " + "EMAIL: " + estudiantes.get(i).getCorreoElectronico() + " " + "CARRERA: " + estudiantes.get(i).getCarrera());
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



}

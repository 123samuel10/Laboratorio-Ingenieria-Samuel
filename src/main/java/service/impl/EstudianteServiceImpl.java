package service.impl;

import Model.Estudiante;
import javafx.scene.control.Alert;
import service.EstudianteService;

import java.util.ArrayList;

public class EstudianteServiceImpl implements EstudianteService {
    ArrayList<Estudiante>estudiantes=new ArrayList<>();
    @Override
    public boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {
        this.estudiantes.add(new Estudiante(nombre, id, carrera, telefono, correo));
        System.out.println(estudiantes);
        return true;
    }

    @Override
    public boolean buscar(String nombre) {
        System.out.println(estudiantes);
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i).getNombre());
            if (estudiantes.get(i).getNombre().equals(nombre)) {
                System.out.println("alerta");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ENCONTRADO");
                alert.setContentText("ENCONTRADO");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(" NO ENCONTRADO");
                alert.setContentText("NO ENCONTRADO");
                alert.showAndWait();
            }
        }
        return true;
    }



}

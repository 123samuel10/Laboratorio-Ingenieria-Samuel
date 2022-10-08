package service.impl;

import Model.Estudiante;
import javafx.scene.control.Alert;
import service.EstudianteService;

import java.util.ArrayList;

public class EstudianteServiceImpl implements EstudianteService {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();

    @Override
    public boolean agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {
        this.estudiantes.add(new Estudiante(nombre, id, carrera, telefono, correo));
        System.out.println(estudiantes);
        return true;
    }
    @Override
    public boolean eliminar(String nombre) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i) != null && estudiantes.get(i).getNombre().equals(nombre)) {
                System.out.println(estudiantes.get(i).getNombre() + "eliminado");
                estudiantes.remove(estudiantes.get(i));

            }

        }
        return true;
    }


    @Override
    public boolean buscar(String nombre,String tabla) {

            System.out.println(estudiantes);
            for (int i = 0; i < estudiantes.size(); i++) {

                if (tabla!=null && nombre.equals(tabla)) {
                    System.out.println("alerta");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("SE HA ENCONTRADO SUS DATOS SON:");
                    alert.setContentText("TELEFONO: "+estudiantes.get(i).getTelefono()+" "+"EMAIL: "+estudiantes.get(i).getCorreoElectronico()+" "+"CARRERA: "+estudiantes.get(i).getCarrera());
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

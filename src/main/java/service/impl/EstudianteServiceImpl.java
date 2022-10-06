package service.impl;

import Model.Estudiante;
import service.EstudianteService;

import java.util.ArrayList;

public class EstudianteServiceImpl implements EstudianteService {
    ArrayList<Estudiante>estudiantes=new ArrayList<>();
    @Override
    public void agregarEstudiante(String nombre, String id, String carrera, String telefono, String correo) {
        for (int i=0;i<estudiantes.size();i++){
            if(estudiantes.get(i)==null){
                this.estudiantes.add(new Estudiante(nombre,id,carrera,telefono,correo));
                break;
            }

        }
    }
}

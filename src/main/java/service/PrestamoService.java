package service;

import Controler.EstudianteController;
import Model.Estudiante;
import Model.Monitor;
import javafx.collections.ObservableList;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal,Estudiante estudiante,Monitor monitor);




}

package service;

import Controler.EstudianteController;
import Model.Estudiante;
import Model.Monitor;

public interface PrestamoService {
    boolean enviarCodigoPersona(String fechaInicial,String fechaFinal, EstudianteController estudianteController);


}

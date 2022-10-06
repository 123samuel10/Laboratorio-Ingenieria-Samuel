package service.impl;

public class Laboratorio {

    private EstudianteServiceImpl  estudianteService;

    public Laboratorio() {
        this.estudianteService = new EstudianteServiceImpl();
    }

    public EstudianteServiceImpl getEstudianteService() {
        return estudianteService;
    }

}

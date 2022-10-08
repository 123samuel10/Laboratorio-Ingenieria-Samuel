package service.impl;

public class Laboratorio {

    private EstudianteServiceImpl estudianteService;
    private MonitorServiceImlp monitorService;

    public Laboratorio() {
        this.estudianteService = new EstudianteServiceImpl();
        this.monitorService = new MonitorServiceImlp();
    }

    public EstudianteServiceImpl getEstudianteService() {
        return estudianteService;
    }

    public MonitorServiceImlp getMonitorService() {
        return monitorService;
    }
}

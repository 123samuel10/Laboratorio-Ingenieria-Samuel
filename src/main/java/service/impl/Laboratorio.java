package service.impl;

public class Laboratorio {

    private EstudianteServiceImpl estudianteService;
    private MonitorServiceImlp monitorService;
    private PrestamoServiceImpl prestamoService;

    public Laboratorio() {
        this.estudianteService = new EstudianteServiceImpl();
        this.monitorService = new MonitorServiceImlp();
        this.prestamoService=new PrestamoServiceImpl();
    }

    public EstudianteServiceImpl getEstudianteService() {
        return estudianteService;
    }

    public MonitorServiceImlp getMonitorService() {
        return monitorService;
    }

    public PrestamoServiceImpl getPrestamoService() {
        return prestamoService;
    }
}

package Controler;

import Model.Estudiante;
import Model.Monitor;
import com.example.democoeducuelaboratorioingenieriasamuel.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.MonitorService;
import service.impl.EstudianteServiceImpl;
import service.impl.MonitorServiceImlp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MonitorController implements Initializable {
    ModelFactoryController mfc = new ModelFactoryController();

    public void botonPadreMonitores(ActionEvent actionEvent) {
    }

    //texfiel
    @FXML
    private TextField antiguedadEscribir;
    @FXML
    private TextField carreraEscribir;
    @FXML
    private TextField correodEscribir;
    @FXML
    private TextField idEscribir;
    @FXML
    private TextField nombreEscribir;
    @FXML
    private TextField telefonoEscribir;

    //tablas
    @FXML
    private TableView<Model.Monitor> tablaMonitor;
    @FXML
    private TableColumn<Model.Monitor, Integer> antiguedadMostrar;
    @FXML
    private TableColumn<Model.Monitor, String> carreraMostrar;
    @FXML
    private TableColumn<Model.Monitor, String> correoMostrar;
    @FXML
    private TableColumn<Model.Monitor, String> idMostrar;
    @FXML
    private TableColumn<Model.Monitor, String> nombreMostrar;
    @FXML
    private TableColumn<Model.Monitor, String> telefonoMostrar;
    private ObservableList<Monitor> monitors;
    private ObservableList<Monitor> filtrarMonitor;

    private MonitorServiceImlp monitorServiceImlp=new MonitorServiceImlp();

    private EstudianteServiceImpl estudianteService;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monitors = FXCollections.observableArrayList();
        filtrarMonitor=FXCollections.observableArrayList();

        this.nombreMostrar.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.idMostrar.setCellValueFactory(new PropertyValueFactory("id"));
        this.carreraMostrar.setCellValueFactory(new PropertyValueFactory("carrera"));
        this.telefonoMostrar.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.correoMostrar.setCellValueFactory(new PropertyValueFactory("correo"));
        this.antiguedadMostrar.setCellValueFactory(new PropertyValueFactory("añosCompañia"));
    }

    void initData(EstudianteServiceImpl estudianteService, MonitorServiceImlp monitorService) {
        this.estudianteService = estudianteService;
        this.monitorServiceImlp = monitorService;
    }


    @FXML
    void btnEstudiantes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estudiante.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        EstudianteController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorServiceImlp);
        fxmlLoader.setController(controller);
        stage3.show();
    }

    @FXML
    void btnPrestamo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Prestamo.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        PrestamoController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorServiceImlp);
        fxmlLoader.setController(controller);
        stage3.show();
    }
    //botones
    @FXML
    void añadir(ActionEvent event) {
        String nombre = null;
        String id = null;
        String carrera = null;
        String correo = null;
        String telefono = null;
        String perfil=null;
        int añosAntiguedad = 0;

        try {
            nombre = this.nombreEscribir.getText();
            id = this.idEscribir.getText();
            carrera = this.carreraEscribir.getText();
            correo = this.correodEscribir.getText();
            telefono = this.telefonoEscribir.getText();
            añosAntiguedad = Integer.parseInt(this.antiguedadEscribir.getText());
            perfil="Monitor";
           this.monitorServiceImlp.agregarMonitor(nombre,id,carrera,correo,telefono,añosAntiguedad,perfil);
            if ("" != nombreEscribir.getText()) {
                monitors.add(new Monitor(nombre, id, carrera, telefono, correo, añosAntiguedad,perfil));
                tablaMonitor.setItems(monitors);
                tablaMonitor.refresh();
                refrescar();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("MENSAJE DE INFORMACION");
                alert.setTitle("Dialogo de advertencia");
                alert.setContentText("Es necesario llenar los campos");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("NO SE HA CREADO EL MONITOR");
            alert.showAndWait();
        }
        mfc.agregarMonitor(nombre, id, carrera, telefono, correo, añosAntiguedad,perfil);
    }
    @FXML
    void eliminar(ActionEvent event) {
        Monitor monitor = this.tablaMonitor.getSelectionModel().getSelectedItem();//selccionar
        if (monitor == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder eliminar");
            alert.showAndWait();
        } else {
            mfc.eliminarMonitor(String.valueOf(monitors.remove(monitor)));
        }
    }
    @FXML
    private TextField buscarMonitor;
    @FXML
    void buscar(ActionEvent event) {
        mfc.buscarMonitor(buscarMonitor.getText());
    }
    @FXML
    void seleccionar(ActionEvent event) {
        Monitor monitor = this.tablaMonitor.getSelectionModel().getSelectedItem();//selecionar
        if (monitor != null) {
            this.nombreEscribir.setText(monitor.getNombre());
            this.idEscribir.setText(monitor.getId());
            this.carreraEscribir.setText(monitor.getCarrera());
            this.correodEscribir.setText(monitor.getCorreo());
            this.telefonoEscribir.setText(monitor.getTelefono());
            this.antiguedadEscribir.setText(String.valueOf(monitor.getAñosCompañia()));
        }
    }
    @FXML
    void modificar(ActionEvent event) {
        Monitor monitor = this.tablaMonitor.getSelectionModel().getSelectedItem();
        if (monitor == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder modificar");
            alert.showAndWait();
        } else {
            String nombre = this.nombreEscribir.getText();
            String id = this.idEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            String correo = this.correodEscribir.getText();
            String telefono = this.telefonoEscribir.getText();
            int añosAntiguedad = Integer.parseInt(this.antiguedadEscribir.getText());
            String  perfil="Monitor";
            Monitor aux = new Monitor(nombre, id, carrera, telefono, correo, añosAntiguedad,perfil);
            if (!this.monitors.contains(aux)) {//si no contiene el aux
                monitor.setNombre(aux.getNombre());
                monitor.setId(aux.getId());
                monitor.setCarrera(aux.getCarrera());
                monitor.setCorreo(aux.getCorreo());
                monitor.setTelefono(aux.getTelefono());
                monitor.setAñosCompañia(aux.getAñosCompañia());
                this.tablaMonitor.refresh();
                refrescar();
            }
        }
    }
    void refrescar() {
        nombreEscribir.setText("");
        idEscribir.setText("");
        correodEscribir.setText("");
        carreraEscribir.setText("");
        telefonoEscribir.setText("");
        antiguedadEscribir.setText("");
    }
    @FXML
    void filtrarMonitor(KeyEvent event) {
        String filtroCodigo=this.buscarMonitor.getText();
        if (filtroCodigo.isEmpty()){
            this.tablaMonitor.setItems(monitors);
        }else {
            this.filtrarMonitor.clear();
            for (Monitor m:this.monitors){
                if (m.getId().contains(filtroCodigo)){
                    this.filtrarMonitor.add(m);
                }
            }
            this.tablaMonitor.setItems(filtrarMonitor);
        }
    }

    public ObservableList<Monitor> getMonitors() {
        return monitors;
    }
}

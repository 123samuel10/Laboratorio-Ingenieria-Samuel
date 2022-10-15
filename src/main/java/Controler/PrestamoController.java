package Controler;

import Model.Estudiante;
import Model.Monitor;
import Model.Prestamo;
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
import service.EstudianteService;
import service.PrestamoService;
import service.impl.EstudianteServiceImpl;
import service.impl.MonitorServiceImlp;
import service.impl.PrestamoServiceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class PrestamoController implements Initializable {

    ModelFactoryController mfc = new ModelFactoryController();

    public void btnPadrePrestamo(ActionEvent actionEvent) {
    }

    @FXML
    private TextField escribirCodigoPersona;


    @FXML
    private TextField fechaEscribir;

    @FXML
    private TextField fechaFinalEscribir;

    //tablas
    @FXML
    private TableColumn<Model.Persona,String > nombrePersona;
    @FXML
    private TableColumn<Model.Prestamo, String> fechaPrestamo;

    @FXML
    private TableColumn<Model.Prestamo, String> fechaFinalMostrar;
    @FXML
    private TableColumn<Model.Estudiante, String> mostrarPerfil;

    @FXML
    private TableColumn<?, ?> mostrarID;
    @FXML
    private TableView<Prestamo> tablaPrestamo;

    private ObservableList<Prestamo> prestamo;
    private ObservableList<Prestamo>filtrarCodigo;

    private EstudianteServiceImpl estudianteService;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prestamo = FXCollections.observableArrayList();
        filtrarCodigo=FXCollections.observableArrayList();
        this.fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fechaInicial"));
        this.fechaFinalMostrar.setCellValueFactory(new PropertyValueFactory("fechaFinal"));
        this.nombrePersona.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.mostrarPerfil.setCellValueFactory(new PropertyValueFactory("perfil"));
        this.mostrarID.setCellValueFactory(new PropertyValueFactory("id"));

    }

    @FXML
    void btnEstudiantes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estudiante.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        EstudianteController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorService);
        fxmlLoader.setController(controller);
        stage3.show();
    }

    @FXML
    void btnMonitor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Monitor.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        MonitorController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorService);
        fxmlLoader.setController(controller);
        stage3.show();

    }

    void initData(EstudianteServiceImpl estudianteService, MonitorServiceImlp monitorService) {
        this.estudianteService = estudianteService;
        this.monitorService = monitorService;
    }

    MonitorServiceImlp monitorService=new MonitorServiceImlp();

    Date date=new Date();

    @FXML
    void enviarCodigoPersona(ActionEvent event) {
        String fecha = null;
        String fechaFinal = null;
        String codigo = escribirCodigoPersona.getText();

            fecha= "DIA: "+date.getDate();
            fechaFinal=fechaFinalEscribir.getText();
            System.out.println(this.estudianteService.getEstudiantes().size());
            for (int i = 0; i < this.estudianteService.getEstudiantes().size(); i++) {
                if (estudianteService.getEstudiantes().get(i).getId().equals(codigo)) {
                    System.out.println(estudianteService.getEstudiantes().get(i).getNombre());
                    prestamo.add(new Prestamo(fecha, fechaFinal, this.estudianteService.getEstudiantes().get(i).getId(), this.estudianteService.getEstudiantes().get(i).getNombre(), this.estudianteService.getEstudiantes().get(i).getPerfil()));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();

                }
                mfc.enviarCodigoPersona(fecha, fechaFinal,this.estudianteService.getEstudiantes().get(i).getId(), this.estudianteService.getEstudiantes().get(i).getNombre(), this.estudianteService.getEstudiantes().get(i).getPerfil());
            }
            for (int i = 0; i < this.monitorService.getMonitors().size(); i++) {
                if (monitorService.getMonitors().get(i).getId().equals(codigo)) {
                    System.out.println(monitorService.getMonitors().get(i).getNombre());
                    prestamo.add(new Prestamo(fecha, fechaFinal, this.monitorService.getMonitors().get(i).getId(), this.monitorService.getMonitors().get(i).getNombre(), this.monitorService.getMonitors().get(i).getPerfil()));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();
                }
                mfc.enviarCodigoPersona(fecha, fechaFinal,this.monitorService.getMonitors().get(i).getId(), this.monitorService.getMonitors().get(i).getNombre(), this.monitorService.getMonitors().get(i).getPerfil());
            }
            mfc.calcular(fechaFinalEscribir.getText());
    }

    @FXML
    private TextField idFiltrarCodigo;
    @FXML
    void filtrarCodigo(KeyEvent event) {
        String filtroCodigo = this.idFiltrarCodigo.getText();
        if (filtroCodigo.isEmpty()) {
            this.tablaPrestamo.setItems(prestamo);
        } else {
            this.filtrarCodigo.clear();
            for (Prestamo p : this.prestamo) {
                if (p.getId().contains(filtroCodigo)) {
                    this.filtrarCodigo.add(p);
                }
            }
            this.tablaPrestamo.setItems(filtrarCodigo);
        }
    }

    @FXML
    void btnCantidadPrestamoMonitores(ActionEvent event) {
        mfc.cantidadPrestamosRealizadoMonitor();
    }


    @FXML
    void estudianteConMasPrestamos(ActionEvent event) {
        mfc.estudianteConMaPrestamos();
    }


}






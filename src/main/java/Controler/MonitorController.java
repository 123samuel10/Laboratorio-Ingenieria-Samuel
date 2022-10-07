package Controler;

import Model.Monitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MonitorController implements Initializable {
    ModelFactoryController mfc=new ModelFactoryController();

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
    private TableColumn<Model.Monitor,Integer> antiguedadMostrar;


    @FXML
    private TableColumn<Model.Monitor,String>carreraMostrar;

    @FXML
    private TableColumn<Model.Monitor,String> correoMostrar;


    @FXML
    private TableColumn<Model.Monitor,String> idMostrar;



    @FXML
    private TableColumn<Model.Monitor,String > nombreMostrar;



    @FXML
    private TableColumn<Model.Monitor,String> telefonoMostrar;
    private ObservableList<Monitor>monitors;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monitors= FXCollections.observableArrayList();
        this.nombreMostrar.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.idMostrar.setCellValueFactory(new PropertyValueFactory("id"));
        this.carreraMostrar.setCellValueFactory(new PropertyValueFactory("carrera"));
        this.telefonoMostrar.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.correoMostrar.setCellValueFactory(new PropertyValueFactory("correo"));
        this.antiguedadMostrar.setCellValueFactory(new PropertyValueFactory("añosCompañia"));
    }

    //botones

    @FXML
    void añadir(ActionEvent event) {
        String nombre = null;
        String id = null;
        String carrera = null;
        String correo = null;
        String telefono = null;
        int añosAntiguedad= 0;
        try {
            nombre = this.nombreEscribir.getText();
            id = this.idEscribir.getText();
            carrera = this.carreraEscribir.getText();
            correo=this.correodEscribir.getText();
            telefono=this.telefonoEscribir.getText();
            añosAntiguedad= Integer.parseInt(this.antiguedadEscribir.getText());

            if (""!=nombreEscribir.getText()){
                monitors.add(new Monitor(nombre,id,carrera,telefono,correo,añosAntiguedad));
                tablaMonitor.setItems(monitors);
                tablaMonitor.refresh();

            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("MENSAJE DE INFORMACION");
                alert.setTitle("Dialogo de advertencia");
                alert.setContentText("Es necesario llenar los campos");
                alert.showAndWait();
            }
        } catch (NumberFormatException e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("NO SE HA CREADO EL ESTUDIANTE");
            alert.showAndWait();
        }
        mfc.agregarMonitor(nombre,id,carrera,telefono,correo,añosAntiguedad);
    }
    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void modificar(ActionEvent event) {

    }



}

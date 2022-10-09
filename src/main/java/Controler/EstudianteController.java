package Controler;

import Model.Estudiante;
import Model.Monitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import service.impl.EstudianteServiceImpl;


import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class EstudianteController implements Initializable {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void btnPadre(ActionEvent actionEvent) {
    }

    //tabla y columnas
    @FXML
    private TableColumn<Model.Estudiante, String> nombreMostrar;
    @FXML
    private TableColumn<Model.Estudiante, String> idMostrar;
    @FXML
    private TableColumn<Model.Estudiante, String> carreraMostrar;
    @FXML
    private TableColumn<Model.Estudiante, String> correoMostrar;

    @FXML
    private TableColumn<Model.Estudiante, String> telefonoMostrar;
    @FXML
    private TableView<Estudiante> tablaEstudiante;

    //texfield
    @FXML
    private TextField telefonoEscribir;
    @FXML
    private TextField nombreEscribir;
    @FXML
    private TextField idEscribir;
    @FXML
    private TextField carreraEscribir;
    @FXML
    private TextField correoEscribir;
    private ObservableList<Estudiante> estudiantes;
    private ObservableList<Estudiante> filtrarEstudiante;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        estudiantes = FXCollections.observableArrayList();
        filtrarEstudiante=FXCollections.observableArrayList();

        this.nombreMostrar.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.idMostrar.setCellValueFactory(new PropertyValueFactory("id"));
        this.carreraMostrar.setCellValueFactory(new PropertyValueFactory("carrera"));
        this.telefonoMostrar.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.correoMostrar.setCellValueFactory(new PropertyValueFactory("correoElectronico"));


    }

    //botones
    @FXML
    void añadir(ActionEvent event) {
        String nombre = null;
        String id = null;
        String carrera = null;
        String correo = null;
        String telefono = null;

        try {
            nombre = this.nombreEscribir.getText();
            id = this.idEscribir.getText();
            carrera = this.carreraEscribir.getText();
            correo = this.correoEscribir.getText();
            telefono = this.telefonoEscribir.getText();
            if ("" != nombreEscribir.getText()) {
                estudiantes.add(new Estudiante(nombre, id, carrera, telefono, correo));
                tablaEstudiante.setItems(estudiantes);
                tablaEstudiante.refresh();
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
            alert.setContentText("NO SE HA CREADO EL ESTUDIANTE");
            alert.showAndWait();
        }
        mfc.agregarEstudiante(nombre, id, carrera, telefono, correo);
    }

    @FXML
    void eliminar(ActionEvent event) {
        Estudiante estudiante = this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar
        if (estudiante == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder eliminar");
            alert.showAndWait();
        } else {
            // this.estudiantes.remove(estudiante);

            mfc.eliminar(String.valueOf(estudiantes.remove(estudiante)));
            this.tablaEstudiante.refresh();
        }
    }

    @FXML
    void seleccionar(ActionEvent event) {
        Estudiante estudiante = this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar
        if (estudiante != null) {
            this.nombreEscribir.setText(estudiante.getNombre());
            this.idEscribir.setText(estudiante.getId());
            this.carreraEscribir.setText(estudiante.getCarrera());
            this.correoEscribir.setText(estudiante.getCorreoElectronico());
            this.telefonoEscribir.setText(estudiante.getTelefono());
        }
    }

    @FXML
    void modificar(ActionEvent event) {
        Estudiante estudiante = this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar
        if (estudiante == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder modificar");
            alert.showAndWait();
        } else {
            String nombre = this.nombreEscribir.getText();
            String id = this.idEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            String correo = this.correoEscribir.getText();
            String telefono = this.telefonoEscribir.getText();
            Estudiante aux = new Estudiante(nombre, id, carrera, telefono, correo);
            if (!this.estudiantes.contains(aux)) {//si no contiene el aux
                estudiante.setNombre(aux.getNombre());
                estudiante.setId(aux.getId());
                estudiante.setCarrera(aux.getCarrera());
                estudiante.setCorreoElectronico(aux.getCorreoElectronico());
                estudiante.setTelefono(aux.getTelefono());
                this.tablaEstudiante.refresh();
                refrescar();
            }
        }
    }

    void refrescar() {
        nombreEscribir.setText("");
        idEscribir.setText("");
        correoEscribir.setText("");
        carreraEscribir.setText("");
        telefonoEscribir.setText("");
    }

    @FXML
    private TextField filtrarCodigo;


    @FXML
    void buscar() {
        mfc.buscar(filtrarCodigo.getText());
    }

    @FXML
    void filtrarNombre(KeyEvent event) {
        String filtroCodigo=this.filtrarCodigo.getText();
        if (filtroCodigo.isEmpty()){
            this.tablaEstudiante.setItems(estudiantes);
        }else {
            this.filtrarEstudiante.clear();
            for (Estudiante e:this.estudiantes){
                if (e.getId().contains(filtroCodigo)){
                    this.filtrarEstudiante.add(e);
                }
            }
            this.tablaEstudiante.setItems(filtrarEstudiante);
        }

    }
}





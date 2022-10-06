package Controler;

import Model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import service.impl.EstudianteServiceImpl;


import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class EstudianteController implements Initializable {
    public void btnPadre(ActionEvent actionEvent) {
    }
    EstudianteServiceImpl serviceEstudiante=new EstudianteServiceImpl();


//tabla y columnas
    @FXML
    private TableColumn<Model.Estudiante,String> nombreMostrar;
    @FXML
    private TableColumn<Model.Estudiante,String> idMostrar;
    @FXML
    private TableColumn<Model.Estudiante,String> carreraMostrar;
    @FXML
    private TableColumn<Model.Estudiante,String > correoMostrar;

    @FXML
    private TableColumn<Model.Estudiante,String >telefonoMostrar;
    @FXML
    private TableView<Model.Estudiante> tablaEstudiante;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        estudiantes=FXCollections.observableArrayList();
        this.nombreMostrar.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.idMostrar.setCellValueFactory(new PropertyValueFactory("id"));
        this.carreraMostrar.setCellValueFactory(new PropertyValueFactory("carrera"));
        this.telefonoMostrar.setCellValueFactory(new PropertyValueFactory("telefono"));
       this.correoMostrar.setCellValueFactory(new PropertyValueFactory("correoElectronico"));


    }
    @FXML
    void añadir(ActionEvent event){
        try {
            String nombre = this.nombreEscribir.getText();
            String id = this.idEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            String correo=this.correoEscribir.getText();
            String telefono=this.telefonoEscribir.getText();

            serviceEstudiante.agregarEstudiante(nombre,id,carrera,correo,telefono);

            if (""!=nombreEscribir.getText()){
                estudiantes.add(new Estudiante(nombre,id, carrera,telefono,correo));
                tablaEstudiante.setItems(estudiantes);
                tablaEstudiante.refresh();
                refrescar();
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

    }


    //botones
//    @FXML
//    void añadir(ActionEvent event) {
//
//        try {
//            String nombre = this.nombreEscribir.getText();
//            String id = this.idEscribir.getText();
//            String carrera = this.carreraEscribir.getText();
//            String correo=this.correoEscribir.getText();
//            String telefono=this.telefonoEscribir.getText();
//
//            if (""!=nombreEscribir.getText()){
//                estudiantes.add(new Estudiante(nombre,id, carrera,telefono,correo));
//                tablaEstudiante.setItems(estudiantes);
//                tablaEstudiante.refresh();
//                nombreEscribir.setText("");
//                idEscribir.setText("");
//                correoEscribir.setText("");
//                carreraEscribir.setText("");
//                telefonoEscribir.setText("");
//            }else {
//                Alert alert=new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText("MENSAJE DE INFORMACION");
//                alert.setTitle("Dialogo de advertencia");
//                alert.setContentText("Es necesario llenar los campos");
//                alert.showAndWait();
//            }
//           } catch (NumberFormatException e){
//            Alert alert=new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText(null);
//            alert.setTitle("ERROR");
//            alert.setContentText("NO SE HA CREADO EL ESTUDIANTE");
//            alert.showAndWait();
//        }
//    }
    @FXML
    void eliminar(ActionEvent event) {
        Estudiante estudiante=this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar

        if (estudiante==null){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder eliminar");
            alert.showAndWait();
        }else {
            this.estudiantes.remove(estudiante);
            this.tablaEstudiante.refresh();
        }
    }
    @FXML
    void seleccionar(ActionEvent event) {
        Estudiante estudiante=this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar
        if (estudiante!=null){
            this.nombreEscribir.setText(estudiante.getNombre());
            this.idEscribir.setText(estudiante.getId());
            this.carreraEscribir.setText(estudiante.getCarrera());
            this.correoEscribir.setText(estudiante.getCorreoElectronico());
            this.telefonoEscribir.setText(estudiante.getTelefono());
        }
    }
    @FXML
    void modificar(ActionEvent event) {
        Estudiante estudiante=this.tablaEstudiante.getSelectionModel().getSelectedItem();//selecionar
        if (estudiante==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Primero debes seleccinar un estudiante, Para poder modificar");
            alert.showAndWait();
        }else {
            String nombre = this.nombreEscribir.getText();
            String id = this.idEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            String correo=this.correoEscribir.getText();
            String telefono=this.telefonoEscribir.getText();
            Estudiante aux=new Estudiante(nombre,id,carrera,telefono,correo);

            if (!this.estudiantes.contains(aux)){//si no contiene el aux
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
    void refrescar(){
        nombreEscribir.setText("");
        idEscribir.setText("");
        correoEscribir.setText("");
        carreraEscribir.setText("");
        telefonoEscribir.setText("");
    }
    @FXML
    private TextField escribirBuscar;


   @FXML
   void buscar(ActionEvent actionEvent) {

           if (tablaEstudiante!=null &&tablaEstudiante.getSelectionModel().getSelectedItem().equals(escribirBuscar.getText())){
               Alert alert=new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("encontrado");
               alert.setContentText("ese estudiante y sus datos existen");
               alert.showAndWait();
           }else {
               Alert alert=new Alert(Alert.AlertType.ERROR);
               alert.setTitle("no enontrado");
               alert.setContentText("no existe");
               alert.showAndWait();
           }

   }


    }




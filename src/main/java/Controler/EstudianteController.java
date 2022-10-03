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


import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class EstudianteController implements Initializable {
    public void btnPadre(ActionEvent actionEvent) {
    }


//tabla y columnas
    @FXML
    private TableColumn<Model.Estudiante,String> nombreMostrar;
    @FXML
    private TableColumn<Model.Estudiante,String> codigoMostrar;
    @FXML
    private TableColumn<Model.Estudiante,String> carreraMostrar;
    @FXML
    private TableColumn<Model.Estudiante,Integer> cantidadMostrar;
    @FXML
    private TableColumn<Model.Estudiante,Integer> precioMostrar;
    @FXML
    private TableView<Model.Estudiante> tablaEstudiante;

    //texfield
    @FXML
    private TextField precioEscribir;
    @FXML
    private TextField nombreEscribir;
    @FXML
    private TextField codigoEscribir;
    @FXML
    private TextField carreraEscribir;
    @FXML
    private TextField cantidadEscribir;
    private ObservableList<Estudiante> estudiantes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        estudiantes=FXCollections.observableArrayList();
        this.nombreMostrar.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.codigoMostrar.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.carreraMostrar.setCellValueFactory(new PropertyValueFactory("carrera"));
       this.cantidadMostrar.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.precioMostrar.setCellValueFactory(new PropertyValueFactory("precio"));

    }
    //botones
    @FXML
    void añadir(ActionEvent event) {

        try {
            String nombre = this.nombreEscribir.getText();
            String codigo = this.codigoEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            int cantidad = Integer.parseInt(this.cantidadEscribir.getText());
            int precio = Integer.parseInt(this.precioEscribir.getText());
            if (""!=nombreEscribir.getText()){
                estudiantes.add(new Estudiante(nombre,codigo, carrera,cantidad,precio));
                tablaEstudiante.setItems(estudiantes);
                tablaEstudiante.refresh();
                nombreEscribir.setText("");
                codigoEscribir.setText("");
                carreraEscribir.setText("");
                cantidadEscribir.setText("");
                precioEscribir.setText("");
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
            this.codigoEscribir.setText(estudiante.getCodigo());
            this.carreraEscribir.setText(estudiante.getCarrera());
            this.cantidadEscribir.setText(estudiante.getCantidad()+"");
            this.precioEscribir.setText(estudiante.getPrecio()+"");
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
            String codigo = this.codigoEscribir.getText();
            String carrera = this.carreraEscribir.getText();
            int cantidad = Integer.parseInt(this.cantidadEscribir.getText());
            int precio = Integer.parseInt(this.precioEscribir.getText());
            Estudiante aux=new Estudiante(nombre,codigo,carrera,cantidad,precio);

            if (!this.estudiantes.contains(aux)){//si no contiene el aux
                estudiante.setNombre(aux.getNombre());
                estudiante.setCodigo(aux.getCodigo());
                estudiante.setCarrera(aux.getCarrera());
                estudiante.setPrecio(aux.getPrecio());
                this.tablaEstudiante.refresh();
            }
        }
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




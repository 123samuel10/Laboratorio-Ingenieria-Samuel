package Controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MonitorController {


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
    private TableColumn<?, ?> antiguedadMostrar;



    @FXML
    private TableColumn<?, ?> carreraMostrar;

    @FXML
    private TableColumn<?, ?> correoMostrar;


    @FXML
    private TableColumn<?, ?> idMostrar;



    @FXML
    private TableColumn<?, ?> nombreMostrar;



    @FXML
    private TableColumn<?, ?> telefonoMostrar;

    //botones

    @FXML
    void añadir(ActionEvent event) {

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

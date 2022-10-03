package Controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MonitorController {


    public void botonPadreMonitores(ActionEvent actionEvent) {
    }

    //textos field
    @FXML
    private TextField antiguedadEscribir;

    @FXML
    private TextField cantidadEscribir;

    @FXML
    private TextField carreraEscribir;

    @FXML
    private TextField codigoEscribir;

    @FXML
    private TextField nombreEscribir;

    @FXML
    private TextField precioEscribir;

    //cuadros
    @FXML
    private TableColumn<?, ?> antiguedadMostrar;
    @FXML
    private TableColumn<?, ?> cantidadMostrar;
    @FXML
    private TableColumn<?, ?> carreraMostrar;

    @FXML
    private TableColumn<?, ?> codigoMostrar;
    @FXML
    private TableColumn<?, ?> nombreMostrar;
    @FXML
    private TableColumn<?, ?> precioMostrar;

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

package Controler;

import Model.Estudiante;
import Model.Monitor;
import Model.Prestamo;
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
import service.impl.EstudianteServiceImpl;

import java.net.URL;
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
    private TableColumn<Model.Estudiante, String> nombrePersona;
    @FXML
    private TableColumn<Model.Prestamo, String> fechaPrestamo;




    @FXML
    private TableColumn<Model.Prestamo,String> fechaFinalMostrar;
    @FXML
    private TableView<Prestamo> tablaPrestamo;

    private ObservableList<Prestamo> prestamo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prestamo = FXCollections.observableArrayList();
        this.fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fechaInicial"));
        this.fechaFinalMostrar.setCellValueFactory(new PropertyValueFactory("fechaFinal"));
        this.nombrePersona.setCellValueFactory(new PropertyValueFactory("estudiante"));

    }




    EstudianteServiceImpl estudianteService=new EstudianteServiceImpl();
    EstudianteController estudianteController=new EstudianteController();
    Estudiante estudiante=new Estudiante();
    Monitor monitor=new Monitor();




    @FXML
    void enviarCodigoPersona(ActionEvent event) {
        String  fecha=null;
        String fechaFinal=null;
        String codigo=null;

        try {
             fecha=fechaEscribir.getText();
             fechaFinal=fechaFinalEscribir.getText();
             codigo=escribirCodigoPersona.getText();
            mfc.enviarCodigoPersona(fecha, fechaFinal,codigo,estudiante,monitor);
        }catch (NumberFormatException e){

        }



    }

    @FXML
    void crearPrestamo(ActionEvent event) {


    }

}






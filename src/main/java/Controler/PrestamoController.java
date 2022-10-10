package Controler;

import Model.Estudiante;
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


    @FXML
    void enviarCodigoPersona(ActionEvent event) {
        String fecha=null;
        String fechaFinal=null;
        String estudianteM=null;
        try {
            fecha=fechaEscribir.getText();
            fechaFinal=fechaFinalEscribir.getText();
            estudianteM= String.valueOf(this.estudianteController.getEstudiantes());

                if (""!=fechaEscribir.getText()){
                    prestamo.add(new Prestamo(fecha,fechaFinal,estudiante));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();

                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NO HAY");
                }
        }catch (NumberFormatException e){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("NO HAY DATOS");

        }


    }

    @FXML
    void crearPrestamo(ActionEvent event) {


    }

}






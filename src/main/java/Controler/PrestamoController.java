package Controler;

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

    ModelFactoryController mfc=new ModelFactoryController();

    public void btnPadrePrestamo(ActionEvent actionEvent) {
    }
    @FXML
    private TextField escribirCodigoPersona;


    @FXML
    private TextField fechaEscribir;

    @FXML
    private TableColumn<?, ?> fechaPrestamo;



    @FXML
    private TableColumn<?, ?> nombrePersona;


    @FXML
    private TableView<Prestamo> tablaPrestamo;

    private ObservableList<Prestamo> prestamo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prestamo= FXCollections.observableArrayList();
        this.fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.nombrePersona.setCellValueFactory(new PropertyValueFactory("estudiante"));
    }


    EstudianteServiceImpl estudianteService=new EstudianteServiceImpl();
    @FXML
    void enviarCodigoPersona(ActionEvent event) {
            String fecha=null;
            String estudiante=null;
            try {
                fecha=this.fechaEscribir.getText();
                estudiante=this.estudianteService.getEstudiantes().get(0).getNombre();

                if (""!=fechaEscribir.getText()){
                    prestamo.add(new Prestamo(fecha,estudiante));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();
                }else {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("holddda");
                }
            }catch (NumberFormatException e){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("quedd");
            }
            mfc.enviarCodigoPersona(fecha,estudiante);


        }


    @FXML
    void crearPrestamo(ActionEvent event) {



    }

    }






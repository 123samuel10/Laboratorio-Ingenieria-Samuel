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
import service.EstudianteService;
import service.PrestamoService;
import service.impl.EstudianteServiceImpl;
import service.impl.PrestamoServiceImpl;

import java.net.URL;
import java.security.KeyStore;
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
    private TableColumn<Model.Estudiante, String> nombrePersona;
    @FXML
    private TableColumn<Model.Prestamo, String> fechaPrestamo;


    @FXML
    private TableColumn<Model.Prestamo, String> fechaFinalMostrar;
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


//    public Estudiante getEstudiante(String codigo,ObservableList<Estudiante>observableList){
//        for (Estudiante estudiante:observableList){
//            if (estudiante.getId().equals(codigo)){
//                return  estudiante;
//            }
//        }
//        return null;
//    }


    EstudianteServiceImpl estudianteService = new EstudianteServiceImpl();

    @FXML
    void enviarCodigoPersona(ActionEvent event) {

        String fecha = null;
        String fechaFinal = null;
        String codigo = escribirCodigoPersona.getText();

        try {
            for (int i = 0; i < estudianteService.getEstudiantes().size(); i++) {
                if (estudianteService.getEstudiantes().get(i)!=null && estudianteService.getEstudiantes().get(i).getId().equals(codigo)) {
                    fecha = fechaEscribir.getText();
                    fechaFinal = fechaFinalEscribir.getText();
                    prestamo.add(new Prestamo(fecha, fechaFinal, codigo));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();
                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("NO HAY NADA");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        mfc.enviarCodigoPersona(fecha, fechaFinal, codigo);
    }


    @FXML
    void crearPrestamo(ActionEvent event) {

    }

}






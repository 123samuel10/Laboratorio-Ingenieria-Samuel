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
    private TableColumn<Model.Prestamo, String> fechaPrestamo;


    @FXML
    private TableColumn<Model.Estudiante, String> nombrePersona;


    @FXML
    private TableView<Prestamo> tablaPrestamo;

    private ObservableList<Prestamo> prestamo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prestamo = FXCollections.observableArrayList();
        this.fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.nombrePersona.setCellValueFactory(new PropertyValueFactory("estudiante"));
    }


    EstudianteController estudianteController = new EstudianteController();

    @FXML
    void enviarCodigoPersona(ActionEvent event) {
        String fecha=null;
        String estudiante=null;
        try {
              fecha = this.fechaEscribir.getText();

              for (int i=0;i<prestamo.size();i++){
                  if (estudianteController.getIdMostrar().equals(escribirCodigoPersona.getText())){
                      System.out.println("entro?");
                      prestamo.add(new Prestamo(fecha));
                      tablaPrestamo.setItems(prestamo);
                      tablaPrestamo.refresh();
                  }else {
                      Alert alert=new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("siiu");
                  }

              }
        }catch (NumberFormatException e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("siiu");
        }
        mfc.enviarCodigoPersona(fecha);

    }





//        try {
//            fecha = this.fechaEscribir.getText();
//            for (int i = 0; i < prestamo.size(); i++) {
//                estudiante = this.estudianteController.getNombreMostrar().getText();
//                if (fechaEscribir.getText()!="") {
//                    prestamo.add(new Prestamo(fecha, estudiante));
//                    tablaPrestamo.setItems(prestamo);
//                    tablaPrestamo.refresh();
//                } else {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("holddda");
//                }
//            }
//
//        } catch (NumberFormatException e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("quedd");
//        }






    @FXML
    void crearPrestamo(ActionEvent event) {


    }

}






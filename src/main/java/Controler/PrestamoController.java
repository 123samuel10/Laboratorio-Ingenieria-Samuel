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

    public void prestamoPractica(EstudianteServiceImpl estudianteService) {
        String fecha = null;
        String fechaFinal = null;
        String codigo = null;
        try {
            for (int i=0;i<estudianteService.getEstudiantes().size();i++){
                if (estudianteService.getEstudiantes().get(i)!=null && escribirCodigoPersona.equals(estudianteService.getEstudiantes().get(i).getId())){
                    fecha = fechaEscribir.getText();
                    fechaFinal = fechaFinalEscribir.getText();
                    codigo = escribirCodigoPersona.getText();
                    prestamo.add(new Prestamo(fecha,fechaFinal,codigo,));
                    tablaPrestamo.setItems(prestamo);
                    tablaPrestamo.refresh();
                }
            }
            mfc.enviarCodigoPersona(fecha,fechaFinal,codigo,);

        }catch (NumberFormatException e){

        }
    }
        @FXML
        void enviarCodigoPersona (ActionEvent event){

        }








    @FXML
    void crearPrestamo(ActionEvent event) {


    }

}






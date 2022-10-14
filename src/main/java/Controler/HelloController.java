

package Controler;

import com.example.democoeducuelaboratorioingenieriasamuel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.impl.EstudianteServiceImpl;
import service.impl.MonitorServiceImlp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    private Stage stage;

    @FXML
    private Text tituloPrincipal;
    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;


    @FXML
    void btnIrHome(ActionEvent event) {

    }
    private EstudianteServiceImpl estudianteService=new EstudianteServiceImpl();

    private MonitorServiceImlp monitorServiceImlp=new MonitorServiceImlp();

    void initData(EstudianteServiceImpl estudianteService, MonitorServiceImlp monitorService) {
        this.estudianteService = estudianteService;
        this.monitorServiceImlp = monitorService;
    }
    @FXML
    void btnIrEstudiante(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estudiante.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        EstudianteController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorServiceImlp);
        fxmlLoader.setController(controller);
        stage3.show();
    }

    @FXML
    void btnIrMonitor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Monitor.fxml"));
        Stage stage3 = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        MonitorController controller = fxmlLoader.getController();
        controller.initData(this.estudianteService, this.monitorServiceImlp);
        fxmlLoader.setController(controller);
        stage3.show();

    }

    @FXML
    void btnIrPrestamo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Prestamo.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage3 = new Stage();
        stage3.setScene(scene);
        stage3.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}













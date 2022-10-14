

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
    @FXML
    void btnIrEstudiante(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estudiante.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.show();
    }

    @FXML
    void btnIrMonitor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Monitor.fxml"));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.show();

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















package Controler;
import com.example.democoeducuelaboratorioingenieriasamuel.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private Stage stage;
    @FXML
    void btnIrEstudiante(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Estudiante.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        Stage stage1=new Stage();
        stage1.setScene(scene);
        stage1.show();

    }

    @FXML
    void btnIrMonitor(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Monitor.fxml"));

        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        Stage stage2=new Stage();
        stage2.setScene(scene);
        stage2.show();

    }
    @FXML
    void btnIrPrestamo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Prestamo.fxml"));
        Parent root=fxmlLoader.load();
        Scene scene=new Scene(root);
        Stage stage3=new Stage();
        stage3.setScene(scene);
        stage3.show();


    }



}













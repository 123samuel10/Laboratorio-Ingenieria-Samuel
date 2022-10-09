package com.example.democoeducuelaboratorioingenieriasamuel;

import Controler.EstudianteController;
import Controler.HelloController;
import Controler.MonitorController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Hello.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();



    }
}
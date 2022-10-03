module com.example.democoeducuelaboratorioingenieriasamuel {
    requires javafx.controls;
    requires javafx.fxml;



    opens Controler to javafx.fxml;
    opens com.example.democoeducuelaboratorioingenieriasamuel to javafx.fxml;
    exports com.example.democoeducuelaboratorioingenieriasamuel;
    exports Controler;
    exports Model;
    opens Model to javafx.fxml;

}
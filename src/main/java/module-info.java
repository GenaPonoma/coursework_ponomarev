module org.example.coursework_ponomarev {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.coursework_ponomarev to javafx.fxml;
    exports org.example.coursework_ponomarev;
}
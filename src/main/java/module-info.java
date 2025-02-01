module org.example.coursework_ponomarev {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.coursework_ponomarev to javafx.fxml;
    exports org.example.coursework_ponomarev;
    exports org.example.coursework_ponomarev.controller;
    opens org.example.coursework_ponomarev.controller to javafx.fxml;
    exports org.example.coursework_ponomarev.factory;
    opens org.example.coursework_ponomarev.factory to javafx.fxml;
    exports org.example.coursework_ponomarev.model;
    opens org.example.coursework_ponomarev.model to javafx.fxml;
}
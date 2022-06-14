module soft.parqueadero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens soft.parqueadero to javafx.fxml;
    exports soft.parqueadero;
    exports soft.controladores;
    opens soft.controladores to javafx.fxml;
    opens soft.model;
}
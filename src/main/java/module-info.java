module com.example.servicios_bdtap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.servicios_bdtap to javafx.fxml;
    exports com.example.servicios_bdtap;
    exports com.example.servicios_bdtap.controllers;
    opens com.example.servicios_bdtap.controllers to javafx.fxml;
}
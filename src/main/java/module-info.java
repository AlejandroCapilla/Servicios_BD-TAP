module com.example.servicios_bdtap {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kernel;
    requires io;
    requires layout;
    requires java.desktop;
    requires jdk.compiler;


    opens com.example.servicios_bdtap to javafx.fxml;
    exports com.example.servicios_bdtap;
    exports com.example.servicios_bdtap.controllers;
    opens com.example.servicios_bdtap.controllers to javafx.fxml;
    exports com.example.servicios_bdtap.models.modelos;
    opens com.example.servicios_bdtap.models.modelos to javafx.fxml;
}
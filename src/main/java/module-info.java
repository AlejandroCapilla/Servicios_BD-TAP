module com.example.servicios_bdtap {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.servicios_bdtap to javafx.fxml;
    exports com.example.servicios_bdtap;
}
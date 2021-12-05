package com.example.servicios_bdtap.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    Button btn_Pagos, btn_Admin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_Pagos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage PagosSta = new Stage();
                FXMLLoader PagosFXML = new FXMLLoader(getClass().getResource("/com/example/servicios_bdtap/Pagos_Recargas.fxml"));

                Parent PagosR = null;
                try {
                    PagosR = PagosFXML.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene PagosSc = new Scene(PagosR, 700, 420);
                PagosSta.setTitle("Sistema de Pagos y Recargas");
                PagosSta.setScene(PagosSc);
                PagosSta.show();
            }

        });
        btn_Admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage AdminSta = new Stage();
                FXMLLoader AdminFXML = new FXMLLoader(getClass().getResource("/com/example/servicios_bdtap/Logeo_Admin.fxml"));

                Parent AdminR = null;
                try {
                    AdminR = AdminFXML.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Scene AdminSc = new Scene(AdminR, 330, 200);
                AdminSta.setTitle("Sistema de Pagos y Recargas");
                AdminSta.setScene(AdminSc);
                AdminSta.show();
            }
        });
    }
}

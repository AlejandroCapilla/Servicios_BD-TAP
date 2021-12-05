package com.example.servicios_bdtap.controllers;

import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.daos.UsuarioAdministradoDAO;
import com.example.servicios_bdtap.models.modelos.UsuarioAdministrado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogeoAdminController implements Initializable {
    @FXML
    Button btn_Acceder;

    @FXML
    TextField txt_Usuario, txt_Contrasena;

    @FXML
    UsuarioAdministradoDAO usuarioAdministradoDAO = new UsuarioAdministradoDAO(MySQLConnection.getConnection());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_Acceder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UsuarioAdministrado usuarioAdministrado = null;
                String usuario, contraseña;
                usuario = txt_Usuario.getText();
                contraseña = txt_Contrasena.getText();
                if(usuario.equals("") || contraseña.equals("")){
                    alertMessage("Datos incompletos!",null,
                            "Porfavor llene todos los campos para continuar", Alert.AlertType.ERROR);
                }else{
                    try {
                        usuarioAdministrado = usuarioAdministradoDAO.adminLogin(usuario, contraseña);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if(usuarioAdministrado == null){
                        alertMessage("Usuario incorrecto",null,
                                "El usuario que ingreso no existe o la contraseña esta equivocada", Alert.AlertType.ERROR);
                    }else{
                        Stage InAdminSta = new Stage();
                        FXMLLoader InAdminFXML = new FXMLLoader(getClass().getResource("/com/example/servicios_bdtap/Interfaz_Admin.fxml"));

                        Parent InAdminR = null;
                        try {
                            InAdminR = InAdminFXML.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene InAdminSc = new Scene(InAdminR, 1000, 500);
                        InAdminSta.setTitle("Sistema de Pagos y Recargas");
                        InAdminSta.setScene(InAdminSc);
                        InAdminSta.show();
                    }
                }

            }
        });
    }

    private void alertMessage(String title, String Header, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(Header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

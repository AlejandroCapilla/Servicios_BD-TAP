package com.example.servicios_bdtap.controllers;

import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.daos.ServicioDAO;
import com.example.servicios_bdtap.models.modelos.Servicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class InterfazAdminController implements Initializable {
    ServicioDAO servicioDAO = new ServicioDAO(MySQLConnection.getConnection());

    @FXML
    private TableView<Servicio> tblServ;

    @FXML
    Button btnAgrSer, btnUpdSer, btnDelSer;

    @FXML
    TextField txtcveServicio, txtserNombre;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblServ.getItems().clear();
        tblServ.setItems(servicioDAO.select());
        btnAgrSer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Servicio AgServicio = new Servicio(Integer.parseInt(txtcveServicio.getText()), txtserNombre.getText());
                servicioDAO.insert(AgServicio);
                tblServ.getItems().clear();
                tblServ.setItems(servicioDAO.select());
                txtcveServicio.setText("");
                txtserNombre.setText("");
            }
        });
        btnDelSer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Servicio DeServicio = (Servicio) tblServ.getSelectionModel().getSelectedItem();
                servicioDAO.delete(DeServicio);
                tblServ.getItems().clear();
                tblServ.setItems(servicioDAO.select());
                txtcveServicio.setText("");
                txtserNombre.setText("");
            }
        });
        btnUpdSer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Servicio UpServicio = new Servicio(Integer.parseInt(txtcveServicio.getText()), txtserNombre.getText());
                Servicio SelServicio = (Servicio) tblServ.getSelectionModel().getSelectedItem();
                servicioDAO.update(SelServicio, UpServicio);
                tblServ.getItems().clear();
                tblServ.setItems(servicioDAO.select());
                txtcveServicio.setText("");
                txtserNombre.setText("");
            }
        });
        tblServ.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Servicio SelServicio = (Servicio) tblServ.getSelectionModel().getSelectedItem();
                txtcveServicio.setText(SelServicio.getA_cveServicio()+"");
                txtserNombre.setText(SelServicio.getA_serNombre());
            }
        });
    }
}

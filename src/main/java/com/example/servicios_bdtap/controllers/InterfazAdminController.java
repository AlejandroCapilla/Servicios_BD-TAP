package com.example.servicios_bdtap.controllers;

import com.example.servicios_bdtap.PDFreports.PDFreports;
import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.daos.CompaniaDAO;
import com.example.servicios_bdtap.models.daos.ServicioDAO;
import com.example.servicios_bdtap.models.modelos.Compania;
import com.example.servicios_bdtap.models.modelos.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @FXML
    PDFreports pdFreports = new PDFreports();

    @FXML
    private TableView<Servicio> tblServ;
    ServicioDAO servicioDAO = new ServicioDAO(MySQLConnection.getConnection());
    ObservableList<Servicio> lsServicio = FXCollections.observableArrayList();

    @FXML
    private TableView<Compania> tblComp;
    CompaniaDAO companiaDAO = new CompaniaDAO(MySQLConnection.getConnection());
    ObservableList<Compania> lsCompania = FXCollections.observableArrayList();

    @FXML
    Button btnAgrSer, btnUpdSer, btnDelSer, btnAgrCom, btnUpdCom, btnDelCom, btnReporDServ, btnReporPServ, btnReporDCom, btnReporPCom;;

    @FXML
    TextField txtcveServicio, txtserNombre, txtcveCompania, txtcomNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblServ.getItems().clear();
        servicioDAO.select(lsServicio);
        tblServ.setItems(lsServicio);
        tblComp.getItems().clear();
        companiaDAO.select(lsCompania);
        tblComp.setItems(lsCompania);
        btnAgrSer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Servicio AgServicio = new Servicio(Integer.parseInt(txtcveServicio.getText()), txtserNombre.getText());
                servicioDAO.insert(AgServicio);
                tblServ.getItems().clear();
                servicioDAO.select(lsServicio);
                tblServ.setItems(lsServicio);
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
                servicioDAO.select(lsServicio);
                tblServ.setItems(lsServicio);
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
                servicioDAO.select(lsServicio);
                tblServ.setItems(lsServicio);
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
        btnAgrCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Compania AgCompania = new Compania(Integer.parseInt(txtcveCompania.getText()), txtcomNombre.getText());
                companiaDAO.insert(AgCompania);
                tblComp.getItems().clear();
                companiaDAO.select(lsCompania);
                tblComp.setItems(lsCompania);
                txtcveCompania.setText("");
                txtcomNombre.setText("");
            }
        });
        btnDelCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Compania DeCompania = (Compania) tblComp.getSelectionModel().getSelectedItem();
                companiaDAO.delete(DeCompania);
                tblComp.getItems().clear();
                companiaDAO.select(lsCompania);
                tblComp.setItems(lsCompania);
                txtcveCompania.setText("");
                txtcomNombre.setText("");
            }
        });
        btnUpdCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Compania UpCompania = new Compania(Integer.parseInt(txtcveCompania.getText()), txtcomNombre.getText());
                Compania SelCompania = (Compania) tblComp.getSelectionModel().getSelectedItem();
                companiaDAO.update(SelCompania, UpCompania);
                tblComp.getItems().clear();
                companiaDAO.select(lsCompania);
                tblComp.setItems(lsCompania);
                txtcveCompania.setText("");
                txtcomNombre.setText("");
            }
        });
        tblComp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Compania SelCompania = (Compania) tblComp.getSelectionModel().getSelectedItem();
                txtcveCompania.setText(SelCompania.getA_cveCompania()+"");
                txtcomNombre.setText(SelCompania.getA_comNombre());
            }
        });
        btnReporPCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pdFreports.m_ReporPCom();
            }
        });
        btnReporDCom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pdFreports.m_ReporDCom();
            }
        });
        btnReporDServ.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pdFreports.m_ReporDServ();
            }
        });
        btnReporPServ.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pdFreports.m_ReporPServ();
            }
        });
    }
}

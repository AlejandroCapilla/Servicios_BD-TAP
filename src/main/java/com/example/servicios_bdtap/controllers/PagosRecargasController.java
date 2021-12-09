package com.example.servicios_bdtap.controllers;

import com.example.servicios_bdtap.PDFreports.PDFreports;
import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.daos.ServicioDAO;
import com.example.servicios_bdtap.models.daos.CompaniaDAO;
import com.example.servicios_bdtap.models.daos.ReporteDeServiciosDAO;
import com.example.servicios_bdtap.models.daos.ReportePorServicioDAO;
import com.example.servicios_bdtap.models.daos.ReporteDeRecargasDAO;
import com.example.servicios_bdtap.models.daos.ReportePorCompaniaDAO;
import com.example.servicios_bdtap.models.daos.TicketRecargaDAO;
import com.example.servicios_bdtap.models.daos.TicketServicioDAO;
import com.example.servicios_bdtap.models.daos.PagoServDAO;
import com.example.servicios_bdtap.models.daos.recargaDAO;
import com.example.servicios_bdtap.models.modelos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class PagosRecargasController implements Initializable{

    @FXML
    PDFreports pdFreports = new PDFreports();

    @FXML
    ObservableList<Servicio> lsServicio = FXCollections.observableArrayList();
    ServicioDAO servicioDAO = new ServicioDAO(MySQLConnection.getConnection());

    @FXML
    ObservableList<Compania> lsCompania = FXCollections.observableArrayList();
    CompaniaDAO companiaDAO = new CompaniaDAO(MySQLConnection.getConnection());

    @FXML
    PagoServDAO pagoServDAO = new PagoServDAO(MySQLConnection.getConnection());

    @FXML
    recargaDAO recargaDAO = new recargaDAO(MySQLConnection.getConnection());

    @FXML
    TicketServicioDAO ticketServicioDAO = new TicketServicioDAO(MySQLConnection.getConnection());
    TicketRecargaDAO ticketRecargaDAO = new TicketRecargaDAO(MySQLConnection.getConnection());

    @FXML
    ReporteDeRecargasDAO reporteDeRecargasDAO = new ReporteDeRecargasDAO(MySQLConnection.getConnection());
    ReporteDeServiciosDAO reporteDeServiciosDAO = new ReporteDeServiciosDAO(MySQLConnection.getConnection());
    ReportePorServicioDAO reportePorServicioDAO = new ReportePorServicioDAO(MySQLConnection.getConnection());
    ReportePorCompaniaDAO reportePorCompaniaDAO = new ReportePorCompaniaDAO(MySQLConnection.getConnection());

    @FXML
    TextField txt_PSoR, txt_Usuario, txt_Comision, txt_Monto, txt_NumRef, txt_Telefono, txt_ConfirmTel, txt_NumAut, txt_Fecha, txt_Hora, txt_NumTicket, txt_cveSerCom;

    @FXML
    Button btn_Pagar, btn_Ticket;

    @FXML
    private ComboBox<Servicio> cbo_Servicios;

    @FXML
    private ComboBox<Compania> cbo_Recargas;

    @FXML
    ToggleGroup toggleGroup = new ToggleGroup();
    public RadioButton rbt_PagoSer, rbt_Recarga;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rbt_PagoSer.setToggleGroup(toggleGroup);
        rbt_Recarga.setToggleGroup(toggleGroup);
        servicioDAO.selectcb(lsServicio);
        cbo_Servicios.setItems(lsServicio);
        companiaDAO.selectcb(lsCompania);
        cbo_Recargas.setItems(lsCompania);
        txt_Comision.setDisable(true);
        txt_Monto.setDisable(true);
        txt_NumRef.setDisable(true);
        txt_Telefono.setDisable(true);
        txt_NumAut.setDisable(true);
        txt_ConfirmTel.setDisable(true);
        txt_Fecha.setDisable(true);
        txt_Hora.setDisable(true);
        txt_NumTicket.setDisable(true);
        txt_Usuario.setDisable(true);
        txt_cveSerCom.setDisable(true);
        txt_PSoR.setDisable(true);
        btn_Pagar.setDisable(true);
        btn_Ticket.setDisable(true);
        cbo_Servicios.setDisable(true);
        cbo_Recargas.setDisable(true);
        rbt_PagoSer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt_Comision.setDisable(false);
                txt_Monto.setDisable(false);
                txt_NumRef.setDisable(false);
                txt_Telefono.setDisable(false);
                txt_NumAut.setDisable(false);
                txt_ConfirmTel.setDisable(true);
                txt_Fecha.setDisable(false);
                txt_Hora.setDisable(false);
                txt_NumTicket.setDisable(false);
                btn_Pagar.setDisable(false);
                cbo_Servicios.setDisable(false);
                txt_Usuario.setDisable(false);
                txt_PSoR.setDisable(false);
                cbo_Recargas.setDisable(true);
                txt_Comision.setText("");
                txt_Monto.setText("");
                txt_NumRef.setText("");
                txt_Telefono.setText("");
                txt_NumAut.setText("");
                txt_ConfirmTel.setText("");
                txt_Fecha.setText("");
                txt_Hora.setText("");
                txt_NumTicket.setText("");
                txt_Usuario.setText("");
                txt_cveSerCom.setText("");
                txt_PSoR.setText("");
            }
        });
        rbt_Recarga.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txt_Comision.setDisable(true);
                txt_Monto.setDisable(false);
                txt_NumRef.setDisable(true);
                txt_Telefono.setDisable(false);
                txt_NumAut.setDisable(false);
                txt_ConfirmTel.setDisable(false);
                txt_Fecha.setDisable(false);
                txt_Hora.setDisable(false);
                txt_NumTicket.setDisable(false);
                btn_Pagar.setDisable(false);
                cbo_Servicios.setDisable(true);
                txt_Usuario.setDisable(false);
                txt_PSoR.setDisable(false);
                cbo_Recargas.setDisable(false);
                txt_Comision.setText("");
                txt_Monto.setText("");
                txt_NumRef.setText("");
                txt_Telefono.setText("");
                txt_NumAut.setText("");
                txt_ConfirmTel.setText("");
                txt_Fecha.setText("");
                txt_Hora.setText("");
                txt_NumTicket.setText("");
                txt_Usuario.setText("");
                txt_cveSerCom.setText("");
                txt_PSoR.setText("");
            }
        });
        btn_Pagar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(rbt_PagoSer.isSelected()){
                    if (veriPagoServicio()) {
                        PagoServ pagoServ = new PagoServ(Integer.parseInt(txt_PSoR.getText()),
                                Integer.parseInt(txt_Usuario.getText()),
                                Integer.parseInt(txt_cveSerCom.getText()),
                                Double.parseDouble(txt_Comision.getText()),
                                Double.parseDouble(txt_Monto.getText()),
                                Integer.parseInt(txt_NumRef.getText()), txt_Telefono.getText());
                        TicketServicio ticketServicio = new TicketServicio(Integer.parseInt(txt_NumTicket.getText()),
                                Integer.parseInt(txt_PSoR.getText()),
                                Integer.parseInt(txt_NumAut.getText()),
                                Date.valueOf(txt_Fecha.getText()),
                                txt_Hora.getText());
                        ReporteDeServicios reporteDeServicios = new ReporteDeServicios(Integer.parseInt(txt_PSoR.getText()));
                        pagoServDAO.insert(pagoServ);
                        ticketServicioDAO.insert(ticketServicio);
                        reporteDeServiciosDAO.insert(reporteDeServicios);
                        btn_Ticket.setDisable(false);
                        btn_Pagar.setDisable(true);
                    }
                }
                if(rbt_Recarga.isSelected()){
                    if (veriRecarga()){
                        recarga recarga = new recarga(Integer.parseInt(txt_PSoR.getText()),
                                Integer.parseInt(txt_Usuario.getText()),
                                Integer.parseInt(txt_cveSerCom.getText()),
                                Double.parseDouble(txt_Monto.getText()),
                                txt_Telefono.getText());
                        TicketRecarga ticketRecarga = new TicketRecarga(Integer.parseInt(txt_NumTicket.getText()),
                                Integer.parseInt(txt_PSoR.getText()),
                                Integer.parseInt(txt_NumAut.getText()),
                                Date.valueOf(txt_Fecha.getText()),
                                txt_Hora.getText());
                        ReporteDeRecargas reporteDeRecargas = new ReporteDeRecargas(Integer.parseInt(txt_PSoR.getText()));
                        recargaDAO.insert(recarga);
                        ticketRecargaDAO.insert(ticketRecarga);
                        reporteDeRecargasDAO.insert(reporteDeRecargas);
                        btn_Ticket.setDisable(false);
                        btn_Pagar.setDisable(true);
                    }
                }
            }
        });
        btn_Ticket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(rbt_PagoSer.isSelected()){
                    pdFreports.m_TicketServicio(txt_PSoR.getText());
                    txt_Comision.setDisable(true);
                    txt_Monto.setDisable(true);
                    txt_NumRef.setDisable(true);
                    txt_Telefono.setDisable(true);
                    txt_NumAut.setDisable(true);
                    txt_ConfirmTel.setDisable(true);
                    txt_Fecha.setDisable(true);
                    txt_Hora.setDisable(true);
                    txt_NumTicket.setDisable(true);
                    txt_Usuario.setDisable(true);
                    txt_cveSerCom.setDisable(true);
                    txt_PSoR.setDisable(true);
                    btn_Pagar.setDisable(true);
                    btn_Ticket.setDisable(true);
                    cbo_Servicios.setDisable(true);
                    cbo_Recargas.setDisable(true);
                    txt_Comision.setText("");
                    txt_Monto.setText("");
                    txt_NumRef.setText("");
                    txt_Telefono.setText("");
                    txt_NumAut.setText("");
                    txt_ConfirmTel.setText("");
                    txt_Fecha.setText("");
                    txt_Hora.setText("");
                    txt_NumTicket.setText("");
                    txt_Usuario.setText("");
                    txt_cveSerCom.setText("");
                    txt_PSoR.setText("");
                }
                if(rbt_Recarga.isSelected()){
                    pdFreports.m_TicketRecarga(txt_PSoR.getText());
                    txt_Comision.setDisable(true);
                    txt_Monto.setDisable(true);
                    txt_NumRef.setDisable(true);
                    txt_Telefono.setDisable(true);
                    txt_NumAut.setDisable(true);
                    txt_ConfirmTel.setDisable(true);
                    txt_Fecha.setDisable(true);
                    txt_Hora.setDisable(true);
                    txt_NumTicket.setDisable(true);
                    txt_Usuario.setDisable(true);
                    txt_cveSerCom.setDisable(true);
                    txt_PSoR.setDisable(true);
                    btn_Pagar.setDisable(true);
                    btn_Ticket.setDisable(true);
                    cbo_Servicios.setDisable(true);
                    cbo_Recargas.setDisable(true);
                    txt_Comision.setText("");
                    txt_Monto.setText("");
                    txt_NumRef.setText("");
                    txt_Telefono.setText("");
                    txt_NumAut.setText("");
                    txt_ConfirmTel.setText("");
                    txt_Fecha.setText("");
                    txt_Hora.setText("");
                    txt_NumTicket.setText("");
                    txt_Usuario.setText("");
                    txt_cveSerCom.setText("");
                    txt_PSoR.setText("");
                }
            }
        });
        cbo_Servicios.setOnAction(event -> {
            String nomSer = cbo_Servicios.getSelectionModel(). getSelectedItem() +"";
            String cveSer = servicioDAO.getCveSer(nomSer);
            txt_cveSerCom.setText(cveSer);
        });
        cbo_Recargas.setOnAction(event -> {
            String nomCom = cbo_Recargas.getSelectionModel(). getSelectedItem() +"";
            String cveCom = companiaDAO.getCveCom(nomCom);
            txt_cveSerCom.setText(cveCom);
        });
    }

    public boolean veriPagoServicio(){
        boolean bandera = false;
        if(veriCampos())
            if(txt_Comision.getText().equals(""))
                alertMessage("Error", null, "Porfavor ingrese la comision para continuar", Alert.AlertType.ERROR);
            else
            if(txt_NumRef.getText().equals(""))
                alertMessage("Error", null, "Porfavor ingrese el numero de referencia para continuar", Alert.AlertType.ERROR);
            else
                bandera = true;
        return bandera;
    }

    public boolean veriRecarga(){
        boolean bandera = false;
        if(veriCampos())
            if(txt_ConfirmTel.getText().equals(""))
                alertMessage("Error", null, "Porfavor ingrese la confirmacion del numero de telefono para continuar", Alert.AlertType.ERROR);
            else
                bandera = true;
        return bandera;
    }

    public boolean veriCampos(){
        boolean bandera = false;
        if(txt_PSoR.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese la clave de pago para continuar", Alert.AlertType.ERROR);
        else
        if(txt_Usuario.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese la clave de usuario para continuar", Alert.AlertType.ERROR);
        else
        if(txt_Monto.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese el monto pago para continuar", Alert.AlertType.ERROR);
        else
        if(txt_Telefono.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese el numero de telefono de pago para continuar", Alert.AlertType.ERROR);
        else
        if(txt_NumAut.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese el numero de atentificacion para continuar", Alert.AlertType.ERROR);
        else
        if(txt_Fecha.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese la fecha para continuar", Alert.AlertType.ERROR);
        else
        if(txt_Hora.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese la hora para continuar", Alert.AlertType.ERROR);
        else
        if(txt_NumTicket.getText().equals(""))
            alertMessage("Error", null, "Porfavor ingrese el numero de ticket para continuar", Alert.AlertType.ERROR);
        else
            bandera = true;
        return bandera;
    }

    private void alertMessage(String title, String Header, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(Header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

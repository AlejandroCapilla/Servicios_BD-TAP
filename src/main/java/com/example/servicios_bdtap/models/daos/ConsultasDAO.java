package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.modelosReportes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ConsultasDAO {
    Connection connServ;

    public ConsultasDAO(Connection conn) {
        this.connServ = conn;
    }

    private void alertMessage(String title, String Header, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(Header);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public List<TicketServicios> getTicketServicios(String cvePServ) {
        ObservableList ticketDeServicios = FXCollections.observableArrayList();

        try {
            String query = "select ts.numTickServicio, ts.ticsNumeAutorizacion, ts.cvePagoServ, ps.pserNumeReferencia, u.usuNombre, s.serNombre, ps.pserComision, ps.pserMonto, ps.pserTelefono, ts.ticsFechaPago, ts.ticsHoraPago from ticketServicio ts inner join pagoserv ps on ps.cvePagoServ = ts.cvePagoServ inner join servicio s on s.cveServicio = ps.cveServicio inner join usuarioRegistrado u on u.cveUsuario = ps.cveUsuario where ts.cvePagoServ = '"+cvePServ+"' order by ts.numTickServicio";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                ticketDeServicios.add(new TicketServicios(rs.getInt("numTickServicio"), rs.getInt("ticsNumeAutorizacion"),
                        rs.getInt("cvePagoServ"), rs.getInt("pserNumeReferencia"),rs.getString ("usuNombre"),
                        rs.getString("serNombre"), rs.getDouble("pserComision"), rs.getDouble("pserMonto"),
                        rs.getString("pserTelefono"), rs.getDate("ticsFechaPago"), rs.getString("ticsHoraPago") ));
            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "TicketServicios", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return ticketDeServicios;
    }

    public List<TicketRecargas> getTicketRecargas(String a_cveRec) {
        ObservableList ticketDeRecargas = FXCollections.observableArrayList();
        try {
            String query = "select tr.numTickRecarga, tr.ticrNumeAutorizacion, tr.cveRecarga, u.usuNombre, c.comNombre, r.recAbono, r.recTelefono, tr.ticrFechaPago, tr.ticrHoraPago from ticketRecarga tr inner join recarga r on r.cveRecarga = tr.cveRecarga inner join compania c on c.cveCompania = r.cveCompania inner join usuarioRegistrado u on u.cveUsuario = r.cveUsuario where tr.cveRecarga = '"+a_cveRec+"' order by tr.numTickRecarga";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                ticketDeRecargas.add(new TicketRecargas(rs.getInt("numTickRecarga"), rs.getInt("ticrNumeAutorizacion"),
                        rs.getInt("cveRecarga"), rs.getString("usuNombre"), rs.getString("comNombre"),
                        rs.getDouble("recAbono"), rs.getString("recTelefono"), rs.getDate("ticrFechaPago"), rs.getString("ticrHoraPago")));

            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "TicketRecargas", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return ticketDeRecargas;
    }

    public List<PorServicio> getPorServicio() {
        ObservableList listaPorServicio = FXCollections.observableArrayList();
        try {
            String query = "select s.serNombre, SUM(ps.pserMonto) from servicio s inner join pagoserv ps on ps.cveServicio = s.cveServicio group by s.serNombre";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                listaPorServicio.add(new PorServicio(rs.getString("s.serNombre"), rs.getDouble("SUM(ps.pserMonto)")));
            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "Lista por Servicios", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return listaPorServicio;
    }

    public List<PorCompanias> getPorCompanias() {
        ObservableList listaPorCompania = FXCollections.observableArrayList();
        try {
            String query = "select c.comNombre, SUM(r.recAbono) from compania c inner join recarga r on r.cveCompania = c.cveCompania group by c.comNombre";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                listaPorCompania.add(new PorCompanias(rs.getString("comNombre"), rs.getDouble("SUM(r.recAbono)")));
            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "Lista por Compania", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return listaPorCompania;
    }

    public List<DeServicios> getDeServicios() {
        ObservableList listaDeServicios = FXCollections.observableArrayList();
        try {
            String query = "select ts.numTickServicio, ts.cvePagoServ, u.usuNombre, s.serNombre, ps.pserMonto from ticketServicio ts inner join pagoserv ps on ps.cvePagoServ = ts.cvePagoServ inner join servicio s on s.cveServicio = ps.cveServicio inner join usuarioRegistrado u on u.cveUsuario = ps.cveUsuario order by ts.numTickServicio";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                listaDeServicios.add(new DeServicios(rs.getInt("numTickServicio"), rs.getInt("cvePagoServ"),
                        rs.getString("usuNombre"), rs.getString("serNombre"), rs.getDouble("pserMonto")));
            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "Lista de servicios", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return listaDeServicios;
    }

    public List<DeRecargas> getDeRecargas() {
        ObservableList listaDeRecargas = FXCollections.observableArrayList();
        try {
            String query = "select tr.numTickRecarga, tr.cveRecarga, u.usuNombre, c.comNombre, r.recAbono from ticketRecarga tr inner join recarga r on r.cveRecarga = tr.cveRecarga inner join compania c on c.cveCompania = r.cveCompania inner join usuarioRegistrado u on u.cveUsuario = r.cveUsuario order by tr.numTickRecarga";
            Statement st = this.connServ.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                listaDeRecargas.add(new DeRecargas(rs.getInt("numTickRecarga"), rs.getInt("cveRecarga"),
                        rs.getString("usuNombre"), rs.getString("comNombre"), rs.getDouble("recAbono")));
            }
        } catch (SQLException var5) {
            this.alertMessage("Error", "Lista de recargas", var5.getMessage(), Alert.AlertType.ERROR);
        }

        return listaDeRecargas;
    }
}

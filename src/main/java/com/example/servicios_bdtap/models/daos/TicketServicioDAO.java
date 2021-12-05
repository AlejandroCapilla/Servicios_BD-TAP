package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.TicketServicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class TicketServicioDAO {
    Connection connTS;

    public TicketServicioDAO (Connection conn){ this.connTS = conn;}

    public boolean insert(TicketServicio ts) {
        try {
            String query = "insert into ticketServicio values(?,?,?,?,?)";
            PreparedStatement statement = connTS.prepareStatement(query);
            statement.setInt(1, ts.getA_numTicketServicio());
            statement.setInt(2, ts.getCvePagoServ());
            statement.setInt(3, ts.getTicsNumeAutorizacion());
            statement.setDate(4, (Date) ts.getA_ticsFechaPago());
            statement.setString(5, ts.getA_ticsHoraPago());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

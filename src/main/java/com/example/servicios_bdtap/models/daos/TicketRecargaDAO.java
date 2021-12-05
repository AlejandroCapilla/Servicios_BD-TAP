package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.TicketRecarga;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class TicketRecargaDAO {
    Connection connTR;

    public TicketRecargaDAO (Connection conn){ this.connTR = conn;}

    public boolean insert(TicketRecarga t) {
        try {
            String query = "insert into ticketRecarga values(?,?,?,?,?)";
            PreparedStatement statement = connTR.prepareStatement(query);
            statement.setInt(1, t.getA_numTicketRecarga());
            statement.setInt(2, t.getCveRecarga());
            statement.setInt(3, t.getTicrNumeAutorizacion());
            statement.setDate(4, (Date) t.getA_ticrFechaPago());
            statement.setString(5, t.getTicrHoraPago());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

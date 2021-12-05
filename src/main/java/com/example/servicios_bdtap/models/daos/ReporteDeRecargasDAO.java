package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.ReporteDeRecargas;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReporteDeRecargasDAO {
    Connection connRR;

    public ReporteDeRecargasDAO (Connection conn){ this.connRR = conn;}

    public boolean insert(ReporteDeRecargas rr) {
        try {
            String query = "insert into reporteDeRecargas values(?,002)";
            PreparedStatement statement = connRR.prepareStatement(query);
            statement.setInt(1, rr.getA_cveRecarga());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

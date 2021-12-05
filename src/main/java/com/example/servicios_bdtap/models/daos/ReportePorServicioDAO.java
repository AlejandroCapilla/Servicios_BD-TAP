package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.ReportePorServicio;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReportePorServicioDAO {
    Connection connRpS;

    public ReportePorServicioDAO (Connection conn){ this.connRpS = conn;}

    public boolean insert(ReportePorServicio rs) {
        try {
            String query = "insert into reportePorServicio values(?,001)";
            PreparedStatement statement = connRpS.prepareStatement(query);
            statement.setInt(1, rs.getA_cveServicio());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

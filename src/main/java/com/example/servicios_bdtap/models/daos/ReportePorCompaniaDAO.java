package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.ReportePorCompania;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReportePorCompaniaDAO {
    Connection connRC;

    public ReportePorCompaniaDAO (Connection conn){ this.connRC = conn;}

    public boolean insert(ReportePorCompania rc) {
        try {
            String query = "insert into reportePorCompania values(?,002)";
            PreparedStatement statement = connRC.prepareStatement(query);
            statement.setInt(1, rc.getA_cveCompania());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

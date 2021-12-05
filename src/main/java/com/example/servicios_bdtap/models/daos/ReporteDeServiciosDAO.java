package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.ReporteDeServicios;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReporteDeServiciosDAO {
    Connection connRS;

    public ReporteDeServiciosDAO (Connection conn){ this.connRS = conn;}

    public boolean insert(ReporteDeServicios rs) {
        try {
            String query = "insert into reporteDeServicios values(?,001)";
            PreparedStatement statement = connRS.prepareStatement(query);
            statement.setInt(1, rs.getA_cvePagoServ());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

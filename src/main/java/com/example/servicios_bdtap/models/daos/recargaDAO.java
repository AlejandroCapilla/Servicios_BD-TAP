package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.recarga;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class recargaDAO {
    Connection connR;

    public recargaDAO (Connection conn){
        this.connR = conn;
    }

    public boolean insert(recarga rec) {
        try {
            String query = "insert into recarga values(?,?,?,?,?)";
            PreparedStatement statement = connR.prepareStatement(query);
            statement.setInt(1, rec.getA_cveRecarga());
            statement.setInt(2,rec.getA_cveUsuario());
            statement.setInt(3, rec.getA_cveCompania());
            statement.setDouble(4, rec.getA_recAbono());
            statement.setString(5, rec.getA_recTelefono());
            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.PagoServ;
import com.example.servicios_bdtap.models.modelos.Servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagoServDAO {
    Connection connPS;
    int cveCompania;

    public PagoServDAO (Connection conn){
        this.connPS = conn;
    }

    public int select(Servicio servicio){
        try{
            String query ="select cveServicio from servicio where serNombre = ?";
            PreparedStatement statement = connPS.prepareStatement(query);
            statement.setString(1, servicio.getA_serNombre());
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                cveCompania = rs.getInt("cveServicio");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return cveCompania;
    }

    public boolean insert(PagoServ pagoServ) {
        try {
            String query = "insert into PagoServ values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connPS.prepareStatement(query);
            statement.setInt(1, pagoServ.getA_cvePagoServ());
            statement.setInt(2, pagoServ.getCveUsuario());
            statement.setInt(3, pagoServ.getCveServicio());
            statement.setDouble(4,pagoServ.getPserComision());
            statement.setDouble(5, pagoServ.getPserMonto());
            statement.setInt(6, pagoServ.getPserNumeReferencia());
            statement.setString(7, pagoServ.getPserTelefono());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

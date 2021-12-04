package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.MySQLConnection;
import com.example.servicios_bdtap.models.modelos.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

//INSERT, UPDATE, DELETE
public class ServicioDAO {
    private int cveServicio;
    private String serNombre;
    Connection connServ;
    ObservableList<Servicio> lsServicio = FXCollections.observableArrayList();

    public ServicioDAO (Connection conn){ this.connServ = conn;}

    public ObservableList<Servicio> select(){
        try{
            String query ="select * from servicio";
            Statement st = connServ.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                lsServicio.add(new Servicio(rs.getInt("cveServicio"), rs.getString("serNombre")));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return lsServicio;
    }

    public boolean insert(Servicio servicio) {
        try {
            String query = "insert into Servicio values(?,?)";
            PreparedStatement statement = connServ.prepareStatement(query);
            statement.setInt(1, servicio.getA_cveServicio());
            statement.setString(2, servicio.getA_serNombre());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(Servicio servicio, Servicio Upservicio) {
        try {
            String query = "UPDATE servicio SET serNombre = ? WHERE cveServicio = ?";
            PreparedStatement statement = connServ.prepareStatement(query);
            statement.setString(1, Upservicio.getA_serNombre());
            statement.setInt(2, servicio.getA_cveServicio());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Servicio servicio) {
        try {
            String query = "DELETE FROM servicio WHERE cveServicio = ?";
            PreparedStatement statement = connServ.prepareStatement(query);
            statement.setInt(1, servicio.getA_cveServicio());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

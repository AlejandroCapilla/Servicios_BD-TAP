package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.Compania;
import javafx.collections.ObservableList;

import java.sql.*;

//insert, update, delete
public class CompaniaDAO {
    Connection connComp;

    public CompaniaDAO (Connection conn){
        this.connComp = conn;
    }

    public void select(ObservableList lsCompañia){
        try{
            String query ="select * from compania";
            Statement st = connComp.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                lsCompañia.add(new Compania(rs.getInt("cveCompania"), rs.getString("comNombre")));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void selectcb(ObservableList lsCompañia){
        try{
            String query ="select comNombre from compania";
            Statement st = connComp.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                lsCompañia.add(rs.getString("comNombre"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public boolean insert(Compania compania) {
        try {
            String query = "insert into compania values(?,?)";
            PreparedStatement statement = connComp.prepareStatement(query);
            statement.setInt(1, compania.getA_cveCompania());
            statement.setString(2, compania.getA_comNombre());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update(Compania compania, Compania Upcompania) {
        try {
            String query = "UPDATE compania SET comNombre = ? WHERE cveCompania = ?";
            PreparedStatement statement = connComp.prepareStatement(query);
            statement.setString(1, Upcompania.getA_comNombre());
            statement.setInt(2, compania.getA_cveCompania());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Compania compania) {
        try {
            String query = "DELETE FROM compania WHERE cveCompania = ?";
            PreparedStatement statement = connComp.prepareStatement(query);
            statement.setInt(1, compania.getA_cveCompania());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

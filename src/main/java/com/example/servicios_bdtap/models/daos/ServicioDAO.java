package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.MySQLConnection;

import java.sql.Statement;

//INSERT, UPDATE, DELETE
public class ServicioDAO {
    private int cveServicio;
    private String serNombre;

    public void insert() {
        try {
            String query = "INSERT servicio (cveServicio, serNombre)" +
                    "VALUES("+cveServicio+",'"+serNombre+"')";
            Statement statement = MySQLConnection.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            String query = "UPDATE servicio SET serNombre ='"+serNombre+
                    "' WHERE cveServicio= "+cveServicio;
            Statement statement = MySQLConnection.getConnection().createStatement();
            statement.executeUpdate(query);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            String query = "DELETE FROM servicio WHERE cveServicio ="+cveServicio;
            Statement statement = MySQLConnection.getConnection().createStatement();
            statement.executeUpdate(query);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


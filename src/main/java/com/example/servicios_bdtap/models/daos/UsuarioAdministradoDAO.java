package com.example.servicios_bdtap.models.daos;

import com.example.servicios_bdtap.models.modelos.UsuarioAdministrado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioAdministradoDAO {
    Connection connAdm;

    public UsuarioAdministradoDAO (Connection conn){
        this.connAdm = conn;
    }

    public UsuarioAdministrado adminLogin(String usu, String contra) throws SQLException {
        UsuarioAdministrado usuarioAdministrado = null;
        try{
            String query = "select * from usuarioAdministrador where admNombre = '"+usu+"' and admPassword = '"+contra+"'";
            Statement st = connAdm.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs != null){
                while (rs.next()){
                    usuarioAdministrado = new UsuarioAdministrado(rs.getInt("cveAdmin"),
                            rs.getString("admNombre"),
                            rs.getString("admPassword"),
                            rs.getString("admTelefono"));
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return usuarioAdministrado;
    }
}

package com.example.servicios_bdtap.models;

public class Conexion {
    private static String server = "127.0.0.1";
    private static String user = "root";
    private static String pwd = "1234";
    private static String db = "Servicios";

    /*
    public static Connection conexion;

    public static void getConexion() {
        try {
            Class.forName("org.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db, user,pwd);

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    */
}

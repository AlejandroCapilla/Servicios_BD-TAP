package com.example.servicios_bdtap.models.modelos;

public class Servicio {
    int a_cveServicio;
    String a_serNombre;

    public Servicio(int a_cveServicio, String a_serNombre) {
        this.a_cveServicio = a_cveServicio;
        this.a_serNombre = a_serNombre;
    }

    public int getA_cveServicio() {
        return a_cveServicio;
    }

    public void setA_cveServicio(int a_cveServicio) {
        this.a_cveServicio = a_cveServicio;
    }

    public String getA_serNombre() {
        return a_serNombre;
    }

    public void setA_serNombre(String a_serNombre) {
        this.a_serNombre = a_serNombre;
    }
}

package com.example.servicios_bdtap.modelosReportes;

public class PorServicio {
    String serNombre;
    Double pserMonto;

    public PorServicio(String serNombre, Double pserMonto) {
        this.serNombre = serNombre;
        this.pserMonto = pserMonto;
    }

    public String getSerNombre() {
        return serNombre;
    }

    public void setSerNombre(String serNombre) {
        this.serNombre = serNombre;
    }

    public Double getPserMonto() {
        return pserMonto;
    }

    public void setPserMonto(Double pserMonto) {
        this.pserMonto = pserMonto;
    }
}

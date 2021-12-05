package com.example.servicios_bdtap.modelosReportes;

public class DeServicios {
    int numTickServicio;
    int cvePagoServ;
    String usuNombre;
    String serNombre;
    Double pserMonto;

    public DeServicios(int numTickServicio, int cvePagoServ, String usuNombre, String serNombre, Double pserMonto) {
        this.numTickServicio = numTickServicio;
        this.cvePagoServ = cvePagoServ;
        this.usuNombre = usuNombre;
        this.serNombre = serNombre;
        this.pserMonto = pserMonto;
    }

    public int getNumTickServicio() {
        return numTickServicio;
    }

    public void setNumTickServicio(int numTickServicio) {
        this.numTickServicio = numTickServicio;
    }

    public int getCvePagoServ() {
        return cvePagoServ;
    }

    public void setCvePagoServ(int cvePagoServ) {
        this.cvePagoServ = cvePagoServ;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
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

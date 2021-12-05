package com.example.servicios_bdtap.models.modelos;

public class ReportePorServicio {
    int a_cveServicio, a_cveAdmin;
    Double a_repsTotalPago;

    public ReportePorServicio(int a_cveServicio) {
        this.a_cveServicio = a_cveServicio;
    }

    public int getA_cveServicio() {
        return a_cveServicio;
    }

    public void setA_cveServicio(int a_cveServicio) {
        this.a_cveServicio = a_cveServicio;
    }

    public int getA_cveAdmin() {
        return a_cveAdmin;
    }

    public void setA_cveAdmin(int a_cveAdmin) {
        this.a_cveAdmin = a_cveAdmin;
    }

    public Double getA_repsTotalPago() {
        return a_repsTotalPago;
    }

    public void setA_repsTotalPago(Double a_repsTotalPago) {
        this.a_repsTotalPago = a_repsTotalPago;
    }
}

package com.example.servicios_bdtap.models.modelos;

public class ReporteDeRecargas {
    int a_cveRecarga, a_cveAdmin;
    double a_rpdrTotalPago;

    public ReporteDeRecargas(int a_cveRecarga) {
        this.a_cveRecarga = a_cveRecarga;
    }

    public int getA_cveRecarga() {
        return a_cveRecarga;
    }

    public void setA_cveRecarga(int a_cveRecarga) {
        this.a_cveRecarga = a_cveRecarga;
    }

    public int getA_cveAdmin() {
        return a_cveAdmin;
    }

    public void setA_cveAdmin(int a_cveAdmin) {
        this.a_cveAdmin = a_cveAdmin;
    }

    public double getA_rpdrTotalPago() {
        return a_rpdrTotalPago;
    }

    public void setA_rpdrTotalPago(double a_rpdrTotalPago) {
        this.a_rpdrTotalPago = a_rpdrTotalPago;
    }
}

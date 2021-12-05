package com.example.servicios_bdtap.models.modelos;

public class ReporteDeServicios {
    int a_cvePagoServ, a_cveAdmin;
    double a_redsTotalPago;

    public ReporteDeServicios(int a_cvePagoServ) {
        this.a_cvePagoServ = a_cvePagoServ;
    }

    public int getA_cvePagoServ() {
        return a_cvePagoServ;
    }

    public void setA_cvePagoServ(int a_cvePagoServ) {
        this.a_cvePagoServ = a_cvePagoServ;
    }

    public int getA_cveAdmin() {
        return a_cveAdmin;
    }

    public void setA_cveAdmin(int a_cveAdmin) {
        this.a_cveAdmin = a_cveAdmin;
    }

    public double getA_redsTotalPago() {
        return a_redsTotalPago;
    }

    public void setA_redsTotalPago(double a_redsTotalPago) {
        this.a_redsTotalPago = a_redsTotalPago;
    }
}

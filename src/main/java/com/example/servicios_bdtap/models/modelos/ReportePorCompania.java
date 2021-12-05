package com.example.servicios_bdtap.models.modelos;

public class ReportePorCompania {
    int a_cveCompania , a_cveAdmin;
    Double a_repcTotalPago;

    public ReportePorCompania(int a_cveCompania) {
        this.a_cveCompania = a_cveCompania;
    }

    public int getA_cveCompania() {
        return a_cveCompania;
    }

    public void setA_cveCompania(int a_cveCompania) {
        this.a_cveCompania = a_cveCompania;
    }

    public int getA_cveAdmin() {
        return a_cveAdmin;
    }

    public void setA_cveAdmin(int a_cveAdmin) {
        this.a_cveAdmin = a_cveAdmin;
    }

    public Double getA_repcTotalPago() {
        return a_repcTotalPago;
    }

    public void setA_repcTotalPago(Double a_repcTotalPago) {
        this.a_repcTotalPago = a_repcTotalPago;
    }
}

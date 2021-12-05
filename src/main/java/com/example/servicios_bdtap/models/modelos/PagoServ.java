package com.example.servicios_bdtap.models.modelos;

public class PagoServ {
    int a_cvePagoServ, cveUsuario, cveServicio;
    Double pserComision, pserMonto;
    int pserNumeReferencia;
    String pserTelefono;

    public PagoServ(int a_cvePagoServ, int cveUsuario, int cveServicio, Double pserComision, Double pserMonto, int pserNumeReferencia, String pserTelefono) {
        this.a_cvePagoServ = a_cvePagoServ;
        this.cveUsuario = cveUsuario;
        this.cveServicio = cveServicio;
        this.pserComision = pserComision;
        this.pserMonto = pserMonto;
        this.pserNumeReferencia = pserNumeReferencia;
        this.pserTelefono = pserTelefono;
    }

    public int getA_cvePagoServ() {
        return a_cvePagoServ;
    }

    public void setA_cvePagoServ(int a_cvePagoServ) {
        this.a_cvePagoServ = a_cvePagoServ;
    }

    public int getCveUsuario() {
        return cveUsuario;
    }

    public void setCveUsuario(int cveUsuario) {
        this.cveUsuario = cveUsuario;
    }

    public int getCveServicio() {
        return cveServicio;
    }

    public void setCveServicio(int cveServicio) {
        this.cveServicio = cveServicio;
    }

    public Double getPserComision() {
        return pserComision;
    }

    public void setPserComision(Double pserComision) {
        this.pserComision = pserComision;
    }

    public Double getPserMonto() {
        return pserMonto;
    }

    public void setPserMonto(Double pserMonto) {
        this.pserMonto = pserMonto;
    }

    public int getPserNumeReferencia() {
        return pserNumeReferencia;
    }

    public void setPserNumeReferencia(int pserNumeReferencia) {
        this.pserNumeReferencia = pserNumeReferencia;
    }

    public String getPserTelefono() {
        return pserTelefono;
    }

    public void setPserTelefono(String pserTelefono) {
        this.pserTelefono = pserTelefono;
    }
}
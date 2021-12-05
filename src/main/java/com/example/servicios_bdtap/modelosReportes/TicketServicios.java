package com.example.servicios_bdtap.modelosReportes;

import java.sql.Date;

public class TicketServicios {
    int numTickServicio;
    int ticsNumeAutorizacion;
    int cvePagoServ;
    int pserNumeReferencia;
    String usuNombre;
    String serNombre;
    Double pserComision;
    Double pserMonto;
    String pserTelefono;
    Date ticsFechaPago;
    String ticsHoraPago;

    public TicketServicios(int numTickServicio, int ticsNumeAutorizacion, int cvePagoServ, int pserNumeReferencia, String usuNombre, String serNombre, Double pserComision, Double pserMonto, String pserTelefono, Date ticsFechaPago, String ticsHoraPago) {
        this.numTickServicio = numTickServicio;
        this.ticsNumeAutorizacion = ticsNumeAutorizacion;
        this.cvePagoServ = cvePagoServ;
        this.pserNumeReferencia = pserNumeReferencia;
        this.usuNombre = usuNombre;
        this.serNombre = serNombre;
        this.pserComision = pserComision;
        this.pserMonto = pserMonto;
        this.pserTelefono = pserTelefono;
        this.ticsFechaPago = ticsFechaPago;
        this.ticsHoraPago = ticsHoraPago;
    }

    public int getNumTickServicio() {
        return numTickServicio;
    }

    public void setNumTickServicio(int numTickServicio) {
        this.numTickServicio = numTickServicio;
    }

    public int getTicsNumeAutorizacion() {
        return ticsNumeAutorizacion;
    }

    public void setTicsNumeAutorizacion(int ticsNumeAutorizacion) {
        this.ticsNumeAutorizacion = ticsNumeAutorizacion;
    }

    public int getCvePagoServ() {
        return cvePagoServ;
    }

    public void setCvePagoServ(int cvePagoServ) {
        this.cvePagoServ = cvePagoServ;
    }

    public int getPserNumeReferencia() {
        return pserNumeReferencia;
    }

    public void setPserNumeReferencia(int pserNumeReferencia) {
        this.pserNumeReferencia = pserNumeReferencia;
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

    public String getPserTelefono() {
        return pserTelefono;
    }

    public void setPserTelefono(String pserTelefono) {
        this.pserTelefono = pserTelefono;
    }

    public Date getTicsFechaPago() {
        return ticsFechaPago;
    }

    public void setTicsFechaPago(Date ticsFechaPago) {
        this.ticsFechaPago = ticsFechaPago;
    }

    public String getTicsHoraPago() {
        return ticsHoraPago;
    }

    public void setTicsHoraPago(String ticsHoraPago) {
        this.ticsHoraPago = ticsHoraPago;
    }
}

package com.example.servicios_bdtap.models.modelos;

import java.util.Date;

public class TicketServicio {
    int a_numTicketServicio, cvePagoServ, ticsNumeAutorizacion;
    Date a_ticsFechaPago;
    String a_ticsHoraPago;

    public TicketServicio(int a_numTicketServicio, int cvePagoServ, int ticsNumeAutorizacion, Date a_ticsFechaPago, String a_ticsHoraPago) {
        this.a_numTicketServicio = a_numTicketServicio;
        this.cvePagoServ = cvePagoServ;
        this.ticsNumeAutorizacion = ticsNumeAutorizacion;
        this.a_ticsFechaPago = a_ticsFechaPago;
        this.a_ticsHoraPago = a_ticsHoraPago;
    }

    public int getA_numTicketServicio() {
        return a_numTicketServicio;
    }

    public void setA_numTicketServicio(int a_numTicketServicio) {
        this.a_numTicketServicio = a_numTicketServicio;
    }

    public int getCvePagoServ() {
        return cvePagoServ;
    }

    public void setCvePagoServ(int cvePagoServ) {
        this.cvePagoServ = cvePagoServ;
    }

    public int getTicsNumeAutorizacion() {
        return ticsNumeAutorizacion;
    }

    public void setTicsNumeAutorizacion(int ticsNumeAutorizacion) {
        this.ticsNumeAutorizacion = ticsNumeAutorizacion;
    }

    public Date getA_ticsFechaPago() {
        return a_ticsFechaPago;
    }

    public void setA_ticsFechaPago(Date a_ticsFechaPago) {
        this.a_ticsFechaPago = a_ticsFechaPago;
    }

    public String getA_ticsHoraPago() {
        return a_ticsHoraPago;
    }

    public void setA_ticsHoraPago(String a_ticsHoraPago) {
        this.a_ticsHoraPago = a_ticsHoraPago;
    }
}

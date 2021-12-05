package com.example.servicios_bdtap.models.modelos;

import java.util.Date;

public class TicketRecarga {
    int a_numTicketRecarga, cveRecarga, ticrNumeAutorizacion;
    Date a_ticrFechaPago;
    String a_ticrHoraPago;

    public TicketRecarga(int a_numTicketRecarga, int cveRecarga, int ticrNumeAutorizacion, Date a_ticrFechaPago, String ticrHoraPago) {
        this.a_numTicketRecarga = a_numTicketRecarga;
        this.cveRecarga = cveRecarga;
        this.ticrNumeAutorizacion = ticrNumeAutorizacion;
        this.a_ticrFechaPago = a_ticrFechaPago;
        this.a_ticrHoraPago = ticrHoraPago;
    }

    public int getA_numTicketRecarga() {
        return a_numTicketRecarga;
    }

    public void setA_numTicketRecarga(int a_numTicketRecarga) {
        this.a_numTicketRecarga = a_numTicketRecarga;
    }

    public int getCveRecarga() {
        return cveRecarga;
    }

    public void setCveRecarga(int cveRecarga) {
        this.cveRecarga = cveRecarga;
    }

    public int getTicrNumeAutorizacion() {
        return ticrNumeAutorizacion;
    }

    public void setTicrNumeAutorizacion(int ticrNumeAutorizacion) {
        this.ticrNumeAutorizacion = ticrNumeAutorizacion;
    }

    public Date getA_ticrFechaPago() {
        return a_ticrFechaPago;
    }

    public void setA_ticrFechaPago(Date a_ticrFechaPago) {
        this.a_ticrFechaPago = a_ticrFechaPago;
    }

    public String getTicrHoraPago() {
        return a_ticrHoraPago;
    }

    public void setTicrHoraPago(String ticrHoraPago) {
        this.a_ticrHoraPago = ticrHoraPago;
    }
}

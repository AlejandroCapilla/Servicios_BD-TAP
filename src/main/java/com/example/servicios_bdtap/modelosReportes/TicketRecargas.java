package com.example.servicios_bdtap.modelosReportes;

import java.sql.Date;

public class TicketRecargas {
    int numTickRecarga;
    int ticrNumeAutorizacion;
    int cveRecarga;
    String usuNombre;
    String comNombre;
    Double recAbono;
    String recTelefono;
    Date ticrFechaPago;
    String ticrHoraPago;

    public TicketRecargas(int numTickRecarga, int ticrNumeAutorizacion, int cveRecarga, String usuNombre, String comNombre,
                          Double recAbono, String recTelefono, Date ticrFechaPago, String ticrHoraPago) {
        this.numTickRecarga = numTickRecarga;
        this.ticrNumeAutorizacion = ticrNumeAutorizacion;
        this.cveRecarga = cveRecarga;
        this.usuNombre = usuNombre;
        this.comNombre = comNombre;
        this.recAbono = recAbono;
        this.recTelefono = recTelefono;
        this.ticrFechaPago = ticrFechaPago;
        this.ticrHoraPago = ticrHoraPago;
    }

    public int getNumTickRecarga() {
        return numTickRecarga;
    }

    public void setNumTickRecarga(int numTickRecarga) {
        this.numTickRecarga = numTickRecarga;
    }

    public int getTicrNumeAutorizacion() {
        return ticrNumeAutorizacion;
    }

    public void setTicrNumeAutorizacion(int ticrNumeAutorizacion) {
        this.ticrNumeAutorizacion = ticrNumeAutorizacion;
    }

    public int getCveRecarga() {
        return cveRecarga;
    }

    public void setCveRecarga(int cveRecarga) {
        this.cveRecarga = cveRecarga;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getComNombre() {
        return comNombre;
    }

    public void setComNombre(String comNombre) {
        this.comNombre = comNombre;
    }

    public Double getRecAbono() {
        return recAbono;
    }

    public void setRecAbono(Double recAbono) {
        this.recAbono = recAbono;
    }

    public String getRecTelefono() {
        return recTelefono;
    }

    public void setRecTelefono(String recTelefono) {
        this.recTelefono = recTelefono;
    }

    public Date getTicrFechaPago() {
        return ticrFechaPago;
    }

    public void setTicrFechaPago(Date ticrFechaPago) {
        this.ticrFechaPago = ticrFechaPago;
    }

    public String getTicrHoraPago() {
        return ticrHoraPago;
    }

    public void setTicrHoraPago(String ticrHoraPago) {
        this.ticrHoraPago = ticrHoraPago;
    }
}

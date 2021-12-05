package com.example.servicios_bdtap.modelosReportes;

public class DeRecargas {
    int numTickRecarga;
    int cveRecarga;
    String usuNombre;
    String comNombre;
    Double recAbono;

    public DeRecargas(int numTickRecarga, int cveRecarga, String usuNombre, String comNombre, Double recAbono) {
        this.numTickRecarga = numTickRecarga;
        this.cveRecarga = cveRecarga;
        this.usuNombre = usuNombre;
        this.comNombre = comNombre;
        this.recAbono = recAbono;
    }

    public int getNumTickRecarga() {
        return numTickRecarga;
    }

    public void setNumTickRecarga(int numTickRecarga) {
        this.numTickRecarga = numTickRecarga;
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
}

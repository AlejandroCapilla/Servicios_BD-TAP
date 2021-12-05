package com.example.servicios_bdtap.modelosReportes;

public class PorCompanias {
    String comNombre;
    Double recAbono;

    public PorCompanias(String comNombre, Double recAbono) {
        this.comNombre = comNombre;
        this.recAbono = recAbono;
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

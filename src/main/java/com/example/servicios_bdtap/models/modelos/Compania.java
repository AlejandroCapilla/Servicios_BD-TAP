package com.example.servicios_bdtap.models.modelos;

public class Compania {
    int a_cveCompania;
    String  a_comNombre;

    public Compania(int a_cveCompania, String a_comNombre) {
        this.a_cveCompania = a_cveCompania;
        this.a_comNombre = a_comNombre;
    }

    public int getA_cveCompania() {
        return a_cveCompania;
    }

    public void setA_cveCompania(int a_cveCompania) {
        this.a_cveCompania = a_cveCompania;
    }

    public String getA_comNombre() {
        return a_comNombre;
    }

    public void setA_comNombre(String a_comNombre) {
        this.a_comNombre = a_comNombre;
    }
}

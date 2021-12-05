package com.example.servicios_bdtap.models.modelos;

public class recarga {
    int a_cveRecarga, a_cveUsuario, a_cveCompania;
    Double a_recAbono;
    String a_recTelefono;

    public recarga(int a_cveRecarga, int a_cveUsuario, int a_cveCompania, Double a_recAbono, String a_recTelefono) {
        this.a_cveRecarga = a_cveRecarga;
        this.a_cveUsuario = a_cveUsuario;
        this.a_cveCompania = a_cveCompania;
        this.a_recAbono = a_recAbono;
        this.a_recTelefono = a_recTelefono;
    }

    public int getA_cveRecarga() {
        return a_cveRecarga;
    }

    public void setA_cveRecarga(int a_cveRecarga) {
        this.a_cveRecarga = a_cveRecarga;
    }

    public int getA_cveUsuario() {
        return a_cveUsuario;
    }

    public void setA_cveUsuario(int a_cveUsuario) {
        this.a_cveUsuario = a_cveUsuario;
    }

    public int getA_cveCompania() {
        return a_cveCompania;
    }

    public void setA_cveCompania(int a_cveCompania) {
        this.a_cveCompania = a_cveCompania;
    }

    public Double getA_recAbono() {
        return a_recAbono;
    }

    public void setA_recAbono(Double a_recAbono) {
        this.a_recAbono = a_recAbono;
    }

    public String getA_recTelefono() {
        return a_recTelefono;
    }

    public void setA_recTelefono(String a_recTelefono) {
        this.a_recTelefono = a_recTelefono;
    }
}

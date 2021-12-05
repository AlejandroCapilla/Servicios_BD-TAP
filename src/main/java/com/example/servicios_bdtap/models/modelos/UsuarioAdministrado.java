package com.example.servicios_bdtap.models.modelos;

public class UsuarioAdministrado {
    int a_cveAdmin;
    String a_admNombre, a_admPassword, admTelefono;

    public UsuarioAdministrado(int a_cveAdmin, String a_admNombre, String a_admPassword, String admTelefono) {
        this.a_cveAdmin = a_cveAdmin;
        this.a_admNombre = a_admNombre;
        this.a_admPassword = a_admPassword;
        this.admTelefono = admTelefono;
    }

    public int getA_cveAdmin() {
        return a_cveAdmin;
    }

    public void setA_cveAdmin(int a_cveAdmin) {
        this.a_cveAdmin = a_cveAdmin;
    }

    public String getA_admNombre() {
        return a_admNombre;
    }

    public void setA_admNombre(String a_admNombre) {
        this.a_admNombre = a_admNombre;
    }

    public String getA_admPassword() {
        return a_admPassword;
    }

    public void setA_admPassword(String a_admPassword) {
        this.a_admPassword = a_admPassword;
    }

    public String getAdmTelefono() {
        return admTelefono;
    }

    public void setAdmTelefono(String admTelefono) {
        this.admTelefono = admTelefono;
    }
}

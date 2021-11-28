package com.example.appsicita.Clases;

public class Usuario {
    String Identificacion,Nombres,Direccion,Movil,Email,enviar, clave;

    public Usuario(String identificacion, String nombres, String direccion, String movil, String email, String enviar, String clave) {
        Identificacion = identificacion;
        Nombres = nombres;
        Direccion = direccion;
        Movil = movil;
        Email = email;
        this.enviar = enviar;
        this.clave = clave;
    }

    public Usuario(String email, String clave) {
        Email = email;
        this.clave = clave;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getMovil() {
        return Movil;
    }

    public void setMovil(String movil) {
        Movil = movil;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEnviar() {
        return enviar;
    }

    public void setEnviar(String enviar) {
        this.enviar = enviar;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

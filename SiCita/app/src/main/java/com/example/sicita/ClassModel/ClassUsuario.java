package com.example.sicita.ClassModel;

import com.google.gson.annotations.SerializedName;

public class ClassUsuario {
    @SerializedName("nombre")
    public String usuario;
    @SerializedName("clave")
    public String clave;



    public ClassUsuario(String usuario, String clave)
    {
        this.usuario=usuario;
        this.clave=clave;
    }


}

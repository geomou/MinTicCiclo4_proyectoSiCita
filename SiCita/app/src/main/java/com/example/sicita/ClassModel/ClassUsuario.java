package com.example.sicita.ClassModel;

public class ClassUsuario {


    private String _usuario;
    private String _clave;



    public ClassUsuario(String usuario, String clave)
    {
        this._usuario=usuario;
        this._clave=clave;
    }

    public String getUsuario(){
        return  _usuario;
    }
    public void setUsuario(String usuario){
        this._usuario=usuario;
    }
    public String getclave(){
        return _clave;
    }
    public void setclave(String clave){
        this._clave= clave;
    }

}

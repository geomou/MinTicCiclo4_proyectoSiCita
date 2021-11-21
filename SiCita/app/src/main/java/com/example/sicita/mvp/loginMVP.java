package com.example.sicita.mvp;

public interface loginMVP {
    interface Model{

        String validarusuario();
    }
    interface Presenter{

        void buscar();


    }
    interface View
    {

        void vervalidacion(String usuario);
    }
}

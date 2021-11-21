package com.example.sicita.presenter;

import com.example.sicita.model.loginInteractor;
import com.example.sicita.mvp.loginMVP;

public class loginPresenter implements loginMVP.Presenter{

    private loginMVP.View view;
    private loginMVP.Model model;

    public   loginPresenter(){
        model= new loginInteractor();
    }
    @Override
    public void buscar() {
        String usuario= model.validarusuario();
        view.vervalidacion(usuario);




    }
}

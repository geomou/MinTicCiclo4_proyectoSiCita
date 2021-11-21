package com.example.sicita.ServicioAdaptadorApi;


import com.example.sicita.ClassModel.ClassUsuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("Usuario_login")
    Call<ClassUsuario> loginusuario(@Body ClassUsuario user);

}

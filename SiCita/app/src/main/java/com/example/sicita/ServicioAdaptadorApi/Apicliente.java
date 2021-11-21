package com.example.sicita.ServicioAdaptadorApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apicliente {
    public   static String url =new UrlAPI().StringApi();
    private  static Retrofit retrofit = null;

    public static Retrofit getusuario(){
        if (retrofit ==null)
        {
            retrofit =new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}

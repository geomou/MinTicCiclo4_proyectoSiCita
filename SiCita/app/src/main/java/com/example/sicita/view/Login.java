package com.example.sicita.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import  android.widget.EditText;
import android.widget.Toast;

import com.example.sicita.R;
import com.example.sicita.mvp.loginMVP;

public class Login extends AppCompatActivity implements loginMVP.View{
    private Button btoingresar; EditText txtusuario; EditText txtclave;
    private String apiurl,usuario,clave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bloquear rotacion de pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
                //Ocultar Accion bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        txtusuario=(EditText) findViewById(R.id.idtxtemailusuairo);
        txtclave=(EditText) findViewById(R.id.idtxtclave);
        btoingresar=(Button) findViewById(R.id.idbtningresar);

    }

    public void ingresar(View view)
    {
        String usuario= txtusuario.getText().toString();
        String clave=txtclave.getText().toString();

        if (!usuario.equals("") && !clave.equals(""))
        {
        if (usuario.equals("admin") && clave.equals("admin"))
        {
            Intent newIntent =new Intent( this, Principal.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            finish();
        }
        else {
            Toast.makeText(this, "Usuario o clave Incorrecto", Toast.LENGTH_SHORT).show();
            txtusuario.requestFocus();
        }

        }
        else
        {
            if (usuario.equals(""))
            {
                Toast.makeText(this, "Usuario no contiene información ", Toast.LENGTH_SHORT).show();
                txtusuario.requestFocus();
            }
            if (clave.equals(""))
            {
                Toast.makeText(this, "Clave no contiene información ", Toast.LENGTH_SHORT).show();
                txtclave.requestFocus();
            }

        }

    }

    private Boolean ValidarIngreso(String  usuario,String clave)
    {
        Boolean ingreso=false;




        return   ingreso =true;


    }

}
package com.example.globalsicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    String usuario, clave;
    EditText txtusuario, txtclave;
    Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        //Ocultar Accion bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        txtusuario = (EditText) findViewById(R.id.idtxtemailusuairo);
        txtclave = (EditText) findViewById(R.id.idtxtclave);
        btningresar = (Button) findViewById(R.id.idbtningresar);


    }

    public void ingresar(View view) {
        String usuario = txtusuario.getText().toString();
        String clave = txtclave.getText().toString();

        if (!usuario.equals("") && !clave.equals("")) {
            if (usuario.equals("admin") && clave.equals("admin")) {
                validaringreso(usuario, clave);
            } else {
                Toast.makeText(this, "Usuario o clave Incorrecto", Toast.LENGTH_SHORT).show();
                txtusuario.requestFocus();
            }

        } else {
            if (usuario.equals("")) {
                Toast.makeText(this, "Usuario no contiene información ", Toast.LENGTH_SHORT).show();
                txtusuario.requestFocus();
            }
            if (clave.equals("")) {
                Toast.makeText(this, "Clave no contiene información ", Toast.LENGTH_SHORT).show();
                txtclave.requestFocus();
            }

        }


    }

    private void validaringreso(String usuario, String clave) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("usuarios");
/*
    Intent newIntent =new Intent( this,Principal.class);
    newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(newIntent);
    finish();
*/
    }
}
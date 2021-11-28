package com.example.globalsicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
String usuario, clave;
EditText txtusurio, txtclave;
Button btningresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtusurio=(EditText) findViewById(R.id.idtxtemailusuairo);
        txtclave=(EditText) findViewById(R.id.idtxtclave);
        btningresar=(Button) findViewById(R.id.idbtningresar);




}

private void validaringreso(){
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("usuarios");

}
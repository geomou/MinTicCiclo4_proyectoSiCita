package com.example.sicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Sede extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede);
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_ppal,menu);
        return  true   ;

    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id=menuItem.getItemId();
        if (id == R.id.mnu_LoginAdmin)
        {
            Intent newIntent=new Intent(this,LoginAdmin.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }
        else if(id == R.id.mnu_LoginUsuario)
        {
            Intent newIntent=new Intent(this,LoginUsuario.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Sede)
        {
            Intent newIntent=new Intent(this,Sede.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }



/*
        switch (id)
        {
            case R.id.mnu_LoginAdmin :
                Intent newIntent=new Intent(this,LoginAdmin.class);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntent);
            case R.id.mnu_LoginUsuario:
                Intent newIntentlu=new Intent(this,LoginUsuario.class);
                newIntentlu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentlu);
            case R.id.mnu_Empresa:
                Intent newIntentemp=new Intent(this,Empresa.class);
                newIntentemp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentemp);
            case R.id.mnu_Sede:
                Intent newIntentse=new Intent(this,Sede.class);
                newIntentse.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentse);
            case R.id.mnu_asesor:
                Intent newIntentas=new Intent(this,Asesor.class);
                newIntentas.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentas);
            case R.id.mnu_SedeHorario:
                Intent newIntentash=new Intent(this,SedeHorario.class);
                newIntentash.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentash);
            case R.id.msnu_empresausuario:
                Intent newIntentaeu=new Intent(this,SedeHorario.class);
                newIntentaeu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentaeu);
            case R.id.mnu_CitaBuscar:
                Intent newIntentacb=new Intent(this,CitaBuscar.class);
                newIntentacb.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentacb);
            case R.id.mnu_Cita:
                Intent newIntentac=new Intent(this,Cita.class);
                newIntentac.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntentac);
            case R.id.mnu_Historia:
                Intent newIntenth=new Intent(this,Historia.class);
                newIntenth.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntenth);

        }
*/
        return super.onOptionsItemSelected(menuItem);
    }

}
package com.example.sicita;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
  /*
    public void  OnBackPressed()
    {
        finish();
    }
    */

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_ppal,menu);
        return  true   ;

    }
    public boolean  onOptionsItemsSelected(MenuItem menuItem)
    {
        int id=menuItem.getItemId();

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
        return  super.onOptionsItemSelected(menuItem);
    }
    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if (KeyCode ==KeyEvent.KEYCODE_BACK )
        {
            new AlertDialog.Builder( this,  R.style.Theme_AppCompat_DayNight_Dialog_Alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Salida del Sistema")
                    .setMessage("¿Desea salir?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Principal.this.finish();
                        }
                    }).show();
            return  true;

        }
         return  super.onKeyDown(KeyCode, event);

    }
}
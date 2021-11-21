package com.example.sicita.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sicita.R;

public class Sede extends AppCompatActivity {
    private EditText txttid,txtidemp,txtempresa,txtnombresede, txtdireccion;
    Switch swmanto,swse,swlav,swrtm;
    Button btnactualizar,btnborrar;
    TextView txvlongitud,txvlatitud;
    String id, idempresa,nombreempresa,sede,direccion,dato,longitud,latitud;
    Boolean continuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede);
        txttid=(EditText) findViewById(R.id.idtxtidsede);
        txtidemp=(EditText) findViewById(R.id.idtxtidempresasede);
        txtempresa=(EditText) findViewById(R.id.idtxtempresasede);
        txtnombresede=(EditText) findViewById(R.id.idtxtnombresede);
        txtdireccion=(EditText) findViewById(R.id.idtxtdireccionsede);
        txtdireccion=(EditText) findViewById(R.id.idtxtdireccionsede);
        swmanto=(Switch) findViewById(R.id.idswmg);
        swse=(Switch) findViewById(R.id.idswse);
        swlav=(Switch) findViewById(R.id.idswlav);
        swrtm=(Switch) findViewById(R.id.idswrtm);
        txvlongitud=(TextView) findViewById(R.id.idtxvlongitud);
        txvlatitud=(TextView) findViewById(R.id.idtxvlatitud);
        btnactualizar=(Button) findViewById(R.id.idbtnactsede);
        btnborrar=(Button) findViewById(R.id.idbtnborrarsede);
     }
     public void Actualizar(View view){
        id=txttid.getText().toString();
        idempresa=txtidemp.getText().toString();
        nombreempresa=txtempresa.getText().toString();
        sede=txtnombresede.getText().toString();
        latitud=txvlatitud.getText().toString();
        longitud=txvlongitud.getText().toString();
         direccion=txtdireccion.getText().toString();
        if (!Validardatos())
        {
            Toast.makeText(this, "No es posible Actualizar ,por la siguiente razón"  + dato, Toast.LENGTH_SHORT).show();
            dato="";
            txttid.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Es posible actualizar"  + dato, Toast.LENGTH_SHORT).show();
        }


    }
     public void Borrar(View view){
         id=txttid.getText().toString();
         if (id.equals(""))
         {
             Toast.makeText(this, "No es posible Eliminar ,no se ha cargado una sede"  , Toast.LENGTH_SHORT).show();
             txtidemp.requestFocus();
         }

     }
     private Boolean Validardatos(){
        continuar=true;
        if (idempresa.equals(""))
        {
            dato=dato + " No  ha cargado empresa " + "\n";
            continuar=false;
        }
        if (sede.equals("") )
        {
            dato=dato + " Nombre Sede " + "\n";
            continuar=false;
        }
        if(direccion.equals(""))
        {
            dato=dato + " Dirección " + "\n";
            continuar=false;
        }
        if (latitud.equals(""))
        {
            dato=dato + " Latitud " + "\n";
            continuar=false;
        }
        if (longitud.equals(""))
         {
             dato=dato + " Longitud " + "\n";
             continuar=false;
         }




        return continuar;
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
            Intent newIntent=new Intent(this, LoginAdmin.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }
        else if(id == R.id.mnu_LoginUsuario)
        {
            Intent newIntent=new Intent(this, LoginUsuario.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Sede)
        {
            Intent newIntent=new Intent(this,Sede.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_SedeHorario)
        {
            Intent newIntent=new Intent(this, Horarios.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }        else if(id == R.id.mnu_asesor)
        {
            Intent newIntent=new Intent(this, Asesor.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Empresa)
        {
            Intent newIntent=new Intent(this, Empresa.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_MaestroCita)
        {
            Intent newIntent=new Intent(this, MaestroCita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_MarcaModelo)
        {
            Intent newIntent=new Intent(this, MarcaModelo.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Vehiculo)
        {
            Intent newIntent=new Intent(this, Vehiculo.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_MaestroCita)
        {
            Intent newIntent=new Intent(this,MaestroCita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Cita)
        {
            Intent newIntent=new Intent(this, Cita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_CitaBuscar)
        {
            Intent newIntent=new Intent(this, CitaBuscar.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_Historia)
        {
            Intent newIntent=new Intent(this, Historia.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_empresausuario)
        {
            Intent newIntent=new Intent(this, EmpresaUsuario.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }





        return super.onOptionsItemSelected(menuItem);
    }


}
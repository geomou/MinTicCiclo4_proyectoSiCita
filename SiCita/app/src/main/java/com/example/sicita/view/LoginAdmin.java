package com.example.sicita.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sicita.R;

public class LoginAdmin extends AppCompatActivity {
    private EditText txtidadmin;EditText txtnit;EditText txtnombres;EditText txttel;EditText txtmovil;EditText txtmail;
    CheckBox chkesadmin;CheckBox chkesasesor;
    Button btnactualizar;Button btnborrar;
 String id; String nit; String nombres;String tel;String movil;String mail;String dato;
 Boolean esadmin;Boolean esasesor;Boolean continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        txtidadmin=(EditText) findViewById(R.id.idtxtidamin);
        txtnit=(EditText) findViewById(R.id.idtxtnitadmin);
        txtnombres=(EditText) findViewById(R.id.idtxtnombreadmin);
        txttel=(EditText) findViewById(R.id.idtxtteladmin);
        txtmovil=(EditText) findViewById(R.id.idtxtmoviladmin);
        txtmail=(EditText) findViewById(R.id.idtxtmoviladmin);
        chkesadmin=(CheckBox) findViewById(R.id.idchkesadmin);
        chkesasesor=(CheckBox) findViewById(R.id.idchkesasesor);


    }
     public void Actualizar(View view)
     {
         nit=txtnit.getText().toString();
         nombres=txtnombres.getText().toString();
         tel=txttel.getText().toString();
         movil=txtmovil.getText().toString();
         mail=txtmail.getText().toString();
         esadmin=chkesadmin.isChecked();
         esasesor=chkesasesor.isChecked();
         if (!ValidardAtos())
         {
             Toast.makeText(this, "No es posible almacenar , por falta de la siguiente información " + dato, Toast.LENGTH_SHORT).show();
             dato="";
             txtnit.requestFocus();

         }
         else

         {
             Toast.makeText(this, "Es posible almacenar " , Toast.LENGTH_SHORT).show();
         }


     }
     public void Borrar (View view)
     {
         id=txtidadmin.getText().toString();
         if(id.equals(""))
         {
             Toast.makeText(this, "No es posible Eliminar , debe de cargar un usuario existente " , Toast.LENGTH_SHORT).show();
             txtnit.requestFocus();
         }
     }
    private  Boolean ValidardAtos()
    {
        continuar=true;
        if (nit.equals(""))
        {
            dato=dato + " Identificación  " + "\n";
            continuar=false;
        }
        if (nombres.equals(""))
        {
            dato=dato + " Nombres " + "\n" ;
            continuar=false;
        }
        if (tel.equals(""))
        {
            dato=dato + " Nombrest " + "\n";
            continuar=false;
        }
        if (movil.equals(""))
        {
            dato=dato + " Móvil " + "\n";
            continuar=false;
        }
        if (mail.equals(""))
        {
            dato=dato + " Mail " + "\n" ;
            continuar=false;
        }


        return  continuar;
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
            Intent newIntent=new Intent(this, LoginUsuario.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Sede)
        {
            Intent newIntent=new Intent(this, Sede.class);
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
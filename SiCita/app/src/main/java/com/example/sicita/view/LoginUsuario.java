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

public class LoginUsuario extends AppCompatActivity {
private EditText txtid;EditText txtidentificacion ;EditText txtnombres;EditText txtdireccion;EditText txtmovil;EditText txtmail;
CheckBox chkenviar;
Button btnactualizar;Button btnborrar;
String dato;String id;String nit;String nombres;String direccion;String movil;String mail;
Boolean continuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);
        txtid=(EditText) findViewById(R.id.idtxtidusuariog);
        txtidentificacion=(EditText) findViewById(R.id.idtxtnitusuario);
        txtnombres=(EditText) findViewById(R.id.idtxtnombreusuario);
        txtdireccion=(EditText) findViewById(R.id.idtxtdireccionusuario);
        txtmovil=(EditText) findViewById(R.id.idtxtmovilusuario);
        txtmail=(EditText) findViewById(R.id.idtxtmailusuario);
        chkenviar=(CheckBox) findViewById(R.id.idchkenviar);
        btnactualizar=(Button) findViewById(R.id.idbtnactualizarusuario);
        btnborrar=(Button) findViewById(R.id.idbtnborrarusuario);


    }
    public void Actualizar(View view){
        id=txtid.getText().toString();
        nit=txtidentificacion.getText().toString();
        nombres=txtnombres.getText().toString();
        direccion=txtdireccion.getText().toString();
        movil=txtmovil.getText().toString();
        mail=txtmail.getText().toString();
        if (!Validardatos())
        {
            Toast.makeText(this, "No es posible almacenar , por falta de la siguiente información " + dato, Toast.LENGTH_SHORT).show();
            dato="";
            txtidentificacion.requestFocus();

        }
        else

        {
            Toast.makeText(this, "Es posible almacenar " , Toast.LENGTH_SHORT).show();
        }

    }
    public void Borrar(View view){
        id=txtid.getText().toString();
        if (id.equals(""))
        {
            Toast.makeText(this, "No es posible Eliminar , debe de cargar un usuario existente " , Toast.LENGTH_SHORT).show();
            txtidentificacion.requestFocus();
        }

    }
    private Boolean Validardatos(){
        continuar=true;
        if (nit.equals(""))
        {
            dato=dato + " Identificación " + "\n";
            continuar=false;
        }
        if (nombres.equals(""))
        {
            dato=dato + " Nombres " + "\n";
            continuar=false;
        }
        if (direccion.equals(""))
        {
            dato=dato + " Dirección " + "\n";
            continuar=false;
        }
        if (movil.equals(""))
        {
            dato=dato + " Móvil " + "\n";
            continuar=false;
        }
        if (mail.equals(""))
        {
            dato=dato + " EMail " + "\n";
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
            Intent newIntent=new Intent(this,LoginUsuario.class);
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
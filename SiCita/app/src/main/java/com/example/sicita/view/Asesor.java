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
import android.widget.Toast;

import com.example.sicita.R;
import com.example.sicita.mvp.asesorMVP;

public class Asesor extends AppCompatActivity implements asesorMVP.View {
    private EditText txtid;EditText txtidentificacion;EditText txtnombre;EditText txttelefono; EditText txtmovil;EditText txtemail;
    Switch swmg; Switch swpintura;Switch swlatoneria;Switch swelectoespe;Switch swelectrogral;
    Button btnactualizar;Button btnborrar;
    String dato="";
    String id;String identificacion;String nombre;String tel;String movil;String mail;
    Boolean mg;Boolean pin; Boolean lat; Boolean esp;Boolean gral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asesor);
        txtid=(EditText) findViewById(R.id.idtxtid);
        txtidentificacion=(EditText) findViewById(R.id.idtxtidentificacion);
        txtnombre=(EditText) findViewById(R.id.idtxtnombre);
        txttelefono=(EditText)  findViewById(R.id.iditxttelefono);
        txtmovil=(EditText) findViewById(R.id.idtxtmovil);
        txtemail=(EditText) findViewById(R.id.idtxtemail);
        swmg=(Switch) findViewById(R.id.idswmg);
        swpintura=(Switch) findViewById(R.id.idswpintura);
        swlatoneria=(Switch) findViewById(R.id.idswlatoneria);
        swelectoespe=(Switch) findViewById(R.id.idswelectroespecial);
        swelectrogral=(Switch) findViewById(R.id.idswelectrogeneral);
        swelectoespe=(Switch) findViewById(R.id.idswelectroespecial);
        btnactualizar =(Button) findViewById(R.id.idbtnActualizar);
        btnborrar=(Button) findViewById(R.id.idbtnborrar);

    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_ppal,menu);
        return  true   ;

    }

    public void Actualizar(View view)
    {
        id=txtid.getText().toString();
        identificacion=txtidentificacion.getText().toString();
        nombre=txtnombre.getText().toString();
        tel=txttelefono.getText().toString();
        movil=txtmovil.getText().toString();
        mail=txtemail.getText().toString();

        boolean validar= this.validarCampos();
        if (!validar)
        {
            Toast.makeText(this, "No es posible almacenar , por falta de la siguiente información " + dato, Toast.LENGTH_SHORT).show();
            txtidentificacion.requestFocus();
            dato="";
        }
        else
        {
            Toast.makeText(this, "Es posible almacenar " + dato, Toast.LENGTH_SHORT).show();
        }

    }
    public void Borrar(View view)
    {
        id=txtid.getText().toString();
        if (id.equals(""))
        {
            Toast.makeText(this, "No es posible eliminar este Asesor , no se encuentra actualizado" , Toast.LENGTH_SHORT).show();
            dato="";
            txtidentificacion.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Es posible borrar " + dato, Toast.LENGTH_SHORT).show();
        }

    }
    public boolean validarCampos()
    {

       boolean continuar=true;

       if (id.equals(""))
       {
           dato=dato+ " Identificación" + "\n";
           continuar= false;
       }
       if (nombre.equals(""))
       {
           dato=dato+ " Nombre " + "\n";
           continuar= false;
       }
        if (tel.equals(""))
        {
            dato=dato+ " Teléfono  " + "\n";
            continuar= false;
        }
        if (movil.equals(""))
        {
            dato=dato+ " Teléfono Móvil  " + "\n";
            continuar= false;
        }
        if (mail.equals(""))
        {
            dato=dato+ " Email  " + "\n";
            continuar= false;
        }

        return continuar;
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
            Intent newIntent=new Intent(this,Asesor.class);
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
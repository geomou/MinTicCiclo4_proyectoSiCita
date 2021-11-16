package com.example.sicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;

public class MarcaModelo extends AppCompatActivity {
    EditText txtid,txtmarca,txtmodeo;
    TableLayout tblmarca,tblmodelo;
    ImageButton btnaddlinmarca,btnaddlinmodelo,btndellinmarca, btndellinmodeo;
    Button btnactualizar,btnborrar;
    String id,dato;
    Integer filastblmarca,filatblmodelo;
    Boolean continuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca_modelo);
        txtid=(EditText) findViewById(R.id.idtxtidempmarca);
        tblmarca=(TableLayout) findViewById(R.id.idtblmarca);
        tblmodelo=(TableLayout) findViewById(R.id.idtblhorarios);
        btnaddlinmarca=(ImageButton) findViewById(R.id.idbtnaddlinmarca);
        btnaddlinmodelo=(ImageButton)findViewById(R.id.idbtnaddlinmodelo);
        btndellinmarca=(ImageButton) findViewById(R.id.idbtndellinmarca);
        btndellinmodeo=(ImageButton) findViewById(R.id.idbtndellinmodelo);
        btnactualizar=(Button) findViewById(R.id.idbtnactualizarmarca);
        txtmarca=(EditText) findViewById(R.id.idtxtmarca);
        txtmodeo=(EditText) findViewById(R.id.idtxtmodeo);


    }

    public void Actualizar(View view)
    {
        id=txtid.getText().toString();
        filastblmarca=tblmarca.getChildCount();
        filatblmodelo=tblmodelo.getChildCount();
        if (!Validardatos())
        {
            Toast.makeText(this, "No es posible Actualizar ,por la siguiente razón"  + dato, Toast.LENGTH_SHORT).show();
            txtmarca.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Es posible actualizar"  + dato, Toast.LENGTH_SHORT).show();
        }



    }
    public void Borrar(View view){
        id=txtid.getText().toString();
        if (id.equals(""))
        {
            Toast.makeText(this, "No es posible Eliminar ,por la siguiente razón"  + dato, Toast.LENGTH_SHORT).show();
            txtmarca.requestFocus();
        }
    }

    private   Boolean Validardatos()
    {
        continuar=true;
        if (id.equals(""))
        {
            dato=dato + "No se ha llamado a una  Empresa " + "\n";
            continuar=false;
        }
        if (filastblmarca == 0)
        {
            dato=dato + " La tabla de Marca no continue datos " + "\n";
            continuar=false;
        }
        if (filatblmodelo==0)
        {
            dato=dato + " La tabla Modelos no continue datos " + "\n";
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

        } else if(id == R.id.mnu_SedeHorario)
        {
            Intent newIntent=new Intent(this,Horarios.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }        else if(id == R.id.mnu_asesor)
        {
            Intent newIntent=new Intent(this,Asesor.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Empresa)
        {
            Intent newIntent=new Intent(this,Empresa.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_MaestroCita)
        {
            Intent newIntent=new Intent(this,MaestroCita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_MarcaModelo)
        {
            Intent newIntent=new Intent(this,MarcaModelo.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Vehiculo)
        {
            Intent newIntent=new Intent(this,Vehiculo.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_MaestroCita)
        {
            Intent newIntent=new Intent(this,MaestroCita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        } else if(id == R.id.mnu_Cita)
        {
            Intent newIntent=new Intent(this,Cita.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_CitaBuscar)
        {
            Intent newIntent=new Intent(this,CitaBuscar.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_Historia)
        {
            Intent newIntent=new Intent(this,Historia.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }else if(id == R.id.mnu_empresausuario)
        {
            Intent newIntent=new Intent(this,EmpresaUsuario.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);

        }





        return super.onOptionsItemSelected(menuItem);
    }


}
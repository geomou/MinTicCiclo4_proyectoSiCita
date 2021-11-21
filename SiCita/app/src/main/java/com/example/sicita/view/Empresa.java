package com.example.sicita.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class Empresa extends AppCompatActivity {
    private EditText txtid; EditText txtnit;EditText txtnombre;EditText txtdireccion;EditText txttel;EditText txttel2; EditText txtcontacto;EditText txturl;EditText txttoken;
    CheckBox  chkactivo;
    Button btnactualizar;Button btnborrar;
    String dato="";String id;String nit; String nombre;String tel;String tel2;String contacto;String url;String token;String dir;
    CheckBox estado;
    Boolean validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        txtid=(EditText) findViewById(R.id.idtxtidemp);
        txtnit=(EditText) findViewById(R.id.idtxtnitemp);
        txtnombre=(EditText) findViewById(R.id.idtxtempresa);
        txtdireccion=(EditText) findViewById(R.id.idtxtdireccion);
        txttel=(EditText) findViewById(R.id.idtxttelefono);
        txttel2=(EditText) findViewById(R.id.idtxttelefono2);
        txtcontacto=(EditText) findViewById(R.id.idtxtcontacto);
        txturl=(EditText) findViewById(R.id.idtxturl);
        txttoken=(EditText) findViewById(R.id.idtxttoken);
        chkactivo=(CheckBox) findViewById(R.id.idckestadoemp);
        btnactualizar=(Button) findViewById(R.id.idbtnActualizar);
        btnborrar=(Button) findViewById(R.id.idbtnborrar);


    }

    public void Actualizar(View view)
    {


        id=txtid.getText().toString();
        nit=txtnit.getText().toString();
        nombre=txtnombre.getText().toString();
        dir=txtdireccion.getText().toString();
        tel=txttel.getText().toString();
        tel2=txttel2.getText().toString();
        contacto=txtcontacto.getText().toString();
        url=txturl.getText().toString();
        token=txttoken.getText().toString();
        validar= this.Validardatos();
        if (!validar)
        {
            Toast.makeText(this, "No es posible almacenar , por falta de la siguiente información " + dato, Toast.LENGTH_SHORT).show();
            txtnit.requestFocus();
            dato="";
        }
        else
        {
            if (chkactivo.isChecked())
            {
                new AlertDialog.Builder( this,  R.style.Theme_AppCompat_DayNight_Dialog_Alert)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirmación")
                        .setMessage("¿Seguro de Marcar la Empresa como Inactiva?")
                        .setNegativeButton("No",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        validar=false;
                                    }
                                })
                        .setPositiveButton("Si",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        validar=true;
                                    }
                                }).show();
                if (!validar)
                {
                    chkactivo.requestFocus();
                }
                else
                {
                    Toast.makeText(this, "Es posible almacenar " + dato, Toast.LENGTH_SHORT).show();
                }

            }
            else {
                Toast.makeText(this, "Es posible almacenar " + dato, Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void Borrar(View view)
   {
       id=txtid.getText().toString();
       if (id.equals(""))
       {
           Toast.makeText(this, "No es posible eliminar esta Empresa , no se encuentra actualizada" , Toast.LENGTH_SHORT).show();
           dato="";
           txtnit.requestFocus();
       }
       else
       {
           Toast.makeText(this, "Es posible borrar " + dato, Toast.LENGTH_SHORT).show();
       }
   }
    protected boolean Validardatos()
    {
        boolean continuar =true;
        if (nit.equals(""))
        {
            dato=dato + " Nit ";
            continuar=false;
        }
        if (nombre.equals(""))
        {
            dato=dato + " Razón Social " + "\n" ;
            continuar=false;
        }
        if (dir.equals(""))
        {
            dato=dato + " Dirección " + "\n" ;
            continuar=false;
        }
        if (tel.equals(""))
        {
            dato=dato + " Teléfono Princial" + "\n" ;
            continuar=false;
        }
        if (contacto.equals(""))
        {
            dato=dato + " Contacto " + "\n" ;
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
            Intent newIntent=new Intent(this,Empresa.class);
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
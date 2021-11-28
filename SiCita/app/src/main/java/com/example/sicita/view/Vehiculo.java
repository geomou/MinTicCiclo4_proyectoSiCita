package com.example.sicita.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sicita.R;
import com.example.sicita.mvp.vehiculoMVP;

public class Vehiculo extends AppCompatActivity implements vehiculoMVP.View {
    private EditText txtid,txtplaca,txtnombre;
    private EditText txtcaracteristicas;
    private Spinner spnmarca, spnmodeo,spnaño;
    private Button btnactualizar,btnborrar;
    private ListView lvListaveh;
    private ListAdapter lvadaptadorlista;

    private String dato,id,nombre,placa,marca,modelo,año,caracteristicas;
    private  Boolean continuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);
        txtid=(EditText) findViewById(R.id.idtxtidpropietario);
        txtnombre=(EditText) findViewById(R.id.idtxtnombrepropietario);
        txtplaca=(EditText) findViewById(R.id.idtxtplacaveh);
        spnmarca=(Spinner) findViewById(R.id.idspnmarcaveh);
        spnmodeo=(Spinner) findViewById(R.id.idspnmodeoveh);
        spnaño=(Spinner) findViewById(R.id.idspnañoveh);
        txtcaracteristicas=(EditText) findViewById(R.id.idtxmocaracteristicasveh);
        btnactualizar=(Button) findViewById(R.id.idbtnactualizarvehi);
        btnborrar=(Button) findViewById(R.id.idibtnborrarvehi);
        lvListaveh=(ListView) findViewById(R.id.idlvvehiculos);


    }
    public void Actualizar(View view){
        id=txtid.getText().toString();
        nombre=txtnombre.getText().toString();
        placa=txtplaca.getText().toString();
        marca=spnmarca.getSelectedItem().toString();
        modelo=spnmodeo.getSelectedItem().toString();
        año=spnaño.getSelectedItem().toString();
        if (!Validardatos())
        {
            Toast.makeText(this, "No es posible Actualizar ,por la siguiente razón :"+ dato, Toast.LENGTH_SHORT).show();
            txtid.requestFocus();
            dato="";
        }
        else
        {
            Toast.makeText(this, "Es posible actualizasr", Toast.LENGTH_SHORT).show();

        }

    }

    public void Borrar(View view){
        id=txtid.getText().toString();
        if (id.equals(""))
        {
            Toast.makeText(this, "No es posible Eliminar ,por la siguiente razón " + dato, Toast.LENGTH_SHORT).show();
            dato="" ;
            txtid.requestFocus();

        }
    }
    private  Boolean Validardatos()
    {
        continuar =true;
        if (id.equals(""))
        {
            dato=" No se ha cargado Propietario " + "\n";
            continuar=false;
        }
        if (placa.equals(""))
        {
            dato=" No se ha registrado la Placa " + "\n";
            continuar=false;
        }

        if (marca.equals(""))
        {
            dato=" No se ha seleccionado Marca " + "\n";
            continuar=false;
        }
        if (modelo.equals(""))
        {
            dato=" No se ha seleccionado  Modelo " + "\n";
            continuar=false;
        }
        if (año.equals(""))
        {
            dato=" No se ha seleccionado Año " + "\n";
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
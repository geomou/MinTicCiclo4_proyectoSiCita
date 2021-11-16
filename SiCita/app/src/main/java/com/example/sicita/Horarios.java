package com.example.sicita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;

public class Horarios extends AppCompatActivity {
 private   EditText txtidsede, txtnombresede,txtnombrehorario;
    CheckBox chklunes, chkmartes, chkmiercoles, chkjueves, chkviernes,chksabado,chkdomingo,chkdisponible;
    Button btnactualizar,btnborrar;
    ImageButton btnactualizardetalle,btnborrardetalle;
    TableLayout tblhorarios;
    String dato,id,nombre,horario;
    Boolean lunes, martes, miercoles, jueves, viernes,sabado, domingo,nodisponible,continuar;
    Integer registros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);
        txtidsede=(EditText) findViewById(R.id.idtxtidsedehorario);
        txtnombresede=(EditText) findViewById(R.id.idtxtxnombresedehorario);
        txtnombrehorario=(EditText) findViewById(R.id.idtxtdesriphorario);
        chklunes=(CheckBox) findViewById(R.id.idchklunes);
        chkmartes=(CheckBox) findViewById(R.id.idchkmartes);
        chkmiercoles=(CheckBox) findViewById(R.id.idchkmiercoles);
        chkjueves=(CheckBox) findViewById(R.id.idchkjueves);
        chkviernes=(CheckBox) findViewById(R.id.idchkviernes);
        chksabado=(CheckBox) findViewById(R.id.idchksabado);
        chkdomingo=(CheckBox) findViewById(R.id.idchkdomingo);
        btnactualizardetalle=(ImageButton) findViewById(R.id.idtxvaddlinhorario);
        btnborrardetalle=(ImageButton) findViewById(R.id.idtxvdellinhorario);
        btnactualizar=(Button) findViewById(R.id.idbtnactualizarhorario);
        btnborrar=(Button) findViewById(R.id.idbtnborrarhorario);
        tblhorarios=(TableLayout) findViewById(R.id.idtblhorarios);
        chkdisponible=(CheckBox) findViewById(R.id.idchknodisponible);

    }

    public void Actualizar(View view){
        id=txtidsede.getText().toString();
        nombre=txtnombresede.getText().toString();
        horario=txtnombrehorario.getText().toString();
        lunes=chklunes.isChecked();
        martes=chkmartes.isChecked();
        miercoles=chkmiercoles.isChecked();
        jueves=chkjueves.isChecked();
        viernes=chkviernes.isChecked();
        sabado=chksabado.isChecked();
        domingo=chkdomingo.isChecked();
        nodisponible=chkdisponible.isChecked();
        registros=tblhorarios.getChildCount();
        if (!validardatos()) 
        {
            Toast.makeText(this, "Es posible almacenar" + dato, Toast.LENGTH_SHORT).show();
            dato="";
            txtidsede.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Es posible actualizar", Toast.LENGTH_SHORT).show();
        }


    }
    public void Borrar(View view)
    {
        id=txtidsede.getText().toString();
        if (id.equals(""))
        {
            Toast.makeText(this, "No es posible Eliminar , debe de cargar una sede existente ", Toast.LENGTH_SHORT).show();
        }

    }


    private  Boolean validardatos()
    {
        continuar=true;
        if (!lunes && !martes && !miercoles && !jueves && !viernes && !sabado && !domingo)
        {
            dato=dato + " No ha seleccionado día  " + "\n";
            continuar=false;

        }
        if (id.equals(""))
        {
            dato=dato + " No ha cargado Sede  " + "\n";
            continuar=false;
        }
        if ( registros == 0)
        {
            dato=dato + " No ha cargado horarios  " + "\n";
            continuar=false;
        }


        return  continuar;

    }


}
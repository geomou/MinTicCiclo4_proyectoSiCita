package com.example.sicita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CitaBuscar extends AppCompatActivity implements
                View.OnClickListener {
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private CheckBox chkbuscarfecha,chkbuscarsede;
    private EditText  txtfecha, txthora;
    private Spinner spnempresa,spnsede,spnplaca,spnnplaca;
    private Button btnbuscar, btnactualizar;
    private String dato,id,fecha,hora,placa,sede,empresa,idsede,placacita;
    private Boolean continuar;
    private TextView txtplaca,txtidsede;









    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita_buscar);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        chkbuscarfecha=(CheckBox) findViewById(R.id.idchkbuscar);
        chkbuscarsede=(CheckBox) findViewById(R.id.idchkbuscarsede);
        spnnplaca=(Spinner) findViewById(R.id.idsnpnplaca);
        spnempresa=(Spinner) findViewById(R.id.idspnempresa);
        spnsede=(Spinner) findViewById(R.id.idsnpsede);
        btnbuscar=(Button) findViewById(R.id.idbtnbuscarcita);
        btnactualizar=(Button) findViewById(R.id.idbtncrearcita);
        txtplaca=(TextView) findViewById(R.id.idtxvplaca);
        txtidsede=(TextView) findViewById(R.id.idtxvidsedebuscar);

    }

    public void Buscar(View view)
    {
        fecha=txtDate.getText().toString();
        hora=txtTime.getText().toString();
        empresa=spnempresa.getSelectedItem().toString();
        sede=spnsede.getSelectedItem().toString();
        placa=spnnplaca.getSelectedItem().toString();
        idsede=txtidsede.getText().toString();
        placacita=txtplaca.getText().toString();
        if (Validardatos(true))
        {
            Toast.makeText(this, "No es posible realizar la consulta ,falta los siguiente datos:" +dato, Toast.LENGTH_SHORT).show();
            dato="";
            spnnplaca.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Se puede  buscar" , Toast.LENGTH_SHORT).show();
            dato="";
        }


    }
    public void Actualizar(View view)
    {
     /*   fecha=txtDate.getText().toString();
        hora=txtTime.getText().toString();*/
        empresa=spnempresa.getSelectedItem().toString();
        sede=spnsede.getSelectedItem().toString();
        placa=spnnplaca.getSelectedItem().toString();

        idsede=txtidsede.getText().toString();
        placacita=txtplaca.getText().toString();
        if (Validardatos(false))
        {
            Toast.makeText(this, "No es posible crear la cita,falta los siguiente datos:" +dato, Toast.LENGTH_SHORT).show();
            dato="";
            spnnplaca.requestFocus();
        }
        else
        {
            Toast.makeText(this, "Se puede  crear la cita" , Toast.LENGTH_SHORT).show();
            dato="";
        }
    }
    private  Boolean Validardatos(Boolean bus)
    {
        continuar= true;

        if (fecha.equals("") && (bus))
        {
            dato=dato + " No ha seleccionado fecha" + "\n";
            continuar=false;
        }
        if (hora.equals("") && (bus))
        {
            dato=dato + " No ha seleccionado hora" + "\n";
            continuar=false;
        }
        if (empresa.equals("") && (bus))
        {
            dato=dato + " No ha seleccionado Empresa" + "\n";
            continuar=false;
        }
        if (sede.equals("") && (bus))
        {
            dato=dato + " No ha seleccionado Sede" + "\n";
            continuar=false;
        }
        if (placa.equals("") && (bus))
        {
            dato=dato + " No ha seleccionado Placa" + "\n";
            continuar=false;
        }
        if (idsede.equals("") || placacita.equals("") && (!bus))
        {
            dato= dato + " No ha seleccionado los datos parala cita" + "\n";
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
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            int monthOfYear = 0;
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }
          , mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }
                , mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

}
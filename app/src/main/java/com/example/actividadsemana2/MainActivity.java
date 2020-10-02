package com.example.actividadsemana2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaracion de variables private //
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private TextView tvFechaNacimiento;
    private Button btnOk;
    private Button btnCancel;
    private Button btnSiguiente;
    private DatePicker picker;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        // Si los parametros del bundle tiene datos o no//
        // Si son identico a null, o sea estan vacio, es porque recien entramos a la aplicacion //
        // si no va para el else, porque los parametros traen datos desde la ventana confirmar datos //
        if (parametros == null) {
            etNombre = (EditText) findViewById(R.id.etNombre);
            tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
            picker = (DatePicker) findViewById(R.id.datePicker);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            btnOk = (Button) findViewById(R.id.btnOk);
            btnCancel = (Button) findViewById(R.id.btnCancel);
            btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        } else {
            // Datos que viene de la pantalla Confirmar Datos por parametros de Bundle //
            nombre = parametros.getString("nombre");
            fechaNacimiento = parametros.getString("fechaNacimiento");
            telefono = parametros.getString("telefono");
            email = parametros.getString("email");
            descripcion = parametros.getString("descripcion");

            // Iguala los campos de la vistas (view) con las variable et //
            etNombre = (EditText) findViewById(R.id.etNombre);
            tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
            picker = (DatePicker) findViewById(R.id.datePicker);
            etTelefono = (EditText) findViewById(R.id.etTelefono);
            etEmail = (EditText) findViewById(R.id.etEmail);
            etDescripcion = (EditText) findViewById(R.id.etDescripcion);
            btnOk = (Button) findViewById(R.id.btnOk);
            btnCancel = (Button) findViewById(R.id.btnCancel);
            btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

            // Con set carga y muestra los datos obtenidos por parametro en los campos correspondientes //
            etNombre.setText(nombre);
            tvFechaNacimiento.setText(fechaNacimiento);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }

        // La escucha del boton Cancelar //
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFechaNacimiento.setText("02/10/2020");
            }
        });

        // La escucha del boton Ok //
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFechaNacimiento.setText(dosDigitos(picker.getDayOfMonth())+"/"+ dosDigitos(picker.getMonth()+1)+"/"+picker.getYear());
                fechaNacimiento = tvFechaNacimiento.getText().toString();

            }
        });

        // La escucha del boton Siguiente //
        btnSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                telefono = etTelefono.getText().toString();
                email = etEmail.getText().toString();
                descripcion = etDescripcion.getText().toString();

                // Para pasar de pantalla MainActivity a ConfirmarDatos //
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("fechaNacimiento", fechaNacimiento);
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",email);
                intent.putExtra("descripcion",descripcion);
                startActivity(intent);
                finish();
            }
        });
    }

        // Agrega a los dias y meses menores a 10 //
        private String dosDigitos ( int n){
            return (n <= 9) ? ("0" + n) : String.valueOf(n);
        }
    }
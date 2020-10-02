package com.example.actividadsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button btnEditar;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        // Iguala las variables String con los datos obtenidos de los parametros del Bundle //
        nombre = parametros.getString("nombre");
        fechaNacimiento = parametros.getString("fechaNacimiento");
        telefono = parametros.getString("telefono");
        email = parametros.getString("email");
        descripcion = parametros.getString("descripcion");

        // Iguala los campos de la vistas (view) con las variable et //
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        // Con set carga y muestra los datos obtenidos por parametro en los campos correspondientes //
        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTel.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        // Escucha del boton Editar //
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Para pasar de pantalla ConfirmarDatos a MainActivity//
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
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

}
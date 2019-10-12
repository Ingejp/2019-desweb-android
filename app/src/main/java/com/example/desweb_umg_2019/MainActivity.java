package com.example.desweb_umg_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCarnet, etNombre, etCorreo, etTelefono;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCarnet = findViewById(R.id.txtCarne);
        etNombre = findViewById(R.id.txtNombre);
        etCorreo = findViewById(R.id.txtCorreo);
        etTelefono = findViewById(R.id.txtTelefono);
        btnGuardar = findViewById(R.id.btnGuardar);

    }



    public void registrarAlumno(){
        ConexionBD conexion = new ConexionBD( this, "bd_alumnos", null, 2);
        SQLiteDatabase baseDeDatos = conexion.getWritableDatabase();

        String carne = this.etCarnet.getText().toString();
        String nombre = this.etNombre.getText().toString();
        String correo = this.etCorreo.getText().toString();
        String telefono = this.etTelefono.getText().toString();

        if(!carne.isEmpty()&& !nombre.isEmpty() && !correo.isEmpty()){
            ContentValues registroAlumno = new ContentValues();
            registroAlumno.put("carne", carne);
            registroAlumno.put("nombre", nombre);
            registroAlumno.put("correo", correo);
            registroAlumno.put("telefono", telefono);
            baseDeDatos.insert("alumno", null, registroAlumno);
            Toast.makeText(this,"Guardado exitosamente", Toast.LENGTH_SHORT).show();

            this.etCarnet.setText("");
            this.etNombre.setText("");
            this.etCorreo.setText("");

        }else{
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        }

    }

}

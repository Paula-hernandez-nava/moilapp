package com.oitic.aplicacionM;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos ,et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Dentro del oncreat", Toast.LENGTH_SHORT).show();
        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_datos = (EditText)findViewById(R.id.txt_datos);
        et1=(EditText)findViewById(R.id.txt_web);

    }

    public void Siguiente(View view){
        Intent siguiente = new Intent(this, Main2Activity.class);
        startActivity(siguiente);
    }


    public void mensaje (View view) {
        Toast mensaje1 = Toast.makeText(getApplicationContext(), "Mensaje ", Toast.LENGTH_LONG);
        mensaje1.show();
    }
    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    public void Buscar(View view){
        String nombre = et_nombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if(datos.length() == 0){
            Toast.makeText(this, "No se encontro ningún registro", Toast.LENGTH_SHORT).show();
        } else {
            et_datos.setText(datos);

        }

    }
    public void Navegar (View view) {
        Intent i =new Intent(this,ActivityWeb.class);
        i.putExtra("sitio web",et1.getText().toString());
        startActivity(i);


    }
}

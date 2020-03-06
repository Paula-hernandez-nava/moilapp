package com.oitic.aplicacionM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText et1, etnum;
    private static final int REQUEST_CALL= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = (EditText)findViewById(R.id.txt_web);
        etnum = findViewById(R.id.editText);
        ImageView imageCall = findViewById(R.id.imagen_call);

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });


    }

    private void makePhoneCall() {
        String number = etnum.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(Main2Activity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(Main2Activity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permiso Negado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

}

package com.example.elperlanegra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity {

    Button regBtn;
    EditText nombre, direccion, telefono, correo, contrasena;
    TextView logEnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        regBtn = findViewById(R.id.buttonReg);
        logEnReg = findViewById(R.id.tv_logReg);
        nombre = findViewById(R.id.et_nombre);
        direccion = findViewById(R.id.et_direccion);
        telefono = findViewById(R.id.et_telefono);
        correo = findViewById(R.id.et_correo);
        contrasena = findViewById(R.id.et_contrasena);

        //Textview iniciar sesion en registroactivity
        logEnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            }
        });

        //Boton registro
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    public void login(View view) {
        startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
    }
}
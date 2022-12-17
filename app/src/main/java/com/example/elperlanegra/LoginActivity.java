package com.example.elperlanegra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button logBtn;
    EditText correo, contrasena;
    TextView regEnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logBtn = findViewById(R.id.buttonLog);
        regEnLog = findViewById(R.id.tv_regLog);
        correo = findViewById(R.id.et_correoLog);
        contrasena = findViewById(R.id.et_contrasenaLog);

        //Textview registrar en loginactivity
        regEnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });

        //Boton iniciar sesion
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void registro(View view) {
        startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
    }
}
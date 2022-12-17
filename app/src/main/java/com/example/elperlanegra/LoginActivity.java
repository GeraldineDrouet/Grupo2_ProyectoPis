package com.example.elperlanegra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button logBtn;
    EditText correo, contrasena;
    TextView regEnLog;

    FirebaseAuth auth;

    ProgressBar pb_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        pb_log = findViewById(R.id.pb_log);
        pb_log.setVisibility(View.GONE);

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
                loginUser();
                //pb_log.setVisibility(View.VISIBLE);

            }
        });
    }

    private void loginUser() {
        String userCorreo = correo.getText().toString();
        String userContrasena = contrasena.getText().toString();


        //correo
        if (TextUtils.isEmpty(userCorreo)){
            Toast.makeText(this, "¡Campo <Correo Electrónico> está vacío!", Toast.LENGTH_SHORT).show();
            return;
        }

        //contraseña
        if (TextUtils.isEmpty(userContrasena)){
            Toast.makeText(this, "¡Campo <Contraseña> está vacío!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userContrasena.length() < 6){
            Toast.makeText(this, "¡¡ATENCIÓN!!\n"+"¡La contraseña debe tener más de 6 dígitos/caracteres!", Toast.LENGTH_SHORT).show();
            return;
        }

        //INICIANDO SESIÓN
        auth.signInWithEmailAndPassword(userCorreo, userContrasena)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            pb_log.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "¡INICIO DE SESIÓN EXITOSO!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            pb_log.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Error: "+ task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
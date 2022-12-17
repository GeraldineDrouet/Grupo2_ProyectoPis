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

import com.example.elperlanegra.modelos.ModeloUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroActivity extends AppCompatActivity {

    Button regBtn;
    EditText nombre, direccion, telefono, correo, contrasena;
    TextView logEnReg;

    FirebaseAuth auth;
    FirebaseDatabase db;

    ProgressBar pb_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        pb_reg = findViewById(R.id.pb_reg);
        pb_reg.setVisibility(View.GONE);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

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
                createUser();
                pb_reg.setVisibility(View.VISIBLE);
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));

            }
        });
    }

    private void createUser() {
        String userNombre = nombre.getText().toString();
        String userDireccion = direccion.getText().toString();
        String userTelefono = telefono.getText().toString();
        String userCorreo = correo.getText().toString();
        String userContrasena = contrasena.getText().toString();

        ///nombre
        if (TextUtils.isEmpty(userNombre)){
            Toast.makeText(this, "¡Campo <Nombre Completo> está vacío!", Toast.LENGTH_SHORT).show();
            return;
        }

        //direccion
        if (TextUtils.isEmpty(userDireccion)){
            Toast.makeText(this, "¡Campo <Dirección> está vacío!", Toast.LENGTH_SHORT).show();
            return;
        }

        //telefono
        if (TextUtils.isEmpty(userTelefono)){
            Toast.makeText(this, "¡Campo <Teléfono> está vacío!", Toast.LENGTH_SHORT).show();
            return;
        }

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

        //CREANDO USUARIO
        auth.createUserWithEmailAndPassword(userCorreo, userContrasena)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            ModeloUser modeloUser = new ModeloUser(userNombre,userDireccion,userTelefono,userCorreo,userContrasena);
                            String id = task.getResult().getUser().getUid();
                            db.getReference().child("Users").child(id).setValue(modeloUser);

                            pb_reg.setVisibility(View.GONE);

                            Toast.makeText(RegistroActivity.this, "¡REGISTRO EXITOSO!", Toast.LENGTH_SHORT).show();
                        } else {
                            pb_reg.setVisibility(View.GONE);
                            Toast.makeText(RegistroActivity.this, "Error: "+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
package com.example.formularios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    Button btnGuardar;
    EditText txtDocumento, txtNombre, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnGuardar = findViewById(R.id.btnGuardar); //Enlazar boton guardae a la variable
        txtDocumento = findViewById(R.id.txtDocumento);
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String documento = txtDocumento.getText().toString();
                if (documento.equals("")){
                    txtDocumento.setError("Ingrese su cedula");
                    txtDocumento.requestFocus();
                } else if (documento.length()<7 || documento.length()>10){
                    txtDocumento.setError("La cedula no es valida");
                    txtDocumento.requestFocus();
                } else {
                    // Patrón para validar el email
                    Pattern pattern = Pattern
                            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                    // El email a validar
                    String email = txtEmail.getText().toString();

                    Matcher mather = pattern.matcher(email);

                    if (!mather.find() == true) {
                        txtEmail.setError("El email ingresado es válido.");
                        txtEmail.requestFocus();
                    }
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
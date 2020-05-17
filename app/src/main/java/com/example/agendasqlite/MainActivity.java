package com.example.agendasqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Button bt1,bt2,bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrar(View view) {
        Intent intentCrearBd= new Intent(this,RegistrarBD.class);
        startActivity(intentCrearBd);

    }

    public void consultar(View view) {
        Intent intentSelect= new Intent(this,Select.class);
        startActivity(intentSelect);

    }

    public void borrar(View view) {

        Intent intentBorrar= new Intent(this,BorrarDatos.class);
        startActivity(intentBorrar);

    }



    public void modificar(View view) {
        Intent intentModificar= new Intent(this,ModificarFila.class);
        startActivity(intentModificar);

    }

    public void listar(View view) {

        Intent listarBd= new Intent(this,ListarBdatos.class);
        startActivity(listarBd);


    }
}

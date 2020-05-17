package com.example.agendasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModificarFila extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_fila);

        ed1=(EditText) findViewById(R.id.editNombre);
        ed2=(EditText) findViewById(R.id.editCalle);
        ed3=(EditText) findViewById(R.id.editTelefono);
        ed4=(EditText) findViewById(R.id.edtDni);
    }

    public void modificar(View view) {

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this, "agenda", null, 1);
        SQLiteDatabase bd=admin.getWritableDatabase();

        String nombre=ed1.getText().toString();
        String calle=ed2.getText().toString();
        String telefono=ed3.getText().toString();
        String dni=ed4.getText().toString();
        ContentValues registro=new ContentValues();
        registro.put("nombre",nombre);
        registro.put("calle",calle);
        registro.put("telefono",telefono);
        int cant = bd.update("datos", registro, "dni="+dni, null);
        bd.close();
        if (cant==1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "no existe una persona con dicho documento", Toast.LENGTH_SHORT).show();


    }
}

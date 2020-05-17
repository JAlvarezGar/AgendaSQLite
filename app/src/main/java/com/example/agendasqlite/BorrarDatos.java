package com.example.agendasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BorrarDatos extends AppCompatActivity {

    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_datos);

        edt1=(EditText)findViewById(R.id.etborrar);
    }

    public void borrar(View view) {
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this, "agenda", null, 1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String dni=edt1.getText().toString();
        int cant=bd.delete("datos", "dni="+dni+"",null);
        bd.close();
        edt1.setText("");

        if (cant==1)
            Toast.makeText(this, "Se borró la persona con dicho documento", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho documento", Toast.LENGTH_SHORT).show();
    }
}

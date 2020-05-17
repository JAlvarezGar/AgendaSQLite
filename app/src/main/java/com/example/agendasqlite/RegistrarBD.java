package com.example.agendasqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class RegistrarBD extends AppCompatActivity implements Button.OnClickListener{

    private EditText edt1,edt2,edt3,edt4;
    String dni="";
    String nombre="";
    String calle="";
    String telefono="";
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_bd);

        edt1=(EditText)findViewById(R.id.edtDni);
        edt2=(EditText)findViewById(R.id.editNombre);
        edt3=(EditText)findViewById(R.id.editCalle);
        edt4=(EditText)findViewById(R.id.editTelefono);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    // guarda registros en la base de datos
    public void guardar(View view) {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"agenda",null,1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        dni= edt1.getText().toString();
        nombre= edt2.getText().toString();
        calle= edt3.getText().toString();
        telefono= edt4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("dni",dni);
        registro.put("nombre",nombre);
        registro.put("calle",calle);
        registro.put("telefono",telefono);
        bd.insert("datos",null,registro);
        bd.close();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona", Toast.LENGTH_SHORT).show();
       Intent intent= new Intent(this,MainActivity.class);
       //intent.putExtra("dni",dni);
       startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        guardar(view);
    }
}

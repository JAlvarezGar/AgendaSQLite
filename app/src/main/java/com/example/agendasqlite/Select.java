package com.example.agendasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Select extends AppCompatActivity implements Button.OnClickListener{

    Button bt1;
    EditText edt1;
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        bt1=(Button)findViewById(R.id.button2);
        edt1=(EditText)findViewById(R.id.etbuscar);
        tv1=(TextView)findViewById(R.id.tvnombre);
        tv3=(TextView)findViewById(R.id.tvcalle);
        tv2=(TextView)findViewById(R.id.tvdni);
        tv4=(TextView)findViewById(R.id.tvtelefono);
        bt1.setOnClickListener(this);


    }
    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "agenda", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String dni = edt1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre,calle,telefono  from datos where dni= " + dni
                        + " ;", null);
        if (fila.moveToFirst()) {
            tv1.setText(fila.getString(0));
            tv2.setText(dni);
            tv3.setText(fila.getString(1));
            tv4.setText(fila.getString(2));

        } else
            Toast.makeText(this, "No existe una persona con dicho dni",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }

    @Override
    public void onClick(View view) {
        consulta(view);
    }
}

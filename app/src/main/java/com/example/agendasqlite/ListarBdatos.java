package com.example.agendasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarBdatos extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bdatos);

        listaBD=(ListView)findViewById(R.id.listView);

        db=openOrCreateDatabase("agenda", Context.MODE_PRIVATE,null);

        listar();
    }

    private void listar() {

        ArrayAdapter<String> adapter;
        List<String> lista= new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM datos",null);
        if(cursor.moveToFirst()){
            do{
                lista.add(cursor.getString(0) + " - " + cursor.getString(1));
            }while(cursor.moveToNext());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaBD.setAdapter(adapter);
        cursor.close();
        db.close();

    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity
{
    //1) Atributo
    ListView listinha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        // 2) Iniciando o elemento
        listinha = findViewById(R.id.listinha);

        // 3) Lista de Alunos para salvar os dados so Select
        ArrayList<Aluno> listaTemp = new ArrayList<Aluno>();

        // 4) Abrir o banco de dados
        SQLiteDatabase dbShow = openOrCreateDatabase("ETEC",
                                        MODE_PRIVATE, null);

        //5) Cursor para receber o select
        Cursor resultado = dbShow.rawQuery("SELECT * FROM Alunos",
                                        null);

        //6) Percorrer o cursor e salvar o aluno na listaTemp
        while(resultado.moveToNext())
        {
            //Instanciando a Classe Aluno
            Aluno alu = new Aluno();
            alu.setMatricula(resultado.getInt(0));
            alu.setNome(resultado.getString(1));
            alu.setCurso(resultado.getString(2));

            //Adcionando o aluno na arraylist
            listaTemp.add(alu);
        }

        //Adaptando a listaTemp para adcionar no layout
        ArrayAdapter<Aluno> adaptador =
                   new ArrayAdapter<Aluno>(ListaActivity.this,
                                 android.R.layout.simple_list_item_1,
                                  listaTemp);

        //Inserindo a listaTemp no listinha(layout)
        listinha.setAdapter(adaptador);


    }
}
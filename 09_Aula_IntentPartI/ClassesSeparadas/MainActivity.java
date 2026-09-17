package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Iniciando os elementos
        btnEntrar = findViewById(R.id.btnEntrar);

        //3) Evento do botão
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*  :::: INTENT ::::
                 Classe responsável pela manipulação
                 das activities!!! Permitindo uma
                 'ligação' entre elas, além de
                 passagem de valores!!!  :)

                 */

                //Instanciando a classe intent
                Intent it = new Intent(MainActivity.this,
                                                MainActivity2.class);
                //Iniciando a segunda activity
                startActivity(it);
            }
        });

    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    ImageView img;
    Button btnDireita, btnEsquerda;
    String aux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' o layout com a programação
        img = findViewById(R.id.img);
        btnDireita = findViewById(R.id.btnDireita);
        btnEsquerda = findViewById(R.id.btnEsquerda);

        //3) Evento btnDireita
        btnDireita.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(aux.equals(""))
                {
                    img.setImageResource(R.drawable.malmsteen);
                    aux = "malmsteen";
                }
                else if(aux.equals("malmsteen"))
                {
                    img.setImageResource(R.drawable.rush);
                    aux = "rush";
                }
                else if(aux.equals("rush"))
                {
                    img.setImageResource(R.drawable.teste);
                    aux = "teste";
                }
                else if(aux.equals("teste"))
                {
                    img.setImageResource(R.drawable.ic_launcher_foreground);
                    aux = "";
                }






            }
        });//

        // 4) Evento btnEsquerda
        btnEsquerda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                img.setImageResource(R.drawable.rush);
            }
        });

        //5) Evento img
        img.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                img.setImageResource(R.drawable.teste);
                return true;
            }
        });


        /*   Fazer as fotos rodarem em Loop
             ex.:
              btnDireita
              Foto1 -> Foto2 -> Foto3 -> Foto1 -> ...

              BtnEsquerda
              Foto1 -> Foto3 -> Foto2 -> Foto1 -> ...



         */




    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{
    //1) Atributos
    TextView lblTitulo2;
    Button btnNavegador, btnGaleria, btnCamera, btnCompartilhar, btnLigar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //2) Iniciar
        lblTitulo2 = findViewById(R.id.lblTitulo2);
        btnNavegador = findViewById(R.id.btnNavegador);
        btnGaleria  = findViewById(R.id.btnGaleria);
        btnCamera = findViewById(R.id.btnCamera);
        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnLigar = findViewById(R.id.btnLigar);
        btnFechar = findViewById(R.id.btnFechar);

        //3) Recuperar valor da outra tela
        String nome = getIntent().getStringExtra("nominho");
        int idade = getIntent().getIntExtra("idadinha",0);

        // 4) Colocando no título
        lblTitulo2.setText("Bem-vindo, " + nome + " de " + idade + "anos!");

        // !!!!! INTENT IMPLÍCITO !!!!!!!
        btnNavegador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri site = Uri.parse("http://google.com");
                startActivity(new Intent(Intent.ACTION_VIEW,site));
            }
        });

        btnLigar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri numTelefone = Uri.parse("tel:11979801104");
                startActivity(new Intent(Intent.ACTION_DIAL,numTelefone));

            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });

        btnCompartilhar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT,
                        "Meu textinho fofo!!! :)");
                startActivity(it.createChooser(it,"Compartilhar via"));
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });





    }
}
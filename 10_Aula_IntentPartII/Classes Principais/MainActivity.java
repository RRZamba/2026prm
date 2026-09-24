package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome, txtIdade;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando
        txtIdade = findViewById(R.id.txtIdade);
        txtNome = findViewById(R.id.txtNome);
        btnEntrar = findViewById(R.id.btnEntrar);

        //3) Evento do botão
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNome.getText().toString();
                int idade = Integer.parseInt(txtIdade.getText().toString());

                //SE Vazio
                if(nome.isEmpty())
                {
                    Toast.makeText(MainActivity.this,
                                "Digite o nome! ANIMAL!",
                             Toast.LENGTH_LONG).show();

                    return;
                }

                //Idade = 0
                if(idade <= 0)
                {
                    Toast.makeText(MainActivity.this,
                            "Digite uma idade válida! ANIMAL!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                if(idade >= 18)
                {
                    //Inicia o intent
                    Intent it = new Intent(MainActivity.this,
                                                MainActivity2.class);

                    //passando os valores
                    it.putExtra("nominho",nome);
                    it.putExtra("idadinha",idade);

                    //Iniciando a outra tela
                    startActivity(it);
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Você é menor! ANIMAL!",
                            Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}

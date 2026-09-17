package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome,txtSenha,txtConfSenha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //2) Iniciando os elementos
        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        txtConfSenha = findViewById(R.id.txtConfSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        //3) Evento do botão
        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recebendo valor
                String nome = txtNome.getText().toString();
                String senha = txtSenha.getText().toString();
                String confSenha = txtConfSenha.getText().toString();

                //Verificando as senhas
                if(senha.equals(confSenha))
                {
                    //Vai pra tela 3
                    Intent it = new Intent(MainActivity2.this,
                                        MainActivity3.class);
                    //Passando os valores
                    it.putExtra("nominho",nome);
                    it.putExtra("senhinha",senha);

                    //Iniciando a tela 3
                    startActivity(it);
                }
                else
                {
                    //Mensagem de ódio
                    Toast.makeText(MainActivity2.this,
                           "Senhas não conferem!!! ANIMAL!!!",
                           Toast.LENGTH_LONG).show();

                    //Limpando os campos
                    txtNome.setText("");
                    txtSenha.setText("");
                    txtConfSenha.setText("");
                }
            }
        });

    }
}
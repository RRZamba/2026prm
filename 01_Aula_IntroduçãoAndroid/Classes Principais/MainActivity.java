package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Classe principal
public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    TextView lblTitulo;
    EditText txtNome, txtIdade, txtSalario;
    Button btnSalvar;


    //Método onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' os elementos do layout com o java S2!!!
        lblTitulo = findViewById(R.id.lblTitulo);
        txtNome = findViewById(R.id.txtNome);
        btnSalvar = findViewById(R.id.btnSalvar);
        txtIdade = findViewById(R.id.txtIdade);
        txtSalario = findViewById(R.id.txtSalario);

        //3) Evento do btnSalvar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando o nome do user
                String nominho = txtNome.getText().toString();
                double salarinho = Double.parseDouble(
                                txtSalario.getText().toString());
                int idadizinha = Integer.parseInt(
                                txtIdade.getText().toString());


                //Colocando uma mensagem no lblTitulo
                lblTitulo.setText("Olá, " + nominho +
                                  "\n Salario: " + salarinho +
                                  "\n Idade: " +idadizinha +
                                  "\n Acho que te amo!!! S2!!!");

                //Limpando a caixa de texto
                txtNome.setText("");
            }
        });
    }
}
package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome, txtQuantidade, txtDescricao, txtValor;
    Button btnCadastrar, btnDescontoLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' os atributos com o .java :)
        txtNome = findViewById(R.id.txtNome);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtQuantidade = findViewById(R.id.txtQuantidade);
        txtValor = findViewById(R.id.txtValor);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnDescontoLimpar = findViewById(R.id.btnDescontoLimpar);

        // 3) btnCadastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperando valores
                String nome = txtNome.getText().toString();
                String qtd = txtQuantidade.getText().toString();
                String descricao = txtDescricao.getText().toString();
                String valor = txtValor.getText().toString();

                //Mensagem
                String mensagem = "Nome: " + nome
                        + "\n Qtd: " + qtd
                        + "\n Desc.: " + descricao
                        + "\n Valor: R$ " + valor;

                //Mostrando a mensagem :/
                Toast.makeText(MainActivity.this,
                        mensagem,
                        Toast.LENGTH_LONG).show();
            }
        });//btn

        //btnDescontoLimpar
        btnDescontoLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Dando 10% de desconto pro mano
                double valor = Double.parseDouble(
                        txtValor.getText().toString());

                valor = valor - (valor * 0.1);

                //Mensagem
                Toast.makeText(MainActivity.this,
                          "Valor com desconto: R$ " + valor,
                           Toast.LENGTH_LONG).show();
            }
        });//btnDescontoLimpar

        //btnDescontLimpar evento 2
        btnDescontoLimpar.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                //Limpando os campos
                txtDescricao.setText("");
                txtValor.setText("");
                txtNome.setText("");
                txtQuantidade.setText("");
                return true;
            }
        });






    }//OnCreate
}//MainActivity

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    TextView lblValor;
    EditText txtNome, txtCategoria,txtPreco;
    SeekBar barraDesconto;
    Button btnTestar;
    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        lblValor = findViewById(R.id.lblValor);
        txtNome  = findViewById(R.id.txtNome);
        txtCategoria  = findViewById(R.id.txtCategoria);
        txtPreco  = findViewById(R.id.txtPreco);
        barraDesconto  = findViewById(R.id.barraDesconto);
        btnTestar  = findViewById(R.id.btnTestar);



        //3) Evento do SeekBar
        barraDesconto.setMax(45);
        barraDesconto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b)
            {
                //Guardando na var. aux o valor da barra
                aux = position;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //Colocar o valor da aux no lblValor
                lblValor.setText("Valor desconto: " + aux + "%");
            }
        }); //SeekBar

        //4) Evento do Botão
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Recuperando os valores
                String nome = txtNome.getText().toString();
                String categoria = txtCategoria.getText().toString();
                double preco = Double.parseDouble(
                                txtPreco.getText().toString());

                //Calcular o desconto
                double resultado = preco - (preco * aux/100);

                //Mensagem
                String mens = "Nome do prato: " + nome
                            + "\n Categoria: " + categoria
                            + "\n Preco original: R$ " + preco
                            + "\n Preco com desconto : R$ " + resultado;

                Toast.makeText(MainActivity.this,
                               mens,
                                Toast.LENGTH_LONG).show();

            }
        });





    }
}
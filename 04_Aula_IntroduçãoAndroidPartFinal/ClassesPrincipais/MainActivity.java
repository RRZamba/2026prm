package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import kotlinx.coroutines.internal.MainDispatcherFactory;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome,txtEnd;
    CheckBox cbAds, cbMusica, cbDormir, cbBallet;
    Button btnTestar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Linkando' o layout com Java
        txtNome = findViewById(R.id.txtNome);
        txtEnd = findViewById(R.id.txtEnd);
        cbBallet = findViewById(R.id.cbBallet);
        cbDormir = findViewById(R.id.cbDormir);
        cbMusica = findViewById(R.id.cbMusica);
        cbAds = findViewById(R.id.cbAds);
        btnTestar = findViewById(R.id.btnTestar);

        //3) Evento do botão
        btnTestar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNome.getText().toString();
                String end = txtEnd.getText().toString();

                //Recuperando valores do CheckBox
                String opcao = "";

                if(cbBallet.isChecked())
                {
                    opcao += "Ballet \n";
                }
                if(cbAds.isChecked())
                {
                    opcao += "ADS \n";
                }
                if(cbDormir.isChecked())
                {
                    opcao += "Dormir \n";
                }
                if(cbMusica.isChecked())
                {
                    opcao += "Música \n";
                }

                //Variável para juntar tudo!!!
                String resultado = "Nome: " + nome +
                                   "\n End.: " + end  +
                                   "\n Opções: " + opcao;

                //Mostrando resultado
                Toast.makeText(MainActivity.this,
                               resultado,
                               Toast.LENGTH_LONG).show();
            }//
        });//
    }//
}//
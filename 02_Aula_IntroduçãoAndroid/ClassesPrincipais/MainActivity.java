package com.example.appmilgrau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome, txtCargo, txtSalario;
    Button btnSalvar, btnSair, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' os atributos com os elementos
        txtNome = findViewById(R.id.txtNome);
        txtCargo = findViewById(R.id.txtCargo);
        txtSalario = findViewById(R.id.txtSalario);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSair = findViewById(R.id.bntSair);
        btnSalvar = findViewById(R.id.btnSalvar);

        //3) Evento btnSalvar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando valores
                String nome =  txtNome.getText().toString();
                String cargo = txtCargo.getText().toString();
                String salario = txtSalario.getText().toString();

                //Mostrando que funcionou :)
                Toast.makeText(MainActivity.this,
                               "Nome: " + nome +
                                   "\n Cargo: " + cargo +
                                   "\n Salário: R$" + salario,
                                    Toast.LENGTH_LONG).show();
            }
        }); //btnSalvar


        //4) Evento btnLimpar
        btnLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Limpando os campos
                txtCargo.setText("");
                txtNome.setText("");
                txtSalario.setText("");
            }
        }); // btnLimpar

        //5) Evento btnSair
        btnSair.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Mens. fofinha!!! S2!!!
                Toast.makeText(MainActivity.this,
                        "Tchau amigo!!! Você é um amigo",
                            Toast.LENGTH_LONG).show();

                //Finalizar a activity
                finishAffinity();

                //Matando a $#@!@!! do processo!!!!
                System.exit(0);
            }
        }); //btnSair
    }
}
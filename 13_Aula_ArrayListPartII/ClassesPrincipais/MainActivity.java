package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome,txtEnd,txtCpf,txtCargo;
    Button btnCad;
    ListView listinha;

    //ArrayList de usuário
    ArrayList<String> listaUsuario = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        txtNome = findViewById(R.id.txtNome);
        txtEnd = findViewById(R.id.txtEnd);
        txtCpf = findViewById(R.id.txtCpf);
        txtCargo = findViewById(R.id.txtCargo);
        btnCad = findViewById(R.id.btnCad);
        listinha = findViewById(R.id.listinha);

        //3) Evento do btnCad
        btnCad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Receber os valores
                String nome = txtNome.getText().toString();
                String endereco = txtEnd.getText().toString();
                String cpf = txtCpf.getText().toString();
                String cargo = txtCargo.getText().toString();

                //Inserindo os valores no ArrayList
                listaUsuario.add("Nome: " + nome +
                                 "End: " + endereco +
                                 "CPF: " + cpf +
                                 "Cargo: " + cargo);

                //Adaptar o ArrayList
                ArrayAdapter<String> adap =
                        new ArrayAdapter<String>(MainActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        listaUsuario);

                //Lista aparece no layout
                listinha.setAdapter(adap);

                //Limpando os campos
                txtCargo.setText("");
                txtCpf.setText("");
                txtEnd.setText("");
                txtNome.setText("");
            }
        });


    }
}
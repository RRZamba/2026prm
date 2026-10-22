package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    EditText txtNome,txtEnd,txtCpf,txtCargo;

    Button btnCad;

    ListView listinha;

    // Criando o ArrayList
    ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos da tela
        txtCargo = findViewById(R.id.txtCargo);
        txtNome = findViewById(R.id.txtNome);
        txtEnd = findViewById(R.id.txtEnd);
        txtCpf = findViewById(R.id.txtCpf);
        btnCad = findViewById(R.id.btnCad);
        listinha = findViewById(R.id.listinha);

        // 3) Evento do btnCad
        btnCad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String end = txtEnd.getText().toString();
                String cpf = txtCpf.getText().toString();
                String nome = txtNome.getText().toString();
                String cargo = txtCargo.getText().toString();

                // Instanciando a classe Usuario
                Usuario user = new Usuario(nome,end,cpf,cargo);


                /*   Exemplo do ArrayList com a Classe Usuário

                      | Nome   | End  |    CPF    | Cargo     |
                     0| Pedro  | SBC  | 12212121  | Chefe     |
                     1| Camila | SBC  | 11112121  | Caixa     |
                     2| Bruna  | Mauá | 85999121  | Motorista |

                 */



                //Adicionando o usuário
                listaUsers.add(user);

                //Adaptando o ArrayList
                ArrayAdapter<Usuario> adaptador =
                            new ArrayAdapter<Usuario>(MainActivity.this,
                                         android.R.layout.simple_list_item_1,
                                          listaUsers);

                // Inserindo a Lista Adaptada no layout
                listinha.setAdapter(adaptador);

                //Limpar os campos
                txtNome.setText("");
                txtCargo.setText("");
                txtCpf.setText("");
                txtEnd.setText("");



            }
        });

        //Evento da listinha
        listinha.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l)
            {
                //Recuperando o valor do ArrayList
                String nome = listaUsers.get(position).getNome();
                String end = listaUsers.get(position).getEndereco();
                String cargo = listaUsers.get(position).getCargo();
                String cpf = listaUsers.get(position).getCpf();

                String mens = "Nome: " + nome +
                              "End.: " + end +
                              "Cargo: " + cargo +
                              "CPF:" + cpf;
                //Mostrando
                Toast.makeText(MainActivity.this,mens,Toast.LENGTH_LONG).show();



            }
        });




    }
}
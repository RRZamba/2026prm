package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtID, txtNome,txtCurso;

    Button btnSalvar, btnSelecionar, btnDeletar,btnAtualizar, btnSelecionarTodos;

    //Classe para trabalhar com o banco de dados
    SQLiteDatabase dbShow;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        btnDeletar =  findViewById(R.id.btnDeletar);
        btnAtualizar =  findViewById(R.id.btnAtualizar);
        btnSelecionar =  findViewById(R.id.btnSelecionar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSelecionarTodos = findViewById(R.id.btnSelecionarTodos);

        //Chamando o método AbrirBD
        AbrirBD();

        //btnSalvar
        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Salvar();
            }
        });

        btnSelecionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Selecionar();
            }
        });

        btnSelecionarTodos.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Abrindo a outra Activity
                Intent it = new Intent(MainActivity.this,
                                        ListaActivity.class);

                startActivity(it);
            }
        });






    } // onCreate

    //Abrir/Criar Banco
    public void AbrirBD()
    {
        //Variável para a query
        String sql;

        try
        {
            //Criando a tabela caso não exista
            sql = "CREATE TABLE IF NOT EXISTS Alunos(" +
                  "Matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                  "Nome TEXT," +
                  "Curso TEXT)";

            //Criando/Abrindo o banco de dados
            dbShow = openOrCreateDatabase("ETEC",
                                        MODE_PRIVATE,
                                      null);

            //Executando a Query
            dbShow.execSQL(sql);

            //Mostrando mensagem
            Toast.makeText(MainActivity.this,
                        "Sistema Carregado com Sucesso!!!",
                            Toast.LENGTH_LONG).show();
        }
        catch(Exception erro)
        {
            Toast.makeText(MainActivity.this,
                            erro.getMessage(),
                            Toast.LENGTH_LONG).show();
        }
    } // AbrirBD


    public void Salvar()
    {
        //Iniciar os elementos de texto
        txtCurso = findViewById(R.id.txtCurso);
        txtNome =  findViewById(R.id.txtNome);

        // Variável para a query
        String sql;

        try
        {
            //Query de Insert
            sql = "INSERT INTO Alunos(Nome,Curso) VALUES" +
                  "( ' " + txtNome.getText().toString() + " '," +
                  " ' " + txtCurso.getText().toString() + " ' )";

            // Executando a query
            dbShow.execSQL(sql);

            Toast.makeText(MainActivity.this,
                         "Aluno Inserido com Sucesso!!!",
                           Toast.LENGTH_LONG).show();

            //Limpando os campos
            txtCurso.setText("");
            txtNome.setText("");

        }
        catch (Exception erro)
        {
            Toast.makeText(MainActivity.this,
                    erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    } //Salvar

        public void Selecionar()
    {
        //Iniciando os elementos
        txtID = findViewById(R.id.txtID);

        //Variável para a query
        String sql;

        try
        {

            //Query de select
            sql = "SELECT * FROM Alunos WHERE Matricula = "
                            + txtID.getText().toString();

            //Cursor para guardar os dados temporariamente
            Cursor cursor = dbShow.rawQuery(sql,null);

            //Movendo para a primeira linh
            cursor.moveToFirst();

            //Pegando os valores
            String nome = cursor.getString(1);
            String curso = cursor.getString(2);

            Toast.makeText(MainActivity.this,
                            "Aluno encontrado:"
                                + "\n" + nome
                                + "\n" + curso,
                                Toast.LENGTH_LONG).show();

            //Fechando o Cursor
            cursor.close();




        }
        catch (Exception erro)
        {
            Toast.makeText(MainActivity.this,
                    erro.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

    }



} //Classe
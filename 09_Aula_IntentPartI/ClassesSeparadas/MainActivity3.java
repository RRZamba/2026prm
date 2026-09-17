package  com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity
{
    //1) Atributo
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //2) Iniciando elementos
        lblResultado = findViewById(R.id.lblResultado);

        //3) Intent para receber os valores
        Intent it = getIntent();

        //4) Mensagem final
        String mensagem = "Usuário Cadastrado!!! \n Nome: "
                            + it.getStringExtra("nominho");

        //5) Mostrando Resultado
        lblResultado.setText(mensagem);
    }
}
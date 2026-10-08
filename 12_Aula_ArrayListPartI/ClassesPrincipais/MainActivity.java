package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    TextView   lblmensagem,lblTextoArtista;
    ImageView imagem;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' os elementos com o layout
        lblmensagem = findViewById(R.id.lblmensagem);
        lblTextoArtista = findViewById(R.id.lblTextoArtista);
        imagem = findViewById(R.id.imagem);
        spinner = findViewById(R.id.spinner);

        /* 3) Criando o ArrayList
              Funciona 'tipo' um array porém
              é uma classe e permite a persistência
              de vários tipos!!! além de métodos
              de acesso, etc!!!
         */
        ArrayList<String> listinha = new ArrayList<String>();

        //4)Adicionando itens do tipo String na minha listinha
        listinha.add("");
        listinha.add("Black Sabbath");
        listinha.add("Rush");
        listinha.add("Kiss");
        listinha.add("Tralalero Tralalá");

        //5) Adaptando o ArrayList para inserir no layout
        ArrayAdapter<String> adaptante =
                  new ArrayAdapter<String>(MainActivity.this,
                                  android.R.layout.simple_list_item_1,
                                    listinha);

        //6) Inserir a lista adaptada no layout
        spinner.setAdapter(adaptante);

        //7) Evento do Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l)
            {
                String itemSelecionado = listinha.get(posicao);

                //Variáveis Auxiliares
                String textoArtista = "";
                int imgArtista = 0;

                if(itemSelecionado.equals(""))
                {
                    textoArtista = "...";
                    imgArtista = R.drawable.ic_launcher_background;
                }

                if(itemSelecionado.equals("Black Sabbath"))
                {
                    textoArtista = "Black Sabbath foi uma banda de heavy metal britânica formada no ano de 1968 em Birmingham pelo guitarrista e principal compositor Tony Iommi, o baixista e principal letrista Geezer Butler, o vocalista Ozzy Osbourne e o baterista Bill Ward.";
                    imgArtista = R.drawable.bs;
                }

                if(itemSelecionado.equals("Rush"))
                {
                    textoArtista = "Rush é uma banda canadense de rock formada em agosto de 1968 na cidade de Toronto, Ontário.[6] A formação original da banda incluía o guitarrista Alex Lifeson, o baterista John Rutsey e o baixista e vocalista Jeff Jones, que foi substituído por Geddy Lee pouco depois de sua formação.";
                    imgArtista = R.drawable.rush;
                }

                if(itemSelecionado.equals("Tralalero Tralalá"))
                {
                    textoArtista = "O primeiro personagem viral fora \"Tralalero Tralala\", um tubarão com três pernas e calçados Nike azuis.";
                    imgArtista = R.drawable.tralale;
                }

                if(itemSelecionado.equals("Kiss"))
                {
                    textoArtista = "Kiss (estilizada como KIϟϟ) foi uma banda de hard rock dos Estados Unidos, formada em Nova Iorque em 1973 por Paul Stanley e Gene Simmons.";
                    imgArtista = R.drawable.kiss;
                }

                //Colocando a imagem e o texto no layout
                lblTextoArtista.setText(textoArtista);
                imagem.setImageResource(imgArtista);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

    }
}
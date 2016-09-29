package br.usjt.arqdesis.aula15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarBancosActivity extends AppCompatActivity {
    public static final String NOME="br.usjt.arqdesis.aula15.nome";
    ArrayList<String>lista;
    Activity atividade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_bancos);
        atividade=this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscaBanco(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhesBancosActivity.class);
                intent.putExtra(NOME, lista.get(position));

                startActivity(intent);
            }
        });
    }

    public ArrayList<String>buscaBanco(String chave)
    {
        ArrayList<String>lista = geraListaBancos();
        if(chave == null || chave.length()==0)
        {
            return lista;
        }else
        {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista)
            {
                if(nome.toUpperCase().contains(chave.toUpperCase()))
                {
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaBancos()
    {
        ArrayList<String>lista = new ArrayList<>();
        lista.add("479 - Itaú");
        lista.add("237 - Bradesco");
        lista.add("033 - Santander Banespa");
        lista.add("001 - Banco do Brasil");
        lista.add("104 - Caixa Econômica Federal");
        return lista;
    }
}
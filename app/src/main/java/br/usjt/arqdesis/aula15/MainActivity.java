package br.usjt.arqdesis.aula15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    public static final String CHAVE = "br.usjt.arqdesis.aula15.chave";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = (EditText) findViewById(R.id.busca_nome_banco);
    }

    public void buscarBanco(View view){
        Intent intent = new Intent(this, ListarBancosActivity.class);
        String chave = nome.getText().toString();
        intent.putExtra(CHAVE,chave);
        startActivity(intent);
    }
}

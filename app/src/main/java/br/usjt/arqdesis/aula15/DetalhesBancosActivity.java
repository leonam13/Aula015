package br.usjt.arqdesis.aula15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class DetalhesBancosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_bancos);
        TextView nome = (TextView)findViewById(R.id.nome_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(ListarBancosActivity.NOME));
    }
}


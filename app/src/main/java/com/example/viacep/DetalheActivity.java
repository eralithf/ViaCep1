package com.example.viacep;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends Activity {

    private TextView textDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        textDetalhe = findViewById(R.id.textDetalhe);


        String cep = getIntent().getStringExtra("cep");
        String logradouro = getIntent().getStringExtra("logradouro");
        String bairro = getIntent().getStringExtra("bairro");
        String cidade = getIntent().getStringExtra("cidade");
        String uf = getIntent().getStringExtra("uf");


        String detalhes = "CEP: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Bairro: " + bairro + "\n" +
                "Cidade: " + cidade + "\n" +
                "Estado: " + uf;

        textDetalhe.setText(detalhes);
    }
}

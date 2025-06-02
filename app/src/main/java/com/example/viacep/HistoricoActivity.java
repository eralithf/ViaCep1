package com.example.viacep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class HistoricoActivity extends Activity {

    ListView listView;
    HistoricoDAO dao;
    ArrayList<Endereco> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        listView = findViewById(R.id.listViewHistorico);
        dao = new HistoricoDAO(this);

        lista = dao.listarTodos();

        ArrayAdapter<Endereco> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );

        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Endereco endereco = lista.get(position);

            Intent intent = new Intent(HistoricoActivity.this, DetalheActivity.class);
            intent.putExtra("cep", endereco.cep);
            intent.putExtra("logradouro", endereco.logradouro);
            intent.putExtra("bairro", endereco.bairro);
            intent.putExtra("cidade", endereco.cidade);
            intent.putExtra("uf", endereco.uf);
            startActivity(intent);
        });
    }
}

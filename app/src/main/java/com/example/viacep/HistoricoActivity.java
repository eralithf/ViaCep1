package com.example.viacep;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class HistoricoActivity extends Activity {

    ListView listView;
    HistoricoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        listView = findViewById(R.id.listViewHistorico);
        dao = new HistoricoDAO(this);

        ArrayList<String> lista = dao.listarTodos();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);
    }
}

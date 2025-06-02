package com.example.viacep;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText editCep;
    private Button btnBuscar, btnHistorico;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCep = findViewById(R.id.editCep);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnHistorico = findViewById(R.id.btnHistorico);
        textResultado = findViewById(R.id.textResultado);


        btnBuscar.setOnClickListener(v -> {
            String cep = editCep.getText().toString().trim();

            if (cep.isEmpty()) {
                Toast.makeText(this, "Digite um CEP.", Toast.LENGTH_SHORT).show();
            } else if (cep.length() != 8 || !cep.matches("\\d+")) {
                Toast.makeText(this, "CEP inválido! Digite exatamente 8 números.", Toast.LENGTH_SHORT).show();
            } else {
                buscarCep(cep);
            }
        });


        btnHistorico.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
            startActivity(intent);
        });
    }

    private void buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        if (response.has("erro")) {
                            textResultado.setText("CEP não encontrado.");
                            return;
                        }

                        String logradouro = response.optString("logradouro", "Não informado");
                        String bairro = response.optString("bairro", "Não informado");
                        String cidade = response.optString("localidade", "Não informado");
                        String uf = response.optString("uf", "Não informado");

                        String resultado = "Logradouro: " + logradouro + "\n" +
                                "Bairro: " + bairro + "\n" +
                                "Cidade: " + cidade + "\n" +
                                "Estado: " + uf;

                        textResultado.setText(resultado);

                    } catch (Exception e) {
                        e.printStackTrace();
                        textResultado.setText("Erro ao processar os dados.");
                    }
                },
                error -> {
                    error.printStackTrace();
                    textResultado.setText("Erro na conexão. Tente novamente.");
                });

        queue.add(jsonObjectRequest);
    }
}

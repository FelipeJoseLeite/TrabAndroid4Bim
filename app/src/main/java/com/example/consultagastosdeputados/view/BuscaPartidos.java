package com.example.consultagastosdeputados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultagastosdeputados.R;
import com.example.consultagastosdeputados.api.ApiDeputado;
import com.example.consultagastosdeputados.api.ApiPartidos;
import com.example.consultagastosdeputados.api.RetroFit;
import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.DeputadosResponse;
import com.example.consultagastosdeputados.model.Partidos;
import com.example.consultagastosdeputados.model.PartidosResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscaPartidos extends AppCompatActivity {

    private Spinner spSiglaPartido;
    private Button btVoltar;
    private Button btBuscar;
    private Map<Spinner, List<String>> spinnerDataMap = new HashMap<>();
    private String siglaPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_partidos);

        spSiglaPartido = findViewById(R.id.spSiglaPartido);
        btBuscar = findViewById(R.id.btBuscar);
        btVoltar = findViewById(R.id.btVoltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscaPartidos.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<String> data1 = new ArrayList<>();
        data1.add("");
        data1.add("MDB");
        data1.add("PDT");
        data1.add("PT");
        data1.add("PCdoB");
        data1.add("PSB");
        data1.add("PSDB");
        data1.add("AGIR");
        data1.add("PMN");
        data1.add("CIDADANIA");
        data1.add("PV");
        data1.add("AVANTE");
        data1.add("PP");
        data1.add("PSTU");
        data1.add("PCB");
        data1.add("PRTB");
        data1.add("DC");
        data1.add("PCO");
        data1.add("PODE");
        data1.add("REPUBLICANOS");
        data1.add("PSOL");
        data1.add("PL");
        data1.add("PSD");
        data1.add("SOLIDARIEDADE");
        data1.add("NOVO");
        data1.add("REDE");
        data1.add("PMB");
        data1.add("UP");
        data1.add("UNIÃO");
        data1.add("PRD");

        spinnerDataMap.put(spSiglaPartido, data1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data1);
        spSiglaPartido.setAdapter(adapter1);

        spSiglaPartido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position != 0){
                    // Obtém o item selecionado no Spinner
                    siglaPartido = (String) parentView.getItemAtPosition(position);

                    // Faça algo com o item selecionado, por exemplo, exibir em um Toast
                    Toast.makeText(BuscaPartidos.this, "Item selecionado: " + siglaPartido, Toast.LENGTH_SHORT).show();
                }else {
                    siglaPartido = null;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Ação quando nenhum item é selecionado (opcional)
            }
        });
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscaPartido();
            }
        });

    }
    public void buscaPartido() {

        ApiPartidos apiPartidos = RetroFit.GET_PARTIDOS();
        Call<PartidosResponse> partidosCall = apiPartidos.obterPartidos(siglaPartido);
        partidosCall.enqueue(new Callback<PartidosResponse>() {
            @Override
            public void onResponse(Call<PartidosResponse> call, Response<PartidosResponse> response) {
                if (response.isSuccessful()) {

                    PartidosResponse partidosResponse = response.body();
                    List<Partidos> partidos = new ArrayList<>();
                    partidos.clear();
                    partidos = partidosResponse.getDados();


                    // Obtenha uma referência ao TableLayout
                    TableLayout tabelaPartidos = findViewById(R.id.tabelaPartidos);

                    // Adicione dinamicamente linhas à tabela para cada deputado
                    for (Partidos partido : partidos) {
                        TableRow row = new TableRow(BuscaPartidos.this);

                        // Preencha as células com os dados correspondentes
                        TextView txtId = new TextView(BuscaPartidos.this);
                        txtId.setText(String.valueOf(partido.getId()));
                        txtId.setPadding(5, 5, 5, 5);
                        row.addView(txtId);

                        TextView txtSigla = new TextView(BuscaPartidos.this);
                        txtSigla.setText(partido.getSigla());
                        txtSigla.setPadding(5, 5, 5, 5);
                        row.addView(txtSigla);

                        TextView txtNome = new TextView(BuscaPartidos.this);
                        txtNome.setText(partido.getNome());
                        txtNome.setPadding(5, 5, 5, 5);
                        row.addView(txtNome);

                        TextView txtUri = new TextView(BuscaPartidos.this);
                        txtUri.setText(partido.getUri());
                        txtUri.setPadding(5, 5, 5, 5);
                        row.addView(txtUri);

                        // Adicione a nova linha à tabela
                        tabelaPartidos.addView(row);
                    }
                } else {
                    // Lógica para lidar com uma resposta de erro
                    Toast.makeText(BuscaPartidos.this, "Não foi possível buscar os Deputados.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidosResponse> call, Throwable t) {
                Log.d("DEBUG", "Erro: " + t.getMessage() + call.toString());

                System.out.println(t.getMessage());
                Toast.makeText(BuscaPartidos.this, "Falha com o Servidor! aaaa" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
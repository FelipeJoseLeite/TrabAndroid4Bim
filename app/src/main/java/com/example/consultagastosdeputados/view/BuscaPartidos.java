package com.example.consultagastosdeputados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.consultagastosdeputados.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscaPartidos extends AppCompatActivity {

    private Spinner spSiglaPartido;
    private Button btVoltar;
    private Map<Spinner, List<String>> spinnerDataMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_partidos);

        spSiglaPartido = findViewById(R.id.spSiglaPartido);
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
                // Obtém o item selecionado no Spinner
                String selectedItem = (String) parentView.getItemAtPosition(position);

                // Faça algo com o item selecionado, por exemplo, exibir em um Toast
                Toast.makeText(BuscaPartidos.this, "Item selecionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Ação quando nenhum item é selecionado (opcional)
            }
        });

    }

}
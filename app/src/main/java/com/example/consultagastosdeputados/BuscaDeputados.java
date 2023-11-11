package com.example.consultagastosdeputados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BuscaDeputados extends AppCompatActivity {

    private EditText edNome;
    private Spinner spSiglaEstado;
    private Spinner spSiglaPartido;
    private Spinner spSiglaSexo;
    private Button btVoltar;
    private Button btBuscar;
    private Map<Spinner, List<String>> spinnerDataMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_deputados);

        edNome = findViewById(R.id.edNome);
        spSiglaPartido = findViewById(R.id.spSiglaPartido);
        spSiglaEstado = findViewById(R.id.spSiglaEstado);
        spSiglaSexo = findViewById(R.id.spSiglaSexo);
        btBuscar = findViewById(R.id.btBuscar);
        btVoltar = findViewById(R.id.btVoltar);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscaDeputados.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Crie uma lista de dados para cada Spinner
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


        List<String> data2 = new ArrayList<>();
        data2.add("");
        data2.add("AC");
        data2.add("AL");
        data2.add("AP");
        data2.add("AM");
        data2.add("BA");
        data2.add("CE");
        data2.add("DF");
        data2.add("ES");
        data2.add("GO");
        data2.add("MA");
        data2.add("MT");
        data2.add("MS");
        data2.add("MG");
        data2.add("PA");
        data2.add("PB");
        data2.add("PR");
        data2.add("PE");
        data2.add("PI");
        data2.add("RJ");
        data2.add("RN");
        data2.add("RS");
        data2.add("RO");
        data2.add("RR");
        data2.add("SC");
        data2.add("SP");
        data2.add("SE");
        data2.add("TO");


        List<String> data3 = new ArrayList<>();
        data3.add("");
        data3.add("F");
        data3.add("M");

        spinnerDataMap.put(spSiglaPartido, data1);
        spinnerDataMap.put(spSiglaEstado, data2);
        spinnerDataMap.put(spSiglaSexo, data3);

        // Crie um adaptador para cada Spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data3);

        // Atribua os adaptadores aos Spinners
        spSiglaPartido.setAdapter(adapter1);
        spSiglaEstado.setAdapter(adapter2);
        spSiglaSexo.setAdapter(adapter3);
    }

}
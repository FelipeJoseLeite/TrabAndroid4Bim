package com.example.consultagastosdeputados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultagastosdeputados.R;
import com.example.consultagastosdeputados.api.ApiDeputado;
import com.example.consultagastosdeputados.api.ApiGastosDeputado;
import com.example.consultagastosdeputados.api.RetroFit;
import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.DeputadosResponse;
import com.example.consultagastosdeputados.model.GastosDeputados;
import com.example.consultagastosdeputados.model.GastosResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscaDeputados extends AppCompatActivity {

    private EditText edNome;
    private Spinner spSiglaEstado;
    private Spinner spSiglaPartido;
    private Spinner spSiglaSexo;
    private Button btVoltar;
    private Button btBuscar;
    private EditText edIdDeputado;
    private Button btBuscarGastos;
    private String siglaPartido;
    private String SiglaEstado;
    private String SiglaSexo;
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
        btBuscarGastos = findViewById(R.id.btBuscarGastos);
        edIdDeputado = findViewById(R.id.edIdDeputado);

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

        spSiglaPartido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(position != 0){

                    siglaPartido = (String) parentView.getItemAtPosition(position);

                    // Faça algo com o item selecionado, por exemplo, exibir em um Toast
                    Toast.makeText(BuscaDeputados.this, "Item selecionado: " + siglaPartido, Toast.LENGTH_SHORT).show();
                } else{
                    siglaPartido = null;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Ação quando nenhum item é selecionado (opcional)
            }
        });
        spSiglaEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position != 0){
                    // Obtém o item selecionado no Spinner
                    SiglaEstado = (String) parentView.getItemAtPosition(position);

                    // Faça algo com o item selecionado, por exemplo, exibir em um Toast
                    Toast.makeText(BuscaDeputados.this, "Item selecionado: " + SiglaEstado, Toast.LENGTH_SHORT).show();
                }else {
                    SiglaEstado = null;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Ação quando nenhum item é selecionado (opcional)
            }
        });
        spSiglaSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position != 0){
                    // Obtém o item selecionado no Spinner
                    SiglaSexo = (String) parentView.getItemAtPosition(position);

                    // Faça algo com o item selecionado, por exemplo, exibir em um Toast
                    Toast.makeText(BuscaDeputados.this, "Item selecionado: " + SiglaSexo, Toast.LENGTH_SHORT).show();
                }else {
                    SiglaSexo = null;
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
                buscaDeputado();
            }
        });

        btBuscarGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiGastosDeputado apiGastosDeputado = RetroFit.GET_GASTOSDEPUTADO();
                Call<GastosResponse> gastosCall = apiGastosDeputado.obterGastosDeputados(Integer.valueOf(edIdDeputado.getText().toString()));
                gastosCall.enqueue(new Callback<GastosResponse>() {

                    @Override
                    public void onResponse(Call<GastosResponse> call, Response<GastosResponse> response) {
                        if (response.isSuccessful()) {

                            GastosResponse gastosResponse = response.body();
                            List<GastosDeputados> gastosDeputados = new ArrayList<>();
                            gastosDeputados.clear();
                            gastosDeputados = gastosResponse.getDados();
                            // Obtenha uma referência ao TableLayout
                            TableLayout tabelaGastos = findViewById(R.id.tabelaGastosDeputado);

                            tabelaGastos.removeViews(1, tabelaGastos.getChildCount() - 1);

                            // Adicione dinamicamente linhas à tabela para cada deputado
                            for (GastosDeputados gastos : gastosDeputados) {
                                TableRow row = new TableRow(BuscaDeputados.this);

                                // Preencha as células com os dados correspondentes
                                TextView txtAno = new TextView(BuscaDeputados.this);
                                txtAno.setText(Integer.toString(gastos.getAno()));
                                txtAno.setPadding(5, 5, 5, 5);
                                row.addView(txtAno);

                                TextView txtMes = new TextView(BuscaDeputados.this);
                                txtMes.setText(Integer.toString(gastos.getMes()));
                                txtMes.setPadding(5, 5, 5, 5);
                                row.addView(txtMes);

                                TextView txtTipoDespesa = new TextView(BuscaDeputados.this);
                                txtTipoDespesa.setText(gastos.getTipoDespesa());
                                txtTipoDespesa.setPadding(5, 5, 5, 5);
                                row.addView(txtTipoDespesa);

                                TextView txtTipoDocumento = new TextView(BuscaDeputados.this);
                                txtTipoDocumento.setText(gastos.getTipoDocumento());
                                txtTipoDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtTipoDocumento);

                                TextView txtDataDocumento = new TextView(BuscaDeputados.this);
                                txtDataDocumento.setText(gastos.getDataDocumento());
                                txtDataDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtDataDocumento);

                                TextView txtValorDocumento = new TextView(BuscaDeputados.this);
                                txtValorDocumento.setText(Double.toString(gastos.getValorDocumento()));
                                txtValorDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtValorDocumento);

                                TextView txtNomeFornecedor = new TextView(BuscaDeputados.this);
                                txtNomeFornecedor.setText(gastos.getNomeFornecedor());
                                txtNomeFornecedor.setPadding(5, 5, 5, 5);
                                row.addView(txtNomeFornecedor);

                                TextView txtValorLiquido = new TextView(BuscaDeputados.this);
                                txtValorLiquido.setText(Double.toString(gastos.getValorLiquido()));
                                txtValorLiquido.setPadding(5, 5, 5, 5);
                                row.addView(txtValorLiquido);

                                TextView txtParcela = new TextView(BuscaDeputados.this);
                                txtParcela.setText(Integer.toString(gastos.getParcela()));
                                txtParcela.setPadding(5, 5, 5, 5);
                                row.addView(txtParcela);

                                // Adicione a nova linha à tabela
                                tabelaGastos.addView(row);
                            }
                        } else {
                            // Lógica para lidar com uma resposta de erro
                            Toast.makeText(BuscaDeputados.this, "Não foi possível buscar os Deputados.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GastosResponse> call, Throwable t) {
                        Log.d("DEBUG", "Erro: " + t.getMessage() + call.toString());

                        System.out.println(t.getMessage());
                        Toast.makeText(BuscaDeputados.this, "Falha com o Servidor! aaaa" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void buscaDeputado() {

        ApiDeputado apiDeputado = RetroFit.GET_DEPUTADO();
        Call<DeputadosResponse> deputadosCall = apiDeputado.obterDeputados(siglaPartido, edNome.getText().toString(), SiglaEstado, SiglaSexo);
        deputadosCall.enqueue(new Callback<DeputadosResponse>() {
            @Override
            public void onResponse(Call<DeputadosResponse> call, Response<DeputadosResponse> response) {
                if (response.isSuccessful()) {

                    DeputadosResponse deputadosResponse = response.body();
                    List<Deputados> deputados = new ArrayList<>();
                    deputados.clear();
                    deputados = deputadosResponse.getDados();


                    // Obtenha uma referência ao TableLayout
                    TableLayout tabelaDeputados = findViewById(R.id.tabelaDeputados);

                    tabelaDeputados.removeViews(1, tabelaDeputados.getChildCount() - 1);


                    // Adicione dinamicamente linhas à tabela para cada deputado
                    for (Deputados deputado : deputados) {
                        TableRow row = new TableRow(BuscaDeputados.this);

                        TextView txtId = new TextView(BuscaDeputados.this);
                        txtId.setText(deputado.getId());
                        txtId.setPadding(5, 5, 5, 5);
                        row.addView(txtId);

                        TextView txtNome = new TextView(BuscaDeputados.this);
                        txtNome.setText(deputado.getNome());
                        txtNome.setPadding(5, 5, 5, 5);
                        row.addView(txtNome);

                        TextView txtPartido = new TextView(BuscaDeputados.this);
                        txtPartido.setText(deputado.getSiglaPartido());
                        txtPartido.setPadding(5, 5, 5, 5);
                        row.addView(txtPartido);

                        TextView txtUF = new TextView(BuscaDeputados.this);
                        txtUF.setText(deputado.getSiglaUf());
                        txtUF.setPadding(5, 5, 5, 5);
                        row.addView(txtUF);

                        TextView txtEmail = new TextView(BuscaDeputados.this);
                        txtEmail.setText(deputado.getEmail());
                        txtEmail.setPadding(5, 5, 5, 5);
                        row.addView(txtEmail);

                        // Adicione a nova linha à tabela
                        tabelaDeputados.addView(row);
                    }
                } else {
                    // Lógica para lidar com uma resposta de erro
                    Toast.makeText(BuscaDeputados.this, "Não foi possível buscar os Deputados.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeputadosResponse> call, Throwable t) {
                Log.d("DEBUG", "Erro: " + t.getMessage() + call.toString());

                System.out.println(t.getMessage());
                Toast.makeText(BuscaDeputados.this, "Falha com o Servidor! aaaa" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
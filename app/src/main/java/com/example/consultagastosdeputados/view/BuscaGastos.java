package com.example.consultagastosdeputados.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultagastosdeputados.R;
import com.example.consultagastosdeputados.api.ApiGastosDeputado;
import com.example.consultagastosdeputados.api.RetroFit;
import com.example.consultagastosdeputados.model.GastosDeputados;
import com.example.consultagastosdeputados.model.GastosResponse;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscaGastos extends AppCompatActivity {

    private EditText edIdDeputado;
    private Button btBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_gastos);

        btBuscar = findViewById(R.id.btBuscar);
        edIdDeputado = findViewById(R.id.edIdDeputado);

        btBuscar.setOnClickListener(new View.OnClickListener() {
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

                            // Adicione dinamicamente linhas à tabela para cada deputado
                            for (GastosDeputados gastos : gastosDeputados) {
                                TableRow row = new TableRow(BuscaGastos.this);

                                // Preencha as células com os dados correspondentes
                                TextView txtAno = new TextView(BuscaGastos.this);
                                txtAno.setText(Integer.toString(gastos.getAno()));
                                txtAno.setPadding(5, 5, 5, 5);
                                row.addView(txtAno);

                                TextView txtMes = new TextView(BuscaGastos.this);
                                txtMes.setText(Integer.toString(gastos.getMes()));
                                txtMes.setPadding(5, 5, 5, 5);
                                row.addView(txtMes);

                                TextView txtTipoDespesa = new TextView(BuscaGastos.this);
                                txtTipoDespesa.setText(gastos.getTipoDespesa());
                                txtTipoDespesa.setPadding(5, 5, 5, 5);
                                row.addView(txtTipoDespesa);

                                TextView txtTipoDocumento = new TextView(BuscaGastos.this);
                                txtTipoDocumento.setText(gastos.getTipoDocumento());
                                txtTipoDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtTipoDocumento);

                                TextView txtDataDocumento = new TextView(BuscaGastos.this);
                                txtDataDocumento.setText(gastos.getDataDocumento());
                                txtDataDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtDataDocumento);

                                TextView txtValorDocumento = new TextView(BuscaGastos.this);
                                txtValorDocumento.setText(Double.toString(gastos.getValorDocumento()));
                                txtValorDocumento.setPadding(5, 5, 5, 5);
                                row.addView(txtValorDocumento);

                                TextView txtNomeFornecedor = new TextView(BuscaGastos.this);
                                txtNomeFornecedor.setText(gastos.getNomeFornecedor());
                                txtNomeFornecedor.setPadding(5, 5, 5, 5);
                                row.addView(txtNomeFornecedor);

                                TextView txtValorLiquido = new TextView(BuscaGastos.this);
                                txtValorLiquido.setText(Double.toString(gastos.getValorLiquido()));
                                txtValorLiquido.setPadding(5, 5, 5, 5);
                                row.addView(txtValorLiquido);

                                TextView txtParcela = new TextView(BuscaGastos.this);
                                txtParcela.setText(Integer.toString(gastos.getParcela()));
                                txtParcela.setPadding(5, 5, 5, 5);
                                row.addView(txtParcela);

                                // Adicione a nova linha à tabela
                                tabelaGastos.addView(row);
                            }
                        } else {
                            // Lógica para lidar com uma resposta de erro
                            Toast.makeText(BuscaGastos.this, "Não foi possível buscar os Deputados.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GastosResponse> call, Throwable t) {
                        Log.d("DEBUG", "Erro: " + t.getMessage() + call.toString());

                        System.out.println(t.getMessage());
                        Toast.makeText(BuscaGastos.this, "Falha com o Servidor! aaaa" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
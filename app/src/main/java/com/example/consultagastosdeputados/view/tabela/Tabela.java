package com.example.consultagastosdeputados.view.tabela;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultagastosdeputados.R;
import com.example.consultagastosdeputados.api.ApiGastosDeputado;
import com.example.consultagastosdeputados.api.RetroFit;
import com.example.consultagastosdeputados.model.GastosDeputados;
import com.example.consultagastosdeputados.model.GastosResponse;
import com.example.consultagastosdeputados.model.Partidos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tabela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);

    }
}
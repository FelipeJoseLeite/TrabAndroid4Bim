package com.example.consultagastosdeputados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearDeputado;
    private LinearLayout linearPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearDeputado = findViewById(R.id.linearDeputado);
        linearPartidos = findViewById(R.id.linearPartidos);

        linearPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BuscaPartidos.class);
                startActivity(intent);
            }
        });
        linearDeputado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BuscaDeputados.class);
                startActivity(intent);
            }
        });

    }
}
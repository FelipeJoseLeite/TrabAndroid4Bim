package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.Partidos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPartidos {

    @GET("partidos")
    Call<List<Partidos>> obterPartidos();
}

package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.Partidos;
import com.example.consultagastosdeputados.model.PartidosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiPartidos {

    @GET("partidos")
    Call<PartidosResponse> obterPartidos(@Query("sigla") String siglaPartido);
}

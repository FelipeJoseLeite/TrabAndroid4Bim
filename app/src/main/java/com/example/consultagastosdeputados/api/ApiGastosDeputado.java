package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.GastosResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiGastosDeputado {

    @GET("deputados/{id}/despesas")
    Call<GastosResponse> obterGastosDeputados(@Path("id") Integer idDeputado);
}

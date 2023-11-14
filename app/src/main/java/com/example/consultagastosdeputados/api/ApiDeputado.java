package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import com.example.consultagastosdeputados.model.DeputadosResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiDeputado {

    @GET("deputados")
    Call<DeputadosResponse> obterDeputados(@Query("siglaPartido") String siglaPartido, @Query("nome") String nome, @Query("siglaUf") String siglaEstado,
                                           @Query("siglaSexo") String siglaSexo);
}

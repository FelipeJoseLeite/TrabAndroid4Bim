package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiGastosDeputado {

    @GET("deputados/{id}/despesas")
    Call<List<Deputados>> obterGastosDeputados();
}

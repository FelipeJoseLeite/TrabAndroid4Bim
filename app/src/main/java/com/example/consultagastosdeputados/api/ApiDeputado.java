package com.example.consultagastosdeputados.api;

import com.example.consultagastosdeputados.model.Deputados;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDeputado {

    @GET("deputados")
    Call<List<Deputados>> obterDeputados();
}

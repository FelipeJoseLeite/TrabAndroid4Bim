package com.example.consultagastosdeputados.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFit {

    private static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    private static Retrofit retrofit;

    private static retrofit2.Retrofit retrofit1 = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiDeputado GET_DEPUTADO(){return retrofit1.create(ApiDeputado.class);}

    public static ApiPartidos GET_PARTIDOS(){return retrofit1.create(ApiPartidos.class);}

    public static ApiGastosDeputado GET_GASTOSDEPUTADO(){return retrofit1.create(ApiGastosDeputado.class);}
}

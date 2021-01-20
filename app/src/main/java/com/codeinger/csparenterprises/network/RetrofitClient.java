package com.codeinger.csparenterprises.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  RetrofitClient {
    private static Retrofit retrofit;

    public static final Retrofit getRetrofit(String baseUrl){
        if (retrofit==null)
            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        }

}

package com.isigk.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String Base_Url="http://10.0.3.2/ISIGK/";

    private static Retrofit retrofit;


    public static Retrofit getClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }


}

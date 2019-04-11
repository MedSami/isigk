package com.isigk.Api;

import com.isigk.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("cin") String cin,
                                  @Query("type") String type
    );
}

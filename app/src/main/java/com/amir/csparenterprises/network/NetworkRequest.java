package com.amir.csparenterprises.network;

import com.amir.csparenterprises.model.ViewPortResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkRequest {

    @GET("viewreport.php")
    Call<ViewPortResponse> getViewreport();

}

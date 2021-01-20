package com.codeinger.csparenterprises.network;

import com.codeinger.csparenterprises.model.ViewPortResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkRequest {

    @GET("viewreport.php")
    Call<ViewPortResponse> getViewreport();

}

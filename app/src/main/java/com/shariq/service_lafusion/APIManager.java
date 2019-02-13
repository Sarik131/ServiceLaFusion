package com.shariq.service_lafusion;

import com.google.gson.JsonElement;
import com.shariq.service_lafusion.model.SpList;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Chintan on 12-02-2018.
 */

public interface APIManager {

    @FormUrlEncoded
    @POST(Constant.URL_LOGIN)
    Call<Map<String, Object>> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_REGISTER)
    Call<Map<String, Object>> register(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_GET_DETAIL)
    Call<Map<String, Object>> getDetails(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_GET_SP_LIST)
    Call<Map<String, Object>> getSpList(@FieldMap Map<String, String> params);



    // Add all your api calls here...
}

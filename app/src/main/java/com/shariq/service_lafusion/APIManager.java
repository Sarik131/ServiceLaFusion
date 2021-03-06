package com.shariq.service_lafusion;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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

    @FormUrlEncoded
    @POST(Constant.URL_CUST_REGISTER)
    Call<Map<String, Object>> custRegister(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_CREATE_QUERY)
    Call<Map<String, Object>> createQuery(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Constant.URL_QUERY_STATUS)
    Call<Map<String, Object>> queryStatus(@FieldMap Map<String, String> params);
    // Add all your api calls here...
}

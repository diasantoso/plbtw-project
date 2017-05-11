package com.restopedia_team.restopedia.API;


import com.restopedia_team.restopedia.Model.UserInfo;
import com.restopedia_team.restopedia.Model.UserKonten;
import com.restopedia_team.restopedia.Model.UserLogin;
import com.restopedia_team.restopedia.Model.UserRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Erikku_Seiichiro on 08-May-17.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("signUp")
    Call<UserRegister> signUp(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

    @FormUrlEncoded
    @POST("login")
    Call<UserLogin> login(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

//    @POST("addKonten")
//    Call<APIBaseResponse> addKonten(@Query("api_key") String api_key, @Query("username") String username, @Query("nama") String nama, @Query("detail") String detail, @Query("alamat") String alamat, @Query("kota") String kota, @Query("gambar") String gambar, @Query("namagambar") String namagambar);

    @GET("getUserInfo")
    Call<UserInfo> getUserInfo(@Query("username") String username, @Query("api_key") String api_key);

    @GET("getAllKonten")
    Call<UserKonten> getAllKonten(@Query("username") String username, @Query("api_key") String api_key);
}

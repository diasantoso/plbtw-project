package com.restopedia_team.restopedia_app.API;

import com.restopedia_team.restopedia_app.Model.UserInfo;
import com.restopedia_team.restopedia_app.Model.UserKonten;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Erikku_Seiichiro on 08-May-17.
 */

public interface ApiInterface {
//    @POST("signUp")
//    Call<APIBaseResponse> signUp(@Query("username") String username, @Query("password") String password, @Query("api_key") String api_key);
//
//    @POST("login")
//    Call<APIUserData> login(@Query("username") String username, @Query("password") String password, @Query("api_key") String api_key);
//
//    @POST("addKonten")
//    Call<APIBaseResponse> addKonten(@Query("api_key") String api_key, @Query("username") String username, @Query("nama") String nama, @Query("detail") String detail, @Query("alamat") String alamat, @Query("kota") String kota, @Query("gambar") String gambar, @Query("namagambar") String namagambar);

    @GET("getUserInfo")
    Call<UserInfo> getUserInfo(@Query("username") String username, @Query("api_key") String api_key);

    @GET("getAllKonten")
    Call<UserKonten> getAllKonten(@Query("username") String username, @Query("api_key") String api_key);

}

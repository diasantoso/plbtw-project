package com.plbtw_asek.restopedia.API;



import com.plbtw_asek.restopedia.Model.StatusMessage;
import com.plbtw_asek.restopedia.Model.UserInfo;
import com.plbtw_asek.restopedia.Model.UserKonten;
import com.plbtw_asek.restopedia.Model.UserLogin;

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
    @POST("login")
    Call<UserLogin> login(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

    @FormUrlEncoded
    @POST("signUp")
    Call<StatusMessage> signUp(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

    @FormUrlEncoded
    @POST("addKonten")
    Call<StatusMessage> addKonten(@Field("api_key") String api_key, @Field("username") String username, @Field("nama") String nama, @Field("detail") String detail, @Field("alamat") String alamat, @Field("kota") String kota, @Field("gambar") String gambar, @Field("namagambar") String namagambar);

    @GET("getUserInfo")
    Call<UserInfo> getUserInfo(@Query("username") String username, @Query("api_key") String api_key);

    @GET("getAllKonten")
    Call<UserKonten> getAllKonten(@Query("api_key") String api_key);

    @GET("getMyKonten")
    Call<UserKonten> getMyKonten(@Query("username") String username, @Query("api_key") String api_key);

    @FormUrlEncoded
    @POST("delKonten")
    Call<StatusMessage> delKonten(@Field("api_key") String api_key, @Field("id_resto") String id_resto);
}

package com.restopedia_team.restopedia_app.API;

import com.plbtw_team.restopedia.Helper.ToStringConverter;
import com.plbtw_team.restopedia.Model.APIBaseResponse;
import com.plbtw_team.restopedia.Model.APIKonten;
import com.plbtw_team.restopedia.Model.APIUserData;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Dias on 4/13/2017.
 */
public class RestClient {

    private static GitApiInterface gitApiInterface ;
    private static String baseUrl = "http://restopedia.890m.com" ;

    public static GitApiInterface getClient() {
        if (gitApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            gitApiInterface = client.create(GitApiInterface.class);
        }
        return gitApiInterface ;
    }

    public interface GitApiInterface {

        @FormUrlEncoded
        @POST("/restopedia-rest/index.php/API/restopedia/signUp")
        Call<APIBaseResponse> signUp(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

        @FormUrlEncoded
        @POST("/restopedia-rest/index.php/API/restopedia/login")
        Call<APIUserData> login(@Field("username") String username, @Field("password") String password, @Field("api_key") String api_key);

        @GET("/restopedia-rest/index.php/API/restopedia/getUserInfo")
        Call<APIUserData> getUserInfo(@Query("username") String username, @Field("api_key") String api_key);

        @FormUrlEncoded
        @POST("/restopedia-rest/index.php/API/restopedia/addKonten")
        Call<APIBaseResponse> addKonten(@Field("api_key") String api_key, @Field("username") String username, @Field("nama") String nama, @Field("detail") String detail, @Field("alamat") String alamat
                , @Field("kota") String kota, @Field("gambar") String gambar, @Field("namagambar") String namagambar);

        @Headers("Cache-Control: no-cache")
        @GET("/restopedia-rest/index.php/API/restopedia/getKontenAll")
        Call<APIKonten> getAllKonten(@Query("username") String username, @Field("api_key") String api_key);

    }
}

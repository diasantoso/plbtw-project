package com.plbtw_asek.restopedia.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erikku_Seiichiro on 08-May-17.
 */

public class ApiClient {
    public static final String BASE_URL = "http://restopedia.890m.com/restopedia-rest/index.php/API/restopedia/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

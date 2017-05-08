package com.restopedia_team.restopedia_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.restopedia_team.restopedia_app.API.ApiClient;
import com.restopedia_team.restopedia_app.API.ApiInterface;
import com.restopedia_team.restopedia_app.Model.UserKonten;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HERYATMO on 01/05/2017.
 */

public class TabActivity_1 extends Activity {

    String USERNAME = "eric";
    String API_KEY = "7cBXDawjrOECIlpMmz8n19";
    UserKonten userKonten;

    TextView txtab1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_1);

        txtab1 = (TextView) findViewById(R.id.tab1);

        getUserKonten();
    }

    //get konten user
    void getUserKonten() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserKonten> call = apiService.getAllKonten(USERNAME, API_KEY);
        call.enqueue(new Callback<UserKonten>() {
            @Override
            public void onResponse(Call<UserKonten> call, Response<UserKonten> response) {
                userKonten = response.body();

                txtab1.setText(userKonten.getKontenData().get(0).getGambar());

                Log.i("Success", "Load User Konten Success");
            }

            @Override
            public void onFailure(Call<UserKonten> call, Throwable t) {
                Log.i("Failed", "Load User Konten Failed");
            }
        });
    }
}
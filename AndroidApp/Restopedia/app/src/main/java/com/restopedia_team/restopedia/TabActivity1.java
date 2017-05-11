package com.restopedia_team.restopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.restopedia_team.restopedia.API.ApiClient;
import com.restopedia_team.restopedia.API.ApiInterface;
import com.restopedia_team.restopedia.Model.UserKonten;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabActivity1 extends Activity {

    String USERNAME;
    String API_KEY = "7cBXDawjrOECIlpMmz8n19";
    UserKonten userKonten;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");

        textView = (TextView) findViewById(R.id.testab1);

        getAllKonten();
    }

    void getAllKonten()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserKonten> call = apiService.getAllKonten(USERNAME, API_KEY);
        call.enqueue(new Callback<UserKonten>() {
            @Override
            public void onResponse(Call<UserKonten> call, Response<UserKonten> response) {
                userKonten = response.body(); //data Konten-----------------------------------------
                textView.setText(userKonten.getKontenData().get(0).getDetailResto());

            }

            @Override
            public void onFailure(Call<UserKonten> call, Throwable t) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Load Track Failure Response");
                }
            }
        });
    }
}

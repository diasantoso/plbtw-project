package com.restopedia_team.restopedia_app;

/**
 * Created by VincentAndriK on 4/13/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.restopedia_team.restopedia_app.API.ApiClient;
import com.restopedia_team.restopedia_app.API.ApiInterface;
import com.restopedia_team.restopedia_app.Model.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabActivity_4 extends Activity {
    String USERNAME = "eric";
    String API_KEY = "7cBXDawjrOECIlpMmz8n19";
    UserInfo userInfo;
    TextView txtab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_4);

        txtab4 = (TextView) findViewById(R.id.tab4);

        getUserInfo();
    }

    //get info user
    void getUserInfo() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserInfo> call = apiService.getUserInfo(USERNAME, API_KEY);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                userInfo = response.body();

                txtab4.setText(userInfo.getUserData().get(0).getApiKey());

                Log.i("Success", "Load User Info Success");
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                Log.i("Failed", "Load User Info Failed");
            }
        });
    }
}

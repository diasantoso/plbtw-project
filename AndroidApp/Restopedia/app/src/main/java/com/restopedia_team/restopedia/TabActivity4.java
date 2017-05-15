package com.restopedia_team.restopedia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.restopedia_team.restopedia.API.ApiClient;
import com.restopedia_team.restopedia.API.ApiInterface;
import com.restopedia_team.restopedia.Model.UserInfo;
import com.restopedia_team.restopedia.Model.UserKonten;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabActivity4 extends Activity {

    String USERNAME;
    String API_KEY;
    UserInfo userInfo;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");
        API_KEY = b.getString("api_key");

        textView = (TextView) findViewById(R.id.testab4);

        getUserInfo();
    }

    void getUserInfo()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserInfo> call = apiService.getUserInfo(USERNAME, API_KEY);
        call.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                userInfo = response.body();
                textView.setText(userInfo.getUserData().get(0).getApiKey());
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Load Track Failure Response");
                }
            }
        });
    }
}

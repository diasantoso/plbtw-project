package com.restopedia_team.restopedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.restopedia_team.restopedia.API.ApiClient;
import com.restopedia_team.restopedia.API.ApiInterface;
import com.restopedia_team.restopedia.Model.KontenDatum;
import com.restopedia_team.restopedia.Model.UserKonten;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabActivity1 extends AppCompatActivity {

    String USERNAME;
    String API_KEY;
    UserKonten userKonten;

    TextView textView;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");
        API_KEY = b.getString("api_key");

        textView = (TextView) findViewById(R.id.testab1);

        getAllKonten();
        //getRestoList();


    }

    /*void getRestoList()
    {
        try {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<KontenDatum>> call = apiService.getAllKonten(USERNAME,API_KEY);

            call.enqueue(new Callback<List<KontenDatum>>() {
                @Override
                public void onResponse(Call<List<KontenDatum>> call, Response<List<KontenDatum>> response) {
                    //Log.d("onResponse", response.message());

                    List<KontenDatum> userList = response.body();
                    layoutManager = new LinearLayoutManager(TabActivity1.this);

                    RecyclerView recyclerView = (RecyclerView)
                            findViewById(R.id.recycler);
                    recyclerView.setLayoutManager(layoutManager);

                    RecyclerViewAdapter recyclerViewAdapter =
                            new RecyclerViewAdapter(userList);

                    recyclerView.setAdapter(recyclerViewAdapter);


                }

                @Override
                public void onFailure(Call<List<KontenDatum>> call, Throwable t) {

                }
            });
        }catch (Exception e) {}
    }
*/

    void getAllKonten()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserKonten> call = apiService.getAllKonten(USERNAME, API_KEY);
        call.enqueue(new Callback<UserKonten>() {
            @Override
            public void onResponse(Call<UserKonten> call, Response<UserKonten> response) {
                UserKonten userKonten = response.body(); //data Konten-----------------------------------------
                List<KontenDatum> restoList = userKonten.getKontenData();
                //textView.setText(userKonten.getKontenData().get(0).getDetailResto());


                layoutManager = new LinearLayoutManager(TabActivity1.this);

                RecyclerView recyclerView = (RecyclerView)
                        findViewById(R.id.recycler);
                recyclerView.setLayoutManager(layoutManager);

                RecyclerViewAdapter recyclerViewAdapter =
                        new RecyclerViewAdapter(restoList);

                recyclerView.setAdapter(recyclerViewAdapter);

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

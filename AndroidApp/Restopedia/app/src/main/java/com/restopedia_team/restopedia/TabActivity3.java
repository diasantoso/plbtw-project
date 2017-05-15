package com.restopedia_team.restopedia;

import android.app.Activity;
import android.os.Bundle;

public class TabActivity3 extends Activity {

    String USERNAME;
    String API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");
        API_KEY = b.getString("api_key");
    }
}

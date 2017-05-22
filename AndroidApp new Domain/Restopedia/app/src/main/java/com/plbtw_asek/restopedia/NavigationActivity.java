package com.plbtw_asek.restopedia;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.widget.TabHost;

import com.plbtw_asek.restopedia.Helper.FontAwesomeManager;
import com.plbtw_asek.restopedia.Helper.TextDrawable;
import com.restopedia_team.restopedia.R;


public class NavigationActivity extends TabActivity {

    String USERNAME;
    String API_KEY;

    TabHost TabHostWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");
        API_KEY = b.getString("api_key");

        //Assign id to Tabhost.
        TabHostWindow = (TabHost) findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec("Home");
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec("Upload");
        TabHost.TabSpec TabMenu3 = TabHostWindow.newTabSpec("Gallery");


        //Setting up tab 1 name.
        TextDrawable draw_icon1 = new TextDrawable(this);
        draw_icon1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        draw_icon1.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        draw_icon1.setTypeface(FontAwesomeManager.getTypeface(this, FontAwesomeManager.FONTAWESOME));
        draw_icon1.setText(getResources().getText(R.string.home));
        TabMenu1.setIndicator("", draw_icon1);
        //Set tab 1 activity to tab 1 menu.
        Intent i = new Intent(this, TabActivity1.class);
        Bundle bundle = new Bundle();
        bundle.putString("username", USERNAME);
        bundle.putString("api_key", API_KEY);
        i.putExtras(bundle);
        TabMenu1.setContent(i);


        //Setting up tab 2 name.
        TextDrawable draw_icon2 = new TextDrawable(this);
        draw_icon2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        draw_icon2.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        draw_icon2.setTypeface(FontAwesomeManager.getTypeface(this, FontAwesomeManager.FONTAWESOME));
        draw_icon2.setText(getResources().getText(R.string.upload));
        TabMenu2.setIndicator("", draw_icon2);
        //Set tab 3 activity to tab 1 menu.
        Intent i2 = new Intent(this, TabActivity2.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("username", USERNAME);
        bundle2.putString("api_key", API_KEY);
        i2.putExtras(bundle2);
        TabMenu2.setContent(i2);


        //Setting up tab 3 name.
        TextDrawable draw_icon3 = new TextDrawable(this);
        draw_icon3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        draw_icon3.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        draw_icon3.setTypeface(FontAwesomeManager.getTypeface(this, FontAwesomeManager.FONTAWESOME));
        draw_icon3.setText(getResources().getText(R.string.gallery));
        TabMenu3.setIndicator("", draw_icon3);
        //Set tab 3 activity to tab 3 menu.
        Intent i3 = new Intent(this, TabActivity3.class);
        Bundle bundle3 = new Bundle();
        bundle3.putString("username", USERNAME);
        bundle3.putString("api_key", API_KEY);
        i3.putExtras(bundle3);
        TabMenu3.setContent(i3);


        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);
    }
}

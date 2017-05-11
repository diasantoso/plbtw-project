package com.restopedia_team.restopedia;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.widget.TabHost;

import com.restopedia_team.restopedia.Helper.FontAwesomeManager;
import com.restopedia_team.restopedia.Helper.TextDrawable;

public class NavigationActivity extends TabActivity {



    TabHost TabHostWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Bundle b = getIntent().getExtras();
        String USERNAME = b.getString("username");

        //Assign id to Tabhost.
        TabHostWindow = (TabHost) findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabHost.TabSpec TabMenu1 = TabHostWindow.newTabSpec("Home");
        TabHost.TabSpec TabMenu2 = TabHostWindow.newTabSpec("Upload");
        TabHost.TabSpec TabMenu3 = TabHostWindow.newTabSpec("Gallery");
        TabHost.TabSpec TabMenu4 = TabHostWindow.newTabSpec("Profile");


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
        TabMenu2.setContent(new Intent(this, TabActivity2.class));


        //Setting up tab 3 name.
        TextDrawable draw_icon3 = new TextDrawable(this);
        draw_icon3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        draw_icon3.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        draw_icon3.setTypeface(FontAwesomeManager.getTypeface(this, FontAwesomeManager.FONTAWESOME));
        draw_icon3.setText(getResources().getText(R.string.gallery));
        TabMenu3.setIndicator("", draw_icon3);
        //Set tab 3 activity to tab 3 menu.
        TabMenu3.setContent(new Intent(this, TabActivity3.class));


        //Setting up tab 4 name.
        TextDrawable draw_icon4 = new TextDrawable(this);
        draw_icon4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        draw_icon4.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        draw_icon4.setTypeface(FontAwesomeManager.getTypeface(this, FontAwesomeManager.FONTAWESOME));
        draw_icon4.setText(getResources().getText(R.string.profile));
        TabMenu4.setIndicator("", draw_icon4);
        //Set tab 4 activity to tab 4 menu.
        TabMenu4.setContent(new Intent(this, TabActivity4.class));


        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);
        TabHostWindow.addTab(TabMenu4);
    }
}

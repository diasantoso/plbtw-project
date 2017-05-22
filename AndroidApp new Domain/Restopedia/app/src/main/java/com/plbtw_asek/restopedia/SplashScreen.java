package com.plbtw_asek.restopedia;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.restopedia_team.restopedia.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by Dias on 5/6/2017.
 */
public class SplashScreen extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {
            /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.primary); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.setLogoSplash(R.drawable.splash); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

        //Customize Path
        //configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
        configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(500);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.primary); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(500);
        configSplash.setPathSplashFillColor(R.color.primary); //path object filling color

        //Customize Title
        configSplash.setTitleSplash("");
        configSplash.setTitleTextColor(R.color.primary);
        configSplash.setTitleTextSize(20f); //float value
        configSplash.setAnimTitleDuration(500);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        //configSplash.setTitleFont("fonts/JLSDataGothicC_NC.otf"); //provide string to your font located in assets/fonts/
    }

    @Override
    public void animationsFinished() {

        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
}

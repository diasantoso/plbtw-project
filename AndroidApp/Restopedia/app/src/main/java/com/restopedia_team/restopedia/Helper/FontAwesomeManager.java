package com.restopedia_team.restopedia.Helper;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by VincentAndriK on 06/05/2017.
 */

public class FontAwesomeManager {
    public static final String ROOT = "fonts/";
    public static final String FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeface(Context context, String font)
    {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}

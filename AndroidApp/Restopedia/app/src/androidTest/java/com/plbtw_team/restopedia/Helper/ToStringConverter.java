package com.plbtw_team.restopedia.Helper;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;

/**
 * Created by Dias on 4/13/2017.
 */
public final class ToStringConverter implements Converter<String> {

    @Override
    public String fromBody(ResponseBody body) throws IOException {
        return body.string();
    }

    @Override
    public RequestBody toBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }
}

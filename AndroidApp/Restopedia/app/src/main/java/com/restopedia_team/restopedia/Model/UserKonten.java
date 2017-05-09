
package com.restopedia_team.restopedia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserKonten {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("kontenData")
    @Expose
    private List<KontenDatum> kontenData = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<KontenDatum> getKontenData() {
        return kontenData;
    }

    public void setKontenData(List<KontenDatum> kontenData) {
        this.kontenData = kontenData;
    }

}

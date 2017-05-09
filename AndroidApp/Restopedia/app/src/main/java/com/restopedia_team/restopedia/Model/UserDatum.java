
package com.restopedia_team.restopedia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDatum {

    @SerializedName("ID_User")
    @Expose
    private String iDUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("api_key")
    @Expose
    private String apiKey;
    @SerializedName("total_request")
    @Expose
    private String totalRequest;

    public String getIDUser() {
        return iDUser;
    }

    public void setIDUser(String iDUser) {
        this.iDUser = iDUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(String totalRequest) {
        this.totalRequest = totalRequest;
    }

}

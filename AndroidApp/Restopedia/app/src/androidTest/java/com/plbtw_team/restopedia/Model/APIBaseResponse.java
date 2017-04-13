package com.plbtw_team.restopedia.Model;

import java.io.Serializable;

/**
 * Created by Dias on 4/13/2017.
 */
public class APIBaseResponse implements Serializable {
    int status;
    String message;

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
}
package com.mppl.smartkosanapp.model;

import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("message")
    private String status;

    public String getResponse() {
        return status;
    }

    public void setResponse(String response) {
        this.status = response;
    }

//    String status;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}

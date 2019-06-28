package com.mppl.smartkosanapp.model;

import com.google.gson.annotations.SerializedName;

public class ResultRegis {
    @SerializedName("data")
    private Boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("user")
    private User user;

    public ResultRegis(Boolean error, String message, User user) {
        this.error = error;
        this.message = message;
        this.user = user;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}

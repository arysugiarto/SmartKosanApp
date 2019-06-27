package com.mppl.smartkosanapp.getmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mppl.smartkosanapp.model.Histori;

import java.util.List;

public class GetHistori {
    @SerializedName("result")
    @Expose
    private List<Histori> result = null;

    public List<Histori> getResult() {
        return result;
    }

    public void setResult(List<Histori> result) {
        this.result = result;
    }
}

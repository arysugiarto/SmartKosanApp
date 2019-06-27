package com.mppl.smartkosanapp.getmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mppl.smartkosanapp.model.Tagihan;

import java.util.List;

public class GetTagihan {

    @SerializedName("result")
    @Expose
    private List<Tagihan> result = null;

    public List<Tagihan> getResult() {
        return result;
    }

    public void setResult(List<Tagihan> result) {
        this.result = result;
    }
}

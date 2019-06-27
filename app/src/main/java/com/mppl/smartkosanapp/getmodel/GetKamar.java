package com.mppl.smartkosanapp.getmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mppl.smartkosanapp.model.Kamar;

import java.util.List;

public class GetKamar {
    @SerializedName("result")
    @Expose
    private List<Kamar> result = null;

    public List<Kamar> getResult() {
        return result;
    }

    public void setResult(List<Kamar> result) {
        this.result = result;
    }
}

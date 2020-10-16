
package com.engin.eticaretkontrol.NetProgress.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("varKey")
    @Expose
    private String varKey;
    @SerializedName("varValue")
    @Expose
    private String varValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVarKey() {
        return varKey;
    }

    public void setVarKey(String varKey) {
        this.varKey = varKey;
    }

    public String getVarValue() {
        return varValue;
    }

    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

}

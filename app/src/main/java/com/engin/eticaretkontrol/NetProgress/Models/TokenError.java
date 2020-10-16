
package com.engin.eticaretkontrol.NetProgress.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenError {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("error_description")
    @Expose
    private String errorDescription;

    public String getError() {
        return error;
    }


    public String getErrorDescription() {
        return errorDescription;
    }


}

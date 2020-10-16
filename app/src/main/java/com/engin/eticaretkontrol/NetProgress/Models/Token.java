
package com.engin.eticaretkontrol.NetProgress.Models;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("error")
    @Nullable
    @Expose
    private String error;
    @SerializedName("error_description")
    @Nullable
    @Expose
    private String errorDescription;

    @Nullable
    public String getError() { return error; }

    @Nullable
    public String getErrorDescription() { return errorDescription; }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static void saveTokens(Token token, SharedPreferences preferences){
        String access_token = token.getAccessToken();
        String refresh_token = token.getRefreshToken();
        preferences.edit().putString("access_token",access_token).apply();
        preferences.edit().putString("refresh_token",refresh_token).apply();
    }

}

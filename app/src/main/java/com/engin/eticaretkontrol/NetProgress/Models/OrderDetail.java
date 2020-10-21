
package com.engin.eticaretkontrol.NetProgress.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetail implements Parcelable {

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

    public String getVarKey() {
        return varKey;
    }

    public String getVarValue() {
        return varValue;
    }


    protected OrderDetail(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        varKey = in.readString();
        varValue = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(varKey);
        dest.writeString(varValue);
    }

    public static final Parcelable.Creator<OrderDetail> CREATOR = new Parcelable.Creator<OrderDetail>() {
        @Override
        public OrderDetail createFromParcel(Parcel in) {
            return new OrderDetail(in);
        }

        @Override
        public OrderDetail[] newArray(int size) {
            return new OrderDetail[size];
        }
    };
}

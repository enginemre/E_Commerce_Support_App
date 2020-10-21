
package com.engin.eticaretkontrol.NetProgress.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingAddress implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("subLocation")
    @Expose
    private String subLocation;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("mobilePhoneNumber")
    @Expose
    private String mobilePhoneNumber;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getLocation() {
        return location;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    protected ShippingAddress(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        firstname = in.readString();
        surname = in.readString();
        country = in.readString();
        location = in.readString();
        subLocation = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
        mobilePhoneNumber = in.readString();
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
        dest.writeString(firstname);
        dest.writeString(surname);
        dest.writeString(country);
        dest.writeString(location);
        dest.writeString(subLocation);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(mobilePhoneNumber);
    }

    public static final Parcelable.Creator<ShippingAddress> CREATOR = new Parcelable.Creator<ShippingAddress>() {
        @Override
        public ShippingAddress createFromParcel(Parcel in) {
            return new ShippingAddress(in);
        }

        @Override
        public ShippingAddress[] newArray(int size) {
            return new ShippingAddress[size];
        }
    };
}


package com.engin.eticaretkontrol.NetProgress.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("mobilePhoneNumber")
    @Expose
    private String mobilePhoneNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("memberGroup")
    @Expose
    private MemberGroup memberGroup;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public MemberGroup getMemberGroup() {
        return memberGroup;
    }

    protected Member(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        firstname = in.readString();
        surname = in.readString();
        email = in.readString();
        gender = in.readString();
        phoneNumber = in.readString();
        mobilePhoneNumber = in.readString();
        address = in.readString();
        status = in.readString();
        memberGroup = (MemberGroup) in.readValue(MemberGroup.class.getClassLoader());
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
        dest.writeString(email);
        dest.writeString(gender);
        dest.writeString(phoneNumber);
        dest.writeString(mobilePhoneNumber);
        dest.writeString(address);
        dest.writeString(status);
        dest.writeValue(memberGroup);
    }

    public static final Parcelable.Creator<Member> CREATOR = new Parcelable.Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

}

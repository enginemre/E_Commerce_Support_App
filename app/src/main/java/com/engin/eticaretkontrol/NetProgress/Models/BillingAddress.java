
package com.engin.eticaretkontrol.NetProgress.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BillingAddress implements Serializable {

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
    @SerializedName("invoiceType")
    @Expose
    private String invoiceType;
    @SerializedName("taxNo")
    @Expose
    private Object taxNo;
    @SerializedName("taxOffice")
    @Expose
    private Object taxOffice;
    @SerializedName("identityRegistrationNumber")
    @Expose
    private String identityRegistrationNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Object getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(Object taxNo) {
        this.taxNo = taxNo;
    }

    public Object getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(Object taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getIdentityRegistrationNumber() {
        return identityRegistrationNumber;
    }

    public void setIdentityRegistrationNumber(String identityRegistrationNumber) {
        this.identityRegistrationNumber = identityRegistrationNumber;
    }

}

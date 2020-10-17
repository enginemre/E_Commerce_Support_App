
package com.engin.eticaretkontrol.NetProgress.Models;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customerFirstname")
    @Expose
    private String customerFirstname;
    @SerializedName("customerSurname")
    @Expose
    private String customerSurname;
    @SerializedName("customerEmail")
    @Expose
    private String customerEmail;
    @SerializedName("customerPhone")
    @Expose
    private String customerPhone;
    @SerializedName("paymentTypeName")
    @Expose
    private String paymentTypeName;
    @SerializedName("paymentProviderCode")
    @Expose
    private String paymentProviderCode;
    @SerializedName("paymentProviderName")
    @Expose
    private String paymentProviderName;
    @SerializedName("paymentGatewayCode")
    @Expose
    private String paymentGatewayCode;
    @SerializedName("paymentGatewayName")
    @Expose
    private String paymentGatewayName;
    @SerializedName("bankName")
    @Expose
    private String bankName;
    @SerializedName("clientIp")
    @Expose
    private String clientIp;
    @SerializedName("userAgent")
    @Expose
    private String userAgent;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("currencyRates")
    @Expose
    private String currencyRates;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("couponDiscount")
    @Expose
    private Double couponDiscount;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;
    @SerializedName("totalCustomTaxAmount")
    @Expose
    private Double totalCustomTaxAmount;
    @SerializedName("promotionDiscount")
    @Expose
    private Double promotionDiscount;
    @SerializedName("generalAmount")
    @Expose
    private Double generalAmount;
    @SerializedName("shippingAmount")
    @Expose
    private Double shippingAmount;
    @SerializedName("additionalServiceAmount")
    @Expose
    private Double additionalServiceAmount;
    @SerializedName("finalAmount")
    @Expose
    private Double finalAmount;
    @SerializedName("sumOfGainedPoints")
    @Expose
    private Double sumOfGainedPoints;
    @SerializedName("installment")
    @Expose
    private Integer installment;
    @SerializedName("installmentRate")
    @Expose
    private Double installmentRate;
    @SerializedName("extraInstallment")
    @Expose
    private Integer extraInstallment;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("hasUserNote")
    @Expose
    private Integer hasUserNote;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("errorMessage")
    @Expose
    private Object errorMessage;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("referrer")
    @Expose
    private Object referrer;
    @SerializedName("invoicePrintCount")
    @Expose
    private Integer invoicePrintCount;
    @SerializedName("useGiftPackage")
    @Expose
    private Integer useGiftPackage;
    @SerializedName("giftNote")
    @Expose
    private Object giftNote;
    @SerializedName("memberGroupName")
    @Expose
    private String memberGroupName;
    @SerializedName("usePromotion")
    @Expose
    private Integer usePromotion;
    @SerializedName("shippingProviderCode")
    @Expose
    private String shippingProviderCode;
    @SerializedName("shippingProviderName")
    @Expose
    private String shippingProviderName;
    @SerializedName("shippingCompanyName")
    @Expose
    private String shippingCompanyName;
    @SerializedName("shippingPaymentType")
    @Expose
    private String shippingPaymentType;
    @SerializedName("shippingTrackingCode")
    @Expose
    private String shippingTrackingCode;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("maillist")
    @Expose
    private Object maillist;
    @SerializedName("member")
    @Expose
    private Member member;
    @SerializedName("orderDetails")
    @Expose
    private List<OrderDetail> orderDetails = null;
    @SerializedName("orderItems")
    @Expose
    private List<OrderItem> orderItems = null;
    @SerializedName("orderCustomTaxLines")
    @Expose
    private List<Object> orderCustomTaxLines = null;
    @SerializedName("shippingAddress")
    @Expose
    private ShippingAddress shippingAddress;
    @SerializedName("billingAddress")
    @Expose
    private BillingAddress billingAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }


    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public String getPaymentProviderCode() {
        return paymentProviderCode;
    }

    public String getPaymentProviderName() {
        return paymentProviderName;
    }

    public String getPaymentGatewayCode() {
        return paymentGatewayCode;
    }

    public String getPaymentGatewayName() {
        return paymentGatewayName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrencyRates() {
        return currencyRates;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public Double getTotalCustomTaxAmount() {
        return totalCustomTaxAmount;
    }

    public Double getPromotionDiscount() {
        return promotionDiscount;
    }

    public Double getGeneralAmount() {
        return generalAmount;
    }

    public Double getShippingAmount() {
        return shippingAmount;
    }

    public Double getAdditionalServiceAmount() {
        return additionalServiceAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public Double getSumOfGainedPoints() {
        return sumOfGainedPoints;
    }

    public Integer getInstallment() {
        return installment;
    }

    public Double getInstallmentRate() {
        return installmentRate;
    }

    public Integer getExtraInstallment() {
        return extraInstallment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Integer getHasUserNote() {
        return hasUserNote;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public Object getReferrer() {
        return referrer;
    }

    public Integer getInvoicePrintCount() {
        return invoicePrintCount;
    }

    public Integer getUseGiftPackage() {
        return useGiftPackage;
    }

    public Object getGiftNote() {
        return giftNote;
    }

    public String getMemberGroupName() {
        return memberGroupName;
    }

    public Integer getUsePromotion() {
        return usePromotion;
    }

    public String getShippingProviderCode() {
        return shippingProviderCode;
    }

    public String getShippingProviderName() {
        return shippingProviderName;
    }

    public String getShippingCompanyName() {
        return shippingCompanyName;
    }

    public String getShippingPaymentType() {
        return shippingPaymentType;
    }

    public String getShippingTrackingCode() {
        return shippingTrackingCode;
    }

    public String getSource() {
        return source;
    }

    // converting date
    public String getCreatedAt() throws ParseException {
        String year = createdAt.substring(0,4);
        String month = createdAt.substring(5,7);
        String day = createdAt.substring(8,10);
        String hours = createdAt.substring(11,13);
        String minutes= createdAt.substring(14,16);

        String date = day+"/"+month+"/"+year+"  "+hours+":"+minutes;

        return date;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }


    public Object getMaillist() {
        return maillist;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<Object> getOrderCustomTaxLines() {
        return orderCustomTaxLines;
    }

    public void setOrderCustomTaxLines(List<Object> orderCustomTaxLines) {
        this.orderCustomTaxLines = orderCustomTaxLines;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

}

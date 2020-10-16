
package com.engin.eticaretkontrol.NetProgress.Models;

import java.io.Serializable;
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

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentProviderCode() {
        return paymentProviderCode;
    }

    public void setPaymentProviderCode(String paymentProviderCode) {
        this.paymentProviderCode = paymentProviderCode;
    }

    public String getPaymentProviderName() {
        return paymentProviderName;
    }

    public void setPaymentProviderName(String paymentProviderName) {
        this.paymentProviderName = paymentProviderName;
    }

    public String getPaymentGatewayCode() {
        return paymentGatewayCode;
    }

    public void setPaymentGatewayCode(String paymentGatewayCode) {
        this.paymentGatewayCode = paymentGatewayCode;
    }

    public String getPaymentGatewayName() {
        return paymentGatewayName;
    }

    public void setPaymentGatewayName(String paymentGatewayName) {
        this.paymentGatewayName = paymentGatewayName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyRates() {
        return currencyRates;
    }

    public void setCurrencyRates(String currencyRates) {
        this.currencyRates = currencyRates;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotalCustomTaxAmount() {
        return totalCustomTaxAmount;
    }

    public void setTotalCustomTaxAmount(Double totalCustomTaxAmount) {
        this.totalCustomTaxAmount = totalCustomTaxAmount;
    }

    public Double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(Double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public Double getGeneralAmount() {
        return generalAmount;
    }

    public void setGeneralAmount(Double generalAmount) {
        this.generalAmount = generalAmount;
    }

    public Double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public Double getAdditionalServiceAmount() {
        return additionalServiceAmount;
    }

    public void setAdditionalServiceAmount(Double additionalServiceAmount) {
        this.additionalServiceAmount = additionalServiceAmount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Double getSumOfGainedPoints() {
        return sumOfGainedPoints;
    }

    public void setSumOfGainedPoints(Double sumOfGainedPoints) {
        this.sumOfGainedPoints = sumOfGainedPoints;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Double getInstallmentRate() {
        return installmentRate;
    }

    public void setInstallmentRate(Double installmentRate) {
        this.installmentRate = installmentRate;
    }

    public Integer getExtraInstallment() {
        return extraInstallment;
    }

    public void setExtraInstallment(Integer extraInstallment) {
        this.extraInstallment = extraInstallment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getHasUserNote() {
        return hasUserNote;
    }

    public void setHasUserNote(Integer hasUserNote) {
        this.hasUserNote = hasUserNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Object getReferrer() {
        return referrer;
    }

    public void setReferrer(Object referrer) {
        this.referrer = referrer;
    }

    public Integer getInvoicePrintCount() {
        return invoicePrintCount;
    }

    public void setInvoicePrintCount(Integer invoicePrintCount) {
        this.invoicePrintCount = invoicePrintCount;
    }

    public Integer getUseGiftPackage() {
        return useGiftPackage;
    }

    public void setUseGiftPackage(Integer useGiftPackage) {
        this.useGiftPackage = useGiftPackage;
    }

    public Object getGiftNote() {
        return giftNote;
    }

    public void setGiftNote(Object giftNote) {
        this.giftNote = giftNote;
    }

    public String getMemberGroupName() {
        return memberGroupName;
    }

    public void setMemberGroupName(String memberGroupName) {
        this.memberGroupName = memberGroupName;
    }

    public Integer getUsePromotion() {
        return usePromotion;
    }

    public void setUsePromotion(Integer usePromotion) {
        this.usePromotion = usePromotion;
    }

    public String getShippingProviderCode() {
        return shippingProviderCode;
    }

    public void setShippingProviderCode(String shippingProviderCode) {
        this.shippingProviderCode = shippingProviderCode;
    }

    public String getShippingProviderName() {
        return shippingProviderName;
    }

    public void setShippingProviderName(String shippingProviderName) {
        this.shippingProviderName = shippingProviderName;
    }

    public String getShippingCompanyName() {
        return shippingCompanyName;
    }

    public void setShippingCompanyName(String shippingCompanyName) {
        this.shippingCompanyName = shippingCompanyName;
    }

    public String getShippingPaymentType() {
        return shippingPaymentType;
    }

    public void setShippingPaymentType(String shippingPaymentType) {
        this.shippingPaymentType = shippingPaymentType;
    }

    public String getShippingTrackingCode() {
        return shippingTrackingCode;
    }

    public void setShippingTrackingCode(String shippingTrackingCode) {
        this.shippingTrackingCode = shippingTrackingCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getMaillist() {
        return maillist;
    }

    public void setMaillist(Object maillist) {
        this.maillist = maillist;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

}

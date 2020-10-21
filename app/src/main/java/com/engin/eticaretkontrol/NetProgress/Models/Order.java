
package com.engin.eticaretkontrol.NetProgress.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Order implements Parcelable {

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

    public Integer collectedState;

    public Integer getCollectedState() {
        if (collectedState == null){
            collectedState =0;
        }
        return collectedState;
    }

    public Integer getId() {
        return id;
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
    public String getCreatedAt() {
        String year = createdAt.substring(0,4);
        String month = createdAt.substring(5,7);
        String day = createdAt.substring(8,10);
        String hours = createdAt.substring(11,13);
        String minutes= createdAt.substring(14,16);

        return day+"/"+month+"/"+year+"  "+hours+":"+minutes;
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


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public List<Object> getOrderCustomTaxLines() {
        return orderCustomTaxLines;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    protected Order(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        customerFirstname = in.readString();
        customerSurname = in.readString();
        customerEmail = in.readString();
        customerPhone = in.readString();
        paymentTypeName = in.readString();
        paymentProviderCode = in.readString();
        paymentProviderName = in.readString();
        paymentGatewayCode = in.readString();
        paymentGatewayName = in.readString();
        bankName = in.readString();
        clientIp = in.readString();
        userAgent = in.readString();
        currency = in.readString();
        currencyRates = in.readString();
        amount = in.readByte() == 0x00 ? null : in.readDouble();
        couponDiscount = in.readByte() == 0x00 ? null : in.readDouble();
        taxAmount = in.readByte() == 0x00 ? null : in.readDouble();
        totalCustomTaxAmount = in.readByte() == 0x00 ? null : in.readDouble();
        promotionDiscount = in.readByte() == 0x00 ? null : in.readDouble();
        generalAmount = in.readByte() == 0x00 ? null : in.readDouble();
        shippingAmount = in.readByte() == 0x00 ? null : in.readDouble();
        additionalServiceAmount = in.readByte() == 0x00 ? null : in.readDouble();
        finalAmount = in.readByte() == 0x00 ? null : in.readDouble();
        sumOfGainedPoints = in.readByte() == 0x00 ? null : in.readDouble();
        installment = in.readByte() == 0x00 ? null : in.readInt();
        installmentRate = in.readByte() == 0x00 ? null : in.readDouble();
        extraInstallment = in.readByte() == 0x00 ? null : in.readInt();
        transactionId = in.readString();
        hasUserNote = in.readByte() == 0x00 ? null : in.readInt();
        status = in.readString();
        paymentStatus = in.readString();
        errorMessage = (Object) in.readValue(Object.class.getClassLoader());
        deviceType = in.readString();
        referrer = (Object) in.readValue(Object.class.getClassLoader());
        invoicePrintCount = in.readByte() == 0x00 ? null : in.readInt();
        useGiftPackage = in.readByte() == 0x00 ? null : in.readInt();
        giftNote = (Object) in.readValue(Object.class.getClassLoader());
        memberGroupName = in.readString();
        usePromotion = in.readByte() == 0x00 ? null : in.readInt();
        shippingProviderCode = in.readString();
        shippingProviderName = in.readString();
        shippingCompanyName = in.readString();
        shippingPaymentType = in.readString();
        shippingTrackingCode = in.readString();
        source = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        maillist = (Object) in.readValue(Object.class.getClassLoader());
        member = (Member) in.readValue(Member.class.getClassLoader());
        if (in.readByte() == 0x01) {
            orderDetails = new ArrayList<OrderDetail>();
            in.readList(orderDetails, OrderDetail.class.getClassLoader());
        } else {
            orderDetails = null;
        }
        if (in.readByte() == 0x01) {
            orderItems = new ArrayList<OrderItem>();
            in.readList(orderItems, OrderItem.class.getClassLoader());
        } else {
            orderItems = null;
        }
        if (in.readByte() == 0x01) {
            orderCustomTaxLines = new ArrayList<Object>();
            in.readList(orderCustomTaxLines, Object.class.getClassLoader());
        } else {
            orderCustomTaxLines = null;
        }
        shippingAddress = (ShippingAddress) in.readValue(ShippingAddress.class.getClassLoader());
        billingAddress = (BillingAddress) in.readValue(BillingAddress.class.getClassLoader());
        collectedState = in.readByte() == 0x00 ? null : in.readInt();
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
        dest.writeString(customerFirstname);
        dest.writeString(customerSurname);
        dest.writeString(customerEmail);
        dest.writeString(customerPhone);
        dest.writeString(paymentTypeName);
        dest.writeString(paymentProviderCode);
        dest.writeString(paymentProviderName);
        dest.writeString(paymentGatewayCode);
        dest.writeString(paymentGatewayName);
        dest.writeString(bankName);
        dest.writeString(clientIp);
        dest.writeString(userAgent);
        dest.writeString(currency);
        dest.writeString(currencyRates);
        if (amount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(amount);
        }
        if (couponDiscount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(couponDiscount);
        }
        if (taxAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(taxAmount);
        }
        if (totalCustomTaxAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(totalCustomTaxAmount);
        }
        if (promotionDiscount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(promotionDiscount);
        }
        if (generalAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(generalAmount);
        }
        if (shippingAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(shippingAmount);
        }
        if (additionalServiceAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(additionalServiceAmount);
        }
        if (finalAmount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(finalAmount);
        }
        if (sumOfGainedPoints == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(sumOfGainedPoints);
        }
        if (installment == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(installment);
        }
        if (installmentRate == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(installmentRate);
        }
        if (extraInstallment == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(extraInstallment);
        }
        dest.writeString(transactionId);
        if (hasUserNote == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(hasUserNote);
        }
        dest.writeString(status);
        dest.writeString(paymentStatus);
        dest.writeValue(errorMessage);
        dest.writeString(deviceType);
        dest.writeValue(referrer);
        if (invoicePrintCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(invoicePrintCount);
        }
        if (useGiftPackage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(useGiftPackage);
        }
        dest.writeValue(giftNote);
        dest.writeString(memberGroupName);
        if (usePromotion == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(usePromotion);
        }
        dest.writeString(shippingProviderCode);
        dest.writeString(shippingProviderName);
        dest.writeString(shippingCompanyName);
        dest.writeString(shippingPaymentType);
        dest.writeString(shippingTrackingCode);
        dest.writeString(source);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeValue(maillist);
        dest.writeValue(member);
        if (orderDetails == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(orderDetails);
        }
        if (orderItems == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(orderItems);
        }
        if (orderCustomTaxLines == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(orderCustomTaxLines);
        }
        dest.writeValue(shippingAddress);
        dest.writeValue(billingAddress);
        if (collectedState == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(collectedState);
        }
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };


    // Comparing two List and find unique elements after that adding temp list
    public static List<Order> compareList(List<Order> dynamicList,List<Order> l2){
        List<Order> comparedList =new ArrayList<>();
        if (dynamicList.size()>l2.size())  {
            for (Order o:dynamicList){
                boolean unique = true;
                for (Order o2: l2){
                    if (o.getId().equals(o2.getId())){
                        unique = false;
                        break;
                    }
                }
                if (unique){
                    comparedList.add(o);
                }
            }

        }
        else if(l2.size()>dynamicList.size()){
            for(Order o:l2){
                boolean unique = true;
                for (Order o2:dynamicList){
                    if (o.getId().equals(o2.getId())){
                        unique = false;
                        break;
                    }
                }
                if (unique){
                    comparedList.add(o);
                }
            }
        }
        else{
            return comparedList;
        }
        return comparedList;
    }

    // adding items from list
    public static List<Order> addItems( List<Order> l1, List<Order> l2){
        int i =0;
        for (Order o :l2){
            l1.add(i,o);
            i++;
        }
        return l1;
    }
    // delete items from list
    public static List<Order> deleteItems(List<Order> l1,List<Order> l2){
        for (Order o :l2){

            l1.remove(o);
        }
        return l1;
    }
    // find orginal item in list
    public static  int findItem(Order order,List<Order> list){
        for(Order o:list){
            if (order.getId().equals(o.getId())){
                return list.indexOf(o);
            }
        }
        return -1;
    }
}

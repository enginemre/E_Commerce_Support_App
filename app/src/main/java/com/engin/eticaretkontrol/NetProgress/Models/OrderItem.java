
package com.engin.eticaretkontrol.NetProgress.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OrderItem implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productSku")
    @Expose
    private String productSku;
    @SerializedName("productBarcode")
    @Expose
    private String productBarcode;
    @SerializedName("productPrice")
    @Expose
    private Double productPrice;
    @SerializedName("productCurrency")
    @Expose
    private String productCurrency;
    @SerializedName("productQuantity")
    @Expose
    private Double productQuantity;
    @SerializedName("productTax")
    @Expose
    private Integer productTax;
    @SerializedName("productDiscount")
    @Expose
    private Double productDiscount;
    @SerializedName("productMoneyOrderDiscount")
    @Expose
    private Double productMoneyOrderDiscount;
    @SerializedName("productWeight")
    @Expose
    private Double productWeight;
    @SerializedName("productStockTypeLabel")
    @Expose
    private String productStockTypeLabel;
    @SerializedName("isProductPromotioned")
    @Expose
    private Integer isProductPromotioned;
    @SerializedName("discount")
    @Expose
    private Double discount;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("orderItemCustomizations")
    @Expose
    private List<Object> orderItemCustomizations = null;
    @SerializedName("orderItemSubscription")
    @Expose
    private Object orderItemSubscription;

    public Integer getId() {
        return id;
    }


    public String getProductName() {
        return productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public Double getProductQuantity() {
        return productQuantity;
    }

    public Integer getProductTax() {
        return productTax;
    }

    public Double getProductDiscount() {
        return productDiscount;
    }

    public Double getProductMoneyOrderDiscount() {
        return productMoneyOrderDiscount;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public String getProductStockTypeLabel() {
        return productStockTypeLabel;
    }

    public Integer getIsProductPromotioned() {
        return isProductPromotioned;
    }

    public Double getDiscount() {
        return discount;
    }

    public Product getProduct() {
        return product;
    }

    public List<Object> getOrderItemCustomizations() {
        return orderItemCustomizations;
    }

    public Object getOrderItemSubscription() {
        return orderItemSubscription;
    }

    protected OrderItem(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readInt();
        productName = in.readString();
        productSku = in.readString();
        productBarcode = in.readString();
        productPrice = in.readByte() == 0x00 ? null : in.readDouble();
        productCurrency = in.readString();
        productQuantity = in.readByte() == 0x00 ? null : in.readDouble();
        productTax = in.readByte() == 0x00 ? null : in.readInt();
        productDiscount = in.readByte() == 0x00 ? null : in.readDouble();
        productMoneyOrderDiscount = in.readByte() == 0x00 ? null : in.readDouble();
        productWeight = in.readByte() == 0x00 ? null : in.readDouble();
        productStockTypeLabel = in.readString();
        isProductPromotioned = in.readByte() == 0x00 ? null : in.readInt();
        discount = in.readByte() == 0x00 ? null : in.readDouble();
        product = (Product) in.readValue(Product.class.getClassLoader());
        if (in.readByte() == 0x01) {
            orderItemCustomizations = new ArrayList<Object>();
            in.readList(orderItemCustomizations, Object.class.getClassLoader());
        } else {
            orderItemCustomizations = null;
        }
        orderItemSubscription = (Object) in.readValue(Object.class.getClassLoader());
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
        dest.writeString(productName);
        dest.writeString(productSku);
        dest.writeString(productBarcode);
        if (productPrice == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(productPrice);
        }
        dest.writeString(productCurrency);
        if (productQuantity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(productQuantity);
        }
        if (productTax == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(productTax);
        }
        if (productDiscount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(productDiscount);
        }
        if (productMoneyOrderDiscount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(productMoneyOrderDiscount);
        }
        if (productWeight == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(productWeight);
        }
        dest.writeString(productStockTypeLabel);
        if (isProductPromotioned == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isProductPromotioned);
        }
        if (discount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(discount);
        }
        dest.writeValue(product);
        if (orderItemCustomizations == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(orderItemCustomizations);
        }
        dest.writeValue(orderItemSubscription);
    }


    public static final Parcelable.Creator<OrderItem> CREATOR = new Parcelable.Creator<OrderItem>() {
        @Override
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        @Override
        public OrderItem[] newArray(int size) {
            return new OrderItem[size];
        }
    };

}


package com.engin.eticaretkontrol.NetProgress.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem implements Serializable {

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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public Double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getProductTax() {
        return productTax;
    }

    public void setProductTax(Integer productTax) {
        this.productTax = productTax;
    }

    public Double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public Double getProductMoneyOrderDiscount() {
        return productMoneyOrderDiscount;
    }

    public void setProductMoneyOrderDiscount(Double productMoneyOrderDiscount) {
        this.productMoneyOrderDiscount = productMoneyOrderDiscount;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductStockTypeLabel() {
        return productStockTypeLabel;
    }

    public void setProductStockTypeLabel(String productStockTypeLabel) {
        this.productStockTypeLabel = productStockTypeLabel;
    }

    public Integer getIsProductPromotioned() {
        return isProductPromotioned;
    }

    public void setIsProductPromotioned(Integer isProductPromotioned) {
        this.isProductPromotioned = isProductPromotioned;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Object> getOrderItemCustomizations() {
        return orderItemCustomizations;
    }

    public void setOrderItemCustomizations(List<Object> orderItemCustomizations) {
        this.orderItemCustomizations = orderItemCustomizations;
    }

    public Object getOrderItemSubscription() {
        return orderItemSubscription;
    }

    public void setOrderItemSubscription(Object orderItemSubscription) {
        this.orderItemSubscription = orderItemSubscription;
    }

}

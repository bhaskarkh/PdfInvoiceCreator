package com.codingerror.model;

import com.codingerror.util.ConstantUtil;
import com.itextpdf.kernel.color.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDetails {
    private String billingInfoText= ConstantUtil.BILLING_INFO;
    private String shippingInfoText=ConstantUtil.SHIPPING_INFO;
    private String billingCompanyText=ConstantUtil.BILLING_COMPANY;
    private String billingCompany=ConstantUtil.EMPTY;
    private String billingNameText=ConstantUtil.BILLING_NAME;
    private String billingName=ConstantUtil.EMPTY;
    private String billingAddressText=ConstantUtil.BILLING_ADDRESS;
    private String billingAddress=ConstantUtil.EMPTY;
    private String billingEmailText=ConstantUtil.BILLING_EMAIL;
    private String billingEmail=ConstantUtil.EMPTY;
    
    private String shippingNameText=ConstantUtil.SHIPPING_NAME;
    private String shippingName=ConstantUtil.EMPTY;
    private String shippingAddressText=ConstantUtil.SHIPPING_ADDRESS;
    private String shippingAddress=ConstantUtil.EMPTY;
    private Color borderColor=Color.GRAY;

    public AddressDetails setBillingInfoText(String billingInfoText) {
        this.billingInfoText = billingInfoText;
        return this;
    }

    public AddressDetails setShippingInfoText(String shippingInfoText) {
        this.shippingInfoText = shippingInfoText;
    return this;
    }

    public AddressDetails setBillingCompanyText(String billingCompanyText) {
        this.billingCompanyText = billingCompanyText;
    return this;
    }

    public AddressDetails setBillingCompany(String billingCompany) {
        this.billingCompany = billingCompany;
    return this;
    }

    public AddressDetails setBillingNameText(String billingNameText) {
        this.billingNameText = billingNameText;
    return this;
    }

    public AddressDetails setBillingName(String billingName) {
        this.billingName = billingName;
    return this;
    }

    public AddressDetails setBillingAddressText(String billingAddressText) {
        this.billingAddressText = billingAddressText;
    return this;
    }

    public AddressDetails setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    return this;
    }

    public AddressDetails setBillingEmailText(String billingEmailText) {
        this.billingEmailText = billingEmailText;
    return this;
    }

    public AddressDetails setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    return this;
    }

    public AddressDetails setShippingNameText(String shippingNameText) {
        this.shippingNameText = shippingNameText;
    return this;
    }

    public AddressDetails setShippingName(String shippingName) {
        this.shippingName = shippingName;
    return this;
    }

    public AddressDetails setShippingAddressText(String shippingAddressText) {
        this.shippingAddressText = shippingAddressText;
    return this;
    }

    public AddressDetails setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    return this;
    }

    public AddressDetails setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    return this;
    }

    public AddressDetails build() {
        return this;
    }

    }

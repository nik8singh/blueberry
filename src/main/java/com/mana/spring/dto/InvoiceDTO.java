package com.mana.spring.dto;

public class InvoiceDTO {

    private long invoiceId;

    private double taxPercent;

    private double taxAmount;

    private double invoiceAmount;

    private AddressDTO shippingAddressDTO;

    private UserDTO userDTO;

    public InvoiceDTO() {
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public AddressDTO getShippingAddressDTO() {
        return shippingAddressDTO;
    }

    public void setShippingAddressDTO(AddressDTO shippingAddressDTO) {
        this.shippingAddressDTO = shippingAddressDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "\nInvoiceDTO{" +
                "\ninvoiceId=" + invoiceId +
                "\n taxPercent=" + taxPercent +
                "\n taxAmount=" + taxAmount +
                "\n invoiceAmount=" + invoiceAmount +
                "\n shippingAddressDTO=" + shippingAddressDTO +
                "\n userDTO=" + userDTO +
                '}';
    }
}
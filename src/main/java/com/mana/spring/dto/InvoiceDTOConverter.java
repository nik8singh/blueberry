package com.mana.spring.dto;


import com.mana.spring.domain.Invoice;

public class InvoiceDTOConverter {

    public static InvoiceDTO convertToDTO(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceId(invoice.getInvoiceId());
        invoiceDTO.setInvoiceAmount(invoice.getInvoiceAmount());
        invoiceDTO.setShippingAddressDTO(invoice.getShippingAddress());
        invoiceDTO.setTaxAmount(invoice.getTaxAmount());
        invoiceDTO.setTaxPercent(invoice.getCouponPercent());

        return invoiceDTO;
    }
}

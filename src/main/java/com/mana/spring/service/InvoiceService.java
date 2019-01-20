package com.mana.spring.service;

import com.mana.spring.domain.Invoice;
import com.mana.spring.dto.InvoiceListDTO;

import java.util.ArrayList;

public interface InvoiceService {

    InvoiceListDTO getCompletedInvoices(int pageNumber);

    InvoiceListDTO getRefundedInvoices(int pageNumber);

    InvoiceListDTO getRefundRequestedInvoices(int pageNumber);

    InvoiceListDTO getPendingInvoices(int pageNumber);

    InvoiceListDTO getInvoices(String email, int pageNumber);

    Invoice getInvoice(long InvoiceNumber);

    Invoice createInvoice(Invoice invoice);

    void completeInvoice(Invoice invoice);

    void refundInvoice(Invoice invoice);

    void requestRefund(Invoice invoice);

}

package com.mana.spring.dao;

import com.mana.spring.domain.Invoice;

import java.util.List;

public interface InvoiceDAO {

    Invoice saveInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    Invoice getByInvoiceNumber(long invoiceNumber);

    Invoice getById(Invoice invoice);

    List getByEmail(String email, int start, int end);

    List getInvoices(boolean completed, boolean refundRequest, boolean refunded, int start, int end);

    long count(boolean completed, boolean refundRequest, boolean refunded);

    long count(String email);

}

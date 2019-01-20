package com.mana.spring.dto;

import com.mana.spring.domain.Invoice;
import com.mana.spring.util.Pagination;

import java.util.ArrayList;

public class InvoiceListDTO extends Pagination {

    private ArrayList<Invoice> invoices;

    public InvoiceListDTO() {
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "\nInvoiceListDTO{" +
                "\n\tinvoices=" + invoices +
                "\n\tcount=" + count +
                "\n\ttotalPages=" + totalPages +
                "\n\tcurrentPageNumber=" + currentPageNumber +
                '}';
    }
}

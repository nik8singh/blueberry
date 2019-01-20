package com.mana.spring.web;

import com.mana.spring.domain.Invoice;
import com.mana.spring.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    public InvoiceService invoiceService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    Invoice createInvoice(@RequestBody Invoice invoice) {

        return invoiceService.createInvoice(invoice);
    }


}

package com.mana.spring.web;

import com.mana.spring.domain.Invoice;
import com.mana.spring.dto.InvoiceListDTO;
import com.mana.spring.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    public InvoiceService invoiceService;

    @RequestMapping(value = "cus/order/made", method = RequestMethod.POST)
    public @ResponseBody
    Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @RequestMapping(value = "cus/order/confirm", method = RequestMethod.POST)
    public @ResponseBody
    Invoice confirmInvoice(@RequestBody Invoice invoice) {
        return invoiceService.confirmOrder(invoice);
    }

    @RequestMapping(value = "cus/order/pay", method = RequestMethod.POST)
    public @ResponseBody
    Invoice makePayment(@RequestBody Invoice invoice) {
        return invoiceService.makePayment(invoice);
    }

    @RequestMapping(value = "adm/list/pending/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    InvoiceListDTO pendingOrders(@PathVariable int pageNumber) {
        return invoiceService.getPendingInvoices(pageNumber);
    }

    @RequestMapping(value = "adm/list/completed/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    InvoiceListDTO completedOrders(@PathVariable int pageNumber) {
        return invoiceService.getCompletedInvoices(pageNumber);
    }

    @RequestMapping(value = "adm/list/refunded/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    InvoiceListDTO refundedOrders(@PathVariable int pageNumber) {
        return invoiceService.getRefundedInvoices(pageNumber);
    }

    @RequestMapping(value = "adm/list/requestedrefund/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    InvoiceListDTO requestedRefundOrders(@PathVariable int pageNumber) {
        return invoiceService.getRefundRequestedInvoices(pageNumber);
    }

    @RequestMapping(value = "adm/sent", method = RequestMethod.POST)
    public ResponseEntity orderSent(@RequestBody Invoice invoice) {
        invoiceService.completeInvoice(invoice);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/refund", method = RequestMethod.POST)
    public ResponseEntity orderRefund(@RequestBody Invoice invoice) {
        invoiceService.refundInvoice(invoice);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/req", method = RequestMethod.POST)
    public ResponseEntity orderRefundRequest(@RequestBody Invoice invoice) {
        invoiceService.requestRefund(invoice);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "cus/order/{invoiceNumber}", method = RequestMethod.GET)
    public @ResponseBody
    Invoice getInvoice(@PathVariable int invoiceNumber) {
        return invoiceService.getInvoice(invoiceNumber);
    }

    @RequestMapping(value = "cus/list/{email}/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    InvoiceListDTO getInvoices(@PathVariable String email, @PathVariable int pageNumber) {
        return invoiceService.getInvoices(email, pageNumber);
    }

}

package com.mana.spring.web;

import com.mana.spring.domain.NonceForm;
import com.mana.spring.domain.Order;
import com.mana.spring.dto.OrderDTO;
import com.mana.spring.dto.OrderListDTO;
import com.mana.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * Shipping address is included in the order obj
     */
    @RequestMapping(value = "cus/review/{userId}", method = RequestMethod.POST)
    public @ResponseBody
    Order createOrderReview(@RequestBody Order order, @PathVariable long userId) {
        Order tempOrder;
        try {
            tempOrder = orderService.calculateOrder(order, userId);
            System.out.println(tempOrder);
        } catch (NullPointerException ex) {
            System.out.println("No data");
            return null;
        }

        return tempOrder;
    }

    /**
     *
     */
    @RequestMapping(value = "cus/process/{orderId}", method = RequestMethod.POST)
    public @ResponseBody
    Order processOrder(@PathVariable long orderId, @RequestBody NonceForm nonceForm) {
        System.out.println("Nonce : " + nonceForm.getNonce());
        System.out.println("orderId : " + orderId);
        return orderService.processNewOrder(orderId, nonceForm);
    }

    /**
     *
     */
    @RequestMapping(value = "cus/addc/{cn}/{oi}", method = RequestMethod.POST)
    public @ResponseBody
    Order addCoupon(@PathVariable String cn, @PathVariable long oi) {
        return orderService.addCoupon(cn, oi);
    }

//    /**
//     *
//     * */
//    @RequestMapping(value = "cus/order/shipped", method = RequestMethod.POST)
//    public @ResponseBody
//    Order orderShipped(@RequestBody Order order) {
//        return orderService.orderShipped(order);
//    }

    @RequestMapping(value = "adm/list/{statusFilter}/{pageNumber}", method = RequestMethod.GET)
    public @ResponseBody
    OrderListDTO getListByStatus(@PathVariable String statusFilter, @PathVariable int pageNumber) {
        return orderService.getListByStatus(statusFilter, pageNumber);
    }

    @RequestMapping(value = "adm/list/search/{searchWord}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    OrderListDTO getPartialSearch(@PathVariable String searchWord) {
        return orderService.listPartialSearch(searchWord);
    }

    /**
     * Shipping address is included in the order obj
     */
    @RequestMapping(value = "cus/order/{orderId}", method = RequestMethod.GET)
    public @ResponseBody
    OrderDTO createOrderReview(@PathVariable long orderId) {
        return orderService.getOrderById(orderId);
    }

    @RequestMapping(value = "adm/update/privateNote/{orderId}", method = RequestMethod.POST)
    public ResponseEntity privateNoteUpdate(@RequestBody String message, @PathVariable long orderId) {
        orderService.updatePrivateNote(message, orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update/publicNote/{orderId}", method = RequestMethod.POST)
    public ResponseEntity publicNoteUpdate(@RequestBody String message, @PathVariable long orderId) {
        orderService.updatePublicNote(message, orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update/tracking/{orderId}", method = RequestMethod.POST)
    public ResponseEntity trackingNumberUpdate(@RequestBody String trackingNumber, @PathVariable long orderId) {
        orderService.updateTrackingNumber(trackingNumber, orderId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "adm/update", method = RequestMethod.POST)
    public ResponseEntity updateOrder(@Valid @RequestBody Order order) {
        orderService.updateOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

}

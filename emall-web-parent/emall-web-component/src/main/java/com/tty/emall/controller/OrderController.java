package com.tty.emall.controller;

import com.tty.emall.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tty
 * @create 2020-09-09-16:06
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    /**
     * 一个订单一个item，一个item一个商品
     */

    @Autowired
    private OrderService orderService;


}

package com.tty.emall.service.api;

import com.tty.emall.entity.Order;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-09-23:52
 */
public interface OrderService {

    List<Order> getOrderList();

}

package com.tty.emall.service.api;

import com.tty.emall.entity.Order;
import com.tty.emall.vo.OrderVo;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-11:15
 */
public interface OrderService {

    List<OrderVo> getOrderByList(Integer status);

    void ship(Integer orderId, Byte status);

    void removeOrderById(Integer id);
}

package com.tty.emall.service.impl;

import com.tty.emall.entity.Order;
import com.tty.emall.mapper.OrderMapper;
import com.tty.emall.service.api.OrderService;
import com.tty.emall.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-11:16
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderVo> getOrderByList(Integer status) {
        List<OrderVo> orderVos = orderMapper.selectOrder(status);
        return orderVos;
    }

    @Override
    public void ship(Integer orderId, Byte status) {
        Order order = new Order();
        order.setId(orderId);
        order.setStatus(status);
        System.out.println(status);
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void removeOrderById(Integer id) {
        orderMapper.deleteByPrimaryKey(id);
    }


}

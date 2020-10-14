package com.tty.emall.controller;

import com.tty.emall.entity.Order;
import com.tty.emall.service.api.OrderService;
import com.tty.emall.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-11:02
 */
@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 默认为0，查询全部订单
     */
    private Integer status = 0;

    /**
     * 如果status不为null，mapper进行拼接条件，如果为null则代表查询全部订单。高亮状态码为0
     * @param model
     * @param status
     * @return
     */
    @GetMapping("/list")
    public String getOrder(Model model, @RequestParam(required = false,value = "status") Integer status) {
        List<OrderVo> orderByList = orderService.getOrderByList(status);
        model.addAttribute("orders", orderByList);
        // 根据前端的选择进行高亮显示菜单
        if (!StringUtils.isEmpty(status)) {
            this.status = status;
        } else {
            // 不存在恢复为0
            this.status = 0;
        }

        System.out.println(this.status);
        model.addAttribute("status", this.status);
        return "/admin/order_list";
    }

    /**
     * 直接带上订单状态，并且设置状态码，跳转到原来的页面，一个控制器就可以完成发货，完成
     * @param orderId
     * @param status
     * @param model
     * @return
     */
    @GetMapping("/ship")
    public String modifyOrderShip(@RequestParam("id") Integer orderId, @RequestParam("status") Byte status, Model model) {
        model.addAttribute("status", this.status);
        orderService.ship(orderId, status);
        return "redirect:/admin/order/list";
    }

    @GetMapping("/remove")
    public String removeOrder(@RequestParam("id") Integer id, Model model) {

        orderService.removeOrderById(id);
        model.addAttribute("status", this.status);
        return "redirect:/admin/order/list";

    }

}

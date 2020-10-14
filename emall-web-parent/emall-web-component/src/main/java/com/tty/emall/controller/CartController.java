package com.tty.emall.controller;

import com.tty.emall.entity.Cart;
import com.tty.emall.entity.User;
import com.tty.emall.service.api.CartService;
import com.tty.emall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;
import utils.ResultEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author tty
 * @create 2020-09-09-10:12
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/get")
    public String getCart(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<CartVo> cartVo = cartService.getCartVo(user.getId());
        float total = 0;
        for (int i = 0; i <cartVo.size(); i++) {
            cartVo.get(i).setTotal((float) (cartVo.get(i).getGoods().getPrice() * cartVo.get(i).getAmount()));
            total += cartVo.get(i).getTotal();
        }
        System.out.println(cartVo);
        model.addAttribute("cartList", cartVo);
        model.addAttribute("cartTotal", total);
        return "/cart";
    }

    @GetMapping("/get/total")
    @ResponseBody
    public Result getCartTotal(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<CartVo> cartVo = cartService.getCartVo(user.getId());
        float total = 0;
        for (int i = 0; i <cartVo.size(); i++) {
            cartVo.get(i).setTotal((float) (cartVo.get(i).getGoods().getPrice() * cartVo.get(i).getAmount()));
            total += cartVo.get(i).getTotal();
        }
        return Result.success(total);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addCart(Cart cart, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        cart.setUserId(user.getId());


        cartService.addCart(cart);

        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());

    }

    @PostMapping("/reduce")
    @ResponseBody
    public Result reduceCart(Integer id) {

        cartService.reduceCart(id);
        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());
    }

    @PostMapping("/remove")
    @ResponseBody
    public Result removeCart(Integer id) {
        cartService.remove(id);
        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());
    }

}

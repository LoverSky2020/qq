package com.tty.emall.service.api;

import com.tty.emall.entity.Cart;
import com.tty.emall.vo.CartVo;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-09-10:14
 */
public interface CartService {

    void addCart(Cart cart);

    List<CartVo> getCartVo(Integer userId);

    void reduceCart(Integer id);

    void remove(Integer id);
}

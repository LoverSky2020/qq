package com.tty.emall.service.impl;

import com.tty.emall.entity.Cart;
import com.tty.emall.mapper.CartMapper;
import com.tty.emall.service.api.CartService;
import com.tty.emall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-09-10:15
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addCart(Cart cart) {

        List<CartVo> cartVo = getCartVo(cart.getUserId());

        boolean flag = false;

        if (!StringUtils.isEmpty(cart.getId())) {
            Cart cart1 = cartMapper.selectByPrimaryKey(cart.getId());
            cart1.setAmount(cart1.getAmount() + 1);
            cartMapper.updateByPrimaryKeySelective(cart1);
        }

        if (StringUtils.isEmpty(cart.getId())) {
            for (int i = 0; i < cartVo.size(); i++) {
                if (cart.getGoodId().equals(cartVo.get(i).getGoodId())) {

                    Cart cart1 = new Cart();
                    cart1.setId(cartVo.get(i).getId());
                    cart1.setAmount(cartVo.get(i).getAmount() + 1);
                    cartMapper.updateByPrimaryKeySelective(cart1);
                    flag = true;
                }
            }
            if (!flag) {
                cart.setAmount(1);
                cartMapper.insertSelective(cart);
            }
        }

    }

    @Override
    public List<CartVo> getCartVo(Integer userId) {
        List<CartVo> cartVos = cartMapper.selectByCartVo(userId);
        return cartVos;
    }

    @Override
    public void reduceCart(Integer id) {
        Cart cart = cartMapper.selectByPrimaryKey(id);
        cart.setAmount(cart.getAmount() - 1);
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    @Override
    public void remove(Integer id) {
        cartMapper.deleteByPrimaryKey(id);
    }
}

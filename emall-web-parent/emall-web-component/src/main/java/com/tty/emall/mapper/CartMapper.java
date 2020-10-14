package com.tty.emall.mapper;

import com.tty.emall.entity.Cart;
import com.tty.emall.entity.CartExample;
import com.tty.emall.vo.CartVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<CartVo> selectByCartVo(@Param("userId") Integer userId);

}
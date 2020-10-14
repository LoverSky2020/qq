package com.tty.emall.service.api;

import com.tty.emall.entity.Type;
import com.tty.emall.vo.TypeVo;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-06-17:29
 */
public interface TypeService {
    /**
     * 查询所有分类商品
     * @return
     */
    List<TypeVo> getClassifiedProducts();

    /**
     * 根据分类查询所有该分类下的商品
     * @return
     */
    TypeVo getClassifiedProductsById(Integer id);

    List<Type> getTypeByList();
}

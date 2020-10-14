package com.tty.emall.service.impl;

import com.tty.emall.entity.Type;
import com.tty.emall.mapper.TypeMapper;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-06-17:46
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<TypeVo> getClassifiedProducts() {
        List<TypeVo> typeVos = typeMapper.selectByTypeAndGoods();
        return typeVos;
    }

    @Override
    public TypeVo getClassifiedProductsById(Integer id) {
        TypeVo typeVo = typeMapper.selectByTypeAndGoodsById(id);
        return typeVo;
    }

    @Override
    public List<Type> getTypeByList() {
        List<Type> types = typeMapper.selectByExample(null);
        return types;
    }
}

package com.tty.emall.service.impl;

import com.tty.emall.entity.Type;
import com.tty.emall.mapper.TypeMapper;
import com.tty.emall.service.api.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-14:41
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getTypeByList() {
        List<Type> types = typeMapper.selectByExample(null);
        return types;
    }

    @Override
    public void removeTypeById(Integer id) {
        typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Type getTypeById(Integer id) {
        Type type = typeMapper.selectByPrimaryKey(id);
        return type;
    }

    @Override
    public void modifyType(Type type) {
        typeMapper.updateByPrimaryKey(type);
    }

    @Override
    public void saveType(Type type) {
        typeMapper.insertSelective(type);
    }
}

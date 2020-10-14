package com.tty.emall.service.api;

import com.tty.emall.entity.Type;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-14:40
 */
public interface TypeService {

    List<Type> getTypeByList();

    void removeTypeById(Integer id);

    Type getTypeById(Integer id);

    void modifyType(Type type);

    void saveType(Type type);
}

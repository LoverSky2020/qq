package com.tty.emall.vo;

import com.tty.emall.entity.Goods;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-06-17:30
 */
public class TypeVo {

    private Integer id;

    private String name;

    private Integer num;

    private List<Goods> goodList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Goods> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Goods> goodList) {
        this.goodList = goodList;
    }

    @Override
    public String toString() {
        return "TypeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", goodList=" + goodList +
                '}';
    }
}

package com.tty.emall.vo;

import com.tty.emall.entity.Goods;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-09-10:39
 */
public class CartVo {

    private Integer id;

    private Integer amount;

    private Integer goodId;

    private Integer userId;

    private Float total;

    private Goods goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "CartVo{" +
                "id=" + id +
                ", amount=" + amount +
                ", goodId=" + goodId +
                ", userId=" + userId +
                ", total=" + total +
                ", goods=" + goods +
                '}';
    }
}

package com.tty.emall.vo;

import com.tty.emall.entity.Admin;
import com.tty.emall.entity.Goods;
import com.tty.emall.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author tty
 * @create 2020-09-03-11:19
 */
public class OrderVo {

    private Integer id;

    private Integer total;

    private Integer amount;

    private Byte status;

    private Byte paytype;

    private String name;

    private String phone;

    private String address;

    private Date systime;

    private Integer userId;

    private List<Goods> goodItem;

    private User user;

    public OrderVo() {
    }

    public OrderVo(Integer id, Integer total, Integer amount, Byte status, Byte paytype, String name, String phone, String address, Date systime, Integer userId, List<Goods> goodItem, User user) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.status = status;
        this.paytype = paytype;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.systime = systime;
        this.userId = userId;
        this.goodItem = goodItem;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPaytype() {
        return paytype;
    }

    public void setPaytype(Byte paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Goods> getGoodItem() {
        return goodItem;
    }

    public void setGoodItem(List<Goods> goodItem) {
        this.goodItem = goodItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "id=" + id +
                ", total=" + total +
                ", amount=" + amount +
                ", status=" + status +
                ", paytype=" + paytype +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", systime=" + systime +
                ", userId=" + userId +
                ", goodItem=" + goodItem +
                ", user=" + user +
                '}';
    }
}

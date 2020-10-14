package com.tty.emall.vo;

import com.tty.emall.entity.Type;

/**
 * @author tty
 * @create 2020-09-02-20:26
 */
public class GoodsVo {

    private Integer id;

    private String cover;

    private String name;

    private String intro;

    private String spec;

    private Integer price;

    private Integer stock;

    private Integer sales;

    /**
     * 一个商品一个分类，一个分类多个商品
     */
    private Type type;

    private String content;
    /**
     * 用来区分是否推荐商品
     */
    private Integer top;

    /**
     * true为今日推荐
     * false则不是
     */
    private Boolean isTop;

    public GoodsVo() {
    }

    public GoodsVo(Integer id, String cover, String name, String intro, String spec, Integer price, Integer stock, Integer sales, Boolean isTop, Type type, String content, Integer top) {
        this.id = id;
        this.cover = cover;
        this.name = name;
        this.intro = intro;
        this.spec = spec;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.isTop = isTop;
        this.type = type;
        this.content = content;
        this.top = top;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTop() {
        return top;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", spec='" + spec + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", top=" + top +
                ", isTop=" + isTop +
                '}';
    }
}

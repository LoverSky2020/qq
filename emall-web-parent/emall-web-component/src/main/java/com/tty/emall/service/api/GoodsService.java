package com.tty.emall.service.api;

import com.tty.emall.entity.Goods;
import com.tty.emall.vo.GoodsVo;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-05-16:47
 */
public interface GoodsService {

    /**
     * 今日推荐
     * @return
     */
    List<Goods> getRecommendGoods();

    /**
     * 热门商品
     * @return
     */
    List<Goods> getHotGoods();

    /**
     * 商品详情
     * @param id
     * @return
     */
    GoodsVo getGoodsDetail(Integer id);

    /**
     * 最新商品
     * @return
     */
    List<Goods> getNewGoods();

}

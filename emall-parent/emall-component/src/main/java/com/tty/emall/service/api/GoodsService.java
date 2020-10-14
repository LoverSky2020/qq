package com.tty.emall.service.api;

import com.tty.emall.entity.Goods;
import com.tty.emall.vo.GoodsVo;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-20:06
 */
public interface GoodsService {

    List<GoodsVo> getGoodsByList();

    List<GoodsVo> getRecommendGoods();

    void removeGoodsById(Integer id);

    Goods getGoodsById(Integer id);

    void modifyGoods(Goods goods);

    void saveGoods(Goods goods);

    void joinRecommend(Integer goodId, Integer type);

    void removeRecommend(Integer goodId, Integer type);
}

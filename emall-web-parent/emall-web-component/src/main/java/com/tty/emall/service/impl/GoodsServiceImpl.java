package com.tty.emall.service.impl;

import com.tty.emall.entity.Goods;
import com.tty.emall.entity.GoodsExample;
import com.tty.emall.mapper.GoodsMapper;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-05-16:48
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getRecommendGoods() {
        List<Goods> goods = goodsMapper.selectByRecommend();
        return goods;
    }

    @Override
    public List<Goods> getHotGoods() {
        GoodsExample example = new GoodsExample();
        // 页面只要白条，那就只查八条
        example.setOrderByClause("sales DESC limit 0, 9");
        List<Goods> goods = goodsMapper.selectByExample(example);
        return goods;
    }

    @Override
    public GoodsVo getGoodsDetail(Integer id) {
        GoodsVo goodsVo = goodsMapper.selectGoodsTypeVoById(id);
        return goodsVo;
    }

    @Override
    public List<Goods> getNewGoods() {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("id DESC  LIMIT 0,10");

        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        return goods;
    }
}

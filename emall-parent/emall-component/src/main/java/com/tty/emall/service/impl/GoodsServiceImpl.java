package com.tty.emall.service.impl;

import com.tty.emall.entity.Goods;
import com.tty.emall.mapper.GoodsMapper;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-20:07
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> getGoodsByList() {

        List<GoodsVo> goods = goodsMapper.selectGoodsVo();

        return getGoodsVos(goods);
    }

    @Override
    public List<GoodsVo> getRecommendGoods() {

        List<GoodsVo> goodsVos = goodsMapper.selectRecommendGoods();

        return getGoodsVos(goodsVos);
    }


    @Override
    public void removeGoodsById(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Goods getGoodsById(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

    @Override
    public void modifyGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public void saveGoods(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void joinRecommend(Integer goodId, Integer type) {
        goodsMapper.insertGoodsRecommend(goodId, type);
    }

    @Override
    public void removeRecommend(Integer goodId, Integer type) {

        goodsMapper.deleteGoodsRecommend(goodId, type);
    }

    /**
     * 组装goods数据
     *
     * @param goodsVos
     * @return
     */
    private List<GoodsVo> getGoodsVos(List<GoodsVo> goodsVos) {
        for (int i = 0; i < goodsVos.size(); i++) {

            if (goodsVos.get(i).getTop() != null && goodsVos.get(i).getTop() != 0) {
                goodsVos.get(i).setIsTop(true);
            } else {
                goodsVos.get(i).setIsTop(false);
            }

        }

        return goodsVos;
    }

}

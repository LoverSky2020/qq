package com.tty.emall;

import com.tty.emall.entity.Goods;
import com.tty.emall.mapper.GoodsMapper;
import com.tty.emall.mapper.TypeMapper;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.vo.TypeVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-05-17:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class EmallTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TypeService typeService;

    @Test
    public void test4() {
        TypeVo classifiedProductsById = typeService.getClassifiedProductsById(1);
        List<Goods> goodList = classifiedProductsById.getGoodList();

    }

    @Test
    public void test3() {
        System.out.println(goodsService.getGoodsDetail(1));
    }

    @Test
    public void testTypeMapper() {
        List<TypeVo> typeVos = typeMapper.selectByTypeAndGoods();
        typeVos.forEach(System.out::println);
    }

    @Test
    public void test1() {
        System.out.println(goodsService.getHotGoods());
    }

    @Test
    public void test() {
        System.out.println(goodsMapper.selectByRecommend());
    }

}

package com.tty.emall.controller;

import com.tty.emall.entity.Goods;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 跟商品有关的控制器
 * 今日推荐
 * 新品上市
 * 热销排行
 * @author tty
 * @create 2020-09-06-19:01
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    /**
     * 热门商品
     * @param model
     * @return
     */
    @RequestMapping("/hot")
    public String getHotGoods(Model model) {
        List<Goods> hotGoods = goodsService.getHotGoods();
        model.addAttribute("goodList", hotGoods);
        model.addAttribute("flag", 3);
        return "/goods";
    }

    /**
     * 今日推荐
     * @param model
     * @return
     */
    @GetMapping("/today")
    public String recommendedGoods(Model model) {

        List<Goods> recommendGoods = goodsService.getRecommendGoods();
        model.addAttribute("goodList", recommendGoods);
        model.addAttribute("flag", 2);

        return "/goods";
    }

    @GetMapping("/new")
    public String newGoods(Model model) {
        List<Goods> goods = goodsService.getNewGoods();
        model.addAttribute("goodList", goods);
        return "/goods";
    }

    @GetMapping("/sort/{id}")
    public String ClassifiedGoods(Model model, @PathVariable Integer id) {
        TypeVo classifiedProducts = typeService.getClassifiedProductsById(id);
        model.addAttribute("goodList", classifiedProducts.getGoodList());
        model.addAttribute("type", classifiedProducts);
        return "/goods";
    }

}

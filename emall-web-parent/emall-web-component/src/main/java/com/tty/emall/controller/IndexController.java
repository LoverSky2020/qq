package com.tty.emall.controller;

import com.tty.emall.entity.Goods;
import com.tty.emall.entity.Type;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.vo.TypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 主页控制器
 * @author tty
 * @create 2020-09-05-17:07
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/display")
    public String displayIndex(Model model) {
        List<Goods> recommendGoods = goodsService.getRecommendGoods();
        List<Goods> hotGoods =  goodsService.getHotGoods();
        List<TypeVo> classifiedProducts = typeService.getClassifiedProducts();
        List<Type> types = typeService.getTypeByList();
        // 今日推荐
        model.addAttribute("todayList", recommendGoods);
        // 热销商品
        model.addAttribute("hotList", hotGoods);
        // 分类商品
        model.addAttribute("dataList", classifiedProducts);
        // 选中商城首页
        model.addAttribute("flag", 1);
        // 回显分类下拉框
        model.addAttribute("typeList", types);
        return "index";
    }



}

package com.tty.emall.controller;

import com.tty.emall.entity.Goods;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品详情控制器
 * @author tty
 * @create 2020-09-06-17:56
 */
@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/{id}")
    public String getDetail(@PathVariable Integer id, Model model) {
        GoodsVo goodsVo = goodsService.getGoodsDetail(id);
        List<Goods> recommendGoods = goodsService.getRecommendGoods();
        model.addAttribute("good",goodsVo);
        // 大家都在买
        model.addAttribute("todayList", recommendGoods);
        return "detail";
    }

}

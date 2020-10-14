package com.tty.emall.controller;

import com.tty.emall.entity.Goods;
import com.tty.emall.entity.Type;
import com.tty.emall.service.api.GoodsService;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.utils.RandName;
import com.tty.emall.utils.Result;
import com.tty.emall.utils.ResultEnum;
import com.tty.emall.utils.UploadUtils;
import com.tty.emall.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-20:05
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypeService typeService;

    /**
     * 用来让前端显示选中全部商品和今日推荐效果
     */
    private Integer flag = 0;

    @GetMapping("/list")
    public String getGoods(Model model) {
        flag = 0;
        List<GoodsVo> goods = goodsService.getGoodsByList();
        model.addAttribute("goods", goods);
        model.addAttribute("type", flag);
        return "/admin/good_list";
    }

    @GetMapping("/recommend")
    public String getRecommendGoods(Model model) {
        flag = 1;
        System.out.println(flag);
        List<GoodsVo> goodsVos = goodsService.getRecommendGoods();
        System.out.println(goodsVos);
        model.addAttribute("type", flag);
        model.addAttribute("goods", goodsVos);
        return "/admin/good_list";
    }

    @GetMapping("/remove/id")
    public String removeGoods(@RequestParam Integer id) {

        goodsService.removeGoodsById(id);


        // 回到删除的页面(全部/推荐)
        if (flag == 1) {
            return "redirect:/admin/goods/recommend";
        }

        return "redirect:/admin/goods/list";

    }

    @GetMapping("/toEdit/{id}")
    public String toEditGoods(@PathVariable Integer id, Model model) {
        Goods goods = goodsService.getGoodsById(id);
        List<Type> typeList = typeService.getTypeByList();
        model.addAttribute("good", goods);
        model.addAttribute("types", typeList);
        return "/admin/good_edit";
    }

    @PostMapping("/edit")
    public String editGoods(Goods goods, MultipartFile multipartFile, HttpServletRequest request) {

        if (!StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
            String path = RandName.getRandomName(multipartFile.getOriginalFilename());
            String uploadPath = "E:\\idea_project\\emall-parent\\emall-webui\\src\\main\\webapp\\upload\\" + path;
            UploadUtils.upload(multipartFile, uploadPath, path, request);
            goods.setCover("upload/" + path);
        }


//        Goods good = goodsService.getGoodsById(goods.getId());

        // 拿到更改前的销售数量 ,还可以让mapper有选择性的更新，如果值为空则不更新该字段 明显让mapper选择性更新比较好少查一次
//        goods.setSales(good.getSales());

        goodsService.modifyGoods(goods);

        return "redirect:/admin/goods/list";

    }

    @GetMapping("/toSave")
    public String toSaveGoods(Model model) {

        List<Type> types = typeService.getTypeByList();

        model.addAttribute("types", types);

        return "/admin/good_add";
    }

    @PostMapping("/save")
    public String saveGoods(Goods goods, MultipartFile multipartFile, HttpServletRequest request) {

        String path = RandName.getRandomName(multipartFile.getOriginalFilename());

        String uploadPath = "E:\\idea_project\\emall-parent\\emall-webui\\src\\main\\webapp\\upload\\" + path;

        UploadUtils.upload(multipartFile, uploadPath, path, request);

        goods.setCover("upload/" + path);
        // 新增的商品，销售数量初始为0
        goods.setSales(0);
        goodsService.saveGoods(goods);
        return "redirect:/admin/goods/list";
    }

    @PostMapping("/join/recommend")
    @ResponseBody
    public Result joinRecommend(@RequestParam Integer goodId, @RequestParam Integer type) {

        goodsService.joinRecommend(goodId,type);

        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());

    }

    @PostMapping("/remove/recommend")
    @ResponseBody
    public Result removeRecommend(@RequestParam Integer goodId, @RequestParam Integer type) {

        goodsService.removeRecommend(goodId,type);

        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());

    }

}

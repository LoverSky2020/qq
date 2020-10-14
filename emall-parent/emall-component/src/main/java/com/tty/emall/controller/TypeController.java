package com.tty.emall.controller;

import com.tty.emall.entity.Type;
import com.tty.emall.mapper.TypeMapper;
import com.tty.emall.service.api.TypeService;
import com.tty.emall.utils.Result;
import com.tty.emall.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tty
 * @create 2020-09-02-14:38
 */
@Controller
@RequestMapping("/admin/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    @ResponseBody
    public Result getType() {

        List<Type> types = typeService.getTypeByList();


        return Result.success(types);
    }

    @DeleteMapping("/{id}")
    public Result removeType(@PathVariable Integer id) {

        typeService.removeTypeById(id);

        return Result.build(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());

    }

    @GetMapping("/edit/{id}")
    public String redisplayType(@PathVariable Integer id, Model model) {

        Type type = typeService.getTypeById(id);

        model.addAttribute("type", type);

        return "/admin/type_edit";

    }

    @PostMapping("/edit")
    public String editType(Type type) {
        System.out.println(type);
        typeService.modifyType(type);
        return "redirect:/admin/type/list/page";
    }

    @PostMapping("/save")
    public String saveType(Type type) {
        typeService.saveType(type);
        return "redirect:/admin/type/list/page";
    }


}

package com.afeng.springmvc.controller;

import com.afeng.springmvc.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//controller类不用继承于其他的类
@Controller
public class ItemController {

    //requestMapping是指当访问路径为括号中的路径时 就调用下列的方法 action可以不写 但是为了代码规范 建议写
    @RequestMapping("/itemList.action")
    public ModelAndView queryItemList() {
        //创建页面所需要的商品数据---假数据
        List<Item> list = new ArrayList<>();
        //Integer id, String name, String detail, Float price, Date createtime
        list.add(new Item(1, "1华为荣耀8", "质量好", 2399f, new Date()));
        list.add(new Item(2, "1华为荣耀1", "质量好", 2399f, new Date()));
        list.add(new Item(3, "1华为荣耀1", "质量好", 2399f, new Date()));
        list.add(new Item(4, "1华为荣耀1", "质量好", 2399f, new Date()));
        list.add(new Item(5, "1华为荣耀1", "质量好", 2399f, new Date()));
        list.add(new Item(6, "1华为荣耀1", "质量好", 2399f, new Date()));
        //创建modelAndView对象 用来存储数据和视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }
}

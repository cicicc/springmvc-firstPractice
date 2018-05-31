package com.afeng.springmvc.controller;


import com.afeng.springmvc.pojo.Items;
import com.afeng.springmvc.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
//controller类不用继承于其他的类
@Controller
public class ItemController {

    //requestMapping是指当访问路径为括号中的路径时 就调用下列的方法 action可以不写 但是为了代码规范 建议写
    //测试案例
   /* @RequestMapping("/itemList.action")
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
    }*/
    //注入ItemsService对象
    @Resource
    private ItemService itemService;

    /**
     * 查询所有商品列表
     * @return modelAndView对象
     */
    @RequestMapping("/itemList.action")
    public ModelAndView queryItemList() {
        //获取商品列表
        List<Items> items = itemService.queryItemList();
        //创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //将数据封装到modelAndView对象中
        modelAndView.addObject("itemList", items);
        //设置转发的逻辑视图
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    /**
     * 接收页面传递过来参数的第一种方式 使用request请求接收参数
     * 并使用modelAndView对象将数据传递回去
     * 是否推荐:不推荐
     * @param request request
     * @return 包含数据的modelAndView对象
     */
    @RequestMapping("itemEdit_notUse1.action")
    public ModelAndView queryItemById001(HttpServletRequest request){
        //从request中获取请求参数
        Integer id = Integer.parseInt(request.getParameter("id"));
        //进行查询 并返回查询结果
        Items item = itemService.queryItemById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", item);
        modelAndView.setViewName("editItem");
        return modelAndView;
    }

    /**
     * 使用request接收页面传递过来的参数
     * 使用model将对象传递回去
     * @param request request请求
     * @param model model对象 在这里 使用model和使用modelMap是同样的效果 因为直接使用model的话 SpringMVC会将其实例化为modelMap对象
     * @return 视图名称
     */
    @RequestMapping("itemEdit_notUse2.action")
    public String queryItemById002(HttpServletRequest request, Model model){
        //从request中接收页面参数
        // 建议在这里参数转换使用valueOf而不是parseInt 因为parseInt可能会抛出异常来
        Integer id = Integer.valueOf(request.getParameter("id"));
        //进行查询 并返回查询结果
        Items item = itemService.queryItemById(id);
        //把查询结果放入商品数据模型中
        model.addAttribute("item", item);
        //设置跳转页面 由springmvc.xml中的配置进行拼接返回路径
        return "editItem";
    }

    /**
     * 使用形参来接受参数
     * 当形参名字和页面传递过来参数一致的时候 就可以直接进行绑定 推荐使用这种方法(只接受基础类型及其包装类 推荐包装类型)
     * 使用model将对象传递回去
     * @param id 使用形参来接受参数
     * @param model model对象 在这里 使用model和使用modelMap是同样的效果 因为直接使用model的话 SpringMVC会将其实例化为modelMap对象
     * @return 视图名称
     */
    @RequestMapping("itemEdit.action")
    public String queryItemById(Integer id, ModelMap model){
        //进行查询 并返回查询结果
        Items item = itemService.queryItemById(id);
        //把查询结果放入商品数据模型中
        model.addAttribute("item", item);
        //设置跳转页面 由springmvc.xml中的配置进行拼接返回路径
        return "editItem";
    }

    /**
     * 根据页面传递过来的item数据对数据库中数据进行更新操作
     * @param item 页面传递过来的item数据
     * @return 成功页面
     */
    @RequestMapping("updateItem.action")
    public String updateItem(Items item){
        //更新商品页面
        itemService.updateItem(item);
        //设置跳转页面 由springmvc.xml中的配置进行拼接返回路径
        return "success";
    }


}

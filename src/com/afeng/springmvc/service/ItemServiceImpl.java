package com.afeng.springmvc.service;


import com.afeng.springmvc.dao.ItemsMapper;
import com.afeng.springmvc.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl  implements ItemService{
    //创建itemMapper对象 用于查询数据
    @Autowired
    private ItemsMapper itemsMapper;

    /**
     * 查询所有的订单 并封装到list集合中返回
     * @return 存储订单数据的list集合
     */
    @Override
    public List<Items> queryItemList() {
        return this.itemsMapper.selectByExample(null);
    }

    /**
     * 根据id查询订单
     * @param id 提供的id
     * @return 查询到的数据结果
     */
    @Override
    public Items queryItemById(Integer id) {
        return this.itemsMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新商品
     * @param item
     */
    @Transactional(readOnly = true)
    @Override
    public void updateItem(Items item) {
        //调用dao更新商品
        this.itemsMapper.updateByPrimaryKeySelective(item);
    }

}

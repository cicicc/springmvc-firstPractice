package com.afeng.springmvc.service;

import com.afeng.springmvc.pojo.Items;

import java.util.List;

public interface ItemService {

    List<Items> queryItemList();

    Items queryItemById(Integer id);

    void updateItem(Items item);
}

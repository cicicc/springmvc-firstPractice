package com.afeng.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    /**
     * CREATE TABLE `items` (
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `name` varchar(32) NOT NULL COMMENT '商品名称',
     *   `price` float(10,1) NOT NULL COMMENT '商品定价',
     *   `detail` text COMMENT '商品描述',
     *   `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
     *   `createtime` datetime NOT NULL COMMENT '生产日期',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
     */
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private String pic;
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public Item() {
    }

    public Item(Integer id, String name, String detail, Float price, Date createtime) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.createtime = createtime;
    }
}

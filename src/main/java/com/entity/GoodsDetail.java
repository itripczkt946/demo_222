package com.entity;

/**
 * 商品详情
 */
public class GoodsDetail {

    private int id;
    private int sortid;
    private String name;
    private String address;
    private double price;
    private String createDate;
    private int remaining;

    private GoodsSort goodsSort;

    public GoodsSort getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(GoodsSort goodsSort) {
        this.goodsSort = goodsSort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}

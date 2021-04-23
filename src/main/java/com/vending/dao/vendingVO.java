package com.vending.dao;

public class vendingVO {
    String itemNumber;
    int price;
    String itemImage;
    String soldOutFlag;

    public vendingVO(String itemNumber, int price, String itemImage, String soldOutFlag) {
        this.itemNumber = itemNumber;
        this.price = price;
        this.itemImage = itemImage;
        this.soldOutFlag = soldOutFlag;
    }

    public String getitemNumber() {
        return itemNumber;
    }

    public void setitemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getitemImage() {
        return itemImage;
    }

    public void setitemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getsoldOutFlag() {
        return soldOutFlag;
    }

    public void setsoldOutFlag(String soldOutFlag) {
        this.soldOutFlag = soldOutFlag;
    }
}
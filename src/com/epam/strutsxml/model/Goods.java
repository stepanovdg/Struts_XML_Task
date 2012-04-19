package com.epam.strutsxml.model;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 4/9/12
 * Time: 7:58 AM
 */
public class Goods implements Serializable {
    private String category;
    private String subCategory;
    private String unit;
    private String provider;
    private String model;
    private String dateOfIssue;
    //    private Date dateOfIssue;
    private String color;
    private Integer price;
    private boolean stock;

    public Goods() {
    }

    public Goods(Goods tableElement) {

        this.setCategory(tableElement.getCategory());
        this.setSubCategory(tableElement.getSubCategory());
        this.setUnit(tableElement.getUnit());
        this.setProvider(tableElement.getProvider());
        this.setModel(tableElement.getModel());
        this.setDateOfIssue(tableElement.getDateOfIssue());
        this.setPrice(tableElement.getPrice());
        this.setStock(tableElement.getStock());

    }

    @Override
    public String toString() {
        return category + subCategory + unit;
    }

    public Goods(String category,
                 String subCategory,
                 String unit,
                 String provider,
                 String model,
                 String dateOfIssue,
                 String color,
                 Integer price,
                 boolean stock) {
        this.category = category;
        this.subCategory = subCategory;
        this.unit = unit;
        this.provider = provider;
        this.model = model;
        this.dateOfIssue = dateOfIssue;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }


    public void setDateOfIssue(String date) {
        this.dateOfIssue = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean getStock() {
        return stock;

    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

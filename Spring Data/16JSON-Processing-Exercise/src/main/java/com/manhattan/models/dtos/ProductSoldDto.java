package com.manhattan.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductSoldDto {
    @Expose
    private int count;

    @Expose
    private List<ProductDetailsDto> products;

    public int getCount() {
        return count;
    }

    public List<ProductDetailsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailsDto> products) {
        this.products = products;
        this.count = products.size();
    }
}

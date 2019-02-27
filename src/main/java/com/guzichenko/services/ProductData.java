package com.guzichenko.services;

import java.math.BigDecimal;

public class ProductData {

    public Long price;
    public String nameOfProduct;

    public ProductData(Long price, String nameOfProduct) {
        this.price = price;
        this.nameOfProduct = nameOfProduct;
    }
}

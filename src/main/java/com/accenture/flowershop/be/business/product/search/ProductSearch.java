package com.accenture.flowershop.be.business.product.search;

import org.codehaus.jackson.map.util.ArrayBuilders;

public class ProductSearch {

    private String name;
    private String price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

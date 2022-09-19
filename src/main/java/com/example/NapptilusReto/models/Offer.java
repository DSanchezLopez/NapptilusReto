package com.example.NapptilusReto.models;

import java.util.Date;

public class Offer {

    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private Date startDate;
    private Date endDate;
    private Double price;

    public Integer getProductId() {
        return productId;
    }


    public Integer getBrandId() {
        return brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getPrice() {
        return price;
    }

    public Offer(Prices price) {
        this.productId = price.getProductId();
        this.brandId = price.getBrandId();
        this.priceList = price.getPriceList();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.price = price.getPrice();
    }

}

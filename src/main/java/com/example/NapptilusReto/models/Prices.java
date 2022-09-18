package com.example.NapptilusReto.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prices {

    @Id
    private Integer id;

    private Integer brandId;

    private Date startDate;

    private Date endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String currency;

    public Integer getBrandId() {
        return brandId;
    }


    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }


    public Integer getPriceList() {
        return priceList;
    }


    public Integer getProductId() {
        return productId;
    }


    public Double getPrice() {
        return price;
    }


}
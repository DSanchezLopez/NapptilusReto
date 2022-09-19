package com.example.NapptilusReto.controllers;

import com.example.NapptilusReto.models.Offer;
import com.example.NapptilusReto.models.Prices;
import com.example.NapptilusReto.repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class PricesController {
    @Autowired
    private final PricesRepository pricesRepository;

    PricesController(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @GetMapping("/retrieveOfferDetails")
    public ResponseEntity<Offer> getOfferDetail(@RequestParam Integer brand,
                                                @RequestParam Integer product,
                                                @RequestParam String date) {

        Offer offer = null;
        List<Prices> listPrices = pricesRepository.findByProductIdAndBrandId(product, brand);

        for (Prices price : listPrices
        ) {
            if (((price.getStartDate().compareTo(stringToDate(date)) < 0) && (price.getEndDate().compareTo(stringToDate(date)) > 0))||
                 (price.getStartDate().compareTo(stringToDate(date)) == 0)||
                 (price.getEndDate().compareTo(stringToDate(date)) == 0)) {
                    offer = new Offer(price);
            }
        }
        if (offer == null) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(offer, HttpStatus.OK);

    }

    private Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}

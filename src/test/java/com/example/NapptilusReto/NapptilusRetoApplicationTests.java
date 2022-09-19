package com.example.NapptilusReto;

import com.example.NapptilusReto.controllers.PricesController;
import com.example.NapptilusReto.models.Offer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NapptilusRetoApplicationTests {

@Autowired
    private PricesController pricesController;

@Test
    public void shouldLoadContext(){

        assertThat(pricesController).isNotNull();

}

@Test
    public void shouldReturnNoContent(){

    ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(0,0,"2030-06-14 00:00:00.0");

    assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);

}

    @Test
    public void shouldReturnAnOutputPricesFor141000DateWith3455ProductIdAnd1BrandId(){

        ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(1,35455,"2020-06-14 10:00:00.0");
        assertEquals(responseEntity.getBody().getPrice(), 35.50);
        assertEquals(responseEntity.getBody().getStartDate().toString(), "2020-06-14 00:00:00.0");
        assertEquals(responseEntity.getBody().getEndDate().toString(), "2020-12-31 23:59:59.0");
        assertEquals(responseEntity.getBody().getPriceList(), 1);
        assertEquals(responseEntity.getBody().getProductId(), 35455);
        assertEquals(responseEntity.getBody().getBrandId(), 1);

    }

    @Test
    public void shouldReturnAnOutputPricesFor141600DateWith3455ProductIdAnd1BrandId(){

        ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(1,35455,"2020-06-14 16:00:00.0");
        assertEquals(responseEntity.getBody().getPrice(), 25.45);
        assertEquals(responseEntity.getBody().getStartDate().toString(), "2020-06-14 15:00:00.0");
        assertEquals(responseEntity.getBody().getEndDate().toString(), "2020-06-14 18:30:00.0");
        assertEquals(responseEntity.getBody().getPriceList(), 2);
        assertEquals(responseEntity.getBody().getProductId(), 35455);
        assertEquals(responseEntity.getBody().getBrandId(), 1);

    }

    @Test
    public void shouldReturnAnOutputPricesFor142100DateWith3455ProductIdAnd1BrandId(){

        ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(1,35455,"2020-06-14 21:00:00.0");
        assertEquals(responseEntity.getBody().getPrice(), 35.5);
        assertEquals(responseEntity.getBody().getStartDate().toString(), "2020-06-14 00:00:00.0");
        assertEquals(responseEntity.getBody().getEndDate().toString(), "2020-12-31 23:59:59.0");
        assertEquals(responseEntity.getBody().getPriceList(), 1);
        assertEquals(responseEntity.getBody().getProductId(), 35455);
        assertEquals(responseEntity.getBody().getBrandId(), 1);

    }

    @Test
    public void shouldReturnAnOutputPricesFor151000DateWith3455ProductIdAnd1BrandId(){

        ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(1,35455,"2020-06-15 10:00:00.0");
        assertEquals(responseEntity.getBody().getPrice(), 30.5);
        assertEquals(responseEntity.getBody().getStartDate().toString(), "2020-06-15 00:00:00.0");
        assertEquals(responseEntity.getBody().getEndDate().toString(), "2020-06-15 11:00:00.0");
        assertEquals(responseEntity.getBody().getPriceList(), 3);
        assertEquals(responseEntity.getBody().getProductId(), 35455);
        assertEquals(responseEntity.getBody().getBrandId(), 1);

    }

    @Test
    public void shouldReturnAnOutputPricesFor162100DateWith3455ProductIdAnd1BrandId(){

        ResponseEntity<Offer> responseEntity = pricesController.getOfferDetail(1,35455,"2020-06-16 21:00:00.0");
        assertEquals(responseEntity.getBody().getPrice(), 38.95);
        assertEquals(responseEntity.getBody().getStartDate().toString(), "2020-06-15 16:00:00.0");
        assertEquals(responseEntity.getBody().getEndDate().toString(), "2020-12-31 23:59:59.0");
        assertEquals(responseEntity.getBody().getPriceList(), 4);
        assertEquals(responseEntity.getBody().getProductId(), 35455);
        assertEquals(responseEntity.getBody().getBrandId(), 1);

    }



}

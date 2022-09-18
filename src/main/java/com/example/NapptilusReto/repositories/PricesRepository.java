package com.example.NapptilusReto.repositories;

import com.example.NapptilusReto.models.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    List<Prices> findByProductIdAndBrandId(Integer productId, Integer brandId);

}

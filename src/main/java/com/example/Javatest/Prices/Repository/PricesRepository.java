package com.example.Javatest.Prices.Repository;

import com.example.Javatest.Prices.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(int productId, int brandId, LocalDateTime givenDate1, LocalDateTime givenDate2);

    List<Price> findByPriceList(int priceList);
}

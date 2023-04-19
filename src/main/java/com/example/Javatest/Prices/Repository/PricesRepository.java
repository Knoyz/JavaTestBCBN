package com.example.Javatest.Prices.Repository;

import com.example.Javatest.Prices.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

    /*
    el nombre es intencionalmente asi para demostrar que se pueden realizar de ambas maneras,
    en caso de que la consulta se complique mucho es mejor utilizar consultas nativas como es el caso,
    pero en caso de necesitar unas consultas sencillas se puede utilizar las DrivedQuerys que brinda la libreria JPA
     */

    @Query(value = "Select * From Price Where Product_ID = :productId and Brand_ID = :brandId and Start_Date <= :givenDate and End_Date > :givenDate Order by Priority desc", nativeQuery = true)
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanAndEndDateGreaterThanOrderByPriorityDesc(@Param("productId") int productId, @Param("brandId") int brandId, @Param("givenDate") LocalDateTime givenDate);

    List<Price> findByPriceList(int priceList);
}

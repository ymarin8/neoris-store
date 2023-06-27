package com.yoanmarin.neorisstore.repository;

import com.yoanmarin.neorisstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value="SELECT * \n" +
            "FROM PRODUCT \n" +
            "WHERE BRAND_ID = ?1\n" +
            "AND PRODUCT_ID = ?2\n" +
            "AND  ?3 BETWEEN START_DATE AND END_DATE\n"+
            "ORDER BY PRIORITY LIMIT 1", nativeQuery = true)
    Product productsByDate(Integer idBrand, Integer idProduct, Date queryDate);
}

package com.yoanmarin.neorisstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yoanmarin.neorisstore.config.IsoCurrency;
import com.yoanmarin.neorisstore.model.DTO.BrandDTO;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;
import com.yoanmarin.neorisstore.utils.Mapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.Currency;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="PRODUCT_ID")
    private Integer idProduct;
    @Column(name="START_DATE")
    private Date startDate;
    @Column(name="END_DATE")
    private Date finalDate;
    @Column(name="PRICE_LIST")
    private Double priceList;
    @Column(name="PRIORITY")
    private Integer priority;
    @Column(name="FINAL_PRICE")
    private Double appliedPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="BRAND_ID")
    private Brand brand;

    private final String ISO_CURRENCY = IsoCurrency.EUR.getIsoCurrencyType();

    public Product(ProductDTO productDTO){
        new Mapper().mapObject(productDTO, Product.class);
    }
}

package com.yoanmarin.neorisstore.model.DTO;

import com.yoanmarin.neorisstore.model.Brand;
import com.yoanmarin.neorisstore.model.Product;
import com.yoanmarin.neorisstore.utils.Mapper;
import lombok.*;

import java.util.Currency;
import java.util.Date;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer id;
    private Integer idProduct;
    private Date startDate;
    private Date finalDate;
    private Double priceList;
    private Integer priority;
    private Double appliedPrice;
    private BrandDTO brand;

    public ProductDTO(Product product) {
        new Mapper().mapObject(product, ProductDTO.class);
    }
}

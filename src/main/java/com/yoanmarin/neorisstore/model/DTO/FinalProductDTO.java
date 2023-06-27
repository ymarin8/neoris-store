package com.yoanmarin.neorisstore.model.DTO;

import com.yoanmarin.neorisstore.model.Product;
import lombok.*;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinalProductDTO {
    private Integer idProduct;
    private BrandDTO brand;
    private Double priceList;
    private Double appliedPrice;
    private Date startDate;
    private Date finalDate;

    public FinalProductDTO(Product product){
        this.idProduct = product.getIdProduct();
        this.brand = new BrandDTO(product.getBrand());
        this.priceList = product.getPriceList();
        this.appliedPrice = product.getAppliedPrice();
        this.startDate = product.getStartDate();
        this.finalDate = product.getFinalDate();
    }
}

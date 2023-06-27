package com.yoanmarin.neorisstore.model.DTO;

import com.yoanmarin.neorisstore.model.Brand;
import com.yoanmarin.neorisstore.utils.Mapper;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandDTO {
    private Integer idBrand;
    private String name;

    public BrandDTO(Brand brand){
        new Mapper().mapObject(brand, BrandDTO.class);
    }
}

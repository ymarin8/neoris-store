package com.yoanmarin.neorisstore.model;

import com.yoanmarin.neorisstore.model.DTO.BrandDTO;
import com.yoanmarin.neorisstore.utils.Mapper;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLInsert;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="BRAND")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BRAND_ID")
    private Integer idBrand;
    @Column(name="BRAND_NAME")
    private String name;

    public Brand(BrandDTO brandDTO){
        new Mapper().mapObject(brandDTO,Brand.class);
    }
}

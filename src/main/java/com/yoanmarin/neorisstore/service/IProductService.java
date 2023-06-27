package com.yoanmarin.neorisstore.service;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;

import java.util.Date;
import java.util.List;

public interface IProductService {
    ServiceResponse<List<ProductDTO>> findAll();
    ServiceResponse<ProductDTO> save(ProductDTO productDTO);
    ServiceResponse<List<ProductDTO>> saveAll(List<ProductDTO> productDTOList);
    ServiceResponse<ProductDTO> productsByDate(Integer idBrand, Integer idProduct, Date queryDate);
}

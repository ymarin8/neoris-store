package com.yoanmarin.neorisstore.service;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.DTO.BrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBrandService {
    ServiceResponse<List<BrandDTO>> findAll();
}

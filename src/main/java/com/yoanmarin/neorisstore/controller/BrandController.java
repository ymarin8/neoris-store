package com.yoanmarin.neorisstore.controller;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.DTO.BrandDTO;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;
import com.yoanmarin.neorisstore.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/neoris/brands", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class BrandController {
    private static final String GEN_ERR_MSG = "Request failed. [CONTROLLER ERROR]: ";
    @Autowired
    private IBrandService brandService;
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<List<BrandDTO>>> getAllBrands(){
        ServiceResponse<List<BrandDTO>> serviceResponse = new ServiceResponse<>();
        try {
            return ResponseEntity.ok().body(brandService.findAll());
        }catch(Exception e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
            return ResponseEntity.internalServerError().body(serviceResponse);
        }
    }
}

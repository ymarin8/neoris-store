package com.yoanmarin.neorisstore.controller;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;
import com.yoanmarin.neorisstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/neoris/products", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ProductController {

    private static final String GEN_ERR_MSG = "Request failed. [CONTROLLER ERROR]: ";
    @Autowired
    private IProductService productService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<List<ProductDTO>>> getAllProducts(){
        ServiceResponse<List<ProductDTO>> serviceResponse = new ServiceResponse<>();
        try {
            return ResponseEntity.ok().body(productService.findAll());
        }catch(Exception e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
            return ResponseEntity.internalServerError().body(serviceResponse);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<ProductDTO>> saveProduct(@RequestBody ProductDTO productDTO){
        ServiceResponse<ProductDTO> serviceResponse = new ServiceResponse<>();
        try {
            return ResponseEntity.ok().body(productService.save(productDTO));
        }catch (Exception e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
            return ResponseEntity.internalServerError().body(serviceResponse);
        }
    }

    @PostMapping(path = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<List<ProductDTO>>> saveAllProducts(@RequestBody List<ProductDTO> productDTOList){
        ServiceResponse<List<ProductDTO>> serviceResponse = new ServiceResponse<>();
        try {
            return ResponseEntity.ok().body(productService.saveAll(productDTOList));
        }catch (Exception e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
            return ResponseEntity.internalServerError().body(serviceResponse);
        }
    }

    @GetMapping(path="/date", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<ProductDTO>> getProductosByDate(@RequestHeader Integer idBrand,
                                                                          @RequestHeader Integer idProduct,
                                                                          @RequestHeader @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date queryDate){
        ServiceResponse<ProductDTO> serviceResponse = new ServiceResponse<>();
        try {
            return ResponseEntity.ok().body(productService.productsByDate(idBrand, idProduct, queryDate));
        }catch(Exception e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
            return ResponseEntity.internalServerError().body(serviceResponse);
        }
    }
}

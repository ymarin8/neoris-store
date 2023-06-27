package com.yoanmarin.neorisstore.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;
import com.yoanmarin.neorisstore.model.Product;
import com.yoanmarin.neorisstore.repository.IProductRepository;
import com.yoanmarin.neorisstore.service.IProductService;
import com.yoanmarin.neorisstore.utils.Mapper;
import org.hibernate.exception.DataException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImp implements IProductService {
    private static final String GEN_ERR_MSG = "Request failed. [SERVICE ERROR]: ";
    @Autowired
    private IProductRepository productRepository;
    @Override
    public ServiceResponse<List<ProductDTO>> findAll() {
        ServiceResponse<List<ProductDTO>> serviceResponse = new ServiceResponse<>();
        try{
            Iterable<Product> allProducts = this.productRepository.findAll();
            List<ProductDTO> resultSet = StreamSupport.stream(allProducts.spliterator(), false)
                    .map(ProductDTO::new)
                    .collect(Collectors.toList());
            if(!resultSet.isEmpty()){
                serviceResponse.setError(false);
                serviceResponse.setMessage("Request successful");
                serviceResponse.setResponse(resultSet);
            }
        }catch (DataException e){
            serviceResponse.setError(true);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
        }
        return serviceResponse;
    }

    @Override
    public ServiceResponse<ProductDTO> save(ProductDTO productDTO) {
        ServiceResponse<ProductDTO> serviceResponseSaved = new ServiceResponse<>();
        try{
            Product productSaved = this.productRepository.save(new Product(productDTO));
            serviceResponseSaved.setError(false);
            serviceResponseSaved.setMessage("Product saved successfully");
            serviceResponseSaved.setResponse(new ProductDTO(productSaved));
        }catch(DataException e){
            serviceResponseSaved.setError(false);
            serviceResponseSaved.setMessage(GEN_ERR_MSG + e.getMessage());
        }
        return serviceResponseSaved;
    }

    @Override
    public ServiceResponse<List<ProductDTO>> saveAll(List<ProductDTO> productDTOList) {
        ServiceResponse<List<ProductDTO>> serviceResponseSaved = new ServiceResponse<>();
        try{
            List<Product> productList = this.productRepository.saveAll(new Mapper().mapList(productDTOList, Product.class));
            serviceResponseSaved.setError(false);
            serviceResponseSaved.setMessage("List of products saved successfully");
            serviceResponseSaved.setResponse(new Mapper().mapList(productList, ProductDTO.class));
        }catch(DataException e){
            serviceResponseSaved.setError(false);
            serviceResponseSaved.setMessage(GEN_ERR_MSG + e.getMessage());
        }
        return serviceResponseSaved;
    }

    @Override
    public ServiceResponse<ProductDTO> productsByDate(Integer idBrand, Integer idProduct, Date queryDate) {
        ServiceResponse<ProductDTO> serviceResponse = new ServiceResponse<>();
        try{
            Product product = this.productRepository.productsByDate(idBrand, idProduct, queryDate);
            serviceResponse.setError(false);
            serviceResponse.setMessage("List of products retrieved successfully");
            serviceResponse.setResponse(new Mapper().mapObject(product, ProductDTO.class));
        }catch(DataException e){
            serviceResponse.setError(false);
            serviceResponse.setMessage(GEN_ERR_MSG + e.getMessage());
        }
        return serviceResponse;
    }
}

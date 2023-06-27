package com.yoanmarin.neorisstore.services;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.Brand;
import com.yoanmarin.neorisstore.model.DTO.ProductDTO;
import com.yoanmarin.neorisstore.model.Product;
import com.yoanmarin.neorisstore.repository.IProductRepository;
import com.yoanmarin.neorisstore.service.imp.ProductServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.internal.util.Assert;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImpTest {
    @Mock
    private IProductRepository productRepository;
    @InjectMocks
    private ProductServiceImp productServiceImp;
    private Integer idProduct;
    private Integer idBrand;
    private String queryDateString;
    private String endDateString;
    private Date queryDate;
    private Date endDate;
    private Product product;
    private Brand brand;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before
    public void before() {
        idProduct = 35455;
        idBrand = 1;
        try {
            endDateString = "2020-12-31 23:59:59";
            endDate = dateFormat.parse(endDateString);
            brand = new Brand(1,"Zara");
            product = new Product(1,35455,queryDate,endDate,35.5,0,40.5,brand);
        } catch (Exception e) {}
    }

    @Test
    public void getProductWhenDayIs14AndHourIs10(){
        try {
            queryDateString = "2020-06-14 10:00:00";
            queryDate = dateFormat.parse(queryDateString);
        }catch (Exception e){}
        Mockito.doReturn(product).when(productRepository).productsByDate(idBrand,idProduct,queryDate);
        ServiceResponse<ProductDTO> response = productServiceImp.productsByDate(idBrand, idProduct, queryDate);
        Assert.notNull(response.getResponse());
        assertFalse(response.isError());
    }

    @Test
    public void getProductWhenDayIs14AndHourIs16(){
        try {
            queryDateString = "2020-06-14 16:00:00";
            queryDate = dateFormat.parse(queryDateString);
        }catch (Exception e){}
        Mockito.doReturn(product).when(productRepository).productsByDate(idBrand,idProduct,queryDate);
        ServiceResponse<ProductDTO> response = productServiceImp.productsByDate(idBrand, idProduct, queryDate);
        Assert.notNull(response.getResponse());
        assertFalse(response.isError());
    }

    @Test
    public void getProductWhenDayIs14AndHourIs21(){
        try {
            queryDateString = "2020-06-14 21:00:00";
            queryDate = dateFormat.parse(queryDateString);
        }catch (Exception e){}
        Mockito.doReturn(product).when(productRepository).productsByDate(idBrand,idProduct,queryDate);
        ServiceResponse<ProductDTO> response = productServiceImp.productsByDate(idBrand, idProduct, queryDate);
        Assert.notNull(response.getResponse());
        assertFalse(response.isError());
    }

    @Test
    public void getProductWhenDayIs15AndHourIs10(){
        try {
            queryDateString = "2020-06-15 10:00:00";
            queryDate = dateFormat.parse(queryDateString);
        }catch (Exception e){}
        Mockito.doReturn(product).when(productRepository).productsByDate(idBrand,idProduct,queryDate);
        ServiceResponse<ProductDTO> response = productServiceImp.productsByDate(idBrand, idProduct, queryDate);
        Assert.notNull(response.getResponse());
        assertFalse(response.isError());
    }

    @Test
    public void getProductWhenDayIs16AndHourIs21(){
        try {
            queryDateString = "2020-06-15 10:00:00";
            queryDate = dateFormat.parse(queryDateString);
        }catch (Exception e){}
        Mockito.doReturn(product).when(productRepository).productsByDate(idBrand,idProduct,queryDate);
        ServiceResponse<ProductDTO> response = productServiceImp.productsByDate(idBrand, idProduct, queryDate);
        Assert.notNull(response.getResponse());
        assertFalse(response.isError());
    }
}

package com.yoanmarin.neorisstore.service.imp;

import com.yoanmarin.neorisstore.config.ServiceResponse;
import com.yoanmarin.neorisstore.model.Brand;
import com.yoanmarin.neorisstore.model.DTO.BrandDTO;
import com.yoanmarin.neorisstore.repository.IBrandRepository;
import com.yoanmarin.neorisstore.service.IBrandService;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BrandServiceImp implements IBrandService {
    private static final String GEN_ERR_MSG = "Request failed. [SERVICE ERROR]: ";
    @Autowired
    private IBrandRepository brandRepository;

    @Override
    public ServiceResponse<List<BrandDTO>> findAll() {
        ServiceResponse<List<BrandDTO>> serviceResponse = new ServiceResponse<>();
        try{
            Iterable<Brand> allBrands = this.brandRepository.findAll();
            List<BrandDTO> resultSet = StreamSupport.stream(allBrands.spliterator(), false)
                    .map(BrandDTO::new)
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
}

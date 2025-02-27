package com.microservices.cloud.student_service.service;

import com.microservices.cloud.student_service.feignClients.AddressFeignClient;
import com.microservices.cloud.student_service.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    AddressFeignClient addressFeignClient;

    Logger logger= LoggerFactory.getLogger(CommonService.class);
    long count=1;

    @CircuitBreaker(name="addressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById(Long addressId) {
        logger.info("Count = "+ count);
        count++;

        AddressResponse addressResponse=addressFeignClient.getAddressById(addressId);
        return addressResponse;
    }

    public AddressResponse fallbackGetAddressById(Long addressId,Throwable th) {
        logger.info("Error = "+th);
        return new AddressResponse();
    }
}

package com.microservices.cloud.student_service.feignClients;

import com.microservices.cloud.student_service.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="${address.service.url}", value="address-feign-client") #without Eureka
@FeignClient( name="api-gateway")
public interface AddressFeignClient {

    @GetMapping("/address-service/api/address/getById/{id}")
    public AddressResponse getAddressById(@PathVariable Long id);
}

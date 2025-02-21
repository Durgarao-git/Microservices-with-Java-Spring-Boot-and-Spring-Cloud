package com.microservices.cloud.address_service.controller;

import com.microservices.cloud.address_service.request.CreateAddressRequest;
import com.microservices.cloud.address_service.response.AddressResponse;
import com.microservices.cloud.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<AddressResponse> createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        return new ResponseEntity<>(addressService.createAddress(createAddressRequest), HttpStatus.CREATED);
    };

    @GetMapping("/getById/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id){
        return new ResponseEntity<>(addressService.getAddressById(id),HttpStatus.OK);
    }


}

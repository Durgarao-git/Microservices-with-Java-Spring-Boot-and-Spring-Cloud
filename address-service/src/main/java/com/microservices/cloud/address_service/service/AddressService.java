package com.microservices.cloud.address_service.service;


import com.microservices.cloud.address_service.entity.Address;
import com.microservices.cloud.address_service.repository.AddressRepository;
import com.microservices.cloud.address_service.request.CreateAddressRequest;
import com.microservices.cloud.address_service.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Logger logger= LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

        Address address=modelMapper.map(createAddressRequest,Address.class);
        Address savedAddress=addressRepository.save(address);
        return (modelMapper.map(savedAddress, AddressResponse.class));
    }

    public AddressResponse getAddressById(Long id) {

        logger.info("Inside getById "+ id);
        Address address=addressRepository.findById(id).get();
        return (modelMapper.map(address, AddressResponse.class));


    }
}

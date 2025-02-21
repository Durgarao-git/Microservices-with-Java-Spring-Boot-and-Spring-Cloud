package com.microservices.cloud.address_service.response;

public class AddressResponse {

    private Long addressId;
    private String  street;
    private String city;

    public AddressResponse(Long addressId, String street, String city) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
    }

    public AddressResponse() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressResponse{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


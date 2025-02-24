package com.microservices.cloud.student_service.response;

public class StudentResponse {

    private String firstName;

    private String lastName;

    private String email;

    private AddressResponse addressResponse;

    public StudentResponse(String firstName, String lastName, String email, AddressResponse addressResponse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressResponse = addressResponse;
    }

    public StudentResponse() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }
}

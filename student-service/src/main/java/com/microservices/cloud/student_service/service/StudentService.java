package com.microservices.cloud.student_service.service;

import com.microservices.cloud.student_service.entity.Student;
import com.microservices.cloud.student_service.feignClients.AddressFeignClient;
import com.microservices.cloud.student_service.repository.StudentRepository;
import com.microservices.cloud.student_service.request.CreateStudentRequest;
import com.microservices.cloud.student_service.response.AddressResponse;
import com.microservices.cloud.student_service.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFeignClient addressFeignClient;


	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student=modelMapper.map(createStudentRequest,Student.class);
		Student savedStudent = studentRepository.save(student);

		StudentResponse studentResponse=modelMapper.map(savedStudent,StudentResponse.class);
		studentResponse.setAddressResponse(getAddressById(savedStudent.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student=studentRepository.findById(id).get();
		StudentResponse studentResponse=modelMapper.map(student,StudentResponse.class);

//		Using WebClient
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		//Using Open Feign
		studentResponse.setAddressResponse(addressFeignClient.getAddressById(student.getAddressId()));

		return  studentResponse;
	}

	public AddressResponse getAddressById(Long addressId){
		Mono<AddressResponse> addressResponseMono=webClient.get().uri("/getById/"+addressId).retrieve()
				.bodyToMono(AddressResponse.class);

		return addressResponseMono.block();
	}

}

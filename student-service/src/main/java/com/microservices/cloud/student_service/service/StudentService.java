package com.microservices.cloud.student_service.service;

import com.microservices.cloud.student_service.entity.Student;
import com.microservices.cloud.student_service.repository.StudentRepository;
import com.microservices.cloud.student_service.request.CreateStudentRequest;
import com.microservices.cloud.student_service.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;
	


	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student=modelMapper.map(createStudentRequest,Student.class);
		Student savedStudent = studentRepository.save(student);

		return modelMapper.map(savedStudent,StudentResponse.class);
	}
	
	public StudentResponse getById (long id) {
		Student student=studentRepository.findById(id).get();
		return modelMapper.map(student,StudentResponse.class);
	}
}

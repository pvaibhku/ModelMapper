package com.example.ModelMapper.svc.impl;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ModelMapper.Repository.MyModelMapperRepository;
import com.example.ModelMapper.dto.StudentDto;
import com.example.ModelMapper.dto.StudentRequestDto;
import com.example.ModelMapper.entity.Student;

@Service
public class MyModelMapperServiceImpl {

	@Autowired
	MyModelMapperRepository modelMapperRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StudentDto createStudent(StudentRequestDto studentRequestDto) {
		var studentResponseDto = new StudentDto();
		List<Object> myList = List.of(List.of(List.of("hghj","ygyuguy","ufgughjhjv")));
		
		try {
		var model = modelMapperRepository.getById(studentRequestDto.getId());
		
		if(model != null) {
			throw new ValidationException("STUDENT ALREADY PRESENT WITH ID");
		}
		
		var studentData = modelMapper.map(studentRequestDto, Student.class);
		modelMapperRepository.save(studentData);
		studentResponseDto = modelMapper.map(studentRequestDto, StudentDto.class);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return studentResponseDto;
	}

}

package com.example.ModelMapper.svc.impl;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ModelMapper.Repository.MyModelMapperRepository;
import com.example.ModelMapper.dto.StudentDto;
import com.example.ModelMapper.dto.StudentRequestDto;
import com.example.ModelMapper.entity.Student;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ModelMapperImplTest {
	
	@InjectMocks
	private MyModelMapperServiceImpl modelMapperServiceImpl;
	
	@Mock
	private MyModelMapperRepository myModelMapperRepository;
	
	@Autowired
	@Spy
	ModelMapper modelMapper = new ModelMapper();
	
	private StudentDto studentdto1;
	private StudentDto studentdto2;
	private StudentDto studentdto3;
	private StudentDto studentDto4;
	
	private Student student1;
	private Student student2;
	private Student student3;
	
	private StudentRequestDto studentRequestDto1;
	private StudentRequestDto studentRequestDto2;
	private StudentRequestDto studentRequestDto3;
	
	@Test
	public void createStudentTest() {
		List<List<List<String>>> myString = new ArrayList<>();
		
		List<String> myLust1 =  new ArrayList<>();
		myLust1.add("jhkgcxhjds");
		
		List<Object> myList2 = new ArrayList<>();
		myList2.add(myLust1);
		
	
		studentdto1 = new StudentDto(1L, "Sundriges", "India", 20);
		studentdto2 = new StudentDto(2L, "LG", "India", 22);
		studentdto3 = new StudentDto(3L, "CEAT", "India",30);
		
		student1 = new Student(1L, "Sundriges", "India", 20);
		student2 = new Student(2L, "LG", "India", 22);
		student3 = new Student(3L, "CEAT", "India",30);
		
		studentRequestDto1 = new StudentRequestDto(1L, "Sundriges", "India", 20);
		studentRequestDto2 = new StudentRequestDto(2L, "LG", "India", 22);
		studentRequestDto3 = new StudentRequestDto(3L, "CEAT", "India",30);
		try {
		Mockito.when(myModelMapperRepository.getById(1L)).thenReturn(null);
		//student1 = modelMapper.map(studentRequestDto1, Student.class);
		studentDto4 = modelMapperServiceImpl.createStudent(studentRequestDto1);
		Assert.assertEquals(studentDto4, studentRequestDto1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}

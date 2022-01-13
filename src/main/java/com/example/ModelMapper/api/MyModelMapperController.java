package com.example.ModelMapper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.ModelMapper.dto.StudentRequestDto;
import com.example.ModelMapper.svc.impl.MyModelMapperServiceImpl;

@RestController
@Validated
public class MyModelMapperController {
	
	@Autowired
	MyModelMapperServiceImpl modelMapperServiceImpl;
	
	@PostMapping("api/create")
	public ResponseEntity<Object> createStudent(@RequestBody StudentRequestDto studentRequestDto){
		return ResponseEntity.ok(modelMapperServiceImpl.createStudent(studentRequestDto));
	}

}

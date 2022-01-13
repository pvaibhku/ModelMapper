package com.example.ModelMapper.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ModelMapper.entity.Student;

@Repository
public interface MyModelMapperRepository extends JpaRepository<Student, Long>{

}

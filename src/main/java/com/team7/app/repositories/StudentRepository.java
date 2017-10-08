package com.team7.app.repositories;

import com.team7.app.business.dto.StudentDto;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentDto, Integer>{
}

package com.team7.app.repositories;

import com.team7.app.business.dto.StudentDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the StudentDto.
 */
public interface StudentRepository extends CrudRepository<StudentDto, Integer> {
}

package com.team7.app.repositories;

import com.team7.app.business.dto.CourseDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the CourseDto.
 */
public interface CourseRepository extends CrudRepository<CourseDto, Integer> {
}

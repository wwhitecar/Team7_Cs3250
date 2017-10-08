package com.team7.app.repositories;

import com.team7.app.business.dto.CourseDto;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepositorie extends CrudRepository<CourseDto, Integer> {
}

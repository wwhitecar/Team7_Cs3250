package com.team7.app.repositories;

import com.team7.app.business.dto.GlobalDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the CourseDto.
 */
public interface GlobalRepository extends CrudRepository<GlobalDto, String> {
}

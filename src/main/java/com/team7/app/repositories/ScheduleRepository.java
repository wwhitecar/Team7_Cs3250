package com.team7.app.repositories;

import com.team7.app.business.dto.ScheduleDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the CourseDto.
 */
public interface ScheduleRepository extends
        CrudRepository<ScheduleDto, Integer> {
}

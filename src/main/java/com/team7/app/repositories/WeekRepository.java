package com.team7.app.repositories;

import com.team7.app.business.dto.WeekDto;
import org.springframework.data.repository.CrudRepository;


/**
 * Inherits our crud operations to be used by the SemesterDto.
 */
public interface WeekRepository extends CrudRepository<WeekDto, Integer> {
}

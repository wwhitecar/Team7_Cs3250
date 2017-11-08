package com.team7.app.repositories;

import com.team7.app.business.dto.SemesterDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the SemesterDto.
 */
public interface SemesterRepository
        extends CrudRepository<SemesterDto, Integer> {
}

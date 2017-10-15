package com.team7.app.repositories;

import com.team7.app.business.dto.ProfessorDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the ProfessorDto.
 */
public interface ProfessorRepository extends CrudRepository<ProfessorDto, Integer>{
}

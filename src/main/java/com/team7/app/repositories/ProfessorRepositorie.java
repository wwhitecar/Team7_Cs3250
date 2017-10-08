package com.team7.app.repositories;

import com.team7.app.business.dto.ProfessorDto;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepositorie extends CrudRepository<ProfessorDto, Integer>{
}

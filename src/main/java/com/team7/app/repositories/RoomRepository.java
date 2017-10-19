package com.team7.app.repositories;

import com.team7.app.business.dto.RoomDto;
import org.springframework.data.repository.CrudRepository;

/**
 * Inherits our crud operations to be used by the ProfessorDto.
 */
public interface RoomRepository extends CrudRepository<RoomDto, Integer>{
}


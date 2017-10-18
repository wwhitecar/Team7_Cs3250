package com.team7.app.repositories;

import com.team7.app.business.dto.GlobalDto;
import org.springframework.data.repository.CrudRepository;

public interface GlobalRepository extends CrudRepository<GlobalDto, String> {
}

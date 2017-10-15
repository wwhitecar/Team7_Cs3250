package com.team7.app.repositories;

import com.team7.app.business.dto.SectionDto;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository extends CrudRepository<SectionDto, Integer> {
}

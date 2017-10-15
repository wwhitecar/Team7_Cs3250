package com.team7.app.services;

import com.team7.app.business.dto.SectionDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface SectionServices {

    Iterable<SectionDto> listAllSection();

    SectionDto getSectionById(Integer id);

    SectionDto saveSection(SectionDto product);

    void deleteSection(Integer id);
}
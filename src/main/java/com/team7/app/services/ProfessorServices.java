package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface ProfessorServices {
    Iterable<ProfessorDto> listAllProfessor();

    ProfessorDto getProfessorById(Integer id);

    ProfessorDto saveProfessor(ProfessorDto product);

    void deleteProfessor(Integer id);
}

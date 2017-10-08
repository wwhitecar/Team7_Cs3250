package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;

public interface ProfessorServices {
    Iterable<ProfessorDto> listAllProfessor();

    ProfessorDto getProfessorById(Integer id);

    ProfessorDto saveProfessor(ProfessorDto product);

    void deleteProfessor(Integer id);
}

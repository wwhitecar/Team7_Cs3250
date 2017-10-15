package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class ProfessorServicesImpl implements ProfessorServices {
    private ProfessorRepository professorRepository;

    @Autowired
    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Iterable<ProfessorDto> listAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public ProfessorDto getProfessorById(Integer id) {
        return professorRepository.findOne(id);
    }

    @Override
    public ProfessorDto saveProfessor(ProfessorDto professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(Integer id) {
        professorRepository.delete(id);
    }
}
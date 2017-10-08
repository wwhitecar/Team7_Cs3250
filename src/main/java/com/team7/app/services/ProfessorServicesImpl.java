package com.team7.app.services;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.repositories.ProfessorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServicesImpl implements ProfessorServices {
    private ProfessorRepositorie professorRepository;

    @Autowired
    public void setProfessorRepository(ProfessorRepositorie professorRepository) {
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
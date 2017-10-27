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

    /**
     * Professor repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Setter for professor Repo for testing purposes.
     * @param profRepo - mock to be used
     */
    public void setProfessorRepository(final ProfessorRepository profRepo) {
        this.professorRepository = profRepo;
    }

    /**
     * Creates a list of all professors that are currently in the
     * database.
     * @return list of all professors in the database
     */
    @Override
    public Iterable<ProfessorDto> listAllProfessor() {
        return professorRepository.findAll();
    }

    /**
     * Finds a professors that resides in the database.
     * @param id - id number for the professors we are looking for.
     * @return the professors that we are looking for
     */
    @Override
    public ProfessorDto getProfessorById(final Integer id) {
        return professorRepository.findOne(id);
    }

    /**
     * Adds a professor to the database.
     * @param professor to be added.
     * @return the course that was added to the database.
     */
    @Override
    public ProfessorDto saveProfessor(final ProfessorDto professor) {
        return professorRepository.save(professor);
    }

    /**
     * Delete a professor that is in the database.
     * @param id of the professor to be removed
     */
    @Override
    public void deleteProfessor(final Integer id) {
        professorRepository.delete(id);
    }
}

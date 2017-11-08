package com.team7.app.services;

import com.team7.app.business.dto.SemesterDto;
import com.team7.app.repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
@Service
public class SemesterServicesImpl implements SemesterServices {

    /**
     * Student repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private SemesterRepository semesterRepository;

    /**
     * Setter for SemesterRepo, for testing purposes only.
     * @param semesterRepo - service to be used
     */
    public void setSemesterRepository(final SemesterRepository semesterRepo) {
        this.semesterRepository = semesterRepo;
    }

    /**
     * Creates a list of all semesters that are currently in the
     * database.
     * @return list of all semesters in the database
     */
    @Override
    public Iterable<SemesterDto> listAllSemesters() {
        return semesterRepository.findAll();
    }

    /**
     * Finds a semester that resides in the database.
     * @param id - id number for the semester we are looking for.
     * @return the semester that we are looking for
     */
    @Override
    public SemesterDto getSemesterById(final Integer id) {
        return semesterRepository.findOne(id);
    }

    /**
     * Adds a semester to the database.
     * @param semester - to be added.
     * @return the semester that was added to the database.
     */
    @Override
    public SemesterDto saveSemester(final SemesterDto semester) {
        return semesterRepository.save(semester);
    }

    /**
     * Delete a semester that is in the database.
     * @param id - semester id to be removed
     */
    @Override
    public void deleteSemesterById(final Integer id) {
        semesterRepository.delete(id);
    }
}

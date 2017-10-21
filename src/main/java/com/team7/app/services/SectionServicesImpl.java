package com.team7.app.services;

import com.team7.app.business.dto.SectionDto;
import com.team7.app.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class SectionServicesImpl implements SectionServices {

    /**
     * Section repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Setter for SectionService, for testing purposes only.
     * @param sectionRepo - service to be used
     */
    public void setSectionRepository(final SectionRepository sectionRepo) {
        this.sectionRepository = sectionRepo;
    }


    /**
     * Creates a list of all sections that are currently in the
     * database.
     * @return list of all sections in the database
     */
    @Override
    public Iterable<SectionDto> listAllSection() {
        return sectionRepository.findAll();
    }

    /**
     * Finds a section that resides in the database.
     * @param id - id number for the section we are looking for.
     * @return the section that we are looking for
     */
    @Override
    public SectionDto getSectionById(final Integer id) {
        return sectionRepository.findOne(id);
    }

    /**
     * Adds a section to the database.
     * @param section to be added.
     * @return the section that was added to the database.
     */
    @Override
    public SectionDto saveSection(final SectionDto section) {
        return sectionRepository.save(section);
    }

    /**
     * Delete a section that is in the database.
     * @param id of the section to be removed
     */
    @Override
    public void deleteSection(final Integer id) {
        sectionRepository.delete(id);
    }
}

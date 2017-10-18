package com.team7.app.services;

import com.team7.app.business.dto.GlobalDto;
import com.team7.app.repositories.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class GlobalServicesImpl implements GlobalServices {


    /**
     * Global repository to allow us to be able to communicate
     * with the database without jbdc implementation.
     */
    private GlobalRepository globalRepository;


    /**
     * Autowired so spring can make a bean and use it.
     * @param gRepository - repo to be used by spring
     */
    @Autowired
    public void setGlobalRepository(final GlobalRepository gRepository) {
        this.globalRepository = gRepository;
    }

    /**
     * Creates a list of all globals that are currently in the database.
     * @return list of all globals in the database
     */
    @Override
    public Iterable<GlobalDto> listAllGlobals() {
        return globalRepository.findAll();
    }

    /**
     * Finds a global that resides in the database.
     * @param name - name of the school we are looking for
     * @return the school we are looking for
     */
    @Override
    public GlobalDto getGlobalByName(final String name) {
        return globalRepository.findOne(name);
    }


    /**
     * adds a global to the database.
     * @param global to be added
     * @return the global that was added to the database.
     */
    @Override
    public GlobalDto saveGlobal(final GlobalDto global) {
        return globalRepository.save(global);
    }

    /**
     * Delete a global that is in the database.
     * @param name of the course
     */
    @Override
    public void deleteGlobal(final String name) {
        globalRepository.delete(name);
    }

}



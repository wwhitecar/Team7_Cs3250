package com.team7.app.services;

import com.team7.app.business.dto.StudentDto;
import com.team7.app.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to communicate to the database.
 * JDBC implementation.
 */
@Service
public class StudentServicesImpl implements StudentServices {

    /**
     * Student repository to allow us to be able to communicate
     * with the the database without jdbc implementation.
     */
    @Autowired
    protected StudentRepository studentRepository;

    /**
     * Creates a list of all students that are currently in the
     * database.
     * @return list of all students in the database
     */
    @Override
    public Iterable<StudentDto> listAllStudent() {
        return studentRepository.findAll();
    }

    /**
     * Finds a student that resides in the database.
     * @param id - id number for the student we are looking for.
     * @return the student that we are looking for
     */
    @Override
    public StudentDto getStudentById(final Integer id) {
        return studentRepository.findOne(id);
    }

    /**
     * Adds a professor to the database.
     * @param student to be added.
     * @return the student that was added to the database.
     */
    @Override
    public StudentDto saveStudent(final StudentDto student) {
        return studentRepository.save(student);
    }

    /**
     * Delete a student that is in the database.
     * @param id of the student to be removed
     */
    @Override
    public void deleteStudent(final Integer id) {
        studentRepository.delete(id);
    }
}

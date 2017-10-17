package com.team7.app.services;

import com.team7.app.business.dto.StudentDto;
/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface StudentServices {

    /**
     * Creates a list of all students that are currently in the
     * database.
     * @return list of all students in the database
     */
    Iterable<StudentDto> listAllStudent();

    /**
     * Finds a student that resides in the database.
     * @param id - id number for the student we are looking for.
     * @return the student that we are looking for
     */
    StudentDto getStudentById(Integer id);

    /**
     * Adds a professor to the database.
     * @param student to be added.
     * @return the student that was added to the database.
     */
    StudentDto saveStudent(StudentDto student);

    /**
     * Delete a student that is in the database.
     * @param id of the student to be removed
     */
    void deleteStudent(Integer id);
}

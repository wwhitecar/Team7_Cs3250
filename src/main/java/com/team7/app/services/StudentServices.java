package com.team7.app.services;

import com.team7.app.business.dto.StudentDto;
/**
 * Interface that will communicate with the database.
 * Basically our old JDBC templates.
 */
public interface StudentServices {

    Iterable<StudentDto> listAllStudent();

    StudentDto getStudentById(Integer id);

    StudentDto saveStudent(StudentDto product);

    void deleteStudent(Integer id);
}

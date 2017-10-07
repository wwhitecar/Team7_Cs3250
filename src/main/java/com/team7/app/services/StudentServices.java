package com.team7.app.services;

import com.team7.app.business.dto.StudentDto;

public interface StudentServices {

    Iterable<StudentDto> listAllStudent();

    StudentDto getStudentById(Integer id);

    StudentDto saveStudent(StudentDto product);

    void deleteStudent(Integer id);
}

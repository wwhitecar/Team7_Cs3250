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
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<StudentDto> listAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        return studentRepository.findOne(id);
    }

    @Override
    public StudentDto saveStudent(StudentDto student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }
}
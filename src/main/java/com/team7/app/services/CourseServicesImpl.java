package com.team7.app.services;

import com.team7.app.business.dto.CourseDto;
import com.team7.app.repositories.CourseRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServicesImpl implements CourseServices {
    private CourseRepositorie courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepositorie courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<CourseDto> listAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDto getCourseById(Integer id) {
        return courseRepository.findOne(id);
    }

    @Override
    public CourseDto saveCourse(CourseDto course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }
}
package com.team7.app.services;

import com.team7.app.business.dto.CourseDto;

public interface CourseServices {
    Iterable<CourseDto> listAllCourse();

    CourseDto getCourseById(Integer id);

    CourseDto saveCourse(CourseDto product);

    void deleteCourse(Integer id);
}

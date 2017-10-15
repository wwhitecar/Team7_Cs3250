package com.team7.app.business.dto;

import javax.persistence.*;

@Entity
public class BuildingDto {

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @Id
    private int buildingNumber;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @ManyToOne
    private CourseDto course;

    /**
     * The professor?
     */
    @ManyToOne
    private ProfessorDto professor;

    /**
     * Empty Constructer.
     */
    public BuildingDto() {

    }

    /**
     * Param constructer.
     * @param course - course to be tied to this building
     * @param professor - professor of the class/building
     */
    public BuildingDto( final int buildingNumber,
                       final CourseDto course,
                       final ProfessorDto professor) {
        this.buildingNumber = buildingNumber;
        this.course = course;
        this.professor = professor;
    }

    /**
     * Getter for coursenumber.
     * @return number for the course.
     */
    public int getBuildingNumber() {
        return buildingNumber;
    }


    /**
     * Getter for coursenumber.
     * @return number for the course.
     */
    public CourseDto getCourseNumber() {
        return course;
    }

    /**
     * Getter for the prof of the building.
     * @return the professor of the building.
     */
    public ProfessorDto getProfessor() {
        return professor;
    }

}
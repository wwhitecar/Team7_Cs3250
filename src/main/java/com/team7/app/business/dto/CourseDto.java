package com.team7.app.business.dto;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * CourseDto is a course that will be avalable for the students
 * to be offered.
 */
@Entity
public class CourseDto {

    /**
     * The department the course falls under.
     */
    private String department;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    @Id
    private int courseNumber;

    /**
     * The amount of credits the course is worth.
     */
    private int credits;

    /**
     * Description of the course.
     */
    private String description;

    /**
     * The learning goals of the course.
     */
    private String learningObjectives;

    /**
     * Prerequs for the course. Decided by class standing.
     */
    private int prereqs;

    /**
     * The coreqs for the course.
     */
    private int coreqs;
    /**
     * Empty Constructer.
     */
    public CourseDto() { }

    /**
     * Full param constructer.
     * @param depart - department of class
     * @param courseNum -coursenumber
     * @param credit - credits the course is worth
     * @param desctip - description of the course
     * @param learningObj - learning objctive of course
     * @param preReqs - prereqs for the course
     * @param coReqs - coreqs for the course
     */
    public CourseDto(final String depart, final int courseNum,
                     final int credit, final String desctip,
                     final String learningObj, final int preReqs,
                     final int coReqs) {
        this.department = depart;
        this.courseNumber = courseNum;
        this.credits = credit;
        this.description = desctip;
        this.learningObjectives = learningObj;
        this.prereqs = preReqs;
        this.coreqs = coReqs;
    }

    /**
     * Getter for Department.
     * @return department the course is in
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Getter for coursenumber.
     * @return number for the course
     */
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Getter for credits.
     * @return the amount of credits the course is worth.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Getter for the descriptoin of the course.
     * @return the description of the course.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the learningObjectives.
     * @return learningObjectives for the course
     */
    public String getLearningObjectives() {
        return learningObjectives;
    }

    /**
     * Getter for the prereqs of the course.
     * @return prereqs of the course
     */
    public int getPrereqs() {
        return prereqs;
    }

    /**
     * The coreqs requird for the course.
     * @return corequs for thee course
     */
    public int getCoreqs() {
        return coreqs;
    }

    /**
     * Overiding the tostring function.
     */
    @Override
    public String toString() {
        return ("Course Information: <br /> Dept: " + getDepartment()
                + "<br /> Course Number: " + getCourseNumber()
                + "<br /> Credits : " + getCredits()
                + "<br /> Description: " + getDescription()
                + "<br /> Learning Objective: " + getLearningObjectives()
                + "<br /> Prereqs: " + getPrereqs()
                + "<br />Coreqs: " + getCoreqs());
    }
}
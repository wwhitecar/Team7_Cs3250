package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

/**
 * A Semester will have a schedual and a name associated
 * with the semester. Will also have a auto generated value
 * within the database.
 */
@Entity
public class SemesterDto {

    /**
     * Primary Key for the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbKey;

    /**
     * Sections that will be for this Semester.
     */
    @OneToMany
    private List<SectionDto> sections;

    /**
     * Name of the semester, usually "Fall/Spring/Summer followed by year.
     */
    private String semesterName;

    /**
     * Generic Constructer.
     */
    public SemesterDto() { }

    /**
     * Constructor for Semester class.
     * @param name - schedule for this semester
     */
    public SemesterDto(final String name) {
        this.semesterName = name;
        this.sections = new ArrayList<>();
    }

    /**
     * Getter for schedule.
     * @return the schedule associated with this semester.
     * @throws NullPointerException if schedule is null
     */
    public String getSemesterName() {
        return this.semesterName;
    }

    /**
     * Setter for semester name.
     * @param newName - new name for the semester
     */
    public void setSemesterName(final String newName) {
        this.semesterName = newName;
    }

    /**
     * Getter for primary key.
     * @return the primary key for this semester in the database.
     */
    public int getDbKey() {
        return this.dbKey;
    }

    /**
     * Getter for the list of sections.
     * @return the list of sections in this semester.
     */
    public List<SectionDto> getSections() {
        return this.sections;
    }
}

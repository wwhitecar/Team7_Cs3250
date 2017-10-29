package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

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
     * Schedual that will be for this Semester.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private ScheduleDto schedule;

    /**
     * Constructor for Semester class.
     * @param semesterSchedual - schedule for this semester
     */
    public SemesterDto(final ScheduleDto semesterSchedual) {
        this.schedule = semesterSchedual;
    }

    /**
     * Getter for schedule.
     * @return the schedule associated with this semester.
     * @throws NullPointerException if schedule is null
     */
    public ScheduleDto getSchedule() throws NullPointerException {
        if (this.schedule == null) {
            throw new NullPointerException();
        }
        return this.schedule;
    }

    /**
     * Getter for primary key.
     * @return the primary key for this semester in the database.
     */
    public int getDbKey() {
        return this.dbKey;
    }
}

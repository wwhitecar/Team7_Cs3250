package com.team7.app.business.dto;

import javax.persistence.*;
import java.util.Map;

import static javax.swing.UIManager.put;

/**
 * Buildings that will be stored into the
 * database.
 */
@Entity
public class DayDto {

    /**
     * Id for the database that is auto generated
     * to assure no duplicates are created.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DayDbKey;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    private String dayName;

    /**
     * Map to hold hours and boolean availability
     * just the name.
     */
    @ElementCollection //from the persistence class
    private Map<Integer, Boolean> dayMap;

    /**
     * Week number that the day is in
     */
    private int week;

    /**
     *  A day has many weeks
     *  @return week the day is in
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "week_number", nullable = false)
    public int getWeekByNumber() {
        return week;
    }


    /**
     * Empty Constructer.
     */
    public DayDto() { }


    /**
     * Setting the initial map with hours in
     * military time.
     * boolean is availability of the time
     */
    public Map setDaysMap(final Map hours) {{
        hours.put(800, true);
        put(900, true);
        put(1000, true);
        put(1100, true);
        put(1200, true);
        put(1300, true);
        put(1400, true);
        put(1500, true);
        put(1600, true);
        put(1700, true);
        put(1800, true);
        put(1900, true);
        put(2000, true);
        return hours;
    }};

    /**
     * Param constructer.
     * @param dayOfTheWeek - building name
     */
    public DayDto(final String dayOfTheWeek) {
        this.dayName = dayOfTheWeek;
    }

    /**
     * Getter for buildingName.
     * @return name of the building.
     */
    public String getDayByName() {
        return dayName;
    }

    /**
     * Setter for buildingName.
     * @param dayOfTheWeek - the new building name
     */
    public void setDayName(final String dayOfTheWeek) {
        this.dayName = dayOfTheWeek;
    }

    /**
     * Getter for dBKey.
     * @return id of the building
     */
    public int getDayDbKey() {
        return DayDbKey;
    }

    /**
     * Getter for dBKey.
     * @return id of the building
     */
    public Map getDayMap() {return dayMap; }


}


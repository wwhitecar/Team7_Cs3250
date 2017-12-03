package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private int dayDbKey;

    /**
     * The course number to identify a course by more then
     * just the name.
     */
    private String dayName;

//    /**
//     * Map to hold hours and boolean availability
//     * just the name.
//     */
//    @ElementCollection //from the persistence class
//    private Map<Integer, Boolean> dayMap;

//    /**
//     * Empty Constructer.
//     */
//    public DayDto() {
//        this.dayMap = setDaysMap();
//    }


//    /**
//     * Setting the initial map with hours in
//     * military time.
//     * boolean is availability of the time
//     */
//    public Map setDaysMap() {
//        dayMap = new HashMap<Integer, Boolean>();
//        dayMap.put(800, true);
//        dayMap.put(900, true);
//        dayMap.put(1000, true);
//        dayMap.put(1100, true);
//        dayMap.put(1200, true);
//        dayMap.put(1300, true);
//        dayMap.put(1400, true);
//        dayMap.put(1500, true);
//        dayMap.put(1600, true);
//        dayMap.put(1700, true);
//        dayMap.put(1800, true);
//        dayMap.put(1900, true);
//        dayMap.put(2000, true);
//        return dayMap;
//    }

    /**
     * Param constructer.
     * @param dayOfTheWeek - building name
     */
    public DayDto(final String dayOfTheWeek) {

//        this.dayMap = setDaysMap();
        this.dayName = dayOfTheWeek;
    }

    /**
     * Getter for dayName.
     * @return name of the day.
     */
    public String getDayName() {
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
        return dayDbKey;
    }

//    /**
//     * Getter for dBKey.
//     * @return id of the building
//     */
//    public Map getDayMap() {
//        return dayMap; }

//    /**
//     * Change the value of the time to false.
//     */
//    public void toggleValue(final Integer time){
//        dayMap.replace(time, false);
//    }
}



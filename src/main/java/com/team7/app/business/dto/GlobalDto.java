package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class to store globals for the application.
 */
@Entity
public class GlobalDto {

    /**
     * Name of the School.
     */
    @Id
    private String schoolName;

    /**
     * Level by credit hours.
     */
    private int levelByCreditHour;

    /**
     * Empty Constructer.
     */
    public GlobalDto() {


    }

    public String toString(){
        return "global";
    }

    /**
     * Fully paramed constructer.
     * @param name - name of the school
     * @param hours - hours for school
     */
    public GlobalDto(final String name, final int hours) {

        this.levelByCreditHour = hours;
        this.schoolName = name;
    }

    /**
     * Getter for school name.
     * @return the name of the school
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Getter for levelbyhour.
     * @return level by credit hour
     */
    public int getLevelByHour() {
        return levelByCreditHour;
    }

    /**
     * Enum class to determine the level of the students.
     */
    public enum HoursPerLevel {

        /**
         * Global Enums.
         */
        Freshman(29), Sophomore(59), Junior(89), Senior(120);

        /**
         * Holds the number of hours.
         */
       private final int hours;


        /**
         * HoursePerLevel.
         * @param theseHours integer of hours
         */
        HoursPerLevel(final int theseHours) {
            this.hours = theseHours;
        }

        /**
         * Getter for hours.
         * @param hours - hours student currently has.
         * @return students current level
         */


 //       public static HoursPerLevel getHours(final int hours) {
  //          HoursPerLevel credits = Freshman;
  //          for (HoursPerLevel h : values()) {
   //             if (h.hours <= hours) {
    //                credits = h;
   //             }
   //         }
   //         return credits;
  //     }
    }
}



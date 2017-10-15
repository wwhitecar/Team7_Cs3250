package com.team7.app.business.dto;

/**
 * Class to store globals for the application.
 */
public class GlobalDto {

    /**
     * Name of the School.
     */
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
         * Freshman if less then 40 credits.
         */
        Freshman(29),
        /**
         * Sophomore if less then 80 credits.
         */
        Sophomore(59),
        /**
         * Junior if less then 120 credits.
         */
        Junior(89),
        /**
         * Senior if over 120 credits.
         */
        Senior(120);

        /**
         * Holds the number of hours.
         */
      // private final int hours;


        /**
         * HoursePerLevel.
         * @param theseHours integer of hours
         */
    //    HoursPerLevel(final int theseHours) {
     //       this.hours = theseHours;
    //    }

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



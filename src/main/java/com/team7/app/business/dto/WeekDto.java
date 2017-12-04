package com.team7.app.business.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * This class is an Entity bean,
 * "so the class should atleast have a package scope no-argument constructor".
 */
@Entity
public class WeekDto {

    /**
     * database key for the week.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int weekDbKey;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto mon;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto tues;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto wed;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto thurs;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto fri;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto sat;

    /**
     * single day for a week.
     */
    @OneToOne
    private DayDto sun;

    /**
     * Consent for the number 3.
     */
    private final int three = 3;

    /**
     * Consent for the number 4.
     */
    private final int four = 4;

    /**
     * Consent for the number 5.
     */
    private final int five = 5;

    /**
     * Consent for the number 6.
     */
    private final int six = 6;

    /**
     * empty constructor.
     */
    public WeekDto() {

    }

    /**
     *
     * @param listy - literal list of the days
     */
    public WeekDto(final List<DayDto> listy) {
        this.mon = listy.get(0);
        this.tues = listy.get(1);
        this.wed = listy.get(2);
        this.thurs = listy.get(three);
        this.fri = listy.get(four);
        this.sat = listy.get(five);
        this.sun = listy.get(six);
    }

    //public int getWeekNum() { return weekNum; }

    /**
     *
     * @param dayName - name of the day
     * @return returns day object
     */
    public DayDto getDayofWeek(final String dayName) {

        DayDto day = new DayDto(dayName);

        switch (dayName.toLowerCase()) {
            case "monday":
                day = mon;
                break;
            case "tuesday":
                day = tues;
                break;
            case "wednesday":
                day = wed;
                break;
            case "thursday":
                day = thurs;
                break;
            case "friday":
               day = fri;
                break;
            case "saturday":
                day = sat;
                break;
            case "sunday":
                day = sun;
                break;
            default:
                day = null;
        }
        return day;

    }

    /**
     * @return weekDbKey - returns the weekDbKey
     */
    public int getWeekDbKey() {
        return weekDbKey; }

    /**
     * @param key - key in the week DB.
     */
    public void setWeekDbkey(final int key) {
        this.weekDbKey = key;
    }

}

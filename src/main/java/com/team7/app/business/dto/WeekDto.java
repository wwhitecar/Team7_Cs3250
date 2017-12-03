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
        this.thurs = listy.get(3);
        this.fri = listy.get(4);
        this.sat = listy.get(5);
        this.sun = listy.get(6);
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
                System.out.println("incorrect day string");

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

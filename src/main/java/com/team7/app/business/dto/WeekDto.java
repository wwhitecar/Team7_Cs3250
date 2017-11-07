package com.team7.app.business.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class WeekDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int WeekDbKey;

    private int weekNum;



    private DayDto mon;
    private DayDto tues;
    private DayDto wed;
    private DayDto thurs;
    private DayDto fri;
    private DayDto sat;
    private DayDto sun;



    public WeekDto() {
         mon = new DayDto("monday");
        tues = new DayDto("tuesday");
         wed = new DayDto("wednesday");
         thurs = new DayDto("thursday");
        fri = new DayDto("friday");
         sat = new DayDto("saturday");
         sun = new DayDto("sunday");

    }

    public int getWeekNum() { return weekNum; }

    public DayDto getDayofWeek(String dayName) {

        DayDto day = new DayDto(dayName);

        switch(dayName) {
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

        }
        return day;

    }

    public int getWeekDbKey() {return WeekDbKey; }

}

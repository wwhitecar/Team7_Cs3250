package com.team7.app.business.dto;

import com.team7.app.services.DayServices;
import com.team7.app.services.DayServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


@Entity
public class WeekDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int WeekDbKey;

    @OneToOne
    private DayDto mon;

    @OneToOne
    private DayDto tues;

    @OneToOne
    private DayDto wed;

    @OneToOne
    private DayDto thurs;

    @OneToOne
    private DayDto fri;

    @OneToOne
    private DayDto sat;

    @OneToOne
    private DayDto sun;

    @Autowired
    @Transient
    private static DayServices ds;

    public WeekDto() {

    }

    //public int getWeekNum() { return weekNum; }

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

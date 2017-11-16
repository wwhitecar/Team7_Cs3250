package com.team7.app.business.dto;

import com.team7.app.services.DayServices;
import com.team7.app.services.DayServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


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

    public WeekDto() {

    }

    public WeekDto(final List<DayDto> listy) {
        this.mon = listy.get(0);
      //  this.tues = listy.get(1);
        //this.wed = listy.get(2);
      //  this.thurs = listy.get(3);
      //  this.fri = listy.get(4);
      //  this.sat = listy.get(5);
      //  this.sun = listy.get(6);
    }

    //public int getWeekNum() { return weekNum; }

    public DayDto getDayofWeek(String dayName) {

        DayDto day = new DayDto();

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

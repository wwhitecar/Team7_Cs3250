package com.team7.app.business.dto;

public class GlobalDto {

    private String schoolName;

    private int levelByCreditHour;

    public GlobalDto() {

    }


    public GlobalDto(final String name, final int hours) {

        this.levelByCreditHour = hours;
        this.schoolName = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getLevelByHour() {
        return levelByCreditHour;
    }

    public enum HoursPerLevel {
        Freshman(39),
        Sophomore(79),
        Junior(119),
        Senior(1000);


        private final int hours;


        HoursPerLevel(int hours) {
            this.hours = hours;
        }


        public static HoursPerLevel getHours(int hours) {
            HoursPerLevel credits = Freshman;
            for (HoursPerLevel h : values()) {
                if (h.hours <= hours) {
                    credits = h;
                }
            }
            return credits;
        }
    }
}



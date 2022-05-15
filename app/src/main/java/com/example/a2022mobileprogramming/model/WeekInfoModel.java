package com.example.a2022mobileprogramming.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class WeekInfoModel {
    int myWeek;
    String mySubject;

    public WeekInfoModel(int week, String subject) {
        setWeek(week);
        setSubject(subject);
    }

    public int getWeek() {
        return myWeek;
    }
    public void setWeek(int week) {
        myWeek = week;
    }
    public String getSubject() {
        return mySubject;
    }
    public void setSubject(String subject) {
        mySubject = subject;
    }

}

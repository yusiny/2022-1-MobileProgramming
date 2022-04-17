package com.example.a2022mobileprogramming.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekInfoModel {
    int myWeek;
    String mySubject;

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

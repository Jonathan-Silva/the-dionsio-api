package com.thedionisio.model.dto;

/**
 * Created by jonathan on 3/6/17.
 */
public class Date {
    @Override
    public String toString() {
        return "Date{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public  String start;
    public  String end;
}

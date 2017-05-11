package com.thedionisio.model.dto;

import java.time.LocalDateTime;

/**
 * Created by jonathan on 3/6/17.
 */
public class DateTimeControl {


    @Override
    public String toString() {
        return "DateTimeControl{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public LocalDateTime start;
    public LocalDateTime end;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.workperiodsorganizer.model.User;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Control total time in hours for certain user
 * in a day, a week, a month.
 * Here we count total amount of work for such
 * periods as a day, a week, a month.
 * If accumulator gets an interval from other day, week, or
 * month then we drop counter.
 * If interval in a different day, but in the same week and month
 * then drop only hoursInADay.
 * If interval in a different week, but in the same month
 * then drop hoursInADay and hoursInAWeek.
 * If interval in a different month,
 * then drop all hours accumulators.
 * After dropping accumulators sets new values
 * according to the current interval.
 * @author Andrew
 */
@Data
public class WorkAccumulator {
    private User user;
    private Long hoursInADay;
    private Long hoursInAWeek;
    private Long hoursInAMonth;
    private LocalDateTime previousDate;
    
    /**
     * Main constructor.
     * @param employeeInterval serves as source of
     * initial data to the fields.
     */
    public WorkAccumulator(EmployeeInterval employeeInterval){
        user = employeeInterval.getEmployee();
        hoursInADay = employeeInterval.length().toHours();
        hoursInAWeek = hoursInADay;
        hoursInAMonth = hoursInADay;
    }
    
    public void accumulate(Interval interval){
        
    }
    
}

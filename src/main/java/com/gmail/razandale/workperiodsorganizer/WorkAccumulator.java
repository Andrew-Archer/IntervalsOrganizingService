/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.workperiodsorganizer.model.User;
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
    private EmployeeInterval previousInterval;
    private enum TypeOfInterval {OTHER_DAY, OTHER_WEEK, OTHER_MONTH};
        
    private TypeOfInterval whatIsNext(EmployeeInterval interval){
        return null;
    }
    
    /**
     * Main constructor.
     * @param employeeInterval serves as source of
     * initial data for the fields.
     */
    public WorkAccumulator(EmployeeInterval employeeInterval){
        user = employeeInterval.getEmployee();
        hoursInADay = employeeInterval.length().toHours();
        hoursInAWeek = hoursInADay;
        hoursInAMonth = hoursInADay;
    }
    
    public void accumulate(EmployeeInterval interval){
		switch(whatIsNext(interval)){
                        //previousInterval is in another day than the
                        //interval.
			case OTHER_DAY:{
                            hoursInADay = interval.length().toHours();
                            hoursInAWeek += hoursInADay;
                            hoursInAMonth += hoursInADay;
                        }
			break;
                        //previousInterval is in another week than the
                        //interval.
			case OTHER_WEEK:{
                            hoursInADay = interval.length().toHours();
                            hoursInAWeek = hoursInADay;
                            hoursInAMonth += hoursInADay;
                        }
                        break;
                        //previousInterval is in another month than the
                        //interval.
                        case OTHER_MONTH:{
                            hoursInADay = interval.length().toHours();
                            hoursInAWeek = hoursInADay;
                            hoursInAMonth = hoursInADay;
                        }
                        break;
                        //previousInterval is in the same day as the
                        //interval.
                        default:{
                            hoursInADay += interval.length().toHours();
                            hoursInAWeek += hoursInADay;
                            hoursInAMonth += hoursInADay;
                        }
		}
        
    }
    
}

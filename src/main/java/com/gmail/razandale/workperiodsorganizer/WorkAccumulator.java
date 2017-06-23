/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.workperiodsorganizer.model.User;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Andrew
 */
@Data
public class WorkAccumulator {
    private User user;
    private Long hoursInADay;
    private Long hoursInAWeek;
    private Long hoursInAMonth;
    private LocalDateTime previousDate;
    
    public void accumulate(Interval interval){
        
    }
    
}

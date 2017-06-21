/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.Interval;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PastTrimmer implements IntervalTrimmer {

    @Override
    public <T extends Interval> List<T> trimInterval(List<T> intervals) {
        //All interval before this time will be trimmed.
        final LocalDateTime methodStartTime = LocalDateTime.now();
        
        //Here we put all that has to be trimmet.
        List<T> intervalsToRemove = new ArrayList<>();
        
        //Searching for what to trim.
        for (T interval : intervals){
            if (interval.getFrom().isBefore(methodStartTime)){
                intervalsToRemove.add(interval);
            }
        }
        
        //Trimming the past.
        intervals.removeAll(intervalsToRemove);
        
        return intervals;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.Interval;
import java.time.Duration;


public class DefaultValidator implements Validator {
    /**
     * The maximum duration of an interval in hours.
     */
    private static final Duration MAX_DURATION = Duration.ofHours(8);
    
    /**
     * The minimum duration of an interval in hours.
     */
    private static final Duration MIN_DURATION = Duration.ofHours(1);
    
    /**
     * Maximum total amount of the work time available in a day.
     */
    private static final Duration MAX_TOTAL_WORK_IN_A_DAY = Duration.ofHours(8);
    
    /**
     * Maximum total amount of the work time available in a week.
     */
    private static final Duration MAX_TOTAL_WORK_IN_A_WEEK = Duration.ofHours(40);
    
    /**
     * Maximum total amount of the work time available in a month.
     */
    private static final Duration MAX_TOTAL_WORK_IN_A_MONTH = Duration.ofHours(160);
    
    /**
     * Check for an {@link Interval} shorter than this minimum length
     * or longer than this maximum length.
     * @return true if the length of the given {@link Interval} is Ok
     * or false in another case.
     */
    private Boolean isValidDuration(Interval interval){
        return interval.length() < MAX_DURATION.toMillis() ||
                        interval.length() > MIN_DURATION.toMillis();
    }

    @Override
    public void validate(Interval interval) throws IntervalValidationException {
        //If duration of the given interval is not valid
        //then add this interval to the validation failures list.
        if(!isValidDuration(interval)){
            validationFailures.addInterval(interval);
            validationFailures.addCause("Wrong interval's length.");
            return;
        }
        
        
        
    }
    
}

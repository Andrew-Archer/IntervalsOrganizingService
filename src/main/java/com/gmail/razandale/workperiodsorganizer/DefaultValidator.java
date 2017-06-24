/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class DefaultValidator implements Validator {
    /**
     * Stores list of all invalidated intervals and
     * all causes of their invalidation.
     */
    private List<ValidationFailures> validationFailuresList;
    
    /**
     * Last validated interval to compare
     * with the new given.
     */
    private EmployeeInterval lastValidatedInterval;
    
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
     * Here we store data about total amount of work
     * for different users in hours.
     */
    private List<WorkAccumulator> workAccumulators = new ArrayList<>();
    
    /**
     * Check for an {@link Interval} shorter than this minimum length
     * or longer than this maximum length.
     * @return true if the length of the given {@link Interval} is right
     * or false in another case.
     */
    private Boolean isValidDuration(Interval interval){
        //Check size of an interval.
        if(interval.length().toMillis() > MAX_DURATION.toMillis() ||
                        interval.length().toMillis() < MIN_DURATION.toMillis()){
            return false;
        }
        //Make sure that an interval occupy not more than one day.
        //We don't need such check for a week or a month because first check
        //includes it.
        return (interval.getFrom().getDayOfMonth() != interval.getTo().getDayOfMonth() &&
                !interval.getFrom().getMonth().equals(interval.getTo().getMonth()) );
     
    }
    
    /**
     * Search for a {@link Workaccumulator} by the given interval's user.
     * @param interval should be an {@link EmployeeInterval} with user to find
     * proper {@link WorkAccumulator}.
     * @return null if workAccumulators is empty, or if there is no
     * {@link WorkAccumulator} for the given interval's user. Other way
     * returns found {@link WorkAccumulator};
     */
    private WorkAccumulator findWorkAccumulator(EmployeeInterval interval){
        if(workAccumulators.isEmpty()){
                return null;
            }
        for(WorkAccumulator workAccumulator : workAccumulators){
            //If have found proper accumulator.
            if(workAccumulator.getUser().equals(interval.getEmployee())){
                return workAccumulator;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param interval 
     */
    private Boolean totalAmountOfWorkIsExceeded(EmployeeInterval interval){
        //Search for a proper WorkAccumulator.
        WorkAccumulator workAccumulator = findWorkAccumulator(interval);
        
        //If accumulators list is empty, or there is no
        //accumulator for given worker.
        if(workAccumulator == null){
            //Add new accumulator.
            workAccumulator = new WorkAccumulator(interval);
            workAccumulators.add(workAccumulator);
        }
        
        //Accumulate the given interval
        workAccumulator.accumulate(interval);
        
        //If breakes any period limits.
        if(workAccumulator.getHoursInADay() > MAX_TOTAL_WORK_IN_A_DAY.toHours() ||
           workAccumulator.getHoursInAWeek() > MAX_TOTAL_WORK_IN_A_WEEK.toHours() ||
           workAccumulator.getHoursInAMonth() > MAX_TOTAL_WORK_IN_A_MONTH.toHours()){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    /**
     * Validate duration of the given interval by checking the interval
     * is not longer or shorter than it's allowed.</br>
     * Also makes it sure that the interval is in only one day.
     * And the last check is the given interval does not occupies an
     * already taken time interval.
     */
    public EmployeeInterval validate(EmployeeInterval interval) {
        List<String> causesOfInvalidation = new ArrayList<>();
        
        //If duration of the given interval is not valid
        //then add this interval to the validation failures list.
        if(!isValidDuration(interval)){
            causesOfInvalidation.add("Wrong interval's length");
        }
        
        //If total amount of work exceed in a day, a week, a month
        //more than allowed by restrictions then add this interval to the validation
        //failures list.
        if(totalAmountOfWorkIsExceeded(interval)){
            causesOfInvalidation.add("Amount of work has been exceeded");
        }
        
        //If this time interval is already taken by some other
        //We can't check it here because there is no data about what work is
        //taken.
        //if(isAlreadyTaken(interval)){
        //    causesOfInvalidation.add("This work is already taken");
        //}
        
        //If there are no invalidation causes return the given interval,
        //other way add new ValidationFailures to the validationFailuresList
        //and return null.
        if(causesOfInvalidation.isEmpty()){
            lastValidatedInterval = interval;
            return interval;
        }else{
            validationFailuresList.add(new ValidationFailures(interval, causesOfInvalidation));
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import java.util.List;
import com.gmail.razandale.intervals.WorkInterval;
import com.gmail.razandale.intervals.EmployeeInterval;

/**
 *
 * @author Andrew
 */
public class OrganizingService {
    //Here we store different periods organizers.
    private List<Organizer> organizers;
    private Validator validator;
    
    /**
     * Constructor builds organizers chain.
     */
    public OrganizingService(List<Organizer> organizers, Validator validator){
        this.organizers = organizers;
        this.validator = validator;
    }
    
    /**
     * Main method to get an organized graph of work.
     * @param workIntervals
     * @param employeeIntervals
     * @return a validated graph of work intervals with employees assigned.
     */
    public List<WorkInterval> organize(
        List<WorkInterval> workIntervals,
        List<EmployeeInterval> employeeIntervals){
        
        //Sort both intervals by from and to boundaries.
        workIntervals.sort(null);
        employeeIntervals.sort(null);
        
        //Run through the work's list and search for employee.
        for (WorkInterval workInterval : workIntervals){
            for(EmployeeInterval employeeInterval : employeeIntervals){
                
                //Check for an employeeInterval shorter than minimum length
                //or for an employeeInterval longer than maximun length.
                if {
                    //Go to the next employeeInterval.
                    continue;
                }
                
                //Check if an intersection exist.
                if (Interval.hasIntersection(workInterval, imployeeInterval)){
                    //Count totall number of working hours for one employee
                    //in a day, a week, etc.
                    //Give the validator new information about working hours.
                    //If new interval does not break the restrictions then
                    //we add it to the result, else go to a new imployeeInterval.
                    if (validator.addEmployeeIntervalData(employeeInterval)){
                        result.combineAndAdd(imployeeInterval, workInterval);
                    }
                }
            }
        }
        
        
        IntervalTrimmer pastTrimmer = new PastTrimmer();
        
        
        List<EmployeeInterval> result = employeeIntervals;
        
        for (Organizer organizer : organizers){
            result = organizer.organize(workIntervals, result);
        }
        return weld(workIntervals,result);
    }
    
    /**
     * Clears workIntervals and refills it with employeeIntervals.
     * @param workIntervals
     * @param employeeIntervals
     * @return a work graph of work intervals filled with employees
     */
    private List<WorkInterval> weld(
        List<WorkInterval> workIntervals,
        List<EmployeeInterval> employeeIntervals){
        throw new RuntimeException("Method veld is not implemented yet.");
    }
}

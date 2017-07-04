/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import java.util.List;
import com.gmail.razandale.intervals.WorkInterval;
import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class OrganizingService {
    
    /**
     * Current validator for the validating an
     * {@link EmployeeInterval}
     */
    private Validator validator;
    
    /**
     * Implements the Welder interface and
     * serves to the welding of two intervals types.
     */
    private Welder welder;
    
    /**
     * Here we store result of welding
     * {@link WorkInterval}s and {@link EmployeeInterval}s.
     */
    private List<WorkInterval> resultingWorkGraph;
   
    /**
     * Constructor with a custom validator.
     * @param validator developer designed validator.
     * @param welder
     */
   public OrganizingService(Validator validator, Welder welder){
       this.validator = validator;
       this.welder = welder;
   }
   
   /**
    * Default constructor. Sets default validator as
    * the validator.
    */
   public OrganizingService(){
       this(new DefaultValidator(),
       new DefaultWelder());
   }
    
    /**
     * Main method to get an organized graph of work.
     * @param workIntervals
     * @param employeeIntervals
     * @return a validated graph of work intervals with employees assigned.
     */
    public List<Interval> organize(
        List<WorkInterval> workIntervals,
        List<EmployeeInterval> employeeIntervals){
        
        List<Interval> tmpWorkInterval = new ArrayList<>();
        
        //Sort both intervals by from and to boundaries.
        workIntervals.sort(null);
        employeeIntervals.sort(null);
        
        //Run through the work's list and search for employee.
        for (WorkInterval workInterval : workIntervals){
            for(EmployeeInterval employeeInterval : employeeIntervals){
                //Check if an intersection exist.
                if (workInterval.hasIntersection(employeeInterval)){
                   //Here should be a organizer method witch
                   //combines two intervals.
                   tmpWorkInterval.add(welder.weld(workInterval,
                        employeeInterval,
                        validator));
                   
                }
            }
        }
        return tmpWorkInterval;
    }
}

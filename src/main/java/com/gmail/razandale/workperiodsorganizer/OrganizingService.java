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
    private Validator validator;
   
    /**
     * Constructor with a custom validator.
     * @param validator developer designed validator.
     */
   public OrganizingService(Validator validator){
       this.validator = validator;
   }
   
   /**
    * Default constructor. Sets default validator as
    * the validator.
    */
   public OrganizingService(){
       this.validator = new DefaultValidator();
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
                
                //If validation is ok the return employee interval and
                //null if interval is invalid.
                employeeInterval = validator.validate(employeeInterval);
                
                //If employeeInterval is null then look for
                //the next employeeInterval.
                if(employeeInterval == null){
                    continue;
                }
                
                //Check if an intersection exist.
                if (workInterval.hasIntersection(employeeInterval)){
                   //Here should be a organizer method witch
                   //combines two intervals.
                }
            }
        }
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

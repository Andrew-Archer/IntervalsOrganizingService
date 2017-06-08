/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import java.util.List;
import com.gmail.razandale.workperiodsorganizer.model.WorkInterval;
import com.gmail.razandale.workperiodsorganizer.model.EmployeeInterval;

/**
 *
 * @author Andrew
 */
public class OrganizingService {
    //Here we store different periods organizers.
    private List<Organizer> organizers;
    
    
    /**
     * Main method to get an organized graph of work.
     * @param workIntervals
     * @param employeeIntervals
     * @return a validated graph of work intervals with employees
     */
    public List<WorkInterval> organize(
        List<WorkInterval> workIntervals,
        List<EmployeeInterval> employeeIntervals){
        
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
     * @return a work graph of work intervals filled with inployees
     */
    private List<WorkInterval> weld(
        List<WorkInterval> workIntervals,
        List<EmployeeInterval> employeeIntervals){
        throw new RuntimeException("Method veld is not implemented yet.");
    }
}

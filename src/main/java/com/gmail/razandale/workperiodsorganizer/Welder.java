/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.intervals.WorkInterval;

/**
 * Welds two intervals into the new one.
 * 
 * @author Andrew
 */
public interface Welder {

    /**
     * Welds an {@link EmployeeInterval} with a {@link WorkInterval} to
     * return new {@link WorkInterval} to be added into the
     * final graph of work.
     * @param workInterval is a work to be done.
     * @param employeeInterval is a work which an {@link Employee} wont
     * to do.
     * @param validator
     * @return {@link WorkInterval} with assignee.
     */
    public Interval weld(WorkInterval workInterval,
             EmployeeInterval employeeInterval,
             Validator validator);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;

/**
 *
 * @author Andrew
 */
public interface Validator {
    /**
     *
     * @param interval
     * @return 
     */
    public EmployeeInterval validate(EmployeeInterval interval);
}

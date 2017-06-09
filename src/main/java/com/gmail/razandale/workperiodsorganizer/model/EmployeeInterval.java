/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer.model;

import java.time.LocalDateTime;

/**
 *
 * @author Andrew
 */
public class EmployeeInterval extends Interval{
    private Employee employee;
    
    //Criteria to determine who picked the job first.
    private LocalDateTime creationTime;
    
    public EmployeeInterval(){
        creationTime = LocalDateTime.now();
    }
}

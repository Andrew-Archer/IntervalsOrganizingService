/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import  com.gmail.razandale.workperiodsorganizer.model.User;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Represents a request for a work created by an employee.
 * @author Andrew
 */
@Data
public class EmployeeInterval extends Interval{
    private User employee;
    
    /**
     * We need this field to know how pick the job first.
     */
    private LocalDateTime creationTime;
}

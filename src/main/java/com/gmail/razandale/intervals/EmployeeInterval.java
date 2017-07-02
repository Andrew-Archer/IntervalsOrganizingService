/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a request for a work created by an employee.
 * @author Andrew
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInterval extends Interval{
    /**
     * We need this field to know how pick the job first.
     */
    private LocalDateTime creationTime;
}

/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
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
    
    public EmployeeInterval(
            User user,
            Work work,
            LocalDateTime from,
            LocalDateTime to,
            LocalDateTime creationTime){
        super(
                user,
                work,
                from,
                to);
        this.creationTime = creationTime;
    }
    
     @Override
    public String toString(){
        String result = new String();
        result = result + "Employee: " + employee == null ?"none":employee.toString() + "\n";
        result = result + "Work : " + work.toString() + "\n";
        result = result + "From: " + from.toString() + "\n";
        result = result + "To: " + to.toString() + "\n";
        result = result + "CreationTime: " + creationTime.toString() + "\n";
        return result;
    }
}

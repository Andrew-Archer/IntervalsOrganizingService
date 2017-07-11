/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public int compareTo(Object o){
        int result = from.compareTo(((EmployeeInterval) o).getFrom());
        if(result == 0){
            if ((creationTime != null) &&  (((EmployeeInterval) o).getCreationTime() != null)){
                result = creationTime.compareTo(((EmployeeInterval) o).getCreationTime());
            }
        }
        return result;
    }
    
     @Override
    public String toString(){
        String result = "";
        result = "======================================\n";
        result = result + (("Employee: " + employee == null) ?"none":employee.toString() + "\n");
        result = result + ("Work : " + work.toString() + "\n");
        result = result + ("From: " + from.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
        result = result + ("To: " + to.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
        result = result + ("CreationTime: " + creationTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
        result = result + "======================================\n";
        return result;
    }
}

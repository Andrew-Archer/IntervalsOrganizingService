/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.intervals;

import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Andrew
 */
@Data
public class WorkInterval extends Interval{

    public WorkInterval(
            User employee,
            Work work,
            LocalDateTime from,
            LocalDateTime to) {
        super(employee, work, from, to);
        
    }
    
    @Override
    public String toString(){
        String result = new String();
        result = result + "Employee: " + (employee == null ? "none" : employee.toString()) + "\n";
        result = result + "Work : " + work.toString() + "\n";
        result = result + "From: " + from.toString() + "\n";
        result = result + "To: " + to.toString() + "\n";
        return result;
    }
}

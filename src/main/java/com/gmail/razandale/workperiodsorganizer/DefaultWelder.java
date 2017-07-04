/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.intervals.WorkInterval;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DefaultWelder implements Welder {
    @Override
    public Interval weld(WorkInterval workInterval, 
            EmployeeInterval employeeInterval,
            Validator validator) {
        Interval resultingWorkGraphInterval = null;
   
        if(validator.validate(employeeInterval) != null){
            if(workInterval.hasIntersection(employeeInterval)){
                switch (workInterval.getOverlappingType(employeeInterval)) {
                    case START_FIT__END_FIT:
                    case START_FIT__END_AFTER:
                    case START_BEFORE__END_FIT:
                    case START_BEFORE__END_AFTER:
                        workInterval.setEmployee(employeeInterval.getEmployee());
                        resultingWorkGraphInterval = workInterval;
                        workInterval = null;
                        break;
                    case START_FIT__END_BEFORE:
                        resultingWorkGraphInterval = new Interval(
                            employeeInterval.getEmployee(),
                            workInterval.getWork(),
                                employeeInterval.getFrom(),
                                employeeInterval.getTo()
                        );
                        workInterval.setFrom(employeeInterval.getTo());
                        break;
                    case START_AFTER__END_FIT:
                    case START_AFTER__END_AFTER:
                        resultingWorkGraphInterval = new Interval(
                            employeeInterval.getEmployee(),
                            workInterval.getWork(),
                                employeeInterval.getFrom(),
                                employeeInterval.getTo()
                        );
                        workInterval = null;
                        break;
                    case START_AFTER__END_BEFORE:
                        resultingWorkGraphInterval = new Interval(
                            employeeInterval.getEmployee(),
                            workInterval.getWork(),
                                employeeInterval.getFrom(),
                                employeeInterval.getTo()
                        );
                        workInterval.setFrom(employeeInterval.getTo());
                        break;
                    case START_BEFORE__END_BEFORE:
                        resultingWorkGraphInterval = new Interval(
                            employeeInterval.getEmployee(),
                            workInterval.getWork(),
                                workInterval.getFrom(),
                                employeeInterval.getTo()
                        );
                        workInterval.setFrom(employeeInterval.getTo());
                        break;
                    default:
                        throw new RuntimeException("Intervals do not intersect.");
                }
            }
        }
        return resultingWorkGraphInterval;
    }
    
}

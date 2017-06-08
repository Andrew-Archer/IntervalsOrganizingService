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
    
    public List<WorkInterval> organize(
        List<WorkInterval> workPeriods,
        List<EmployeeInterval> workRequestPeriods){
        
        List<EmployeeInterval> result = workRequestPeriods;
        
        for (Organizer organizer : organizers){
            result = organizer.organize(workPeriods, result);
        }
        return veld(workPeriods,result);
    }
}

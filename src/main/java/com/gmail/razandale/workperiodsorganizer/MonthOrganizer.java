/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.workperiodsorganizer.model.EmployeeInterval;
import com.gmail.razandale.workperiodsorganizer.model.WorkInterval;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class MonthOrganizer extends Organizer{

    @Override
    public List<EmployeeInterval> organize(List<WorkInterval> works, List<EmployeeInterval> workRequestPeriods) {}

    @Override
    protected Boolean validate() {}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.workperiodsorganizer.model.WorkInterval;
import com.gmail.razandale.workperiodsorganizer.model.EmployeeInterval;
import java.util.List;

/**
 *
 * @author Andrew
 */
public abstract class Organizer {
    public abstract List<EmployeeInterval> organize(
        List<WorkInterval> works,
        List<EmployeeInterval> workRequestPeriods);
    
    protected abstract Boolean validate();
}

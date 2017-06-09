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
 * @author andrew
 */
public class WeekOrganizer extends Organizer {

    public WeekOrganizer() {
    }

    @Override
    public List<EmployeeInterval> organize(List<WorkInterval> works, List<EmployeeInterval> workRequestPeriods) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.intervals;

import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.util.List;

/**
 *
 * @author Andrew
 */
public class WorkInterval extends Interval{
    private Long employeeId;
    private List<Work> works;
}

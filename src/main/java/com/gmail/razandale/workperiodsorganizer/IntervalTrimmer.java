/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.Interval;
import java.util.List;

/**
 * Implement this interface to create
 * trimmer that returns needed interval's list.
 * @author Andrew
 */
public interface IntervalTrimmer {
    /**
     * Trims intervals to make them fits your needs.
     * @param <T> must be descendant of {@CodeInterval}.
     * @param intervals is list of intervals to trim.
     * @return trimmed interval's list.
     */
    public <T extends Interval> List<T> trimInterval(List<T> intervals);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer.model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Andrew
 */
public class Interval {
    protected Long id;
    protected LocalDateTime from;
    protected LocalDateTime to;
    
    public Duration length(){
        return Duration.between(from, to);
    }
}

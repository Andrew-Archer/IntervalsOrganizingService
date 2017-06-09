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
    private Long id;
    private LocalDateTime from;
    private LocalDateTime to;
    
    public Duration length(){
        return Duration.between(getFrom(), getTo());
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the from
     */
    public LocalDateTime getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public LocalDateTime getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(LocalDateTime to) {
        this.to = to;
    }
    
    
}

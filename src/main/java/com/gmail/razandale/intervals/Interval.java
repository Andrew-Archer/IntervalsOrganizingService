/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Do not subclass this class it's for
 * internal use only.
 * @author Andrew
 */
@Data
public class Interval implements Comparable{
    protected Long id;
    protected LocalDateTime from;
    protected LocalDateTime to;
    
    /**
     * Returns duration of this interval.
     * @return duration of this interval as
     * {@link java.time.LocalDateTime}.
     */
    public Long length(){
        return Duration.between(getFrom(), getTo()).toMillis();
    }

    @Override
    /**
     * If this from and argument's from is equal,
     * then compares this to and argument's to.
     */
    public int compareTo(Object o) {
        return from.compareTo(((Interval)o).getFrom()) == 0 ?
                to.compareTo(((Interval)o).getTo()) : 
                from.compareTo(((Interval)o).getFrom());
    }
}

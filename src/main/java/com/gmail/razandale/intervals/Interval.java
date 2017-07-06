/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import static com.gmail.razandale.intervals.Interval.IntersectionType.*;
import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.time.Duration;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Do not subclass this class it's for internal use only.
 *
 * @author Andrew
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interval implements Comparable {

    public static enum IntersectionType {
        START_BEFORE__END_BEFORE,
        START_BEFORE__END_FIT,
        START_BEFORE__END_AFTER,
        START_FIT__END_BEFORE,
        START_FIT__END_FIT,
        START_FIT__END_AFTER,
        START_AFTER__END_BEFORE,
        START_AFTER__END_FIT,
        START_AFTER__END_AFTER
    };
    
    protected User employee;
    protected Work work;
    protected LocalDateTime from;
    protected LocalDateTime to;
    
    

    /**
     * Returns duration of this interval.
     *
     * @return duration of this interval as {@link Duration}.
     */
    public Duration length() {
        return Duration.between(getFrom(), getTo());
    }

    /**
     * Checks weather the current {@link Interval} is overlapping with the given
     * {@link Interval}.
     * @param interval an {@link Interval} to check for overlapping.
     * @return {@code true} if {@link Interval} is overlapping and
     * {@code false} if it's not.
     */
    public boolean hasIntersection(Interval interval) {
        return !((interval.getFrom().isBefore(getFrom().plusNanos(1))
                && interval.getTo().isBefore(getFrom().plusNanos(1)))
                || (interval.getFrom().isAfter(getTo().minusNanos(1))
                && interval.getTo().isAfter(getTo().minusNanos(1))));
    }

    
    /**
     * There are only 9 types of overlapping is available, since there are no
     * zero length {@link Interval}s.
     * @param interval
     * @return
     */
    public IntersectionType getOverlappingType(Interval interval) {
        int result;
        int startType = 30;
        int endType = 3;

        if (interval.getFrom().isBefore(getFrom())) {
            startType = 10;
        } else if (interval.getFrom().isAfter(getFrom())) {
            startType = 20;
        }

        if (interval.getTo().isBefore(getTo())) {
            endType = 1;
        } else if (interval.getTo().isAfter(getTo())) {
            endType = 2;
        }

        result = startType + endType;
        
        switch (result){
            case 33:
                return START_FIT__END_FIT;
            case 31:
                return START_FIT__END_BEFORE;
            case 32:
                return START_FIT__END_AFTER;
            case 23:
                return START_AFTER__END_FIT;
            case 21:
                return START_AFTER__END_BEFORE;
            case 22:
                return START_AFTER__END_AFTER;
            case 13:
                return START_BEFORE__END_FIT;
            case 11:
                return START_BEFORE__END_BEFORE;
            case 12:
                return START_BEFORE__END_AFTER;
            default :
                return null;
            
        }
    }
    
    @Override
    /**
     * If this from and argument's from is equal, then compares this to and
     * argument's to.
     */
    public int compareTo(Object o) {
        return from.compareTo(((Interval) o).getFrom()) == 0
                ? to.compareTo(((Interval) o).getTo())
                : from.compareTo(((Interval) o).getFrom());
    }
    
    @Override
    public String toString(){
        String result = new String();
        result = result + "Employee: " + employee == null ?"none":employee.toString() + "\n";
        result = result + "Work : " + work.toString() + "\n";
        result = result + "From: " + from.toString() + "\n";
        result = result + "To: " + to.toString() + "\n";
        return result;
    }
}

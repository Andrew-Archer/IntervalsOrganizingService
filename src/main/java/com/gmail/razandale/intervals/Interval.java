/*
 * Free to charge.
 */
package com.gmail.razandale.intervals;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Do not subclass this class it's for internal use only.
 *
 * @author Andrew
 */
@Data
public class Interval implements Comparable {

    protected Long id;
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
}

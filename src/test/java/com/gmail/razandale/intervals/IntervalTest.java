/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.intervals;

import com.gmail.razandale.intervals.Interval.IntersectionType;
import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class IntervalTest {
    
    public IntervalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of length method, of class Interval.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Interval instance = new Interval(
                null,
                null,
                LocalDateTime.of(0, 1, 1, 1, 0),
                LocalDateTime.of(0, 1, 1, 2, 0));
        Duration expResult = Duration.ofHours(1);
        Duration result = instance.length();
        assertEquals("length() gives wrong duration of an interval.",expResult, result);
    }

    /**
     * Test of hasIntersection method, of class Interval.
     */
    @Test
    public void testHasIntersection() {
        System.out.println("hasIntersection");
        Interval interval = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,1,2)
        );
        Interval instance = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2)
        );
        assertTrue("hasIntersection does not see intersection of test intervals.", instance.hasIntersection(interval));
    }

    /**
     * Test of getOverlappingType method, of class Interval.
     */
    @Test
    public void testGetOverlappingType() {
        System.out.println("getOverlappingType");
        Interval interval = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,1,2)
        );
        Interval instance = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2)
        );
        Interval.IntersectionType expResult = IntersectionType.START_FIT__END_BEFORE;
        Interval.IntersectionType result = instance.getOverlappingType(interval);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Interval.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Interval beforeStartInterval = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,0),
            LocalDateTime.of(1,1,1,2,2)
        );
        
        Interval sameStartInterval = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2)
        );
        
        Interval afterStartInterval = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,2),
            LocalDateTime.of(1,1,1,2,3)
        );
        
        Interval instance = new Interval(
            null,
            null,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2)
        );
        
        boolean expResult;
        expResult = instance.compareTo(beforeStartInterval) > 0;
        expResult = expResult && instance.compareTo(sameStartInterval) == 0;
        expResult = expResult && instance.compareTo(afterStartInterval) < 0;
        assertTrue(expResult);
    }
}

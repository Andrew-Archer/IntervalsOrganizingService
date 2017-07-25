/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.workperiodsorganizer.model.User;
import com.gmail.razandale.workperiodsorganizer.model.Work;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class WorkAccumulatorTest {
    
    public WorkAccumulatorTest() {
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
     * Test of accumulate method, of class WorkAccumulator.
     */
    @Test
    public void testAccumulate() {
        System.out.println("accumulate");
        //Create sample types of work
        Work work1 = new Work("group", "One trainer a lot of people.");
        Work work2 = new Work("single", "One trainer one human.");
        
        //Fill list with types of work
        List<Work> listOfWork = new ArrayList<>();
        
        //Create sample user
        User user = new User(listOfWork, "worker");
        EmployeeInterval interval1 = new EmployeeInterval(
                user,
                work1,
                LocalDateTime.of(1, 1, 1, 1, 0),
                LocalDateTime.of(1, 1, 1, 2, 0),
                LocalDateTime.now());
        EmployeeInterval interval2 = new EmployeeInterval(
                user,
                work2,
                LocalDateTime.of(1, 1, 1, 1, 0),
                LocalDateTime.of(1, 1, 1, 10, 0),
                LocalDateTime.now());
        WorkAccumulator instance = new WorkAccumulator(interval1);
        instance.accumulate(interval2);
        assertEquals(instance.getHoursInADay(), new Long(10));
        assertEquals(instance.getHoursInAWeek(), new Long(10));
        assertEquals(instance.getHoursInAMonth(), new Long(10));
        assertTrue(instance.getPreviousInterval() == interval2);
    }

}

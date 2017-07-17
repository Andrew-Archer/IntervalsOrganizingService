/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.intervals.WorkInterval;
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
public class DefaultWelderTest {
    private final List<Work> sampleListOfWork = new ArrayList<>();
    private final User sampleWorker = new User(sampleListOfWork, "trainer");
    
    public DefaultWelderTest() {
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
     * Test of weld method, of class DefaultWelder.
     */
    @Test
    public void testWeld() {
        System.out.println("weld");
        sampleListOfWork.add(new Work("group", "Many people can be involved."));
        sampleListOfWork.add(new Work("pesonal", "One trainer for each person."));
        WorkInterval workInterval = new WorkInterval(
                null,
                sampleListOfWork.get(1),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.of(1, 2, 2, 2, 0)
        );
        EmployeeInterval employeeInterval = new EmployeeInterval(
                sampleWorker,
                sampleListOfWork.get(1),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.of(1, 2, 2, 2, 0),
                LocalDateTime.now()
        );
        Validator validator = new DefaultValidator();
        DefaultWelder instance = new DefaultWelder();
        Interval expResult = workInterval;
        Interval result = instance.weld(workInterval, employeeInterval, validator);
        assertEquals(expResult, result);
    }
    
}

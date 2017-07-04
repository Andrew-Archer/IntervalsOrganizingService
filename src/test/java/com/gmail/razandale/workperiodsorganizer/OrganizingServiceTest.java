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
public class OrganizingServiceTest {
    private List<Work> sampleListOfWork = new ArrayList<>();
    private  User sampleWorker = new User(sampleListOfWork, "trainer");
    private List<WorkInterval> workIntervals = new ArrayList<>();
    private List<EmployeeInterval> employeeIntervals = new ArrayList<>();
    private List<Interval> expectedResults = new ArrayList<>();
    public OrganizingServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        sampleListOfWork.add(new Work("group", "Many people can be involved."));
        sampleListOfWork.add(new Work("pesonal", "One trainer for each person."));
        
        workIntervals.add(new WorkInterval(
                null,
                sampleListOfWork.get(1),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.of(1, 2, 2, 1, 0)
        ));
                
        employeeIntervals.add(new EmployeeInterval(
                sampleWorker,
                sampleListOfWork.get(1),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.now()
        ));
        
        expectedResults.add(new Interval(
                sampleWorker,
                sampleListOfWork.get(1),
                LocalDateTime.of(1, 2, 2, 1, 0),
                LocalDateTime.of(1, 2, 2, 1, 0)
        ));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of organize method, of class OrganizingService.
     */
    @Test
    public void testOrganize() {
        System.out.println("OrganizingService.organize.\n");
        System.out.println("Data are given.\n");
        System.out.println("workIntervals: " + workIntervals.toString() + "\n");
        System.out.println("employeeIntervals: \n" + employeeIntervals.toString() + "\n");
        System.out.println("expectedResults: \n" + expectedResults.toString() + "\n");
        
        OrganizingService instance = new OrganizingService();
        List<Interval> expResult = expectedResults;
        List<Interval> result = instance.organize(workIntervals, employeeIntervals);
        System.out.println("result is: " + result.toString() + "\n");
        assertEquals(expResult, result);
    }
    
}

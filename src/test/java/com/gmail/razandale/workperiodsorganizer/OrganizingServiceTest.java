/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
import com.gmail.razandale.intervals.WorkInterval;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of organize method, of class OrganizingService.
     */
    @Test
    public void testOrganize() {
        System.out.println("organize");
        List<WorkInterval> workIntervals = null;
        List<EmployeeInterval> employeeIntervals = null;
        OrganizingService instance = new OrganizingService();
        List<Interval> expResult = null;
        List<Interval> result = instance.organize(workIntervals, employeeIntervals);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
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
        EmployeeInterval interval = null;
        WorkAccumulator instance = null;
        instance.accumulate(interval);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

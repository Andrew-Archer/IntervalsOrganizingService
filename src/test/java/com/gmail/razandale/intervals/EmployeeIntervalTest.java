/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.intervals;

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
public class EmployeeIntervalTest {
    
    public EmployeeIntervalTest() {
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
 

    @Test
    public void testCompareTo(){
        Work work = new Work("single", "One person one trainer.");
        List<Work> works = new ArrayList<>();
        works.add(work);
        User user = new User(works, "James");
        System.out.println("compareTo");
        List<EmployeeInterval> expSorting = new ArrayList<>();
        List<EmployeeInterval> gotSorting = new ArrayList<>();
        EmployeeInterval beforeStartBeforeCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,0),
            LocalDateTime.of(1,1,1,1,0),
            LocalDateTime.of(1,1,1,1,0)
        );
        expSorting.add(beforeStartBeforeCreation);
        
        EmployeeInterval beforeStartSameCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,0),
            LocalDateTime.of(1,1,1,2,1),
            LocalDateTime.of(1,1,1,1,1)
        );
        expSorting.add(beforeStartSameCreation);
        
        EmployeeInterval beforeStartAfterCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,0),
            LocalDateTime.of(1,1,1,2,3),
            LocalDateTime.of(1,1,1,1,2)
        );
        expSorting.add(beforeStartAfterCreation);
        
        EmployeeInterval sameStartBeforeCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2),
            LocalDateTime.of(1,1,1,1,0)
        );
        expSorting.add(beforeStartAfterCreation);
        
        EmployeeInterval sameStartSameCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2),
            LocalDateTime.of(1,1,1,1,1)
        );
        expSorting.add(sameStartSameCreation);
        
        EmployeeInterval sameStartAfterCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,2,2),
            LocalDateTime.of(1,1,1,1,2)
        );
        expSorting.add(sameStartAfterCreation);
        
        EmployeeInterval afterStartBeforeCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,2),
            LocalDateTime.of(1,1,1,2,2),
            LocalDateTime.of(1,1,1,1,0)
        );
        expSorting.add(afterStartBeforeCreation);
        
        EmployeeInterval afterStartSameCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,2),
            LocalDateTime.of(1,1,1,2,3),
            LocalDateTime.of(1,1,1,1,1)
        );
        expSorting.add(afterStartSameCreation);
        
        EmployeeInterval afterStartAfterCreation = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,2),
            LocalDateTime.of(1,1,1,2,3),
            LocalDateTime.of(1,1,1,1,2)
        );
        expSorting.add(afterStartAfterCreation);
        
        //Copy sorting that we expect.
        gotSorting.addAll(expSorting);
        
        //Sorting result that we will got.
        gotSorting.sort(null);
        
        EmployeeInterval instance = new EmployeeInterval(
            user,
            work,
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,1,1),
            LocalDateTime.of(1,1,1,1,1)
            
        );
        
        boolean expResult;
        expResult = instance.compareTo(beforeStartBeforeCreation) > 0;
        expResult = expResult && (instance.compareTo(beforeStartSameCreation) > 0);
        expResult = expResult && (instance.compareTo(beforeStartAfterCreation) > 0);
        expResult = expResult && (instance.compareTo(sameStartBeforeCreation) > 0);
        expResult = expResult && (instance.compareTo(sameStartSameCreation) == 0);
        expResult = expResult && instance.compareTo(sameStartAfterCreation) < 0;
        expResult = expResult && instance.compareTo(afterStartBeforeCreation) < 0;
        expResult = expResult && instance.compareTo(afterStartSameCreation) < 0;
        expResult = expResult && (instance.compareTo(afterStartAfterCreation) < 0);
        
        
        assertTrue("CompareTo gives the wrong result.", expResult);
        
        assertEquals("Lists sorted in a different order.", expSorting, gotSorting);
    }
    
}

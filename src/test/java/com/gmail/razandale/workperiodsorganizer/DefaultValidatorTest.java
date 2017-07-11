/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.razandale.workperiodsorganizer;

import com.gmail.razandale.intervals.EmployeeInterval;
import com.gmail.razandale.intervals.Interval;
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
public class DefaultValidatorTest {
    
    public DefaultValidatorTest() {
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
     * Test of validate method, of class DefaultValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Work work = new Work("single", "Trainer per user.");
        List<Work> works = new ArrayList<>();
        works.add(work);
        User user = new User(works , "trainer");
        
        EmployeeInterval interval = new EmployeeInterval(
        user,
        work,        
        LocalDateTime.of(1,1,1,1,1),
        LocalDateTime.of(1,1,1,1,1),
        LocalDateTime.of(1,1,1,1,1)
        );
        
        DefaultValidator instance = new DefaultValidator();
        EmployeeInterval expResult = interval;
        EmployeeInterval result = instance.validate(interval);
        List<InvalidationOccurences> fails = instance.getValidationFailuresList();
        for(InvalidationOccurences a : fails){
            System.out.println(a.toString());
        }
        assertEquals(expResult, result);
    }
    
}

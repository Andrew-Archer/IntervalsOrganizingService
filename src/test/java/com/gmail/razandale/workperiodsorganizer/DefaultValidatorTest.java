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
        
        EmployeeInterval writeInterval = new EmployeeInterval(
        user,
        work,        
        LocalDateTime.of(1,1,1,1,0),
        LocalDateTime.of(1,1,1,7,0),
        LocalDateTime.of(1,1,1,1,1)
        );
        
        EmployeeInterval wrongInterval = new EmployeeInterval(
        user,
        work,        
        LocalDateTime.of(1,1,1,1,0),
        LocalDateTime.of(1,1,1,9,1),
        LocalDateTime.of(1,1,1,1,1)
        );
        
        DefaultValidator instance = new DefaultValidator();
        EmployeeInterval expResult = wrongInterval;
        assertEquals(writeInterval, instance.validate(writeInterval));
        EmployeeInterval result = instance.validate(wrongInterval);
        List<InvalidationOccurences> fails = instance.getValidationFailuresList();
        assertEquals("Wrong interval's length", fails.get(0).getInvalidationCauses().get(0));
        assertEquals("Amount of work has been exceeded",fails.get(0).getInvalidationCauses().get(1));
        assertEquals(null, result);
        

    }
    
}

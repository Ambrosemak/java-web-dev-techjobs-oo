package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job jobTest1;
    Job jobTest2;
    Job jobTestTheFullConstructor;
    Job jobTestForEquality;
    Job jobTestEmptyConstructor;

    @Before
    public void createJobObjects(){
        jobTest1 = new Job();
        jobTest2 = new Job();
        jobTestTheFullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTestForEquality = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTestEmptyConstructor = new Job("", new Employer(""),new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingsJobId() {
        assertTrue(jobTest1.getId() != jobTest2.getId() && jobTest2.getId() == jobTest1.getId() +1 );
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(jobTestTheFullConstructor.getName() instanceof String);
        assertTrue(jobTestTheFullConstructor.getEmployer() instanceof Employer);
        assertTrue(jobTestTheFullConstructor.getLocation() instanceof Location);
        assertTrue(jobTestTheFullConstructor.getPositionType() instanceof PositionType);
        assertTrue(jobTestTheFullConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(jobTestTheFullConstructor.equals(jobTestForEquality));
    }

    @Test
    public void testToStringStartsAndEndsWithBlankLines(){
        assertTrue(jobTestTheFullConstructor.toString().startsWith("\n"));
        assertTrue(jobTestTheFullConstructor.toString().endsWith("\n"));
    }

    @Test
    public void testToStringLabelForEachField(){
        assertTrue(jobTestTheFullConstructor.toString().contains("ID: " + jobTestTheFullConstructor.getId()));
        assertTrue(jobTestTheFullConstructor.toString().contains("Name: " + jobTestTheFullConstructor.getName()));
        assertTrue(jobTestTheFullConstructor.toString().contains("Employer: " + jobTestTheFullConstructor.getEmployer()));
        assertTrue(jobTestTheFullConstructor.toString().contains("Location: " + jobTestTheFullConstructor.getLocation()));
        assertTrue(jobTestTheFullConstructor.toString().contains("Position Type: " + jobTestTheFullConstructor.getPositionType()));
        assertTrue(jobTestTheFullConstructor.toString().contains("Core Competency: " + jobTestTheFullConstructor.getCoreCompetency()));
    }

    @Test
    public void testToStringIfFieldEmpty(){
        assertTrue(jobTestEmptyConstructor.toString().contains("Name: Data not available"));
        assertTrue(jobTestEmptyConstructor.toString().contains("Employer: Data not available"));
        assertTrue(jobTestEmptyConstructor.toString().contains("Location: Data not available"));
        assertTrue(jobTestEmptyConstructor.toString().contains("Position Type: Data not available"));
        assertTrue(jobTestEmptyConstructor.toString().contains("Core Competency: Data not available"));
    }
}

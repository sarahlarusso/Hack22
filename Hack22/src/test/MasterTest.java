package test;

import general.HashList;
import general.School;
import general.Student;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MasterTest {
    /*
    This is a test class. Put all tests in individual methods and add Javadocs, plus @Test before the method so
    the program runs the test. Do not push erroneous code. Do not push to master.
     */

    /**
     * Master method for this class; runs all tests
     */
    public static void runTests() {
        Result result = JUnitCore.runClasses(MasterTest.class);
        List<Failure> failures = result.getFailures();
        for(Failure failure : failures) {
            System.out.println(failure.toString());
        }
        final int RUN_COUNT = result.getRunCount();
        System.out.println((RUN_COUNT - failures.size()) + "/" + RUN_COUNT + " tests passed");
        System.out.println(result.wasSuccessful());
    }

    /**
     * Stencil test method
     */
    @Test
    public void test() {
        //This is the interior of the test method.

        //This is an "assert<Boolean>" method, which you can use to check whether a boolean value is true/false.
        assertTrue(true);
        assertFalse(false);

        //This is an "assertEquals" method, which can be use to check whether two values are equal.
        //The first value is the correct value, and the second is the value the program outputs.
        assertEquals(3, 3);
        assertEquals(5, 1 + 4);
    }

    /**
     * Tests HashList methods
     */
    @Test
    public void testHashList() {
        HashList<Integer> list = new HashList<>(List.of(0, 1, 2, 3, 4, 5));
        assertEquals(6, list.size());
        assertEquals(5, (int) list.get(5));
        try {
            list.get(6);
            fail();
        } catch (IndexOutOfBoundsException npe) {
            //Test passed
        }
        list.add(6);
        assertEquals(7, list.size());
        assertEquals(6, (int) list.get(6));
        list.remove(2);
        assertEquals(6, list.size());
        assertEquals(5, (int) list.get((Integer) 5));
        assertEquals(5, (int) list.get(4));
    }

    /**
     * Test the Methods in Student Class
     */
    @Test
    public void testStudents(){
        School school1 = new School("WorcesterShire Polytechnic Institute");
        Student stud1 = new Student("Joe Cool", "joeissocool",school1);
        assertEquals("Joe Cool", stud1.getName());
        assertEquals(stud1, school1.getStudents().get(0));

    }



}

package test;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

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
}

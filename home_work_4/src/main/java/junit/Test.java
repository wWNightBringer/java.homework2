package junit;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Test {
    private MathFunc func;

    @Before
    public void init() {
        func = new MathFunc();
    }

    @After
    public void tearDown() {
        func = null;
    }

    @org.junit.Test
    public void calls() throws IllegalAccessException {
        assertEquals(0, func.getCalls());
        func.fuctorial(1);
        assertEquals(1, func.getCalls());
        assertEquals(3, func.countEmployeer());

    }

    @org.junit.Test
    public void factorial() throws IllegalAccessException {
        assertTrue(func.fuctorial(0) == 1);
        assertTrue(func.fuctorial(1) == 1);
        assertTrue(func.fuctorial(5) == 120);
        assertTrue(func.countEmployeer() == 3);
    }

    @Ignore
    @org.junit.Test(expected = IllegalAccessError.class)
    public void fuctorialNegative() throws IllegalAccessException {
        func.fuctorial(-1);
    }

    @Ignore
    @org.junit.Test
    public void todo() {
        assertTrue(func.plus(1, 1) == 3);
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        Result result = core.run(Test.class);
        System.out.println("run tests " + result.getRunCount());
        System.out.println("failer tests " + result.getFailureCount());
        System.out.println("ingnored tests " + result.getIgnoreCount());
        System.out.println("success " + result.wasSuccessful());
    }
}

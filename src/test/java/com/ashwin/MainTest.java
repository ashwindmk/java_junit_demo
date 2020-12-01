package com.ashwin;

import org.junit.*;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Timeout;

import java.security.InvalidParameterException;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Rule
    public final Timeout timeout = Timeout.seconds(2);

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @BeforeClass
    public static void beforeClass() {
        // Executes once before everything else
        System.out.println("MainTest | beforeClass");
    }

    @Before
    public void before() {
        // Executes before every test
        System.out.println("MainTest | before");
    }

    @Test
    public void testAdd() {
        System.out.println("MainTest | testAdd");
        int a = 12;
        int b = 8;

        Main main = new Main();
        int c = main.add(a, b);

        assertEquals("testAdd", (a + b), c);
    }

    @Test
    public void testSub() {
        System.out.println("MainTest | testSub");
        int a = 12;
        int b = -8;

        Main main = new Main();
        int c = main.add(a, b);

        assertEquals("testSub", (a + b), c);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void testInsufficientBalanceException() throws Exception {
        System.out.println("MainTest | testException");
        int req = 25;
        int bal = 20;

        Main main = new Main();
        main.withdraw(req, bal);
    }

    @Test(expected = InvalidParameterException.class)
    public void testInvalidParameterException() throws Exception {
        System.out.println("MainTest | testException");
        int req = -25;
        int bal = 20;

        Main main = new Main();
        main.withdraw(req, bal);
    }

    @Test
    public void testInsufficientBalanceExceptionMessage() {
        System.out.println("MainTest | testInsufficientBalanceExceptionMessage");
        int req = 25;
        int bal = 20;

        InsufficientBalanceException e = Assert.assertThrows(InsufficientBalanceException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                Main main = new Main();
                main.withdraw(req, bal);
            }
        });
        assertEquals("testInsufficientBalanceExceptionMessage", "Trying to withdraw " + req + " from " + bal, e.getMessage());
    }

    @Test
    public void testProcessTimeout() {
        System.out.println("MainTest | testProcessTimeout");
        Main main = new Main();
        int res = main.process(4);
        Assert.assertEquals("testTimeoutProcess", 0, res);
    }

    @Test
    public void testErrorCollectors() {
        System.out.println("MainTest | testErrorCollectors");
        Main main = new Main();

        try {
            main.withdraw(-5, 10);
        } catch (Exception e) {
            // This will fail the test, but continues
            errorCollector.addError(e);
        }

        try {
            main.withdraw(12, 10);
        } catch (Exception e) {
            // This will fail the test, but continues
            errorCollector.addError(e);
        }
    }

    @After
    public void after() {
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("MainTest | afterClass");
    }
}

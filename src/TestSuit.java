
import TestSuits.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.text.SimpleDateFormat;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        RequestTripTest.class,
        TripDeciderTest.class,
        SevenSeaterTest.class,
        SedanTest.class
})
public class TestSuit {
    @BeforeClass
    public static void setUp() {
        System.out.println("Setting up Test Suit of 190042102");
    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Test conducted at " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date())+ " by 190042102");
    }

}

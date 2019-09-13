package com.msalihkocak.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DateUtilTest {

    @Parameterized.Parameter(0)
    public int year;

    @Parameterized.Parameter(1)
    public boolean shouldBeLeap;

    @Parameterized.Parameters(name = "The year {0, number,####} should have leap year as {1}")
    public static Object[][] parameters(){
        return new Object[][] { {1992, true}, {1996, true}, {1991, true}, {1988, true} };
    }

    @Test
    public void isLeapYear(){
        assertThat(DateUtil.isLeapYear(year), is(shouldBeLeap));
    }

/*    @Test
    public void normalLeapYearIsLeap(){
        assertTrue(DateUtil.isLeapYear(1992));
    }

    @Test
    public void normalLeapYearIsLeap2(){
        assertTrue(DateUtil.isLeapYear(1996));
    }

    @Test
    public void nonLeapYearIsNotLeap(){
        assertFalse(DateUtil.isLeapYear(1993));
    }

    @Test
    public void trueTrueControl(){
        assertTrue(DateUtil.returnTrue());
    }

    @Test
    public void centuryIsNotLeapYear(){
        assertFalse(DateUtil.isLeapYear(1900));
        assertFalse(DateUtil.isLeapYear(1700));
    }

    @Test
    public void millenniumIsLeapYear(){
        assertTrue(DateUtil.isLeapYear(2000));
    }*/
}
package com.msalihkocak.date;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.*;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DateUtilJUnitParamsTest {

    // Giving the test attributes as csv style
    @Test
    @Parameters({
            "1992, true",
            "1996, true",
            "1991, true",
            "1988, true",
    })
    @TestCaseName("Check for is leap year for {0} - > {1}")
    public void isLeapYear(int year, boolean shouldBeLeap){
        assertThat(DateUtil.isLeapYear(year), is(shouldBeLeap));
    }

    // Csv file style
    @Test
    @FileParameters("src/test/resources/JunitParamsTestParameters.csv")
    public void whenWithCsvFile_thenSafeAdd(int year, boolean shouldBeLeap) {
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
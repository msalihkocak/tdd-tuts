package com.msalihkocak.assertions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssertTimeout {
    @Test(timeout = 1000L)
    public void testThingThatMayRunForever(){
        assertEquals(42, someLongRoutine());
    }

    private static int someLongRoutine(){
        while (true){
            // Loituma - Ievan Polka
        }
    }
}

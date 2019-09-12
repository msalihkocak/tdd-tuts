package com.msalihkocak.rectangle;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AssertionExamplesTest {

    @Test
    public void tryAssertTrue(){
        Rectangle rectangle = new Rectangle(10, 10);
        assertTrue(rectangle.isSquare());
    }

    @Test
    public void tryAssertFalse(){
        Rectangle rectangle = new Rectangle(1,10);
        assertFalse(rectangle.isSquare());
    }

    @Test
    public void tryAssertTrue2(){
        Rectangle rectangle = new Rectangle(10,10);
        assertTrue("Rectangle with same width and height should be square", rectangle.isSquare());
    }

    @Test
    public void tryAssertNull(){
        Object o = null;
        assertNull(o);
    }

    @Test
    public void tryAssertNotNull(){
        Object o = new Rectangle(1,1);
        assertNotNull(o);
    }

    @Test
    public void tryAssertEquals(){
        assertEquals(16, new Rectangle(2,8).getArea());
    }

    @Test
    public void tryAssertEqualsWithStrings(){
        // This will fail
        assertEquals("Hey, THIS IS SPARTA!", "Hey, This is Sparta!");
    }

    @Test
    public void tryAssertNotEquals(){
        assertNotEquals(9999, new Rectangle(2,5).getArea());
    }

    @Test
    public void tryAssertEqualsWithDouble(){
        double aspectRatio = new Rectangle(1,3).getAspectRatio();
        assertEquals(0.333333, aspectRatio, 0.001);
    }

    @Test
    public void tryAssertEqualsWithObject(){
        assertEquals(new Rectangle(1,1), new Rectangle(1,1));
    }

    @Test
    public void tryAssertSame(){
        Rectangle example1 = new Rectangle(4,5);
        Rectangle example1SecondReference = example1;

        assertSame(example1, example1SecondReference);

        Rectangle example2SameValuesWith1 = new Rectangle(4,5);

        assertNotSame(example1, example2SameValuesWith1);
        assertEquals(example1, example2SameValuesWith1);
    }

    @Test
    public void tryAssertFail(){
        // This will fail
        fail("This was never meant to happen.");
    }

    @Test
    public void tryAssertArray(){
        Rectangle rectangle = new Rectangle(5,6);
        assertArrayEquals(new int[] {5,6}, rectangle.getSides());
    }

    @Test
    public void tryAssertList(){
        Rectangle rectangle = new Rectangle(7,8);
        assertEquals(asList(7,8), rectangle.getSidesList());
    }
}
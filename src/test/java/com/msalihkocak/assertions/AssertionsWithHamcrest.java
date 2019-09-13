package com.msalihkocak.assertions;


import com.msalihkocak.rectangle.Rectangle;
import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.number.IsCloseTo;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AssertionsWithHamcrest {

    @Test
    public void tryAssertTrue(){
        Rectangle rectangle = new Rectangle(10, 10);
        assertThat(rectangle.isSquare(), is(true));
    }

    @Test
    public void tryAssertFalse(){
        Rectangle rectangle = new Rectangle(1,10);
        assertThat(rectangle.isSquare(), is(false));
    }

    @Test
    public void tryAssertTrue2(){
        Rectangle rectangle = new Rectangle(10,10);
        assertThat("Rectangle with same width and height should be square", rectangle.isSquare(), is(true));
    }

    @Test
    public void tryAssertNull(){
        Object o = null;
        assertThat(o, is(nullValue()));
    }

    @Test
    public void tryAssertNotNull(){
        Object o = new Rectangle(1,1);
        assertThat(o, is(not(nullValue())));
    }

    @Test
    public void tryAssertEquals(){
        assertThat(new Rectangle(2,8).getArea(), is(equalTo(16)));
    }

    @Ignore("This is here to show failure")
    @Test
    public void tryAssertEqualsWithStrings(){
        // This will fail
        assertEquals("Hey, THIS IS SPARTA!", "Hey, This is Sparta!");
    }

    @Test
    public void tryAssertNotEquals(){
        assertThat(new Rectangle(2,8).getArea(), is(not(equalTo(9999))));
    }

    @Test
    public void tryAssertEqualsWithDouble(){
        double aspectRatio = new Rectangle(1,3).getAspectRatio();
        assertThat(aspectRatio, closeTo(0.333333, 0.01));
    }

    @Test
    public void tryAssertEqualsWithObject(){
        assertThat(new Rectangle(1,1), is(equalTo(new Rectangle(1,1))));
    }

    @Test
    public void tryAssertSame(){
        Rectangle example1 = new Rectangle(4,5);
        Rectangle example1SecondReference = example1;

        assertThat(example1, is(sameInstance(example1SecondReference)));

        Rectangle example2SameValuesWith1 = new Rectangle(4,5);

        assertThat(example1, is(not(sameInstance(example2SameValuesWith1))));
        assertThat(example1, is(equalTo(example2SameValuesWith1)));
    }

    @Test
    public void tryAssertArray(){
        Rectangle rectangle = new Rectangle(5,6);
        // Primitive arrays are not comparable by using hamcrest
    }

    @Test
    public void tryAssertList(){
        Rectangle rectangle = new Rectangle(7,8);
        assertThat(rectangle.getSidesList(), contains(7,8));
    }
}

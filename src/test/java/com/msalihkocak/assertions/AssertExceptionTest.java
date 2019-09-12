package com.msalihkocak.assertions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AssertExceptionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void willThrowError() throws Exception{
        expectedException.expect(IOException.class);
        expectedException.expectMessage("ang");

        willThrow();
    }

    @Test(expected = IOException.class)
    public void throwWillBeThrown() throws IOException {
        willThrow();
    }

    private static void willThrow() throws IOException{
        throw new IOException("Bang");
    }
}

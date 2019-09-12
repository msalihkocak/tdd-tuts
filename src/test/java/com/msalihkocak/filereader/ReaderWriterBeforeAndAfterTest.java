package com.msalihkocak.filereader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReaderWriterBeforeAndAfterTest {
    private File writtenFile;
    private File tempFolder;

    @Before
    public void setup() throws Exception{
        tempFolder = File.createTempFile("tmp", "file");
        tempFolder.delete();
        tempFolder.mkdir();
    }

    @After
    public void teardown() throws Exception {
        assertTrue(writtenFile.delete());
        assertTrue(tempFolder.delete());
    }

    @Test
    public void readLinesWroteThemAndCheckConsistency() throws Exception{
        List<String> writtenLines = asList("One", "Two", "Three");
        writtenFile = ReaderWriter.write(tempFolder, "MyFile", writtenLines);

        List<String> readLines = ReaderWriter.read(writtenFile);

        assertEquals(writtenLines, readLines);
    }

    @Test
    public void readZeroLinesAfterWritingNothingAndCheckConsistency() throws Exception{
        List<String> writtenLines = asList();
        writtenFile = ReaderWriter.write(tempFolder, "MyFile", writtenLines);

        List<String> readLines = ReaderWriter.read(writtenFile);

        assertEquals(writtenLines, readLines);
    }
}

package com.tools.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tools.util.Util;

@RunWith(MockitoJUnitRunner.class)
public class DataFileManagerTest {

    private DataFileManager dataFileManager;
    private String pathTestFile;
    private Path pathTestFileOutuput;

    @Before
    public void init() throws IOException {
        Util.createPathStructure();
        dataFileManager = new DataFileManager();
        pathTestFile = Paths.get(System.getProperty("user.dir").concat("/src/test/resources/in/test.dat")).toString();
        pathTestFileOutuput = Util.getPathOutputFile("test");
    }

    @Test
    public void mustTransFormatFile() throws IOException {
        dataFileManager.transFormatFile(pathTestFile,"test");
        Assert.assertTrue(Files.exists(pathTestFileOutuput, LinkOption.NOFOLLOW_LINKS));

        Files.deleteIfExists(pathTestFileOutuput);
    }

}

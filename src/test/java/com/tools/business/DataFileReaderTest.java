package com.tools.business;


import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tools.fixture.DataFileInputFixture;
import com.tools.model.DataFileInput;

@RunWith(MockitoJUnitRunner.class)
public class DataFileReaderTest {

    private DataFileReader dataFileReader;

    @Mock
    private DataFileWriter dataFileWriter;

    private String pathTestFile;
    private DataFileInput expected;
    private String filename;

    @Before
    public void init() {
        dataFileReader = new DataFileReader();
        pathTestFile = Paths.get(System.getProperty("user.dir").concat("/src/test/resources/in/test.dat")).toString();
        filename = "test";
    }

    @Test(expected = IOException.class)
    public void mustReturnException_FileNotFound() throws IOException {
        dataFileReader.populateDataFile(RandomStringUtils.randomAlphabetic(15), RandomStringUtils.random(6));
    }

    @Test
    public void mustTransformDataFile() throws IOException {
        expected = DataFileInputFixture.get();
        final DataFileInput dataFileInput = dataFileReader.populateDataFile(pathTestFile, filename);

        Assert.assertEquals(expected.getFilename(), dataFileInput.getFilename());
        Assert.assertEquals(expected.getCustomers().get(0).getCnpj(), dataFileInput.getCustomers().get(0).getCnpj());
        Assert.assertEquals(expected.getCustomers().get(0).getName(), dataFileInput.getCustomers().get(0).getName());
        Assert
            .assertEquals(expected.getSales().get(0).getSellerName(), dataFileInput.getSales().get(0).getSellerName());
        Assert.assertEquals(expected.getSellers().get(0).getCpf(), dataFileInput.getSellers().get(0).getCpf());
    }


}

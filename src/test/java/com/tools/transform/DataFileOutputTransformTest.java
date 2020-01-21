package com.tools.transform;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.tools.fixture.DataFileInputFixture;
import com.tools.fixture.DataFileOutputFixture;
import com.tools.model.DataFileInput;
import com.tools.model.DataFileOutput;

@RunWith(MockitoJUnitRunner.class)
public class DataFileOutputTransformTest {

    private DataFileOutputTransform transform;

    @Before
    public void init() {
        transform = new DataFileOutputTransform();
    }

    @Test
    public void mustTransformData() {
        final DataFileOutput expected = DataFileOutputFixture.get();

        final DataFileInput input = DataFileInputFixture.get();
        final DataFileOutput output = transform.from(input);

        Assert.assertEquals(expected, output);
    }
}

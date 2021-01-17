package com.mortgage.optional.converter;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.model.Prospect;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Unit test for {@link ProspectToProspectDTOConverter}.
 */
public class ProspectToProspectDTOConverterTest {

    private ProspectToProspectDTOConverter converter;

    @Before
    public void init() {
        this.converter = new ProspectToProspectDTOConverter();
    }

    @Test
    public void testShouldConvertTheEntity(){
        Prospect prospect = new Prospect("test", 20.5,2.5,3);

        ProspectDTO actual = converter.convert(prospect);

        ProspectDTO expected = new ProspectDTO("test", 20.5,2.5,3);
        Assertions.assertEquals(expected, actual);
    }
}

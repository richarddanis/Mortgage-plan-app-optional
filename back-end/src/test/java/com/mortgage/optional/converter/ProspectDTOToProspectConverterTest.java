package com.mortgage.optional.converter;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.model.Prospect;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

/**
 * Unit test for {@link ProspectDTOToProspectConverter}.
 */
public class ProspectDTOToProspectConverterTest {

    private ProspectDTOToProspectConverter converter;

    @Before
    public void init() {
        this.converter = new ProspectDTOToProspectConverter();
    }

    @Test
    public void testShouldConvertTheEntity(){
        ProspectDTO prospectDTO = new ProspectDTO("test", 20.5,2.5,3);

        Optional<Prospect> actual = converter.convert(prospectDTO);

        Prospect expected = new Prospect("test", 20.5,2.5,3);
        Assertions.assertTrue(actual.isPresent());
        Assertions.assertEquals(expected, actual.get());
    }
}

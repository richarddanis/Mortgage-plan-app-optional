package com.mortgage.optional.service;

import com.mortgage.optional.calculator.MortgageCalculator;
import com.mortgage.optional.converter.ProspectDTOToProspectConverter;
import com.mortgage.optional.converter.ProspectToProspectDTOConverter;
import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.dto.ReportDTO;
import com.mortgage.optional.exception.EntityNotFoundException;
import com.mortgage.optional.model.Prospect;
import com.mortgage.optional.repository.ProspectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Unit test for {@link ProspectService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProspectServiceTest {

    private ProspectService prospectService;

    @Mock
    private ProspectRepository repository;

    @Mock
    private ProspectDTOToProspectConverter prospectConverter;

    @Mock
    private ProspectToProspectDTOConverter prospectDTOConverter;

    @Mock
    private MortgageCalculator mortgageCalculator;

    @Before
    public void init(){
        prospectService = new ProspectService(repository, prospectConverter, prospectDTOConverter, mortgageCalculator);
    }

    @Test
    public void testShouldSaveProspectDTO(){
        ProspectDTO prospectDTO = new ProspectDTO("test", 2.0, 3.5, 2);
        Prospect prospect = new Prospect("test", 2.0, 3.5, 2);
        Mockito.when(prospectConverter.convert(Mockito.any(ProspectDTO.class))).thenReturn(Optional.of(prospect));
        Mockito.when(repository.save(Mockito.any(Prospect.class))).thenReturn(prospect);
        Mockito.when(prospectDTOConverter.convert(Mockito.any(Prospect.class))).thenReturn(prospectDTO);

        ProspectDTO actual = prospectService.save(prospectDTO);

        ProspectDTO expected = new ProspectDTO("test", 2.0, 3.5, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testShouldThrowEntityNotFoundExceptionWhenCannotSaveTheElement(){
        ProspectDTO prospectDTO = new ProspectDTO("test", 2.0, 3.5, 2);
        Prospect prospect = new Prospect("test", 2.0, 3.5, 2);
        Mockito.when(prospectConverter.convert(Mockito.any(ProspectDTO.class))).thenReturn(Optional.of(prospect));

        prospectService.save(prospectDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testShouldThrowEntityNotFoundExceptionWhenDTOConverterCannotConvertElement(){
        ProspectDTO prospectDTO = new ProspectDTO("test", 2.0, 3.5, 2);
        Prospect prospect = new Prospect("test", 2.0, 3.5, 2);
        Mockito.when(prospectConverter.convert(Mockito.any(ProspectDTO.class))).thenReturn(Optional.of(prospect));
        Mockito.when(repository.save(Mockito.any(Prospect.class))).thenReturn(prospect);

        prospectService.save(prospectDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testShouldThrowEntityNotFoundExceptionWhenConverterCannotConvertElement(){
        ProspectDTO prospectDTO = new ProspectDTO("test", 2.0, 3.5, 2);

        prospectService.save(prospectDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testShouldThrowExceptionWhenProspectIsNull(){
        prospectService.save(null);
    }

    @Test
    public void testShouldRetrieveMortgageReport(){
        ReportDTO reportDTO = new ReportDTO("test", 25, 5, 20);
        Prospect prospect = new Prospect("test", 2.0, 3.5, 2);
        Mockito.when(repository.findAllByOrderByCreateDateDesc()).thenReturn(Collections.singletonList(prospect));
        Mockito.when(mortgageCalculator.calculateAndGenerateReport(Mockito.any(Prospect.class))).thenReturn(reportDTO);

        List<ReportDTO> actual = prospectService.getMortgageCalculation();

        ReportDTO expected = new ReportDTO("test", 25, 5, 20);
        Assertions.assertEquals(1,actual.size());
        Assertions.assertEquals(expected, actual.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void testShouldThrowExceptionWhenUnexpectExceptionHappening(){
        Mockito.when(repository.findAllByOrderByCreateDateDesc()).thenThrow(new RuntimeException());

        prospectService.getMortgageCalculation();
    }
}

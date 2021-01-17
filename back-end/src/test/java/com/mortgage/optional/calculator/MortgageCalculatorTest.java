package com.mortgage.optional.calculator;

import com.mortgage.optional.dto.ProspectDTO;
import com.mortgage.optional.dto.ReportDTO;
import com.mortgage.optional.model.Prospect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for {@link MortgageCalculator}.
 */
public class MortgageCalculatorTest {

    private MortgageCalculator calculator;

    @BeforeEach
    public void init(){
        calculator = new MortgageCalculator();
    }

    @Test
    public void testShouldCalculateTheMortgage() {
        ReportDTO expected = new ReportDTO("test", 100.5, 3, 8.887108378218747);

        Prospect prospect = new Prospect("test", 100.5, 100.2, 3);
        ReportDTO actual = calculator.calculateAndGenerateReport(prospect);

        Assertions.assertEquals(expected, actual);
    }
}

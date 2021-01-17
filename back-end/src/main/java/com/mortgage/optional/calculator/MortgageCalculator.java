package com.mortgage.optional.calculator;

import com.mortgage.optional.model.Prospect;
import com.mortgage.optional.dto.ReportDTO;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class MortgageCalculator {

    private static final int MONTH_IN_YEAR = 12;
    private static final int PERCENTAGE = 100;

    /**
     * Calculate the mortgage.
     *
     * @param prospect list of read prospects
     * @return list of mortgage object
     */
    public ReportDTO calculateAndGenerateReport(Prospect prospect) {
        double monthlyRate = calculateMonthlyRate(prospect.getInterest());
        double paymentPerMonth = (prospect.getTotalLoan() * (monthlyRate * interestPower(monthlyRate, numberOfMonths(prospect.getYears()))))
                / (interestPower(monthlyRate, numberOfMonths(prospect.getYears())) - 1);
        return new ReportDTO(prospect.getFullName(), prospect.getTotalLoan(), prospect.getYears(), paymentPerMonth);
    }

    private int numberOfMonths(int years) {
        return years * MONTH_IN_YEAR;
    }

    private double interestPower(double interest, int numberOfMonths){
        double result = interest + 1;
        double multiplier = result;
        result *= IntStream.range(0, numberOfMonths - 1).mapToDouble(i -> multiplier).reduce(1, (a, b) -> a * b);
        return result;
    }

    private double calculateMonthlyRate(double interestRate) {
        return interestRate / PERCENTAGE / MONTH_IN_YEAR;
    }
}

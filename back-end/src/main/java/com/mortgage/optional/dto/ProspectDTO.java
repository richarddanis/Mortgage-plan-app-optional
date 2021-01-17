package com.mortgage.optional.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProspectDTO {

    @NotBlank
    @NotNull
    @NotEmpty(message = "Customer name must be not empty.")
    private String fullName;

    @NotNull
    @Min(value = 1)
    private double totalLoan;

    @NotNull
    @Min(value = 1)
    private double interest;

    @NotNull
    @Min(value = 1)
    private int years;

    public ProspectDTO(String fullName, double totalLoan, double interest, int years) {
        this.fullName = fullName;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getFullName() {
        return fullName;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProspectDTO that = (ProspectDTO) o;
        return Double.compare(that.totalLoan, totalLoan) == 0 && Double.compare(that.interest, interest) == 0 && years == that.years && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, totalLoan, interest, years);
    }

    @Override
    public String toString() {
        return "ProspectDTO{" +
                "fullName='" + fullName + '\'' +
                ", totalLoan=" + totalLoan +
                ", interest=" + interest +
                ", years=" + years +
                '}';
    }
}

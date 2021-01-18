package com.mortgage.optional.dto;

import java.util.Objects;

/**
 * Class for representing a generated report object.
 */
public class ReportDTO {

    private final String customerName;
    private final double borrow;
    private final int period;
    private final double paymentPerMonth;

    public ReportDTO(String customerName, double borrow, int period, double paymentPerMonth) {
        this.customerName = customerName;
        this.borrow = borrow;
        this.period = period;
        this.paymentPerMonth = paymentPerMonth;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBorrow() {
        return borrow;
    }

    public int getPeriod() {
        return period;
    }

    public double getPaymentPerMonth() {
        return paymentPerMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportDTO reportDTO = (ReportDTO) o;
        return Double.compare(reportDTO.borrow, borrow) == 0 && period == reportDTO.period && Double.compare(reportDTO.paymentPerMonth, paymentPerMonth) == 0 && Objects.equals(customerName, reportDTO.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, borrow, period, paymentPerMonth);
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "customerName='" + customerName + '\'' +
                ", borrow=" + borrow +
                ", period=" + period +
                ", paymentPerMonth=" + paymentPerMonth +
                '}';
    }
}

package com.mortgage.optional.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.Objects;

@Entity
public class Prospect {

    @Id
    @GeneratedValue
    @Column(unique = true, name = "ID")
    private Long id;

    @Column(nullable = false, name = "FULL_NAME")
    private String fullName;

    @Column(nullable = false, name = "TOTAL_LOAN")
    private double totalLoan;

    @Column(nullable = false, name = "INTEREST")
    private double interest;

    @Column(nullable = false, name = "YEARS")
    private int years;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * Empty constructor for hibernate.
     */
    public Prospect() {
    }

    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }

    public Prospect(String fullName, double totalLoan, double interest, int years) {
        this.fullName = fullName;
        this.totalLoan = totalLoan;
        this.interest = interest;
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

    public Date getCreateDate() {
        return createDate;
    }

    public int getYears() {
        return years;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prospect that = (Prospect) o;
        return Double.compare(that.totalLoan, totalLoan) == 0 && Double.compare(that.interest, interest) == 0 && years == that.years && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, totalLoan, interest, years);
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "fullName='" + fullName + '\'' +
                ", totalLoan=" + totalLoan +
                ", interest=" + interest +
                ", years=" + years +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

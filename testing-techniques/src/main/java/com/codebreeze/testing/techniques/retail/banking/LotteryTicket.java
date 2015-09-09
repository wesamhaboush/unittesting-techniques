package com.codebreeze.testing.techniques.retail.banking;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class LotteryTicket {
    private LocalDate dateOfIssue;
    private String ownerName;
    private List<Integer> numbers;

    private int priceInDollars;

    public LotteryTicket() {
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(final LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    public int getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(final int priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(priceInDollars, that.priceInDollars) &&
                Objects.equals(dateOfIssue, that.dateOfIssue) &&
                Objects.equals(ownerName, that.ownerName) &&
                Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfIssue, ownerName, numbers, priceInDollars);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dateOfIssue", dateOfIssue)
                .append("ownerName", ownerName)
                .append("numbers", numbers)
                .append("priceInDollars", priceInDollars)
                .toString();
    }
}

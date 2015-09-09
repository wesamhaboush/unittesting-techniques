package com.codebreeze.testing.techniques.retail.banking;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.ZonedDateTime;
import java.util.Objects;

public final class Debt {
    private final double amount;
    private final String unit;
    private final ZonedDateTime dueDate;

    public Debt(final double amount, final String unit, final ZonedDateTime dueDate) {
        this.amount = amount;
        this.unit = unit;
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Debt debt = (Debt) o;
        return Objects.equals(amount, debt.amount) &&
                Objects.equals(unit, debt.unit) &&
                Objects.equals(dueDate, debt.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unit, dueDate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("amount", amount)
                .append("unit", unit)
                .append("dueDate", dueDate)
                .toString();
    }
}

package com.codebreeze.testing.techniques.retail.banking;

import com.google.common.base.Preconditions;

public class Account {
    private final String name;
    private final String number;
    private double balance;

    public Account(final String name, final String number, final double balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public void withdraw(final double value) {
        Preconditions.checkArgument(balance >= value, "balance [%f] is not enough to withdraw [%f]", balance, value);
        balance -= value;
    }

    public void deposit(final double value) {
        balance += value;
    }

    public double getBalance(){
        return balance;
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Bank Statement:")
                .append("Name:").append(this.name)
                .append("Account Number:").append(this.number)
                .append("Balance:").append(balance)
                .toString();
    }
}

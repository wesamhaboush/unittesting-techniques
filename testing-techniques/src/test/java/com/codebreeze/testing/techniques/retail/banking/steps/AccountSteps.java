package com.codebreeze.testing.techniques.retail.banking.steps;

import com.codebreeze.testing.techniques.retail.banking.Account;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountSteps {
    private String username;
    private String accountNumber;
    private double initialBalance;
    private Account account;
    private Collection<Exception> exceptions = new LinkedList<>();

    @Given("a new account is created")
    public void reset() {
        this.username = null;
        this.accountNumber = null;
        this.initialBalance = 0.0;
        this.account = null;
    }

    @Given("account is for user $username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Given("account has balance [current-balance]")
    public void accountWithBalance(@Named("current-balance") double currentBalance) {
        reset();
        account = new Account("somename", "1223", currentBalance);
    }


    @Given("account has number $accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Given("account initial balance is $balance")
    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @When("I initiate the account with those values")
    public void initializeAccount() {
        this.account = new Account(username, accountNumber, initialBalance);
    }

    @When("I withdraw [amount-withdrawn]")
    public void withdraw(@Named("amount-withdrawn") double amountWithdrawn) {
        try {
            this.account.withdraw(amountWithdrawn);
        } catch (IllegalArgumentException ise) {
            exceptions.add(ise);
        }
    }

    @When("I deposit [amount-deposited]")
    public void deposit(@Named("amount-deposited") double amountDeposited) {
        this.account.deposit(amountDeposited);
    }

    @Then("the account state should reflect those values")
    public void verifyValuesAreCorrect() {
        assertThat(account.getName(), is(username));
        assertThat(account.getNumber(), is(accountNumber));
        assertThat(account.getBalance(), closeTo(initialBalance, 0.01));
    }

    @Then("the account has a balance of [new-balance]")
    public void checkBalance(@Named("new-balance") double checkBalance) {
        assertThat(account.getBalance(), closeTo(checkBalance, 0.01));
    }

    @Then("the withdrawal is rejected")
    public void errorOccurred() {
        assertTrue(Iterables.any(exceptions, new Predicate<Exception>() {
            @Override
            public boolean apply(@Nullable final Exception input) {
                return input.getClass() == IllegalArgumentException.class;
            }
        }));
    }
}

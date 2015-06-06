package com.codebreeze.testing.techniques.retail.banking.steps

import com.codebreeze.testing.techniques.retail.banking.Account
import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Named
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When

import static org.hamcrest.core.Is.is
import static org.hamcrest.number.IsCloseTo.closeTo
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertTrue

public class GAccountSteps {
    String username;
    String accountNumber
    double initialBalance
    Account account
    List<?> exceptions = []

    @Given("a new account is created")
    public reset() {
        this.username = null
        this.accountNumber = null
        this.initialBalance = 0.0
        this.account = null
    }

    @Given("account is for user \$username")
    def setUsername(String username) {
        this.username = username
    }

    @Given("account has balance [current-balance]")
    def accountWithBalance(@Named("current-balance") double currentBalance) {
        reset()
        account = new Account("somename", "1223", currentBalance)
    }


    @Given("account has number \$accountNumber")
    def setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber
    }

    @Given("account initial balance is \$balance")
    def setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance
    }

    @When("I initiate the account with those values")
    def initializeAccount() {
        this.account = new Account(username, accountNumber, initialBalance)
    }

    @When("I withdraw [amount-withdrawn]")
    def withdraw(@Named("amount-withdrawn") double amountWithdrawn) {
        try {
            this.account.withdraw amountWithdrawn
        } catch (IllegalArgumentException ise) {
            exceptions.add ise
        }
    }

    @When("I deposit [amount-deposited]")
    def deposit(@Named("amount-deposited") double amountDeposited) {
        this.account.deposit amountDeposited
    }

    @Then("the account state should reflect those values")
    def verifyValuesAreCorrect() {
        assertThat(account.getName(), is(username))
        assertThat(account.getNumber(), is(accountNumber))
        assertThat(account.getBalance(), closeTo(initialBalance, 0.01))
    }

    @Then("the account has a balance of [new-balance]")
    def checkBalance(@Named("new-balance") double checkBalance) {
        assertThat(account.getBalance(), closeTo(checkBalance, 0.01))
    }

    @Then("the withdrawal is rejected")
    def errorOccurred() {
        assertTrue(Iterables.any(exceptions, new Predicate<Exception>() {
            @Override
            public boolean apply(final Exception input) {
                return input.getClass() == IllegalArgumentException.class
            }
        }))
    }
}

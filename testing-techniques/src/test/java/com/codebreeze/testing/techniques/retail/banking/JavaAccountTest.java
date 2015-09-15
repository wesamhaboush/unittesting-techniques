package com.codebreeze.testing.techniques.retail.banking;

import org.junit.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.RandomUtils.nextDouble;
import static org.junit.Assert.assertEquals;

public class JavaAccountTest {
    @Test
    public void test_Account_Initialization_Works_Ok(){
        //given
        String name = randomAlphabetic(15);
        String number = randomNumeric(16);
        double initialBalance = nextDouble(1, 100000);

        //when
        Account account = new Account(name, number, initialBalance);

        //then
        assertEquals(name, account.getName());
        assertEquals(number, account.getNumber());
        assertEquals(initialBalance, account.getBalance(), 0.1);
    }

    @Test
    public void test_Withdraw_Happy_Path_Works(){
        //given
        String name = randomAlphabetic(15);
        String number = randomNumeric(16);
        double initialBalance = nextDouble(2, 100000);
        double withdrawnAmount = nextDouble(1, initialBalance - 1);
        double newBalance = initialBalance - withdrawnAmount;

        //when
        Account account = new Account(name, number, initialBalance);
        account.withdraw(withdrawnAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 0.1);
    }

    @Test
    public void test_Deposit_Happy_Path_Works(){
        //given
        String name = randomAlphabetic(15);
        String number = randomNumeric(16);
        double initialBalance = nextDouble(1, 100000);
        double depositAmount = nextDouble(1, 100000);
        double newBalance = initialBalance + depositAmount;

        //when
        Account account = new Account(name, number, initialBalance);
        account.deposit(depositAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Withdrawing_Of_More_Than_The_Balance_Is_Rejected(){
        //given
        String name = randomAlphabetic(15);
        String number = randomNumeric(16);
        double initialBalance = nextDouble(1, 100000);
        double withdrawnAmount = initialBalance + nextDouble(1, 100000);

        //when
        Account account = new Account(name, number, initialBalance);
        account.withdraw(withdrawnAmount);

        //then
    }
}

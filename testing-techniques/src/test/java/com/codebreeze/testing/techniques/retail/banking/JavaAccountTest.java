package com.codebreeze.testing.techniques.retail.banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaAccountTest {
    @Test
    public void testAccountInitializationWorksOk(){
        //given
        String name = "name1";
        String number = "number1";
        double initialBalance = 100;

        //when
        Account account = new Account(name, number, initialBalance);

        //then
        assertEquals(name, account.getName());
        assertEquals(number, account.getNumber());
        assertEquals(initialBalance, account.getBalance(), 00.1);
    }

    @Test
    public void testWithdrawalWorksOk(){
        //given
        double initialBalance = 100;
        double withdrawnAmount = 10;
        double newBalance = initialBalance - withdrawnAmount;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 00.1);
    }

    @Test
    public void testWithdrawalWorksOkAnotherExample(){
        //given
        double initialBalance = 30;
        double withdrawnAmount = 2;
        double newBalance = initialBalance - withdrawnAmount;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 00.1);
    }

    @Test
    public void testDepositsWorksOk(){
        //given
        double initialBalance = 100;
        double withdrawnAmount = 10;
        double newBalance = initialBalance + withdrawnAmount;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.deposit(withdrawnAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 00.1);
    }

    @Test
    public void testDepositsWorksOkAnotherExample(){
        //given
        double initialBalance = 30;
        double withdrawnAmount = 2;
        double newBalance = initialBalance + withdrawnAmount;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.deposit(withdrawnAmount);

        //then
        assertEquals(newBalance, account.getBalance(), 00.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalOfTooMuchMoneyIsRejected(){
        //given
        double initialBalance = 100;
        double withdrawnAmount = 101;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalOfTooMuchMoneyIsRejectedAnotherExample(){
        //given
        double initialBalance = 30;
        double withdrawnAmount = 121;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
    }
}
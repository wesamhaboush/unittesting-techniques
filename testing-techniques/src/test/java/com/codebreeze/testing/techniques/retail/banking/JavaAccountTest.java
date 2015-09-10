package com.codebreeze.testing.techniques.retail.banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaAccountTest {
    @Test
    public void test_Account_Initialization_Works_Ok(){
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
    public void test_Withdraw_Happy_Path_Works(){
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
    public void test_Withdraw_Happy_Path_Works_Another_Example(){
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
    public void test_Deposit_Happy_Path_Works(){
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
    public void test_Deposit_Works_Ok_Another_Example(){
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
    public void test_Withdrawing_Of_More_Than_The_Balance_Is_Rejected(){
        //given
        double initialBalance = 100;
        double withdrawnAmount = 101;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Withdrawing_Of_More_Than_The_Balance_Is_Rejected_Another_Example(){
        //given
        double initialBalance = 30;
        double withdrawnAmount = 121;

        //when
        Account account = new Account("name", "number", initialBalance);
        account.withdraw(withdrawnAmount);

        //then
    }
}
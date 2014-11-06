package com.codebreeze.testing.techniques.retail.banking

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertThat


class GroovyAccountTest {
    @Test
    void "test account initialization works ok"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 100

        //when
        def account = new Account(name, number, initialBalance)

        //then
        assertEquals name, account.name
        assertEquals number, account.number
        assertEquals initialBalance, account.balance, 00.1
    }

    @Test
    void "test withdraw happy path works"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 100
        def withdrawnAmount = 10
        def newBalance = initialBalance - withdrawnAmount

        //when
        def account = new Account(name, number, initialBalance)
        account.withdraw withdrawnAmount

        //then
        assertEquals newBalance, account.balance, 00.1
    }

    @Test
    void "test withdraw happy path works - another example"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 30
        def withdrawnAmount = 2
        def newBalance = initialBalance - withdrawnAmount

        //when
        def account = new Account(name, number, initialBalance)
        account.withdraw withdrawnAmount

        //then
        assertEquals newBalance, account.balance, 00.1
    }

    @Test
    void "test deposit happy path works"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 100
        def depositAmount = 10
        def newBalance = initialBalance + depositAmount

        //when
        def account = new Account(name, number, initialBalance)
        account.deposit depositAmount

        //then
        assertEquals newBalance, account.balance, 00.1
    }

    @Test
    void "test deposit happy path works another example"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 30
        def depositAmount = 2
        def newBalance = initialBalance + depositAmount

        //when
        def account = new Account(name, number, initialBalance)
        account.deposit depositAmount

        //then
        assertEquals newBalance, account.balance, 00.1
    }

    @Test
    void "test Withdrawing More Than Balance Is Rejected"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 100
        def withdrawnAmount = 101

        //when
        def account = new Account(name, number, initialBalance)

        //then
        shouldFail IllegalArgumentException, {account.withdraw withdrawnAmount}
    }

    @Test
    void "test withdrawing more than balance is rejected - another example"(){
        //given
        def name = "name1"
        def number = "number1"
        def initialBalance = 30
        def withdrawnAmount = 121

        //when
        def account = new Account(name, number, initialBalance)

        //then
        shouldFail IllegalArgumentException, {account.withdraw withdrawnAmount}
    }
}

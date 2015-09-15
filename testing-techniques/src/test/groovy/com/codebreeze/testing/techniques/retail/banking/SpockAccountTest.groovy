package com.codebreeze.testing.techniques.retail.banking

import spock.lang.Specification

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric
import static org.apache.commons.lang3.RandomUtils.nextDouble

class SpockAccountTest extends Specification {

    def "account gets initialized correctly"() {
        given:
            def name = randomAlphabetic 15
            def number = randomNumeric 16
            def initialBalance = nextDouble 1, 100000

        when:
            def account = Account.newInstance name, number, initialBalance

        then:
            account.name == name
            account.number == number
            account.balance == initialBalance
    }

    def "test i can withdraw successfully from my account"() {
        when:
            def name = randomAlphabetic 15
            def number = randomNumeric 16
            def account = Account.newInstance name, number, initialBalance
            account.withdraw withdrawnAmount

        then:
            account.balance == newBalance

        where:
            initialBalance | withdrawnAmount | newBalance
            100            | 10              | 90
            30             | 2               | 28
    }

    def "test i can deposit successfully into my account"() {
        when:
            def name = randomAlphabetic 15
            def number = randomNumeric 16
            def account = Account.newInstance name, number, initialBalance
            account.deposit depositAmount

        then:
            account.balance == newBalance

        where:
            initialBalance | depositAmount | newBalance
            100            | 10              | 110
            30             | 2               | 32
    }

    def "test i can not withdraw too much money"() {
        when:
            def name = randomAlphabetic 15
            def number = randomNumeric 16
            def account = Account.newInstance name, number, initialBalance
            account.withdraw withdrawnAmount

        then:
            thrown(IllegalArgumentException)

        where:

            initialBalance | withdrawnAmount
            100            | 101
            30             | 121
    }
}

package com.codebreeze.testing.techniques.retail.banking;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

import static com.google.common.base.Preconditions.checkState;
import static com.google.common.collect.ImmutableMap.copyOf;

public class Atm {

    private final Map<Pair<String, String>, Account> accountPasswordAccount;

    public Atm(final Map<Pair<String, String>, Account> accountPasswordAccount){
        this.accountPasswordAccount = copyOf(accountPasswordAccount);
    }

    public Account authenticate(final String accountNumber, final String password){
        final Pair<String, String> accountPrimaryKey = Pair.of(accountNumber, password);
        checkState(this.accountPasswordAccount.containsKey(accountPrimaryKey));
        return this.accountPasswordAccount.get(accountPrimaryKey);
    }
}

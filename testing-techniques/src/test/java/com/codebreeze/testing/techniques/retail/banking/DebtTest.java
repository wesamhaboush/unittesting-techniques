package com.codebreeze.testing.techniques.retail.banking;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class DebtTest {
    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Debt.class)
                .verify();
        EqualsVerifier.forClass(Debt.class)
                .usingGetClass()
                .verify();
    }

}
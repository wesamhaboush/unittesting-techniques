package com.codebreeze.testing.techniques.retail.banking;

import com.google.code.beanmatchers.BeanMatchers;
import org.junit.Test;

import java.time.LocalDate;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

public class LotteryTicketTest {
    @Test
    public void testBean() {
        BeanMatchers.registerValueGenerator(() -> now().plus(nextInt(0, 100), DAYS), LocalDate.class);
        assertThat(LotteryTicket.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
}
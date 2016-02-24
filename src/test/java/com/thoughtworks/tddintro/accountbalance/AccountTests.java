package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account account = new Account();

    @Before
            public void setup(){
        account.deposit(10.00f);
    }


    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){

        float result = account.getBalance();
        assertThat(result, is(10.00f));
    }
//
    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){

        account.withdraw(5.50f);
        float result = account.getBalance();
        assertThat(result, is(4.50f));
    }
//
    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account.withdraw(10.50f);
        float result = account.getBalance();
        assertThat(result,is(10.00f));
    }
}

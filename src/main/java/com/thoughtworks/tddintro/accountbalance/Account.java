package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by laurengallinaro on 2/22/16.
 */
public class Account {

    private float balance;

    public void deposit(float value){
        balance += value;
    }

    public float getBalance() {
        return balance;
    }

    public void withdraw(float value) {
        if( balance > value) {
            balance -= value;
        }
    }
}

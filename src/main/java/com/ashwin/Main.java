package com.ashwin;

import java.security.InvalidParameterException;

public class Main {
    public int add(int a, int b) {
        return a + b;
    }

    public int withdraw(int required, int balance) throws Exception {
        if (required < 0) {
            throw new InvalidParameterException("Required cannot be negative");
        }

        if (required > balance) {
            throw new InsufficientBalanceException("Trying to withdraw " + required + " from " + balance);
        }
        return balance - required;
    }
}

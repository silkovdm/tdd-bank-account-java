package org.xpdojo.bank;

import javax.management.relation.RoleUnresolved;

public class Account {

    private int balance = 0;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (balance - amount > 0) {
            this.balance -= amount;
        } else {
            throw new RuntimeException("Balance " + balance + "is insufficient to withdraw " + amount);
        }
    }

    public void transfer(int amount, Account accountTo) {
        if (balance - amount > 0) {
            this.withdraw(amount);
            accountTo.deposit(amount);
        } else {
            throw new RuntimeException("Balance " + balance + "is insufficient to transfer " + amount);
        }
    }
}

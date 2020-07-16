package org.xpdojo.bank;

public class Account {

    private int balance = 0;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (balance - amount < 0) {
            throw new RuntimeException("Balance " + balance + "is insufficient to withdraw " + amount);
        }
        this.balance -= amount;
    }

    public void transfer(int amount, Account accountTo) {
        if (balance - amount < 0) {
            throw new RuntimeException("Balance " + balance + "is insufficient to transfer " + amount);
        }
        this.withdraw(amount);
        accountTo.deposit(amount);
    }
}
